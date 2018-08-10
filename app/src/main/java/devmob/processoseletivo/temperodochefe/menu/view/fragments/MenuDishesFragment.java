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

public class MenuDishesFragment extends BaseMenuFragment {

    public static String TAG = MenuDishesFragment.class.getSimpleName();

    private MenuItemFragmentAdapter dishAdapter;

    public static MenuDishesFragment newInstance(MenuView menuView, boolean isOrdering, MenuItemClickInterface teste) {
        MenuDishesFragment fragment = new MenuDishesFragment();
        fragment.setArguments(menuView, isOrdering, teste);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_dishes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dishAdapter = new MenuItemFragmentAdapter(getActivity(), isOrdering, teste);
        RecyclerView recyclerView = view.findViewById(R.id.menu_recycler_dishes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(dishAdapter);

        menuView.getMenuItems(TAG);
    }

    @Override
    public void setRecyclerItems(ArrayList<ItemMenu> arrayList) {
        dishAdapter.setItemMenuArrayList(arrayList);
        super.setRecyclerItems(arrayList);
    }
}
