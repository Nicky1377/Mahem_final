package android.niky.mahem_final.Search_Filter;

import android.content.Intent;
import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Filter_Estekhdami extends AppCompatActivity {
    Button fani,monshi,nurse,edari,teach,mali,seller,seraydar,resturan,kar_sakhteman,art,beauty,computer,haml,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter__estekhdami);


        fani=(Button)findViewById(R.id.btn1);
        monshi=(Button)findViewById(R.id.btn2);
        nurse=(Button)findViewById(R.id.btn3);
        edari=(Button)findViewById(R.id.btn4);
        teach=(Button)findViewById(R.id.btn5);
        mali=(Button)findViewById(R.id.btn6);
        seller=(Button)findViewById(R.id.btn7);
        seraydar=(Button)findViewById(R.id.btn8);
        resturan=(Button)findViewById(R.id.btn9);
        kar_sakhteman=(Button)findViewById(R.id.btn10);
        art=(Button)findViewById(R.id.btn11);
        beauty=(Button)findViewById(R.id.btn12);
        computer=(Button)findViewById(R.id.btn13);
        haml=(Button)findViewById(R.id.btn14);
        other=(Button)findViewById(R.id.btn15);

        fani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_Estekhdami.this,Filter_Estekhdami_monshi_fani.class);
                startActivity(i);
            }
        });

        monshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_Estekhdami.this,Filter_Estekhdami_monshi_fani.class);
                startActivity(i);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_Estekhdami.this,Filter_Estekhdami_monshi_fani.class);
                startActivity(i);
            }
        });

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }
}
