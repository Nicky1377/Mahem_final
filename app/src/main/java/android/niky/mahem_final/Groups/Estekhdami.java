package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Estekhdami extends AppCompatActivity  {
Button fani,monshi,nurse,edari,teach,mali,seller,seraydar,resturan,kar_sakhteman,art,beauty,computer,haml,other;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estekhdami);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

      
        fani=(Button)findViewById(R.id.btn1);
        fani.setOnClickListener(new IntentClick("29"));
        monshi=(Button)findViewById(R.id.btn2);
        monshi.setOnClickListener(new IntentClick("30"));
        nurse=(Button)findViewById(R.id.btn3);
        nurse.setOnClickListener(new IntentClick("31"));
        edari=(Button)findViewById(R.id.btn4);
        edari.setOnClickListener(new IntentClick("32"));
        teach=(Button)findViewById(R.id.btn5);
        teach.setOnClickListener(new IntentClick("33"));
        mali=(Button)findViewById(R.id.btn6);
        mali.setOnClickListener(new IntentClick("34"));
        seller=(Button)findViewById(R.id.btn7);
        seller.setOnClickListener(new IntentClick("35"));
        seraydar=(Button)findViewById(R.id.btn8);
        seraydar.setOnClickListener(new IntentClick("36"));
        resturan=(Button)findViewById(R.id.btn9);
        resturan.setOnClickListener(new IntentClick("37"));
        kar_sakhteman=(Button)findViewById(R.id.btn10);
        kar_sakhteman.setOnClickListener(new IntentClick("38"));
        art=(Button)findViewById(R.id.btn11);
        art.setOnClickListener(new IntentClick("39"));
        beauty=(Button)findViewById(R.id.btn12);
        beauty.setOnClickListener(new IntentClick("40"));
        computer=(Button)findViewById(R.id.btn13);
        computer.setOnClickListener(new IntentClick("41"));
        haml=(Button)findViewById(R.id.btn14);
        haml.setOnClickListener(new IntentClick("42"));
        other=(Button)findViewById(R.id.btn15);
        other.setOnClickListener(new IntentClick("43"));


        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }


    class IntentClick implements View.OnClickListener {
        private String Id;

        public IntentClick(String id) {
            Id = id;
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(getBaseContext(), Ads.class);
            i.putExtra("id", Id);
            startActivity(i);
        }
    }


}


