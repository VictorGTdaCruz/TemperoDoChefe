package devmob.processoseletivo.temperodochefe.menu.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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

public class OrderFragment extends BaseMenuFragment {

    public static String TAG = OrderFragment.class.getSimpleName();

    private MenuItemFragmentAdapter orderAdapter;

    private FloatingActionButton fab;

    public static OrderFragment newInstance(MenuView menuView, MenuItemClickInterface teste) {
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(menuView, true, teste);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_order, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fab = view.findViewById(R.id.menu_fab_order);

        orderAdapter = new MenuItemFragmentAdapter(getActivity(), true, teste);
        RecyclerView recyclerView = view.findViewById(R.id.menu_recycler_order);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(orderAdapter);

        menuView.getMenuItems(TAG);
    }

    @Override
    public void setRecyclerItems(ArrayList<ItemMenu> arrayList) {
        orderAdapter.setItemMenuArrayList(arrayList);
        if (arrayList.isEmpty()) fab.hide();
        else fab.show();
        super.setRecyclerItems(arrayList);
    }
}