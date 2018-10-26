package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;
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
                startActivity(i);
            }
        });

        amlak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_group.this,Filter_Home.class);
                startActivity(i);
            }
        });

        naghlie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_group.this,Filter_Khodro.class);
                startActivity(i);
            }
        });

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();


    }
}
