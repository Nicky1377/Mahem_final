package android.niky.mahem_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Amlak_HomeSell extends AppCompatActivity {
Button aparteman,home,zamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak__home_sell);



        aparteman=(Button)findViewById(R.id.btn1);
        home=(Button)findViewById(R.id.btn2);
        zamin=(Button)findViewById(R.id.btn3);

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }
}
