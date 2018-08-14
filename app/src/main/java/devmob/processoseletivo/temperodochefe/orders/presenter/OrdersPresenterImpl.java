package devmob.processoseletivo.temperodochefe.orders.presenter;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.core.callback.SimpleCallback;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.orders.model.OrdersModelImpl;
import devmob.processoseletivo.temperodochefe.orders.view.OrdersView;

public class OrdersPresenterImpl implements OrdersPresenter {

    private OrdersView ordersView;

    private OrdersModelImpl ordersModel;

    private int table;
    private ArrayList<ItemMenu> tableItems;

    public OrdersPresenterImpl(final OrdersView ordersView, int table) {
        this.ordersView = ordersView;
        this.table = table;

        ordersModel = new OrdersModelImpl();

        getTableItems();
    }

    private void getTableItems() {
        ordersModel.getTableItems(String.valueOf(table), new SimpleCallback<ArrayList<ItemMenu>>() {
            @Override
            public void onSuccess(ArrayList<ItemMenu> response) {
                tableItems = response;
                ordersView.updateRecyclerItems(tableItems);
            }

            @Override
            public void onError(String error) {
                ordersView.showOrderError(error);
            }
        });
    }

    @Override
    public void removeItem(ItemMenu itemMenu) {
        ordersModel.removeItem(String.valueOf(table), itemMenu);
    }
}
