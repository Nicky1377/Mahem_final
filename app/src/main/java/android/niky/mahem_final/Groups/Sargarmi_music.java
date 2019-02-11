package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Sargarmi_music extends AppCompatActivity  {
Button piano,saz_badi,guitar,dram,violon,sonati;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sargarmi_music);





        piano=(Button)findViewById(R.id.btn1);
        piano.setOnClickListener(new IntentClick("104"));
        saz_badi=(Button)findViewById(R.id.btn2);
        saz_badi.setOnClickListener(new IntentClick("105"));
        guitar=(Button)findViewById(R.id.btn3);
        guitar.setOnClickListener(new IntentClick("106"));
        dram=(Button)findViewById(R.id.btn4);
        dram.setOnClickListener(new IntentClick("107"));
        violon=(Button)findViewById(R.id.btn5);
        violon.setOnClickListener(new IntentClick("108"));
        sonati=(Button)findViewById(R.id.btn6);
        sonati.setOnClickListener(new IntentClick("109"));

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
