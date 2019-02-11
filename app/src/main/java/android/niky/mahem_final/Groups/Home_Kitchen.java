package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Home_Kitchen extends AppCompatActivity {
Button freezer,gas,wash_cloth,food,wash_dish,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__kitchen);





        freezer=(Button)findViewById(R.id.btn1);
        freezer.setOnClickListener(new IntentClick("54"));
        gas=(Button)findViewById(R.id.btn2);
        gas.setOnClickListener(new IntentClick("55"));
        wash_cloth=(Button)findViewById(R.id.btn3);
        wash_cloth.setOnClickListener(new IntentClick("56"));
        food=(Button)findViewById(R.id.btn4);
        food.setOnClickListener(new IntentClick("57"));
        wash_dish=(Button)findViewById(R.id.btn5);
        wash_dish.setOnClickListener(new IntentClick("58"));
        other=(Button)findViewById(R.id.btn6);
        other.setOnClickListener(new IntentClick("59"));

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
