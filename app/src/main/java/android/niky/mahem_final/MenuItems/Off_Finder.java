package android.niky.mahem_final.MenuItems;

import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Off_Finder extends AppCompatActivity {
    Button weekend,cafe,arayesh,health,tafrih,LavazemJanebi,M_Arayesh,khodro,zivar,kitchen,teach,art,khadamat,hotel,lavazem_safar,
            pooshak,lavazemTahrir,other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off__finder);

        weekend=(Button)findViewById(R.id.btn1);
        cafe=(Button)findViewById(R.id.btn2);
        arayesh=(Button)findViewById(R.id.btn3);
        health=(Button)findViewById(R.id.btn4);
        tafrih=(Button)findViewById(R.id.btn5);
        LavazemJanebi=(Button)findViewById(R.id.btn6);
        M_Arayesh=(Button)findViewById(R.id.btn7);
        khodro=(Button)findViewById(R.id.btn8);
        zivar=(Button)findViewById(R.id.btn9);
        kitchen=(Button)findViewById(R.id.btn10);
        teach=(Button)findViewById(R.id.btn11);
        art=(Button)findViewById(R.id.btn12);
        khadamat=(Button)findViewById(R.id.btn13);
        hotel=(Button)findViewById(R.id.btn14);
        lavazem_safar=(Button)findViewById(R.id.btn15);
        pooshak=(Button)findViewById(R.id.btn16);
        lavazemTahrir=(Button)findViewById(R.id.btn17);
        other=(Button)findViewById(R.id.btn18);

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();
    }
}
