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

public class Home_Kitchen extends AppCompatActivity {
Button freezer,gas,wash_cloth,food,wash_dish,other;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__kitchen);


        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        freezer=(Button)findViewById(R.id.btn1);
        freezer.setOnClickListener(new IntentClick("54",intent));
        gas=(Button)findViewById(R.id.btn2);
        gas.setOnClickListener(new IntentClick("55",intent));
        wash_cloth=(Button)findViewById(R.id.btn3);
        wash_cloth.setOnClickListener(new IntentClick("56",intent));
        food=(Button)findViewById(R.id.btn4);
        food.setOnClickListener(new IntentClick("57",intent));
        wash_dish=(Button)findViewById(R.id.btn5);
        wash_dish.setOnClickListener(new IntentClick("58",intent));
        other=(Button)findViewById(R.id.btn6);
        other.setOnClickListener(new IntentClick("59",intent));

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
