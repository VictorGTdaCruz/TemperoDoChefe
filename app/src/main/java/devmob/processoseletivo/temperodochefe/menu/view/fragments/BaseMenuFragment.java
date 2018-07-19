package devmob.processoseletivo.temperodochefe.menu.view.fragments;

import android.support.v4.app.Fragment;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.menu.view.MenuView;

public class BaseMenuFragment extends Fragment {

    protected MenuView menuView;

    public void setArguments(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setRecyclerItems(ArrayList arrayList){}

}
