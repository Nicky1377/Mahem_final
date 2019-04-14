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

public class Sargarmi_book extends AppCompatActivity {
Button teach,religion,history,literary,magazine,other;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sargarmi_book);


        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        teach=(Button)findViewById(R.id.btn1);
        teach.setOnClickListener(new IntentClick("98",intent));
        religion=(Button)findViewById(R.id.btn2);
        religion.setOnClickListener(new IntentClick("99",intent));
        history=(Button)findViewById(R.id.btn3);
        history.setOnClickListener(new IntentClick("100",intent));
        literary=(Button)findViewById(R.id.btn4);
        literary.setOnClickListener(new IntentClick("101",intent));
        magazine=(Button)findViewById(R.id.btn5);
        magazine.setOnClickListener(new IntentClick("102",intent));
        other=(Button)findViewById(R.id.btn6);
        other.setOnClickListener(new IntentClick("103",intent));

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
