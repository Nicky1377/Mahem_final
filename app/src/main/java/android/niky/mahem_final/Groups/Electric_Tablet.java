package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Electric_Tablet extends AppCompatActivity {
Button mobile,tablet,LavazemJanebi,simcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric__tablet);





        mobile=(Button)findViewById(R.id.btn1);
        mobile.setOnClickListener(new IntentClick("25"));
        tablet=(Button)findViewById(R.id.btn2);
        tablet.setOnClickListener(new IntentClick("26"));
        LavazemJanebi=(Button)findViewById(R.id.btn3);
        LavazemJanebi.setOnClickListener(new IntentClick("27"));
        simcard=(Button)findViewById(R.id.btn4);
        simcard.setOnClickListener(new IntentClick("28"));

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
