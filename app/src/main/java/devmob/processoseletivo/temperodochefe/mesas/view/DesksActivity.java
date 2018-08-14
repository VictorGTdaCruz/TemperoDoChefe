package devmob.processoseletivo.temperodochefe.mesas.view;

import android.content.Intent;
import android.media.Image;
import  android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import devmob.processoseletivo.temperodochefe.R;
import devmob.processoseletivo.temperodochefe.menu.view.MenuActivity;
import devmob.processoseletivo.temperodochefe.mesas.model.Employee;
import devmob.processoseletivo.temperodochefe.mesas.presenter.DatabaseCon;
import devmob.processoseletivo.temperodochefe.mesas.presenter.EmployeeCallback;


public class DesksActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DatabaseCon.EmployeeInfoInterface {

    private ImageView empImageview;
    private TextView empNameTextview;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Drawer configurations
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Get the header reference
        View header = navigationView.getHeaderView(0);
        // Initialize the imageview and textview
        empImageview = (ImageView) header.findViewById(R.id.employee_imageView);
        empNameTextview = (TextView) header.findViewById(R.id.empUsernameTextview);
        // Handle user data
        auth = FirebaseAuth.getInstance();
        String loggedUser = auth.getCurrentUser().getUid();
        Log.i("user", auth.getCurrentUser().getEmail());
        DatabaseCon.getUserInfo(loggedUser, this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            auth.signOut();
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mesas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_menu){
            Intent menuIntent = new Intent(this, MenuActivity.class);
            startActivity(menuIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void employeeInforCallback(Employee emp) {
        if (emp != null) {
            // Update imageview
            Picasso.get().load(emp.getPhotoUrl()).resize(256,256).into(empImageview);
            // Update textview
            empNameTextview.setText(emp.getName());
        } else {
            empImageview.setImageResource(R.drawable.image_profile);
        }
    }
}
