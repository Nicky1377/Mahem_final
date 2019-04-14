package android.niky.mahem_final.MenuItems;

import android.content.Intent;
import android.niky.mahem_final.Add.SabtAgahi_Takhfif;
import android.niky.mahem_final.R;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class Off_Finder extends AppCompatActivity {
    Button weekend,cafe,arayesh,health,tafrih,LavazemJanebi,M_Arayesh,khodro,zivar,kitchen,teach,art,khadamat,hotel,lavazem_safar,
            pooshak,lavazemTahrir,other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off__finder);

        init();
        weekend.setOnClickListener(new IntentClick("D1", SabtAgahi_Takhfif.class));
        cafe.setOnClickListener(new IntentClick("D2", SabtAgahi_Takhfif.class));
        arayesh.setOnClickListener(new IntentClick("D3", SabtAgahi_Takhfif.class));
        health.setOnClickListener(new IntentClick("D4", SabtAgahi_Takhfif.class));
        tafrih.setOnClickListener(new IntentClick("D5", SabtAgahi_Takhfif.class));
        LavazemJanebi.setOnClickListener(new IntentClick("D6", SabtAgahi_Takhfif.class));
        M_Arayesh.setOnClickListener(new IntentClick("D7", SabtAgahi_Takhfif.class));
        khodro.setOnClickListener(new IntentClick("D8", SabtAgahi_Takhfif.class));
        zivar.setOnClickListener(new IntentClick("D9", SabtAgahi_Takhfif.class));
        kitchen.setOnClickListener(new IntentClick("D10", SabtAgahi_Takhfif.class));
        teach.setOnClickListener(new IntentClick("D11", SabtAgahi_Takhfif.class));
        art.setOnClickListener(new IntentClick("D12", SabtAgahi_Takhfif.class));
        khadamat.setOnClickListener(new IntentClick("D13", SabtAgahi_Takhfif.class));
        hotel.setOnClickListener(new IntentClick("D14", SabtAgahi_Takhfif.class));
        lavazem_safar.setOnClickListener(new IntentClick("D15", SabtAgahi_Takhfif.class));
        pooshak.setOnClickListener(new IntentClick("D16", SabtAgahi_Takhfif.class));
        lavazemTahrir.setOnClickListener(new IntentClick("D17", SabtAgahi_Takhfif.class));
        other.setOnClickListener(new IntentClick("D18", SabtAgahi_Takhfif.class));





        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();
    }

    void init()
    {
        weekend=(Button)findViewById(R.id.btn1);
        cafe=(Button)findViewById(R.id.btn2);
        arayesh=(Button)findViewById(R.id.btn3);
        health=(Button)findViewById(R.id.btn4);
        tafrih=(Button)findViewById(R.id.btn5);
        LavazemJanebi=(Button)findViewById(R.id.btn6);
        M_Arayesh=(Button)findViewById(R.id.btn7);
        khodro=(Button)findViewById(R.id.btn8);
        zivar=(Button)findViewById(R.id.btn9);
        kitchen=(Button)findViewById(R.id.btn10);
        teach=(Button)findViewById(R.id.btn11);
        art=(Button)findViewById(R.id.btn12);
        khadamat=(Button)findViewById(R.id.btn13);
        hotel=(Button)findViewById(R.id.btn14);
        lavazem_safar=(Button)findViewById(R.id.btn15);
        pooshak=(Button)findViewById(R.id.btn16);
        lavazemTahrir=(Button)findViewById(R.id.btn17);
        other=(Button)findViewById(R.id.btn18);

    }
    class IntentClick implements View.OnClickListener {

        private  Class context;
        private String ID;

        public IntentClick(String id,final Class c ) {

            ID=id;
            context=c;
        }

        @Override
        public void onClick(View view) {
            Button b=(Button)view;

            Intent i = new Intent(getBaseContext(), context);
            i.putExtra("group", b.getText().toString());
            i.putExtra("type", "sabt");
            i.putExtra("id",ID);
            startActivity(i);
        }
    }
}
