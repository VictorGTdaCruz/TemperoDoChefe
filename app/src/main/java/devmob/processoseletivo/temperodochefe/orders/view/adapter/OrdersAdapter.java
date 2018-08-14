package devmob.processoseletivo.temperodochefe.orders.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.menu.view.MenuItemClickInterface;

public class OrdersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ItemMenu> itemOrdersArrayList = new ArrayList<>();

    private Context context;

    private MenuItemClickInterface clickInterface;

    public OrdersAdapter(Context context, MenuItemClickInterface clickInterface) {
        this.context = context;
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_orders, parent, false);
        return new ItemOrdersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemOrdersViewHolder itemViewHolder = (ItemOrdersViewHolder) holder;
        itemViewHolder.bindData(itemOrdersArrayList.get(position), clickInterface);
    }

    @Override
    public int getItemCount() {
        return itemOrdersArrayList.size();
    }

    public void setItemMenuArrayList(ArrayList<ItemMenu> arrayList) {
        itemOrdersArrayList = arrayList;
        this.notifyDataSetChanged();
    }
}