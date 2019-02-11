package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

public class Sargarmi extends AppCompatActivity {
Button cycle,sport,travel,asbab_bazi,music,book,pet,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sargarmi);





        cycle=(Button)findViewById(R.id.btn1);
        sport=(Button)findViewById(R.id.btn2);
        travel=(Button)findViewById(R.id.btn3);
        asbab_bazi=(Button)findViewById(R.id.btn4);
        music=(Button)findViewById(R.id.btn5);
        book=(Button)findViewById(R.id.btn6);
        pet=(Button)findViewById(R.id.btn7);
        other=(Button)findViewById(R.id.btn8);

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Sargarmi.this,Sargarmi_music.class);
                startActivity(i);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Sargarmi.this,Sargarmi_book.class);
                startActivity(i);
            }
        });

        cycle.setOnClickListener(new IntentClick("92"));
        sport.setOnClickListener(new IntentClick("93"));
        travel.setOnClickListener(new IntentClick("94"));
        asbab_bazi.setOnClickListener(new IntentClick("95"));
        pet.setOnClickListener(new IntentClick("96"));
        other.setOnClickListener(new IntentClick("97"));


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
