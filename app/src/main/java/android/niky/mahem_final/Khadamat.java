package android.niky.mahem_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }
}
