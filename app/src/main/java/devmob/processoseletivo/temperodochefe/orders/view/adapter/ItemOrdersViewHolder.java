package devmob.processoseletivo.temperodochefe.orders.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.core.util.CurrencyUtil;
import devmob.processoseletivo.temperodochefe.menu.view.MenuItemClickInterface;

public class ItemOrdersViewHolder extends RecyclerView.ViewHolder{

    private ImageView item_img;
    private TextView item_name;
    private TextView item_price;
    private Button item_btn_order;

    ItemOrdersViewHolder(View itemView) {
        super(itemView);

        item_name = itemView.findViewById(R.id.item_order_txt_name);
        item_price = itemView.findViewById(R.id.item_order_txt_price);
        item_img = itemView.findViewById(R.id.item_order_img);
        item_btn_order = itemView.findViewById(R.id.item_order_btn);
    }

    public void bindData(final ItemMenu itemMenu, final MenuItemClickInterface clickInterface) {
        Picasso.get().load(itemMenu.getImg()).into(item_img);

        item_name.setText(itemMenu.getName());

        String price = CurrencyUtil.ApplyCurrency(itemMenu.getPrice());
        item_price.setText(price);

        item_btn_order.setText(R.string.orders_item_btn_text_remove);
        item_btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickInterface.onClickItemButton(itemMenu);
            }
        });
    }
}
