package android.niky.mahem_final.Groups;

import android.niky.mahem_final.Add.SabtAgahi_other;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.niky.mahem_final.Search_Filter.Ads;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home_EQ extends AppCompatActivity {
Button kitchen,design;
    Class intent;
    Intent ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__eq);


       ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        kitchen=(Button)findViewById(R.id.btn1);
        design=(Button)findViewById(R.id.btn2);

        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home_EQ.this,Home_Kitchen.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+kitchen.getText().toString());
                startActivity(i);
            }
        });

        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Home_EQ.this,Home_Design.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+design.getText().toString());
                startActivity(i);
            }
        });

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }



}
