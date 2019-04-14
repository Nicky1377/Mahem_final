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

public class Khadamat_teach extends AppCompatActivity  {
Button Language,school,software,art,sport,moshaver;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khadamat_teach);

        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        Language=(Button)findViewById(R.id.btn1);
        Language.setOnClickListener(new IntentClick("75",intent));
        school=(Button)findViewById(R.id.btn2);
        school.setOnClickListener(new IntentClick("76",intent));
        software=(Button)findViewById(R.id.btn3);
        software.setOnClickListener(new IntentClick("77",intent));
        art=(Button)findViewById(R.id.btn4);
        art.setOnClickListener(new IntentClick("78",intent));
        sport=(Button)findViewById(R.id.btn5);
        sport.setOnClickListener(new IntentClick("79",intent));
        moshaver=(Button)findViewById(R.id.btn6);
        moshaver.setOnClickListener(new IntentClick("80",intent));
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
