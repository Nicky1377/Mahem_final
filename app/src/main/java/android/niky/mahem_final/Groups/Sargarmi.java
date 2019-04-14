package android.niky.mahem_final.Groups;

import android.niky.mahem_final.Add.SabtAgahi_other;
import android.niky.mahem_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Sargarmi extends AppCompatActivity {
Button cycle,sport,travel,asbab_bazi,music,book,pet,other;
    Class intent;
    Intent ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sargarmi);


        ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        cycle=(Button)findViewById(R.id.btn1);
        sport=(Button)findViewById(R.id.btn2);
        travel=(Button)findViewById(R.id.btn3);
        asbab_bazi=(Button)findViewById(R.id.btn4);
        music=(Button)findViewById(R.id.btn5);
        book=(Button)findViewById(R.id.btn6);
        pet=(Button)findViewById(R.id.btn7);
        other=(Button)findViewById(R.id.btn8);

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Sargarmi.this,Sargarmi_music.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+music.getText().toString());
                startActivity(i);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Sargarmi.this,Sargarmi_book.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+book.getText().toString());
                startActivity(i);
            }
        });

        cycle.setOnClickListener(new IntentClick("92",intent));
        sport.setOnClickListener(new IntentClick("93",intent));
        travel.setOnClickListener(new IntentClick("94",intent));
        asbab_bazi.setOnClickListener(new IntentClick("95",intent));
        pet.setOnClickListener(new IntentClick("96",intent));
        other.setOnClickListener(new IntentClick("97",intent));


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
