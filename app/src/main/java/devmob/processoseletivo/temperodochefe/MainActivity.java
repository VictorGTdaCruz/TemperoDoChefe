package devmob.processoseletivo.temperodochefe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import devmob.processoseletivo.temperodochefe.mesas.view.DesksActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inicia a activity
        Intent mesasIntent = new Intent(this, DesksActivity.class);
        startActivity(mesasIntent);
    }
}
