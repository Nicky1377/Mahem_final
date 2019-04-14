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

public class Personal extends AppCompatActivity {
Button clothes,watch,health,child_clothes,other;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;



        clothes=(Button)findViewById(R.id.btn1);
        clothes.setOnClickListener(new IntentClick("87",intent));
        watch=(Button)findViewById(R.id.btn2);
        watch.setOnClickListener(new IntentClick("88",intent));
        health=(Button)findViewById(R.id.btn3);
        health.setOnClickListener(new IntentClick("89",intent));
        child_clothes=(Button)findViewById(R.id.btn4);
        child_clothes.setOnClickListener(new IntentClick("90",intent));
        other=(Button)findViewById(R.id.btn5);
        other.setOnClickListener(new IntentClick("91",intent));

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
