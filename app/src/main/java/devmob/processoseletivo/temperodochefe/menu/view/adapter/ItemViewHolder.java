package devmob.processoseletivo.temperodochefe.menu.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;

public class ItemViewHolder extends RecyclerView.ViewHolder{

    private ImageView item_img;
    private TextView item_name;
    private TextView item_price;

    ItemViewHolder(View itemView) {
        super(itemView);

        item_name = itemView.findViewById(R.id.item_txt_name);
        item_price = itemView.findViewById(R.id.item_txt_price);
        item_img = itemView.findViewById(R.id.item_img);
    }

    public void bindData(final ItemMenu itemMenu) {
        item_name.setText(itemMenu.getName());

        String price = Integer.toString(itemMenu.getPrice());
        item_price.setText(price);
    }
}
