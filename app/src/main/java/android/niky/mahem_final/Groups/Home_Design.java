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

public class Home_Design extends AppCompatActivity  {
Button carpet,chair,lostr,commode,parde,bed,decor,TV_desk,fan,other;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__design);


        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        carpet=(Button)findViewById(R.id.btn1);
        carpet.setOnClickListener(new IntentClick("44",intent));
        chair=(Button)findViewById(R.id.btn2);
        chair.setOnClickListener(new IntentClick("45",intent));
        lostr=(Button)findViewById(R.id.btn3);
        lostr.setOnClickListener(new IntentClick("46",intent));
        commode=(Button)findViewById(R.id.btn4);
        commode.setOnClickListener(new IntentClick("47",intent));
        parde=(Button)findViewById(R.id.btn5);
        parde.setOnClickListener(new IntentClick("48",intent));
        bed=(Button)findViewById(R.id.btn6);
        bed.setOnClickListener(new IntentClick("49",intent));
        decor=(Button)findViewById(R.id.btn7);
        decor.setOnClickListener(new IntentClick("50",intent));
        TV_desk=(Button)findViewById(R.id.btn8);
        TV_desk.setOnClickListener(new IntentClick("51",intent));
        fan=(Button)findViewById(R.id.btn9);
        fan.setOnClickListener(new IntentClick("52",intent));
        other=(Button)findViewById(R.id.btn10);
        other.setOnClickListener(new IntentClick("53",intent));

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
