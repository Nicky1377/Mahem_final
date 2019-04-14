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

public class Tajhizat_tajhizat extends AppCompatActivity {
Button shop,burbershop,office,industry,cofe,other;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajhizat_tajhizat);


        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        shop=(Button)findViewById(R.id.btn1);
        shop.setOnClickListener(new IntentClick("111",intent));
        burbershop=(Button)findViewById(R.id.btn2);
        burbershop.setOnClickListener(new IntentClick("112",intent));
        office=(Button)findViewById(R.id.btn3);
        office.setOnClickListener(new IntentClick("113",intent));
        industry=(Button)findViewById(R.id.btn4);
        industry.setOnClickListener(new IntentClick("114",intent));
        cofe=(Button)findViewById(R.id.btn5);
        cofe.setOnClickListener(new IntentClick("115",intent));
        other=(Button)findViewById(R.id.btn6);
        other.setOnClickListener(new IntentClick("116",intent));

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
