package devmob.processoseletivo.temperodochefe.menu.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.menu.view.MenuView;
import devmob.processoseletivo.temperodochefe.menu.view.MenuItemClickInterface;
import devmob.processoseletivo.temperodochefe.menu.view.adapter.MenuItemFragmentAdapter;

public class MenuDrinksFragment extends BaseMenuFragment {

    public static String TAG = MenuDrinksFragment.class.getSimpleName();

    private MenuItemFragmentAdapter drinkAdapter;

    public static MenuDrinksFragment newInstance(MenuView menuView, boolean isOrdering, MenuItemClickInterface menuItemClickInterface) {
        MenuDrinksFragment fragment = new MenuDrinksFragment();
        fragment.setArguments(menuView, isOrdering, menuItemClickInterface);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_drinks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        drinkAdapter = new MenuItemFragmentAdapter(getActivity(), menuItemClickInterface, isOrdering, false);
        RecyclerView recyclerView = view.findViewById(R.id.menu_recycler_drinks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(drinkAdapter);

        menuView.getMenuItems(TAG);
    }

    @Override
    public void setRecyclerItems(ArrayList<ItemMenu> arrayList) {
        drinkAdapter.setItemMenuArrayList(arrayList);
        super.setRecyclerItems(arrayList);
    }
}
