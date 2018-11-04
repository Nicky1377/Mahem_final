package android.niky.mahem_final.Add;

import android.content.Context;
import android.content.Intent;
import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SabtAgahi_other extends AppCompatActivity {
EditText Group,Title,Type,Gheimat,Tozihat,location;
    View TypeLayout,GheimatLayout;
    TextView Type_1,Type_2,Gh_1,Gh_2,Gh_3,Gh_4;
    CheckBox rules;
    Button send,cam1,cam2,cam3,cam4,cam5;
    PopupWindow Type_Layout,Gheimat_Layout;
    ArrayList<Button> btns;
    int pic=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi_other);


        Group=(EditText)findViewById(R.id.T1);
        Title=(EditText)findViewById(R.id.T2);
        Type=(EditText)findViewById(R.id.T3);
        Gheimat=(EditText)findViewById(R.id.T4);
        Tozihat=(EditText)findViewById(R.id.T5);
        location=(EditText)findViewById(R.id.T6);

        send=(Button)findViewById(R.id.send);
        cam1=(Button)findViewById(R.id.c1);
        cam2=(Button)findViewById(R.id.c2);
        cam3=(Button)findViewById(R.id.c3);
        cam4=(Button)findViewById(R.id.c4);
        cam5=(Button)findViewById(R.id.c5);

        rules=(CheckBox)findViewById(R.id.rule);

        btns=new ArrayList<Button>(5);
        btns.add(cam1);
        btns.add(cam2);
        btns.add(cam3);
        btns.add(cam4);
        btns.add(cam5);

        for(Button item:btns)
        {
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pic++;
                    //  pick();


                }
            });
        }

        Gheimat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                GheimatLayout=inflater.inflate(R.layout.gheimat_layout,null);
                Gheimat_Layout= new PopupWindow(GheimatLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Gheimat_Layout.showAsDropDown(view);

                Gheimat_map();

            }
        });

        Type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                TypeLayout=inflater.inflate(R.layout.type_layout,null);
                Type_Layout= new PopupWindow(TypeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Type_Layout.showAsDropDown(view);

                Type_map();

            }
        });



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tt("ارسال شد.");
            }
        });

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

        Group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SabtAgahi_other.this,SabtAgahi.class);
                startActivity(i);
            }
        });
    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }



    public void Type_map()
    {
        Type_1=(TextView)Type.findViewById(R.id.Tt1);
        Type_2=(TextView)Type.findViewById(R.id.Tt2);

        Type_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Type.setText(Type_1.getText().toString());
                Type_Layout.dismiss();
            }
        });

        Type_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Type.setText(Type_2.getText().toString());
                Type_Layout.dismiss();
            }
        });


    }

    public void Gheimat_map()
    {

        Gh_1=(TextView)Gheimat.findViewById(R.id.Tt1);
        Gh_2=(TextView)Gheimat.findViewById(R.id.Tt2);
        Gh_3=(TextView)Gheimat.findViewById(R.id.Tt3);
        Gh_4=(TextView)Gheimat.findViewById(R.id.Tt4);





        Gh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_1.getText().toString());
                Gheimat_Layout.dismiss();
            }
        });

        Gh_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_2.getText().toString());
                Gheimat_Layout.dismiss();
            }
        });

        Gh_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_3.getText().toString());
                Gheimat_Layout.dismiss();
            }
        });

        Gh_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_4.getText().toString());
                Gheimat_Layout.dismiss();
            }
        });

    }


    //pick picture...
    public void pick()
    {

    }
}
