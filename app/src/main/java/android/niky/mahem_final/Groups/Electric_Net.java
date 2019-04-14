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

public class Electric_Net extends AppCompatActivity {
Button laptop,Janebi,printer,modem;
    Class intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric__net);

        Intent ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;



        laptop=(Button)findViewById(R.id.btn1);
        Janebi=(Button)findViewById(R.id.btn2);
        printer=(Button)findViewById(R.id.btn3);
        modem=(Button)findViewById(R.id.btn4);

        laptop.setOnClickListener(new IntentClick("16",intent));
        Janebi.setOnClickListener(new IntentClick("17",intent));
        printer.setOnClickListener(new IntentClick("18",intent));
        modem.setOnClickListener(new IntentClick("19",intent));

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
