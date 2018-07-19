package devmob.processoseletivo.temperodochefe.mesas.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import devmob.processoseletivo.temperodochefe.R;

public class DesksAdapter extends RecyclerView.Adapter<DesksAdapter.ViewHolder>{

    // The number of desks in the restaurant
    private int desksNumber;
    // Create Interface for the Listener
    public interface ItemSelectionListener {
        void onItemSelectionListener(int pos);
    }

    private ItemSelectionListener mItemSelectionListener;
    private Context mContext;

    // Get the number of desks
    // as the desks are named by numbers and are not saved on the history, just receive the number of desks
    public DesksAdapter (Context context, int numberOfDesks, ItemSelectionListener itemSelectionListener) {
        this.mContext = context;
        this.desksNumber = numberOfDesks;
        this.mItemSelectionListener = itemSelectionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.desks_layout_cardview,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // set the text of the card
        String deskTitle = "Mesa" + position;
        holder.textView.setText(deskTitle);
        // set the default image
        holder.imageView.setImageResource(R.drawable.mesa);
    }

    @Override
    public int getItemCount() {
        return this.desksNumber;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View v) {
            super(v);

            v.setOnClickListener(this);
            textView = (TextView) v.findViewById(R.id.desk_title_textview);
            imageView = (ImageView) v.findViewById(R.id.desk_background_imageview);
        }

        @Override
        public void onClick(View v) {
            if (mItemSelectionListener != null) {
                mItemSelectionListener.onItemSelectionListener(getAdapterPosition());
            }
        }
    }
}
