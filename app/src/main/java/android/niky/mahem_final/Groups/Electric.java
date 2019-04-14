package android.niky.mahem_final.Groups;

import android.content.Context;
import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Add.SabtAgahi_other;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Electric extends AppCompatActivity {
Button tablet,net,soti,console,other;
Class intent;
Intent ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric);



       ii =getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;


        tablet=(Button)findViewById(R.id.btn1);
        net=(Button)findViewById(R.id.btn2);
        soti=(Button)findViewById(R.id.btn3);
        console=(Button)findViewById(R.id.btn4);
        other=(Button)findViewById(R.id.btn5);

        tablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Electric.this,Electric_Tablet.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+tablet.getText().toString());
                startActivity(i);
            }
        });
        soti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Electric.this,Electric_soti.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+soti.getText().toString());
                startActivity(i);
            }
        });

        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Electric.this,Electric_Net.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+net.getText().toString());
                startActivity(i);
            }
        });

        console.setOnClickListener(new IntentClick("14",intent));
        other.setOnClickListener(new IntentClick("15",intent));

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
            Intent ii=getIntent();
            Intent i = new Intent(getBaseContext(), context);
            i.putExtra("id", Id);
            i.putExtra("type",ii.getStringExtra("type"));
            i.putExtra("group",ii.getStringExtra("group")+"/"+b.getText().toString());
            startActivity(i);
        }
    }

}
