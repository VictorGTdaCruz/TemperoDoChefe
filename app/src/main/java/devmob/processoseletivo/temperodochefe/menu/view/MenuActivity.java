package devmob.processoseletivo.temperodochefe.menu.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.menu.presenter.MenuPresenter;
import devmob.processoseletivo.temperodochefe.menu.presenter.MenuPresenterImpl;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.BaseMenuFragment;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.MenuDrinksFragment;

public class MenuActivity extends AppCompatActivity implements MenuView {

    private android.support.v4.app.FragmentManager fragmentManager;

    private MenuPresenter menuPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fragmentManager = getSupportFragmentManager();

        BottomNavigationView bottomNavigation = findViewById(R.id.menu_bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(bottomNavigationListener());

        menuPresenter = new MenuPresenterImpl(this);
    }

    @Override
    public void setupRecyclerItems(ArrayList arrayList) {
        BaseMenuFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) currentFragment.setRecyclerItems(arrayList);
    }

    @Override
    public void showRequestError() {
        Toast.makeText(getApplicationContext(), "deu ruim na request", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getMenuItems() {
        menuPresenter.getMenuItems();
    }

    private BaseMenuFragment getCurrentFragment() {
        List<Fragment> fragments = fragmentManager.getFragments();
        for (int i = 0; i < fragments.size(); i++) {
            if (fragments.get(i).isVisible())
                return (BaseMenuFragment) fragments.get(i);
        }
        return null;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationListener() {
        return new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.bottom_navigation_menu_food:
//                        fragment = new MenuFoodFragment;
                        break;
                    case R.id.bottom_navigation_menu_dessert:
//                        fragment = new MenuDessertFragment;
                        break;
                    default:
                        fragment = new MenuDrinksFragment();
                        break;
                }

                assert fragment != null;
                setFragment(fragment, fragment.getClass().getSimpleName());
                return true;
            }
        };
    }

    private void setFragment(Fragment fragment, String tag) {
        fragmentManager.beginTransaction()
                .replace(R.id.menu_fragment_container, fragment, tag)
                .commit();
        getCurrentFragment().setArguments(this);
    }
}
