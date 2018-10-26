package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Amlak_HomeRent extends AppCompatActivity {
    Button aparteman,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak__home_rent);





        aparteman=(Button)findViewById(R.id.btn1);
        home=(Button)findViewById(R.id.btn2);

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();

    }
}
