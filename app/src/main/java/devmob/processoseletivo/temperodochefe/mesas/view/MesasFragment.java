package devmob.processoseletivo.temperodochefe.mesas.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.mesas.adapters.DesksAdapter;
import devmob.processoseletivo.temperodochefe.orders.view.OrdersActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MesasFragment extends Fragment implements DesksAdapter.ItemSelectionListener {

    private RecyclerView desksRecyclerView;
    private DesksAdapter desksAdapter;

    public MesasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_desks, container, false);

        desksRecyclerView = view.findViewById(R.id.desks_recyclerview);
        int numberOfDesks = 8;
        desksRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        // Initialize the adapter
        desksAdapter = new DesksAdapter(getContext(), numberOfDesks, this);
        desksRecyclerView.setAdapter(desksAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemSelectionListener(int pos) {
        // Initialize the MenuActivity sending the number of the table and associate an order with the desk
        Log.v("MESA SELECTIONADA: ", String.valueOf(pos));
        Intent ordersIntent = new Intent(getActivity(), OrdersActivity.class);
        ordersIntent.putExtra("orders_table_intent_key", pos);
        startActivity(ordersIntent);

    }
}
