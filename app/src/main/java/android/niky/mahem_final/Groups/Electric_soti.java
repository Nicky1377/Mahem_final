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

public class Electric_soti extends AppCompatActivity {
Button camera,System_soti,TV,DVD,other;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_soti);

        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;



        camera=(Button)findViewById(R.id.btn1);
        camera.setOnClickListener(new IntentClick("20",intent));
        System_soti=(Button)findViewById(R.id.btn2);
        System_soti.setOnClickListener(new IntentClick("21",intent));
        TV=(Button)findViewById(R.id.btn3);
        TV.setOnClickListener(new IntentClick("22",intent));
        DVD=(Button)findViewById(R.id.btn4);
        DVD.setOnClickListener(new IntentClick("23",intent));
        other=(Button)findViewById(R.id.btn5);
        other.setOnClickListener(new IntentClick("24",intent));

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
