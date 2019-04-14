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

public class Khadamat extends AppCompatActivity {
Button pazirayi,beauty,clean,asbab_keshi,nurse,decor,repair,teach,computer,translate,maali,graphic,other;
    Class intent;
    Intent ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khadamat);


        ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;



        pazirayi=(Button)findViewById(R.id.btn1);
        beauty=(Button)findViewById(R.id.btn2);
        clean=(Button)findViewById(R.id.btn3);
        asbab_keshi=(Button)findViewById(R.id.btn4);
        nurse=(Button)findViewById(R.id.btn5);
        decor=(Button)findViewById(R.id.btn6);
        repair=(Button)findViewById(R.id.btn7);
        teach=(Button)findViewById(R.id.btn8);
        computer=(Button)findViewById(R.id.btn9);
        translate=(Button)findViewById(R.id.btn10);
        maali=(Button)findViewById(R.id.btn11);
        graphic=(Button)findViewById(R.id.btn12);
        other=(Button)findViewById(R.id.btn13);

        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Khadamat.this,Khadamat_teach.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+teach.getText().toString());
                startActivity(i);
            }
        });

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Khadamat.this,Khadamat_computer.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+computer.getText().toString());
                startActivity(i);
            }
        });

        pazirayi.setOnClickListener(new IntentClick("60",intent));
        beauty.setOnClickListener(new IntentClick("61",intent));
        clean.setOnClickListener(new IntentClick("62",intent));
        asbab_keshi.setOnClickListener(new IntentClick("63",intent));
        nurse.setOnClickListener(new IntentClick("64",intent));
        decor.setOnClickListener(new IntentClick("65",intent));
        repair.setOnClickListener(new IntentClick("66",intent));
        translate.setOnClickListener(new IntentClick("67",intent));
        maali.setOnClickListener(new IntentClick("68",intent));
        graphic.setOnClickListener(new IntentClick("69",intent));
        other.setOnClickListener(new IntentClick("70",intent));





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
