package devmob.processoseletivo.temperodochefe.menu.presenter;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.core.callback.SimpleCallback;
import devmob.processoseletivo.temperodochefe.menu.model.MenuModel;
import devmob.processoseletivo.temperodochefe.menu.view.MenuView;

public class MenuPresenterImpl implements MenuPresenter{

    private MenuView menuView;

    private MenuModel menuModel;

    private ArrayList menuItemsArrayList = null;

    public MenuPresenterImpl(MenuView view) {
        menuView = view;
        menuModel = new MenuModel();
    }

    @Override
    public void getMenuItems() {
        if (menuItemsArrayList == null) {
            menuModel.getMenuItems(new SimpleCallback<ArrayList>() {
                @Override
                public void onSuccess(ArrayList arrayList) {
                    menuItemsArrayList = arrayList;
                    menuView.setupRecyclerItems(arrayList);
                }

                @Override
                public void onError() {
                    menuView.showRequestError();
                }
            });
        } else {
            menuView.setupRecyclerItems(menuItemsArrayList);
        }
    }
}
