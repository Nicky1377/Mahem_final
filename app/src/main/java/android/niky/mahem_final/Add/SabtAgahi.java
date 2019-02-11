package android.niky.mahem_final.Add;

import android.niky.mahem_final.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class SabtAgahi extends AppCompatActivity {
    Button estekhdam,takhfifYab,amlak,naghlie,electric,home,khadamat,tajhizat,sargarmi,personal;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi);

        init();

        takhfifYab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SabtAgahi.this,SabtAgahi_Takhfif.class);
                startActivity(i);
            }
        });

        naghlie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SabtAgahi.this,SabtAgahi_Car.class);
                startActivity(i);
            }
        });

        amlak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SabtAgahi.this,SabtAgahi_Home_Office.class);
                startActivity(i);
            }
        });

        estekhdam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SabtAgahi.this,SabtAgahi_Estekhdam.class);
                startActivity(i);
            }
        });

        electric.setOnClickListener(new IntentClick(electric.getText().toString()));
        home.setOnClickListener(new IntentClick(home.getText().toString()));
        khadamat.setOnClickListener(new IntentClick(khadamat.getText().toString()));
        tajhizat.setOnClickListener(new IntentClick(tajhizat.getText().toString()));
        sargarmi.setOnClickListener(new IntentClick(sargarmi.getText().toString()));
        personal.setOnClickListener(new IntentClick(personal.getText().toString()));

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }

    private void init()
    {
        title=(TextView)findViewById(R.id.title) ;
        estekhdam=(Button)findViewById(R.id.btn1);
        takhfifYab=(Button)findViewById(R.id.btn2);
        amlak=(Button)findViewById(R.id.btn3);
        naghlie=(Button)findViewById(R.id.btn4);
        electric=(Button)findViewById(R.id.btn5);
        home=(Button)findViewById(R.id.btn6);
        khadamat=(Button)findViewById(R.id.btn7);
        tajhizat=(Button)findViewById(R.id.btn8);
        sargarmi=(Button)findViewById(R.id.btn9);
        personal=(Button)findViewById(R.id.btn10);
    }

    class IntentClick implements View.OnClickListener {
        private String group;

        public IntentClick(String Group) {
            group = Group;
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(getBaseContext(), SabtAgahi_other.class);
            i.putExtra("group", group);
            startActivity(i);
        }
    }
}
