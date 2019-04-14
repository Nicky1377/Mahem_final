package android.niky.mahem_final.Groups;

import android.niky.mahem_final.Add.SabtAgahi_Car;
import android.niky.mahem_final.Add.SabtAgahi_other;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Naghlieh extends AppCompatActivity  {
Button savari,sangin,motor,yadaki,keshavarzi,other;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naghlieh);

        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_Car.class;
        }else
            intent=Ads.class;


        savari=(Button)findViewById(R.id.btn1);
        savari.setOnClickListener(new IntentClick("81",intent));
        sangin=(Button)findViewById(R.id.btn2);
        sangin.setOnClickListener(new IntentClick("82",intent));
        motor=(Button)findViewById(R.id.btn3);
        motor.setOnClickListener(new IntentClick("83",intent));
        yadaki=(Button)findViewById(R.id.btn4);
        yadaki.setOnClickListener(new IntentClick("84",intent));
        keshavarzi=(Button)findViewById(R.id.btn5);
        keshavarzi.setOnClickListener(new IntentClick("85",intent));
        other=(Button)findViewById(R.id.btn6);
        other.setOnClickListener(new IntentClick("86",intent));

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
