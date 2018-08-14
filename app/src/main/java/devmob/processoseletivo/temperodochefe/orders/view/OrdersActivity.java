package devmob.processoseletivo.temperodochefe.orders.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.menu.view.MenuItemClickInterface;
import devmob.processoseletivo.temperodochefe.orders.presenter.OrdersPresenter;
import devmob.processoseletivo.temperodochefe.orders.presenter.OrdersPresenterImpl;
import devmob.processoseletivo.temperodochefe.orders.view.adapter.OrdersAdapter;

public class OrdersActivity extends AppCompatActivity implements OrdersView{

    private OrdersPresenter ordersPresenter;

    private OrdersAdapter ordersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        int table = getIntent().getIntExtra(getString(R.string.orders_table_intent_key), 0);

        ordersPresenter = new OrdersPresenterImpl(this, table);

        RecyclerView recycler = findViewById(R.id.recycler_orders);
        ordersAdapter = new OrdersAdapter(this, new MenuItemClickInterface() {
            @Override
            public void onClickItemButton(ItemMenu itemMenu) {
                ordersPresenter.removeItem(itemMenu);
            }
        });
        recycler.setAdapter(ordersAdapter);
    }

    @Override
    public void showOrderError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateRecyclerItems(ArrayList<ItemMenu> arrayList) {
        ordersAdapter.setItemMenuArrayList(arrayList);
    }
}
