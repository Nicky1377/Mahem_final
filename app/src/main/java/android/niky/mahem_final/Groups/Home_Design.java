package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Home_Design extends AppCompatActivity  {
Button carpet,chair,lostr,commode,parde,bed,decor,TV_desk,fan,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__design);





        carpet=(Button)findViewById(R.id.btn1);
        carpet.setOnClickListener(new IntentClick("44"));
        chair=(Button)findViewById(R.id.btn2);
        chair.setOnClickListener(new IntentClick("45"));
        lostr=(Button)findViewById(R.id.btn3);
        lostr.setOnClickListener(new IntentClick("46"));
        commode=(Button)findViewById(R.id.btn4);
        commode.setOnClickListener(new IntentClick("47"));
        parde=(Button)findViewById(R.id.btn5);
        parde.setOnClickListener(new IntentClick("48"));
        bed=(Button)findViewById(R.id.btn6);
        bed.setOnClickListener(new IntentClick("49"));
        decor=(Button)findViewById(R.id.btn7);
        decor.setOnClickListener(new IntentClick("50"));
        TV_desk=(Button)findViewById(R.id.btn8);
        TV_desk.setOnClickListener(new IntentClick("51"));
        fan=(Button)findViewById(R.id.btn9);
        fan.setOnClickListener(new IntentClick("52"));
        other=(Button)findViewById(R.id.btn10);
        other.setOnClickListener(new IntentClick("53"));

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
