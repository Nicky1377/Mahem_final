package android.niky.mahem_final.Add;

import android.content.Context;
import android.niky.mahem_final.Groups.Amlak;
import android.niky.mahem_final.Groups.Electric;
import android.niky.mahem_final.Groups.Estekhdami;
import android.niky.mahem_final.Groups.Home_EQ;
import android.niky.mahem_final.Groups.Khadamat;
import android.niky.mahem_final.Groups.Naghlieh;
import android.niky.mahem_final.Groups.Personal;
import android.niky.mahem_final.Groups.Sargarmi;
import android.niky.mahem_final.Groups.Tajhizat;
import android.niky.mahem_final.MenuItems.Menu1;
import android.niky.mahem_final.MenuItems.Off_Finder;
import android.niky.mahem_final.MenuItems.Register;
import android.niky.mahem_final.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class SabtAgahi extends AppCompatActivity {
    Button estekhdam,takhfifYab,amlak,naghlie,electric,home,khadamat,tajhizat,sargarmi,personal;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi);

        init();


        String str = readFileAsString(getBaseContext(), getFilesDir().getAbsolutePath() + "/.MahemProg/phn.txt");
        if (str.equals("")) {

                    tt("شما ثبت نام نکرده اید ...");
                    Intent i=new Intent(getBaseContext(), Register.class);
                    startActivity(i);

        }

        takhfifYab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          Intent i=new Intent(getBaseContext(), Off_Finder.class);
          i.putExtra("type","sabt");
          startActivity(i);
            }
        });

        naghlie.setOnClickListener(new IntentClick(naghlie.getText().toString(),Naghlieh.class));

        amlak.setOnClickListener(new IntentClick(amlak.getText().toString(),Amlak.class));

        estekhdam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SabtAgahi.this,SabtAgahi_Estekhdam.class);
                startActivity(i);
            }
        });
        estekhdam.setOnClickListener(new IntentClick(estekhdam.getText().toString(),Estekhdami.class));

        electric.setOnClickListener(new IntentClick(electric.getText().toString(),Electric.class));
        home.setOnClickListener(new IntentClick(home.getText().toString(), Home_EQ.class));
        khadamat.setOnClickListener(new IntentClick(khadamat.getText().toString(), Khadamat.class));
        tajhizat.setOnClickListener(new IntentClick(tajhizat.getText().toString(), Tajhizat.class));
        sargarmi.setOnClickListener(new IntentClick(sargarmi.getText().toString(), Sargarmi.class));
        personal.setOnClickListener(new IntentClick(personal.getText().toString(), Personal.class));

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }

    public String readFileAsString(Context context, String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File(filePath)));
            while ((line = in.readLine()) != null) stringBuilder.append(line);
        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //
        }

        return stringBuilder.toString();
    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }

    private void init()
    {
        title=(TextView)findViewById(R.id.title) ;
        estekhdam=(Button)findViewById(R.id.btn1);
        takhfifYab=(Button)findViewById(R.id.btn2);
        amlak=(Button)findViewById(R.id.btn3);
        naghlie=(Button)findViewById(R.id.btn4);
        electric=(Button)findViewById(R.id.btn5);
        home=(Button)findViewById(R.id.btn6);
        khadamat=(Button)findViewById(R.id.btn7);
        tajhizat=(Button)findViewById(R.id.btn8);
        sargarmi=(Button)findViewById(R.id.btn9);
        personal=(Button)findViewById(R.id.btn10);
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
            i.putExtra("type", "sabt");
            startActivity(i);
        }
    }
}
