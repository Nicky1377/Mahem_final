package android.niky.mahem_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Naghlieh extends AppCompatActivity {
Button savari,sangin,motor,yadaki,keshavarzi,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naghlieh);





        savari=(Button)findViewById(R.id.btn1);
        sangin=(Button)findViewById(R.id.btn2);
        motor=(Button)findViewById(R.id.btn3);
        yadaki=(Button)findViewById(R.id.btn4);
        keshavarzi=(Button)findViewById(R.id.btn5);
        other=(Button)findViewById(R.id.btn6);

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }
}
