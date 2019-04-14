package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Filter_Estekhdami extends AppCompatActivity {
    Button fani,monshi,nurse,edari,teach,mali,seller,seraydar,resturan,kar_sakhteman,art,beauty,computer,haml,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter__estekhdami);


        fani=(Button)findViewById(R.id.btn1);
        monshi=(Button)findViewById(R.id.btn2);
        nurse=(Button)findViewById(R.id.btn3);
        edari=(Button)findViewById(R.id.btn4);
        teach=(Button)findViewById(R.id.btn5);
        mali=(Button)findViewById(R.id.btn6);
        seller=(Button)findViewById(R.id.btn7);
        seraydar=(Button)findViewById(R.id.btn8);
        resturan=(Button)findViewById(R.id.btn9);
        kar_sakhteman=(Button)findViewById(R.id.btn10);
        art=(Button)findViewById(R.id.btn11);
        beauty=(Button)findViewById(R.id.btn12);
        computer=(Button)findViewById(R.id.btn13);
        haml=(Button)findViewById(R.id.btn14);
        other=(Button)findViewById(R.id.btn15);

        fani.setOnClickListener(new IntentClick(fani,"29"));
        monshi.setOnClickListener(new IntentClick(monshi,"30"));
        nurse.setOnClickListener(new IntentClick(nurse,"31"));
        edari.setOnClickListener(new IntentClick(edari,"32"));
        teach.setOnClickListener(new IntentClick(teach,"33"));
        mali.setOnClickListener(new IntentClick(mali,"34"));
        seller.setOnClickListener(new IntentClick(seller,"35"));
        seraydar.setOnClickListener(new IntentClick(seraydar,"36"));
        resturan.setOnClickListener(new IntentClick(resturan,"37"));
        kar_sakhteman.setOnClickListener(new IntentClick(kar_sakhteman,"38"));
        art.setOnClickListener(new IntentClick(art,"39"));
        beauty.setOnClickListener(new IntentClick(beauty,"40"));
        computer.setOnClickListener(new IntentClick(computer,"41"));
        haml.setOnClickListener(new IntentClick(haml,"42"));
        other.setOnClickListener(new IntentClick(other,"43"));

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }

    class IntentClick implements View.OnClickListener{
        private Button Name;
        private String Id;
        public IntentClick(Button name,String id)
        {
            Name=name;
           Id=id;
        }
        @Override
        public void onClick(View view) {
            Intent i=new Intent(getBaseContext(),Filter_Estekhdami_monshi_fani.class);
            i.putExtra("name",Name.getText().toString());
            i.putExtra("id",Id);
            startActivityForResult(i,1);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_FIRST_USER) {

                Intent i = new Intent();
                i.putExtra("id",data.getStringExtra("id"));
                i.putExtra("AcName", "Estekhdami");
                i.putExtra("group",data.getStringExtra("group"));
                i.putExtra("Gharardad", data.getStringExtra("Gharardad"));
                i.putExtra("EducationLevel", data.getStringExtra("EducationLevel"));
                i.putExtra("city", data.getStringExtra("city"));
                i.putExtra("newest",data.getStringExtra("newest"));
                i.putExtra("cheap",data.getStringExtra("cheap"));
                i.putExtra("expensive",data.getStringExtra("expensive"));
                setResult(RESULT_OK,i);
                finish();

            }
        }
    }
}
