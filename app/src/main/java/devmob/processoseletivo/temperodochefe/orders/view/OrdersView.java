package devmob.processoseletivo.temperodochefe.orders.view;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;

public interface OrdersView {

    void showOrderError(String error);

    void updateRecyclerItems(ArrayList<ItemMenu> arrayList);

}
