package devmob.processoseletivo.temperodochefe.menu.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class MenuDrinksFragmentAdapter extends RecyclerView.Adapter<DrinkViewHolder> {

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class DrinkViewHolder extends RecyclerView.ViewHolder {
    public DrinkViewHolder(View itemView) {
        super(itemView);
    }
}
