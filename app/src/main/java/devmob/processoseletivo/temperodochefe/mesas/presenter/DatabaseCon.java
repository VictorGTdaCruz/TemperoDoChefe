package devmob.processoseletivo.temperodochefe.mesas.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Map;
import devmob.processoseletivo.temperodochefe.mesas.model.DeskAdapterDataModel;
import devmob.processoseletivo.temperodochefe.mesas.model.Employee;

public class DatabaseCon {

    public interface EmployeeInfoInterface {
        void employeeInforCallback(Employee emp);
    }
    // Interface for communication with activity
    private static EmployeeInfoInterface employeeInfoInterface;

    public DatabaseCon () {}

    public static void getUserInfo (final String userID, Context context) {

        // Create listener
        employeeInfoInterface = (EmployeeInfoInterface) context;
        // Initialize firebase
        FirebaseApp.initializeApp(context);
        // Get a reference of the database
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        // create query to get user info
        dbRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Employee emp = new Employee();
                for (DataSnapshot dt : dataSnapshot.getChildren()) {
                    String name = dt.child("name").getValue(String.class);
                    String photoURL = dt.child("photoURL").getValue(String.class);

                    emp.setName(name);
                    emp.setPhotoUrl(photoURL);
                }
                // Implement callback
                employeeInfoInterface.employeeInforCallback(emp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // failed to read data
                // Send some default data
            }
        });
    }
}
