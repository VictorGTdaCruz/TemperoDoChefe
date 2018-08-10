package devmob.processoseletivo.temperodochefe.menu.view.adapter;

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

public class MenuItemFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ItemMenu> itemMenuArrayList = new ArrayList<>();

    private Context context;

    private boolean isOrdering;

    private MenuItemClickInterface clickInterface;

    public MenuItemFragmentAdapter(Context context, boolean isOrdering, MenuItemClickInterface clickInterface) {
        this.context = context;
        this.isOrdering = isOrdering;
        this.clickInterface = clickInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (isOrdering) {
            view = LayoutInflater.from(context).inflate(R.layout.item_menu_ordering, parent, false);
            return new ItemOrderingViewHolder(view);
        }
        else {
            view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemOrderingViewHolder) {
            ItemOrderingViewHolder orderingViewHolder = (ItemOrderingViewHolder) holder;
            orderingViewHolder.bindData(itemMenuArrayList.get(position), clickInterface);
        } else {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.bindData(itemMenuArrayList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return itemMenuArrayList.size();
    }

    public void setItemMenuArrayList(ArrayList<ItemMenu> arrayList) {
        itemMenuArrayList = arrayList;
        this.notifyDataSetChanged();
    }
}