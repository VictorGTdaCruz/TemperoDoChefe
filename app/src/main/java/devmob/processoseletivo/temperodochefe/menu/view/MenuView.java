package devmob.processoseletivo.temperodochefe.menu.view;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;

public interface MenuView {

    void setupOnItemClickListeners(MenuItemClickInterface menuItemButtonClickInterface, MenuItemClickInterface orderItemButtonClickInterface);

    void getMenuItems(String tag);

    void showFirebaseError();

    void setupRecyclerItems(ArrayList<ItemMenu> arrayList);

    void showItemAddedMessage();

    void showItemRemovedMessage();

    void makeNewOrder(String table, String peopleAmount);

}
