package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Electric_Tablet extends AppCompatActivity {
Button mobile,tablet,LavazemJanebi,simcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric__tablet);





        mobile=(Button)findViewById(R.id.btn1);
        tablet=(Button)findViewById(R.id.btn2);
        LavazemJanebi=(Button)findViewById(R.id.btn3);
        simcard=(Button)findViewById(R.id.btn4);
        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }
}
