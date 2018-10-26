package android.niky.mahem_final.Groups;

import android.content.Intent;
import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Estekhdami extends AppCompatActivity {
Button fani,monshi,nurse,edari,teach,mali,seller,seraydar,resturan,kar_sakhteman,art,beauty,computer,haml,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estekhdami);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

      
        fani=(Button)findViewById(R.id.btn1);
        monshi=(Button)findViewById(R.id.btn2);
        nurse=(Button)findViewById(R.id.btn3);
        edari=(Button)findViewById(R.id.btn4);
        teach=(Button)findViewById(R.id.btn5);
        mali=(Button)findViewById(R.id.btn6);
        seller=(Button)findViewById(R.id.btn7);
        seraydar=(Button)findViewById(R.id.btn8);
        resturan=(Button)findViewById(R.id.btn9);
        kar_sakhteman=(Button)findViewById(R.id.btn10);
        art=(Button)findViewById(R.id.btn11);
        beauty=(Button)findViewById(R.id.btn12);
        computer=(Button)findViewById(R.id.btn13);
        haml=(Button)findViewById(R.id.btn14);
        other=(Button)findViewById(R.id.btn15);


        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }
}
