package android.niky.mahem_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tajhizat extends AppCompatActivity {
Button tajhizat,omde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajhizat);





        tajhizat=(Button)findViewById(R.id.btn1);
        omde=(Button)findViewById(R.id.btn2);

        tajhizat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Tajhizat.this,Tajhizat_tajhizat.class);
                startActivity(i);
            }
        });


    }
}
