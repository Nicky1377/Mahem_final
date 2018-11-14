package android.niky.mahem_final.Groups;

import android.content.Intent;
import android.niky.mahem_final.AdsList;
import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Amlak extends AppCompatActivity {
Button home_sell,home_rent,office_sell,office_rent,aghd,other;
View.OnClickListener click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amlak);





        home_sell=(Button)findViewById(R.id.btn1);
        home_rent=(Button)findViewById(R.id.btn2);
        office_sell=(Button)findViewById(R.id.btn3);
        office_rent=(Button)findViewById(R.id.btn4);
        aghd=(Button)findViewById(R.id.btn5);
        other=(Button)findViewById(R.id.btn6);


        home_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Amlak.this,Amlak_HomeSell.class);
                startActivity(i);
            }
        });

        home_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Amlak.this,Amlak_HomeRent.class);
                startActivity(i);
            }
        });
        office_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Amlak.this,Amlak_OfficeSell.class);
                startActivity(i);
            }
        });
        office_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Amlak.this,Amlak_OfficeRent.class);
                startActivity(i);
            }
        });
        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();

        aghd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(1);
            }
        });

    }


    public void click(int id)
    {
        Intent i=new Intent(getBaseContext(), AdsList.class);
        i.putExtra("id",id);
        startActivity(i);
    }
}
