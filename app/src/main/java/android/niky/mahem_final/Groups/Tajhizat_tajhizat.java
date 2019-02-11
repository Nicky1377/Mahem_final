package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Tajhizat_tajhizat extends AppCompatActivity {
Button shop,burbershop,office,industry,cofe,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajhizat_tajhizat);





        shop=(Button)findViewById(R.id.btn1);
        shop.setOnClickListener(new IntentClick("111"));
        burbershop=(Button)findViewById(R.id.btn2);
        burbershop.setOnClickListener(new IntentClick("112"));
        office=(Button)findViewById(R.id.btn3);
        office.setOnClickListener(new IntentClick("113"));
        industry=(Button)findViewById(R.id.btn4);
        industry.setOnClickListener(new IntentClick("114"));
        cofe=(Button)findViewById(R.id.btn5);
        cofe.setOnClickListener(new IntentClick("115"));
        other=(Button)findViewById(R.id.btn6);
        other.setOnClickListener(new IntentClick("116"));

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
