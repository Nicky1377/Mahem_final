package android.niky.mahem_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SabtAgahi_Home_Office extends AppCompatActivity {
Button home,office;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi__home__office);

        home=(Button)findViewById(R.id.btn1);
        office=(Button)findViewById(R.id.btn2);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SabtAgahi_Home_Office.this,SabtAgahi_Amlak_Home.class);
                startActivity(i);
            }
        });

        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SabtAgahi_Home_Office.this,SabtAgahi_Amlak_Office.class);
                startActivity(i);
            }
        });

    }
}
