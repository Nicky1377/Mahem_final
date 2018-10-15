package android.niky.mahem_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Amlak_OfficeRent extends AppCompatActivity {
    Button shop,office,tejari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak__office_rent);





        shop=(Button)findViewById(R.id.btn1);
        office=(Button)findViewById(R.id.btn2);
        tejari=(Button)findViewById(R.id.btn3);
        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }
}
