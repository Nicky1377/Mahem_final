package android.niky.mahem_final.Groups;

import android.niky.mahem_final.Add.SabtAgahi_Amlak_Office;
import android.niky.mahem_final.Add.SabtAgahi_other;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Amlak_OfficeRent extends AppCompatActivity  {
    Button shop,office,tejari;
    Class intent;
    Intent ii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak__office_rent);

        ii =getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_Amlak_Office.class;
        }else
            intent=Ads.class;

        shop=(Button)findViewById(R.id.btn1);
        shop.setOnClickListener(new IntentClick("8",intent));
        office=(Button)findViewById(R.id.btn2);
        office.setOnClickListener(new IntentClick("9",intent));
        tejari=(Button)findViewById(R.id.btn3);
        tejari.setOnClickListener(new IntentClick("10",intent));



        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
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
            //Intent ii=getIntent();
            Intent i = new Intent(getBaseContext(), context);
            i.putExtra("id", Id);
            i.putExtra("type",ii.getStringExtra("type"));
            i.putExtra("group",ii.getStringExtra("group"));
            startActivity(i);
        }
    }

    }
