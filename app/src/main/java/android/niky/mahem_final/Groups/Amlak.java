package android.niky.mahem_final.Groups;

import android.niky.mahem_final.Add.SabtAgahi_Amlak_Home;
import android.niky.mahem_final.Add.SabtAgahi_Estekhdam;
import android.niky.mahem_final.Add.SabtAgahi_Takhfif;
import android.niky.mahem_final.Add.SabtAgahi_other;
import android.niky.mahem_final.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;
public class Amlak extends AppCompatActivity {
    Button home_sell,home_rent,office_sell,office_rent,aghd,other;
   // TextView title;
    Intent ii;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak);

        init();

        ii =getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_Amlak_Home.class;
        }else
            intent=Ads.class;


        home_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Amlak.this, Amlak_HomeSell.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+home_sell.getText().toString());
                startActivity(i);
            }
        });

        home_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Amlak.this,Amlak_HomeRent.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+home_rent.getText().toString());
                startActivity(i);
            }
        });
        office_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Amlak.this,Amlak_OfficeSell.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+office_sell.getText().toString());
                startActivity(i);
            }
        });
        office_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Amlak.this,Amlak_OfficeRent.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+office_rent.getText().toString());
                startActivity(i);
            }
        });

        aghd.setOnClickListener(new IntentClick("1",intent));

        other.setOnClickListener(new IntentClick("2",intent));

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }


    private void init()
    {

      //  title=(TextView)findViewById(R.id.title);
        home_sell=(Button)findViewById(R.id.btn1);
        home_rent=(Button)findViewById(R.id.btn2);
        office_sell=(Button)findViewById(R.id.btn3);
        office_rent=(Button)findViewById(R.id.btn4);
        aghd=(Button)findViewById(R.id.btn5);
        other=(Button)findViewById(R.id.btn6);


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
            Intent i = new Intent(getBaseContext(), context);
            i.putExtra("id", Id);
            i.putExtra("type",ii.getStringExtra("type"));
            i.putExtra("group",ii.getStringExtra("group")+"/"+b.getText().toString());
            startActivity(i);
        }
    }
}
