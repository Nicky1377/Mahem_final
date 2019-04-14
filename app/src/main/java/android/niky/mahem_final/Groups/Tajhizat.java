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

public class Tajhizat extends AppCompatActivity {
Button tajhizat,omde;
    Class intent;
    Intent ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajhizat);


       ii=getIntent();
        if(ii.getStringExtra("type").equals("sabt"))
        {
            intent= SabtAgahi_other.class;
        }else
            intent=Ads.class;




        tajhizat=(Button)findViewById(R.id.btn1);
        omde=(Button)findViewById(R.id.btn2);

        tajhizat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Tajhizat.this,Tajhizat_tajhizat.class);
                i.putExtra("type",ii.getStringExtra("type"));
                i.putExtra("group",ii.getStringExtra("group")+"/"+tajhizat.getText().toString());
                startActivity(i);
            }
        });
        omde.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
          Intent i = new Intent(getBaseContext(), Ads.class);
          i.putExtra("id", "110");
          i.putExtra("type",ii.getStringExtra("type"));
          i.putExtra("group",ii.getStringExtra("group")+"/"+omde.getText().toString());
          startActivity(i);
              }
                                });

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }




}
