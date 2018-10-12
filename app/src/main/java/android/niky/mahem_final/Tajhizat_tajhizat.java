package android.niky.mahem_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tajhizat_tajhizat extends AppCompatActivity {
Button shop,burbershop,office,industry,cofe,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tajhizat_tajhizat);





        shop=(Button)findViewById(R.id.btn1);
        burbershop=(Button)findViewById(R.id.btn2);
        office=(Button)findViewById(R.id.btn3);
        industry=(Button)findViewById(R.id.btn4);
        cofe=(Button)findViewById(R.id.btn5);
        other=(Button)findViewById(R.id.btn6);
    }
}
