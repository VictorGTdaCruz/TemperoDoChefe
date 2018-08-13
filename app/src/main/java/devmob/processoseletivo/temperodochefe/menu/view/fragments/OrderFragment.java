package devmob.processoseletivo.temperodochefe.menu.view.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.menu.view.MenuView;
import devmob.processoseletivo.temperodochefe.menu.view.MenuItemClickInterface;
import devmob.processoseletivo.temperodochefe.menu.view.NewOrderDialog;
import devmob.processoseletivo.temperodochefe.menu.view.adapter.MenuItemFragmentAdapter;

public class OrderFragment extends BaseMenuFragment {

    public static String TAG = OrderFragment.class.getSimpleName();

    private MenuItemFragmentAdapter orderAdapter;

    private FloatingActionButton fab;

    private int table = 0;
    private int peopleAmount = 0;

    public static OrderFragment newInstance(MenuView menuView, MenuItemClickInterface menuItemClickInterface) {
        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(menuView, true, menuItemClickInterface);
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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NewOrderDialog dialog = new NewOrderDialog(OrderFragment.this, new OrderDialogInterface() {
                    @Override
                    public void setVariables(String table, String peopleAmount) {
                        menuView.makeNewOrder(table, peopleAmount);
                    }
                });
                dialog.show();
            }
        });

        orderAdapter = new MenuItemFragmentAdapter(getActivity(), menuItemClickInterface, true, true);
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