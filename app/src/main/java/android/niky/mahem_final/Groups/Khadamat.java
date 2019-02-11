package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Khadamat extends AppCompatActivity {
Button pazirayi,beauty,clean,asbab_keshi,nurse,decor,repair,teach,computer,translate,maali,graphic,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khadamat);




        pazirayi=(Button)findViewById(R.id.btn1);
        beauty=(Button)findViewById(R.id.btn2);
        clean=(Button)findViewById(R.id.btn3);
        asbab_keshi=(Button)findViewById(R.id.btn4);
        nurse=(Button)findViewById(R.id.btn5);
        decor=(Button)findViewById(R.id.btn6);
        repair=(Button)findViewById(R.id.btn7);
        teach=(Button)findViewById(R.id.btn8);
        computer=(Button)findViewById(R.id.btn9);
        translate=(Button)findViewById(R.id.btn10);
        maali=(Button)findViewById(R.id.btn11);
        graphic=(Button)findViewById(R.id.btn12);
        other=(Button)findViewById(R.id.btn13);

        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Khadamat.this,Khadamat_teach.class);
                startActivity(i);
            }
        });

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Khadamat.this,Khadamat_computer.class);
                startActivity(i);
            }
        });

        pazirayi.setOnClickListener(new IntentClick("60"));
        beauty.setOnClickListener(new IntentClick("61"));
        clean.setOnClickListener(new IntentClick("62"));
        asbab_keshi.setOnClickListener(new IntentClick("63"));
        nurse.setOnClickListener(new IntentClick("64"));
        decor.setOnClickListener(new IntentClick("65"));
        repair.setOnClickListener(new IntentClick("66"));
        translate.setOnClickListener(new IntentClick("67"));
        maali.setOnClickListener(new IntentClick("68"));
        graphic.setOnClickListener(new IntentClick("69"));
        other.setOnClickListener(new IntentClick("70"));





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
