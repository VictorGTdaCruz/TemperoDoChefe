package devmob.processoseletivo.temperodochefe.menu.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.core.entities.Drink;

public class MenuDrinksFragmentAdapter extends RecyclerView.Adapter<DrinkViewHolder> {

    private ArrayList<Drink> drinkArrayList;

    private Context context;

    public MenuDrinksFragmentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_menu_item, parent, false);
        return new DrinkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        holder.bindData(drinkArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return drinkArrayList.size();
    }

    public void setDrinkArrayList(ArrayList<Drink> arrayList) {
        drinkArrayList = arrayList;
        this.notifyDataSetChanged();
    }
}

class DrinkViewHolder extends RecyclerView.ViewHolder {
    public DrinkViewHolder(View itemView) {
        super(itemView);
    }

    public void bindData(Drink drink) {

    }
}
