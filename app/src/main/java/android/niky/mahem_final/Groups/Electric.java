package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Electric extends AppCompatActivity {
Button tablet,net,soti,console,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric);





        tablet=(Button)findViewById(R.id.btn1);
        net=(Button)findViewById(R.id.btn2);
        soti=(Button)findViewById(R.id.btn3);
        console=(Button)findViewById(R.id.btn4);
        other=(Button)findViewById(R.id.btn5);

        tablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Electric.this,Electric_Tablet.class);
                startActivity(i);
            }
        });
        soti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Electric.this,Electric_soti.class);
                startActivity(i);
            }
        });

        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Electric.this,Electric_Net.class);
                startActivity(i);
            }
        });

        console.setOnClickListener(new IntentClick("14"));
        other.setOnClickListener(new IntentClick("15"));

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }

    class IntentClick implements View.OnClickListener {
        private String Id;

        public IntentClick(String id) {
            Id = id;
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(getBaseContext(), Ads.class);
            i.putExtra("id", Id);
            startActivity(i);
        }
    }

}
