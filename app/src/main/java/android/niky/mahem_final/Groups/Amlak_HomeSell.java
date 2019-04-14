package android.niky.mahem_final.Groups;

import android.niky.mahem_final.Add.SabtAgahi_Amlak_Home;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.niky.mahem_final.Search_Filter.Ads;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Amlak_HomeSell extends AppCompatActivity {
Button aparteman,home,zamin;
    Class intent;
    Intent ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak__home_sell);

        ii =getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_Amlak_Home.class;
        }else
            intent= Ads.class;


        aparteman=(Button)findViewById(R.id.btn1);
        aparteman.setOnClickListener(new IntentClick("3",intent));
        home=(Button)findViewById(R.id.btn2);
        home.setOnClickListener(new IntentClick("4",intent));
        zamin=(Button)findViewById(R.id.btn3);
        zamin.setOnClickListener(new IntentClick("5",intent));

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

            Intent i = new Intent(getBaseContext(), context);
            i.putExtra("id", Id);
            i.putExtra("type",ii.getStringExtra("type"));
            i.putExtra("group",ii.getStringExtra("group"));
            startActivity(i);
        }
    }


}
