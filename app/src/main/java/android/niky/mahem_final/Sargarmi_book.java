package android.niky.mahem_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sargarmi_book extends AppCompatActivity {
Button teach,religion,history,literary,magazine,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sargarmi_book);





        teach=(Button)findViewById(R.id.btn1);
        religion=(Button)findViewById(R.id.btn2);
        history=(Button)findViewById(R.id.btn3);
        literary=(Button)findViewById(R.id.btn4);
        magazine=(Button)findViewById(R.id.btn5);
        other=(Button)findViewById(R.id.btn6);

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }
}
