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

public class Sargarmi_music extends AppCompatActivity  {
Button piano,saz_badi,guitar,dram,violon,sonati;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sargarmi_music);


        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        piano=(Button)findViewById(R.id.btn1);
        piano.setOnClickListener(new IntentClick("104",intent));
        saz_badi=(Button)findViewById(R.id.btn2);
        saz_badi.setOnClickListener(new IntentClick("105",intent));
        guitar=(Button)findViewById(R.id.btn3);
        guitar.setOnClickListener(new IntentClick("106",intent));
        dram=(Button)findViewById(R.id.btn4);
        dram.setOnClickListener(new IntentClick("107",intent));
        violon=(Button)findViewById(R.id.btn5);
        violon.setOnClickListener(new IntentClick("108",intent));
        sonati=(Button)findViewById(R.id.btn6);
        sonati.setOnClickListener(new IntentClick("109",intent));

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
