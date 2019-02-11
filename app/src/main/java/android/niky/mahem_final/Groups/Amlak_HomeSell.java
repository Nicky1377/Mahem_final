package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Amlak_HomeSell extends AppCompatActivity {
Button aparteman,home,zamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak__home_sell);



        aparteman=(Button)findViewById(R.id.btn1);
        aparteman.setOnClickListener(new IntentClick("3"));
        home=(Button)findViewById(R.id.btn2);
        home.setOnClickListener(new IntentClick("4"));
        zamin=(Button)findViewById(R.id.btn3);
        zamin.setOnClickListener(new IntentClick("5"));

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }

    class IntentClick implements View.OnClickListener{
        private String Id;
        public IntentClick(String id)
        {
            Id=id;
        }
        @Override
        public void onClick(View view) {
            Intent i=new Intent(getBaseContext(),Ads.class);
            i.putExtra("id",Id);
            startActivity(i);
        }
    }


}
