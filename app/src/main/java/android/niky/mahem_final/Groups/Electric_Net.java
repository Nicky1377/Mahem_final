package android.niky.mahem_final.Groups;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.niky.mahem_final.Search_Filter.Ads;

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

        laptop.setOnClickListener(new IntentClick("16"));
        Janebi.setOnClickListener(new IntentClick("17"));
        printer.setOnClickListener(new IntentClick("18"));
        modem.setOnClickListener(new IntentClick("19"));

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
