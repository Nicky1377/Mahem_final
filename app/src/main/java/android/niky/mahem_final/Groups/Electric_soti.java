package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Electric_soti extends AppCompatActivity {
Button camera,System_soti,TV,DVD,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric_soti);



        camera=(Button)findViewById(R.id.btn1);
        camera.setOnClickListener(new IntentClick("20"));
        System_soti=(Button)findViewById(R.id.btn2);
        System_soti.setOnClickListener(new IntentClick("21"));
        TV=(Button)findViewById(R.id.btn3);
        TV.setOnClickListener(new IntentClick("22"));
        DVD=(Button)findViewById(R.id.btn4);
        DVD.setOnClickListener(new IntentClick("23"));
        other=(Button)findViewById(R.id.btn5);
        other.setOnClickListener(new IntentClick("24"));

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
