package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.niky.mahem_final.Search_Filter.Ads;

public class Khadamat_computer extends AppCompatActivity {
Button web,net,pc,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khadamat_computer);




        web=(Button)findViewById(R.id.btn1);
        web.setOnClickListener(new IntentClick("71"));
        net=(Button)findViewById(R.id.btn2);
        net.setOnClickListener(new IntentClick("72"));
        pc=(Button)findViewById(R.id.btn3);
        pc.setOnClickListener(new IntentClick("73"));
        mobile=(Button)findViewById(R.id.btn4);
        mobile.setOnClickListener(new IntentClick("74"));

        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }

    class IntentClick implements View.OnClickListener {
        private String Id;

        public IntentClick(String id) {
            Id = id;
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(getBaseContext(), Ads.class);
            i.putExtra("id", Id);
            startActivity(i);
        }
    }

}
