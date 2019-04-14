package android.niky.mahem_final.Groups;

import android.niky.mahem_final.Add.SabtAgahi_Estekhdam;
import android.niky.mahem_final.Add.SabtAgahi_other;
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
    Class intent;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estekhdami);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_Estekhdam.class;
        }else
            intent=Ads.class;


        fani=(Button)findViewById(R.id.btn1);
        fani.setOnClickListener(new IntentClick("29",intent));
        monshi=(Button)findViewById(R.id.btn2);
        monshi.setOnClickListener(new IntentClick("30",intent));
        nurse=(Button)findViewById(R.id.btn3);
        nurse.setOnClickListener(new IntentClick("31",intent));
        edari=(Button)findViewById(R.id.btn4);
        edari.setOnClickListener(new IntentClick("32",intent));
        teach=(Button)findViewById(R.id.btn5);
        teach.setOnClickListener(new IntentClick("33",intent));
        mali=(Button)findViewById(R.id.btn6);
        mali.setOnClickListener(new IntentClick("34",intent));
        seller=(Button)findViewById(R.id.btn7);
        seller.setOnClickListener(new IntentClick("35",intent));
        seraydar=(Button)findViewById(R.id.btn8);
        seraydar.setOnClickListener(new IntentClick("36",intent));
        resturan=(Button)findViewById(R.id.btn9);
        resturan.setOnClickListener(new IntentClick("37",intent));
        kar_sakhteman=(Button)findViewById(R.id.btn10);
        kar_sakhteman.setOnClickListener(new IntentClick("38",intent));
        art=(Button)findViewById(R.id.btn11);
        art.setOnClickListener(new IntentClick("39",intent));
        beauty=(Button)findViewById(R.id.btn12);
        beauty.setOnClickListener(new IntentClick("40",intent));
        computer=(Button)findViewById(R.id.btn13);
        computer.setOnClickListener(new IntentClick("41",intent));
        haml=(Button)findViewById(R.id.btn14);
        haml.setOnClickListener(new IntentClick("42",intent));
        other=(Button)findViewById(R.id.btn15);
        other.setOnClickListener(new IntentClick("43",intent));


        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }


    class IntentClick implements View.OnClickListener {
        private String Id;
        private Class context;
        public IntentClick(String id,final Class c) {
            Id = id;
            context=c;
        }

        @Override
        public void onClick(View view) {
            Button b=(Button)view;
            Intent ii=getIntent();
            Intent i = new Intent(getBaseContext(), context);
            i.putExtra("id", Id);
            i.putExtra("type",ii.getStringExtra("type"));
            i.putExtra("group",ii.getStringExtra("group")+"/"+b.getText().toString());
            startActivity(i);
        }
    }


}


