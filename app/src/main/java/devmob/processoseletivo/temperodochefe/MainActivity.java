package devmob.processoseletivo.temperodochefe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import devmob.processoseletivo.temperodochefe.menu.view.MenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, MenuActivity.class));
    }
}
