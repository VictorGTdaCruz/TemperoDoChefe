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
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.menu.presenter.MenuPresenter;
import devmob.processoseletivo.temperodochefe.menu.presenter.MenuPresenterImpl;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.BaseMenuFragment;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.MenuDessertsFragment;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.MenuDishesFragment;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.MenuDrinksFragment;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.OrderFragment;

public class MenuActivity extends AppCompatActivity implements MenuView {

    private android.support.v4.app.FragmentManager fragmentManager;

    private MenuPresenter menuPresenter;

    private boolean isOrdering;

    private MenuItemClickInterface menuItemButtonClickInterface;
    private MenuItemClickInterface orderItemButtonClickInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        if (savedInstanceState != null) {
            savedInstanceState.getBoolean(String.valueOf(R.string.flag_menu_is_a_new_order), false);
        }

        isOrdering = true;

        menuPresenter = new MenuPresenterImpl(this);

        fragmentManager = getSupportFragmentManager();

        BottomNavigationView bottomNavigation = findViewById(R.id.menu_bottom_navigation);
        if (isOrdering) bottomNavigation.inflateMenu(R.menu.menu_bottom_navigation_is_ordering);
        else  bottomNavigation.inflateMenu(R.menu.menu_bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(bottomNavigationListener());
        bottomNavigation.setSelectedItemId(R.id.bottom_navigation_menu_dish);
    }

    @Override
    public void setupOnItemClickListeners(MenuItemClickInterface menuItemButtonClickInterface, MenuItemClickInterface orderItemButtonClickInterface) {
        this.menuItemButtonClickInterface = menuItemButtonClickInterface;
        this.orderItemButtonClickInterface = orderItemButtonClickInterface;
    }

    @Override
    public void getMenuItems(String tag) {
        menuPresenter.getMenuItems(tag);
    }

    @Override
    public void showFirebaseError() {
        Toast.makeText(getApplicationContext(), getString(R.string.menu_error_firebase), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setupRecyclerItems(ArrayList<ItemMenu> arrayList) {
        BaseMenuFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) currentFragment.setRecyclerItems(arrayList);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationListener() {
        return new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.bottom_navigation_menu_drink:
                        fragment = MenuDrinksFragment.newInstance(MenuActivity.this,
                                isOrdering, menuItemButtonClickInterface);
                        break;
                    case R.id.bottom_navigation_menu_dessert:
                        fragment = MenuDessertsFragment.newInstance(MenuActivity.this,
                                isOrdering, menuItemButtonClickInterface);
                        break;
                    case R.id.bottom_navigation_menu_order:
                        fragment = OrderFragment.newInstance(MenuActivity.this,
                                orderItemButtonClickInterface);
                        break;
                    default:
                        fragment = MenuDishesFragment.newInstance(MenuActivity.this,
                                isOrdering, menuItemButtonClickInterface);
                }

                setFragment(fragment);
                return true;
            }
        };
    }

    private void setFragment(Fragment fragment) {
        fragmentManager
                .beginTransaction()
                .replace(R.id.menu_fragment_container, fragment)
                .commit();
    }

    private BaseMenuFragment getCurrentFragment() {
        List<Fragment> fragments = fragmentManager.getFragments();
        for (int i = 0; i < fragments.size(); i++) {
            if (fragments.get(i).isVisible())
                return (BaseMenuFragment) fragments.get(i);
        }
        return null;
    }
}
