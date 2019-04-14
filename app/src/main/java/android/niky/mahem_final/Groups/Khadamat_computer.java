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

public class Khadamat_computer extends AppCompatActivity {
Button web,net,pc,mobile;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khadamat_computer);


        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;



        web=(Button)findViewById(R.id.btn1);
        web.setOnClickListener(new IntentClick("71",intent));
        net=(Button)findViewById(R.id.btn2);
        net.setOnClickListener(new IntentClick("72",intent));
        pc=(Button)findViewById(R.id.btn3);
        pc.setOnClickListener(new IntentClick("73",intent));
        mobile=(Button)findViewById(R.id.btn4);
        mobile.setOnClickListener(new IntentClick("74",intent));

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
