package devmob.processoseletivo.temperodochefe.menu.presenter;

import devmob.processoseletivo.temperodochefe.menu.view.MenuView;

public class MenuPresenterImpl implements MenuPresenter{

    private MenuView menuView;

    public MenuPresenterImpl(MenuView view) {
        menuView = view;
    }

}
