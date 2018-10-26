package android.niky.mahem_final.Groups;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.R;

public class Home_Design extends AppCompatActivity {
Button carpet,chair,lostr,commode,parde,bed,decor,TV_desk,fan,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__design);





        carpet=(Button)findViewById(R.id.btn1);
        chair=(Button)findViewById(R.id.btn2);
        lostr=(Button)findViewById(R.id.btn3);
        commode=(Button)findViewById(R.id.btn4);
        parde=(Button)findViewById(R.id.btn5);
        bed=(Button)findViewById(R.id.btn6);
        decor=(Button)findViewById(R.id.btn7);
        TV_desk=(Button)findViewById(R.id.btn8);
        fan=(Button)findViewById(R.id.btn9);
        other=(Button)findViewById(R.id.btn10);

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }
}
