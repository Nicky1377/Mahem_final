package android.niky.mahem_final.Groups;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Add.SabtAgahi_Estekhdam;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Group extends AppCompatActivity {
Button estekhdam,amlak,naghlie,electric,home,khadamat,tajhizat,sargarmi,personal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);





        estekhdam=(Button)findViewById(R.id.btn1);
        amlak=(Button)findViewById(R.id.btn2);
        naghlie=(Button)findViewById(R.id.btn3);
        electric=(Button)findViewById(R.id.btn4);
        home=(Button)findViewById(R.id.btn5);
        khadamat=(Button)findViewById(R.id.btn6);
        tajhizat=(Button)findViewById(R.id.btn7);
        sargarmi=(Button)findViewById(R.id.btn8);
        personal=(Button)findViewById(R.id.btn9);


        naghlie.setOnClickListener(new Group.IntentClick(naghlie.getText().toString(),Naghlieh.class));
        amlak.setOnClickListener(new Group.IntentClick(amlak.getText().toString(),Amlak.class));
        estekhdam.setOnClickListener(new Group.IntentClick(estekhdam.getText().toString(),Estekhdami.class));
        electric.setOnClickListener(new Group.IntentClick(electric.getText().toString(),Electric.class));
        home.setOnClickListener(new Group.IntentClick(home.getText().toString(), Home_EQ.class));
        khadamat.setOnClickListener(new Group.IntentClick(khadamat.getText().toString(), Khadamat.class));
        tajhizat.setOnClickListener(new Group.IntentClick(tajhizat.getText().toString(), Tajhizat.class));
        sargarmi.setOnClickListener(new Group.IntentClick(sargarmi.getText().toString(), Sargarmi.class));
        personal.setOnClickListener(new Group.IntentClick(personal.getText().toString(), Personal.class));
        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
    }

    class IntentClick implements View.OnClickListener {
        private String group;
        private  Class context;

        public IntentClick(String Group,final Class c ) {
            group = Group;
            context=c;
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(getBaseContext(), context);
            i.putExtra("group", group);
            i.putExtra("type", "getAds");
            startActivity(i);
        }
    }
}
