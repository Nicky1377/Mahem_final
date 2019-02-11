package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Naghlieh extends AppCompatActivity  {
Button savari,sangin,motor,yadaki,keshavarzi,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naghlieh);


        savari=(Button)findViewById(R.id.btn1);
        savari.setOnClickListener(new IntentClick("81"));
        sangin=(Button)findViewById(R.id.btn2);
        sangin.setOnClickListener(new IntentClick("82"));
        motor=(Button)findViewById(R.id.btn3);
        motor.setOnClickListener(new IntentClick("83"));
        yadaki=(Button)findViewById(R.id.btn4);
        yadaki.setOnClickListener(new IntentClick("84"));
        keshavarzi=(Button)findViewById(R.id.btn5);
        keshavarzi.setOnClickListener(new IntentClick("85"));
        other=(Button)findViewById(R.id.btn6);
        other.setOnClickListener(new IntentClick("86"));

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
