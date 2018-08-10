package devmob.processoseletivo.temperodochefe.menu.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.menu.view.MenuView;
import devmob.processoseletivo.temperodochefe.menu.view.MenuItemClickInterface;

public abstract class BaseMenuFragment extends Fragment {

    protected MenuView menuView;
    protected boolean isOrdering;
    protected MenuItemClickInterface teste;
    protected ProgressBar progressBar;
    protected TextView emptyText;

    public void setArguments(MenuView menuView, boolean isOrdering, MenuItemClickInterface teste) {
        this.menuView = menuView;
        this.isOrdering = isOrdering;
        this.teste = teste;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progress_bar);
        emptyText = view.findViewById(R.id.menu_text_empty);

        shouldShowProgressBar(true);
    }

    public void setRecyclerItems(ArrayList<ItemMenu> arrayList) {
        shouldShowProgressBar(false);
        if (arrayList.isEmpty()) {
            emptyText.setVisibility(View.VISIBLE);
        } else {
            emptyText.setVisibility(View.GONE);
        }
    }

    public void shouldShowProgressBar(boolean bool) {
        if (bool) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
