package android.niky.mahem_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home_Kitchen extends AppCompatActivity {
Button freezer,gas,wash_cloth,food,wash_dish,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__kitchen);





        freezer=(Button)findViewById(R.id.btn1);
        gas=(Button)findViewById(R.id.btn2);
        wash_cloth=(Button)findViewById(R.id.btn3);
        food=(Button)findViewById(R.id.btn4);
        wash_dish=(Button)findViewById(R.id.btn5);
        other=(Button)findViewById(R.id.btn6);
    }
}
