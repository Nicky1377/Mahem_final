package android.niky.mahem_final.Groups;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.R;

public class Khadamat_teach extends AppCompatActivity {
Button Language,school,software,art,sport,moshaver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khadamat_teach);




        Language=(Button)findViewById(R.id.btn1);
        school=(Button)findViewById(R.id.btn2);
        software=(Button)findViewById(R.id.btn3);
        art=(Button)findViewById(R.id.btn4);
        sport=(Button)findViewById(R.id.btn5);
        moshaver=(Button)findViewById(R.id.btn6);
        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }
}
