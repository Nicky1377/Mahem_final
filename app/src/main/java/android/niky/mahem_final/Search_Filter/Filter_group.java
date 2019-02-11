package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


import android.niky.mahem_final.Add.SabtAgahi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;


public class Filter_group extends AppCompatActivity {
    Button estekhdam,amlak,naghlie,electric,home,khadamat,tajhizat,sargarmi,personal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_group);





        estekhdam=(Button)findViewById(R.id.btn1);
        amlak=(Button)findViewById(R.id.btn2);
        naghlie=(Button)findViewById(R.id.btn3);
        electric=(Button)findViewById(R.id.btn4);
        home=(Button)findViewById(R.id.btn5);
        khadamat=(Button)findViewById(R.id.btn6);
        tajhizat=(Button)findViewById(R.id.btn7);
        sargarmi=(Button)findViewById(R.id.btn8);
        personal=(Button)findViewById(R.id.btn9);

        estekhdam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_group.this,Filter_Estekhdami.class);
                startActivityForResult(i,2);
            }
        });

        amlak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_group.this,Filter_Home.class);
                startActivityForResult(i,3);
            }
        });

        naghlie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_group.this,Filter_Khodro.class);
                startActivityForResult(i,4);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_FIRST_USER) {

            }
        }
            else if(requestCode == 2)
            {
                Intent i = new Intent();
                i.putExtra("AcName", "Estekhdami");
                i.putExtra("group",data.getStringExtra("group"));
                i.putExtra("Gharardad", data.getStringExtra("Gharardad"));
                i.putExtra("EducationLevel", data.getStringExtra("EducationLevel"));
                i.putExtra("city", data.getStringExtra("city"));
                i.putExtra("newest",data.getStringExtra("newest"));
                i.putExtra("cheap",data.getStringExtra("cheap"));
                i.putExtra("expensive",data.getStringExtra("expensive"));
                setResult(RESULT_OK,i);
                finish();

        }else if(requestCode == 3)
        {

            Intent i = new Intent();
            i.putExtra("AcName", "Home");
            i.putExtra("group",data.getStringExtra("group"));
            i.putExtra("rooms",data.getStringExtra("rooms"));
            i.putExtra("meter", data.getStringExtra("meter"));
            i.putExtra("Type", data.getStringExtra("Type"));
            i.putExtra("gheimat", data.getStringExtra("gheimat"));
            i.putExtra("hoome", data.getStringExtra("hoome"));
            i.putExtra("newest",data.getStringExtra("newest"));
            i.putExtra("cheap",data.getStringExtra("cheap"));
            i.putExtra("expensive",data.getStringExtra("expensive"));
           // estekhdam.setText(data.getStringExtra("group"));
            setResult(RESULT_OK,i);
            finish();

        }
        else if(requestCode==4)
        {
            Intent i = new Intent();
            i.putExtra("AcName", "Car");
            i.putExtra("group", data.getStringExtra("group"));
            i.putExtra("brand", data.getStringExtra("brand"));
            i.putExtra("year", data.getStringExtra("year"));
            i.putExtra("Type", data.getStringExtra("Type"));
            i.putExtra("gheimat", data.getStringExtra("gheimat"));
            i.putExtra("K_meter", data.getStringExtra("K_meter"));
            i.putExtra("city", data.getStringExtra("city"));
            i.putExtra("newest", data.getStringExtra("newest"));
            i.putExtra("cheap", data.getStringExtra("cheap"));
            i.putExtra("expensive", data.getStringExtra("expensive"));
            // estekhdam.setText(data.getStringExtra("group"));
            setResult(RESULT_OK,i);
            finish();
        }
    }

        class IntentClick implements View.OnClickListener {
            private String Name;

            public IntentClick(String name) {
                Name = name;
            }

            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("name", Name);
                setResult(RESULT_FIRST_USER, i);
                finish();
            }



    }
}
