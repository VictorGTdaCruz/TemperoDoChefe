package devmob.processoseletivo.temperodochefe.menu.model;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import devmob.processoseletivo.temperodochefe.BuildConfig;
import devmob.processoseletivo.temperodochefe.core.callback.SimpleCallback;
import devmob.processoseletivo.temperodochefe.core.entities.ItemMenu;
import devmob.processoseletivo.temperodochefe.core.entities.Order;

public class MenuModel {

    private DatabaseReference database;

    public MenuModel() {
        database = FirebaseDatabase.getInstance().getReferenceFromUrl(BuildConfig.FIREBASE_DATABASE_URL);
    }

    public void getMenuItems(final SimpleCallback<ArrayList<ItemMenu>> callback) {
        database.child("menu").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<ItemMenu> itemMenus = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    ItemMenu item = noteDataSnapshot.getValue(ItemMenu.class);
                    itemMenus.add(item);
                }
                callback.onSuccess(itemMenus);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callback.onError(databaseError.getMessage());
            }
        });
    }

    public void makeNewOrder(Order order) {
        database.child("pedidos").setValue(order);
    }

}
