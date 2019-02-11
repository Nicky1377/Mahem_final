package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Personal extends AppCompatActivity {
Button clothes,watch,health,child_clothes,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);



        clothes=(Button)findViewById(R.id.btn1);
        clothes.setOnClickListener(new IntentClick("87"));
        watch=(Button)findViewById(R.id.btn2);
        watch.setOnClickListener(new IntentClick("88"));
        health=(Button)findViewById(R.id.btn3);
        health.setOnClickListener(new IntentClick("89"));
        child_clothes=(Button)findViewById(R.id.btn4);
        child_clothes.setOnClickListener(new IntentClick("90"));
        other=(Button)findViewById(R.id.btn5);
        other.setOnClickListener(new IntentClick("91"));

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
