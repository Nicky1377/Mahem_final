package android.niky.mahem_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Electric_Net extends AppCompatActivity {
Button laptop,Janebi,printer,modem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electric__net);





        laptop=(Button)findViewById(R.id.btn1);
        Janebi=(Button)findViewById(R.id.btn2);
        printer=(Button)findViewById(R.id.btn3);
        modem=(Button)findViewById(R.id.btn4);

    }
}
