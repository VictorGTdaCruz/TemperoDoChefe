package devmob.processoseletivo.temperodochefe.menu.presenter;

import android.util.Log;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.core.callback.SimpleCallback;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.menu.model.MenuModel;
import devmob.processoseletivo.temperodochefe.menu.view.MenuView;
import devmob.processoseletivo.temperodochefe.menu.view.MenuItemClickInterface;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.MenuDessertsFragment;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.MenuDishesFragment;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.MenuDrinksFragment;
import devmob.processoseletivo.temperodochefe.menu.view.fragments.OrderFragment;

public class MenuPresenterImpl implements MenuPresenter{

    private MenuView menuView;

    private MenuModel menuModel;

    private ArrayList<ItemMenu> dessertsArrayList = new ArrayList<>();
    private ArrayList<ItemMenu> drinksArrayList = new ArrayList<>();
    private ArrayList<ItemMenu> dishesArrayList = new ArrayList<>();
    private ArrayList<ItemMenu> orderArrayList = new ArrayList<>();

    public MenuPresenterImpl(MenuView view) {
        menuView = view;
        menuModel = new MenuModel();

        menuView.setupOnItemClickListeners(new MenuItemClickInterface() {
            @Override
            public void onClickItemButton(ItemMenu itemMenu) {
                orderArrayList.add(itemMenu);
            }
        }, new MenuItemClickInterface() {
            @Override
            public void onClickItemButton(ItemMenu itemMenu) {
                orderArrayList.remove(itemMenu);
                menuView.setupRecyclerItems(orderArrayList);
            }
        });
    }

    @Override
    public void getMenuItems(String tag) {
        if (dessertsArrayList.isEmpty() && drinksArrayList.isEmpty() && dishesArrayList.isEmpty())
            getMenuItemsFromFirebase(tag);
        else
            showItemsBasedOnFragment(tag);
    }

    private void getMenuItemsFromFirebase(final String tag) {
        menuModel.getMenuItems(new SimpleCallback<ArrayList<ItemMenu>>() {
            @Override
            public void onSuccess(ArrayList<ItemMenu> arrayList) {
                populateArrayLists(arrayList);
                showItemsBasedOnFragment(tag);
            }

            @Override
            public void onError(String error) {
                menuView.showFirebaseError();
            }
        });
    }

    private void showItemsBasedOnFragment(String tag) {
        if (tag.equals(MenuDishesFragment.class.getSimpleName())){
            menuView.setupRecyclerItems(dishesArrayList);
        } else if (tag.equals(MenuDrinksFragment.TAG)) {
            menuView.setupRecyclerItems(drinksArrayList);
        } else if (tag.equals(MenuDessertsFragment.TAG)) {
            menuView.setupRecyclerItems(dessertsArrayList);
        } else if (tag.equals(OrderFragment.TAG)) {
            menuView.setupRecyclerItems(orderArrayList);
        }
    }

    private void populateArrayLists(ArrayList<ItemMenu> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            switch (arrayList.get(i).getType()) {
                case "dish" :
                    dishesArrayList.add(arrayList.get(i));
                    break;
                case "drink" :
                    drinksArrayList.add(arrayList.get(i));
                    break;
                case "dessert" :
                    dessertsArrayList.add(arrayList.get(i));
                    break;
                default:
                    break;
            }
        }
    }
}
