package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


public class Filter_Home extends AppCompatActivity {
    EditText Group,rooms,meter,Type,Gheimat,hoome,rahn,ejareh;
    View HoomeLayout,TypeLayout,GheimatLayout,GheimatMoredNazarLayout;
    TextView Type_1,Type_2,Type_3,Gh_1,Gh_2,Gh_3,Gh_4,yes,no;
    CheckBox rahn_To_ejareh;
    Button send,newest,expensive,cheap,ok;
    PopupWindow Type_Layout,Hoome_Layout,Gheimat_Layout,Gheimat_Mored_Nazar_Layout;

    boolean Newest=false,Expensive=false,Cheap=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter__home);


        Group=(EditText)findViewById(R.id.T1);
        rooms=(EditText)findViewById(R.id.T2);
        meter=(EditText)findViewById(R.id.T3);
        Type=(EditText)findViewById(R.id.T4);
        Gheimat=(EditText)findViewById(R.id.T5);
        hoome=(EditText)findViewById(R.id.T6);

        send=(Button)findViewById(R.id.send);
        expensive=(Button)findViewById(R.id.c1);
        newest=(Button)findViewById(R.id.c2);
        cheap=(Button)findViewById(R.id.c3);



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
                TypeLayout=inflater.inflate(R.layout.type_agahi_layout,null);
                Type_Layout= new PopupWindow(TypeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Type_Layout.showAsDropDown(view);

                Type_map();

            }
        });

        hoome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                 HoomeLayout=inflater.inflate(R.layout.there_layout,null);
                Hoome_Layout= new PopupWindow(HoomeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Hoome_Layout.showAsDropDown(view);

               Hoome_map();

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tt("اعمال شد.");
                Send_Filter_Home();
            }
        });

        Filter_Buttons();

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }
    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }

    public  void Gheimat_map()
    {
        Gh_1=(TextView)GheimatLayout.findViewById(R.id.Tt1);
        Gh_2=(TextView)GheimatLayout.findViewById(R.id.Tt2);
        Gh_3=(TextView)GheimatLayout.findViewById(R.id.Tt3);
        Gh_4=(TextView)GheimatLayout.findViewById(R.id.Tt4);


        Gh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_1.getText().toString());
                Gheimat_Layout.dismiss();
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                GheimatMoredNazarLayout=inflater.inflate(R.layout.ghimat_mored_nazar_layout,null);
                Gheimat_Mored_Nazar_Layout = new PopupWindow(GheimatMoredNazarLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Gheimat_Mored_Nazar_Layout.showAsDropDown(Gheimat);
                Rahn_To_Ejareh_map();

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

    public void Rahn_To_Ejareh_map()
    {

        rahn=(EditText)GheimatMoredNazarLayout.findViewById(R.id.call1);
        ejareh=(EditText)GheimatMoredNazarLayout.findViewById(R.id.Call2);
        rahn_To_ejareh=(CheckBox)GheimatMoredNazarLayout.findViewById(R.id.RTE);
        ok=(Button)GheimatMoredNazarLayout.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat_Mored_Nazar_Layout.dismiss();
            }
        });

    }

    public void Type_map()
    {
        Type_1=(TextView)TypeLayout.findViewById(R.id.Tt1);
        Type_2=(TextView)TypeLayout.findViewById(R.id.Tt2);
        Type_3=(TextView)TypeLayout.findViewById(R.id.Tt3);


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

        Type_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Type.setText(Type_3.getText().toString());
                Type_Layout.dismiss();
            }
        });

    }

    public void Hoome_map()
    {
        yes=(TextView)HoomeLayout.findViewById(R.id.Tt1);
        no=(TextView)HoomeLayout.findViewById(R.id.Tt2);



        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoome.setText(yes.getText().toString());
                Hoome_Layout.dismiss();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoome.setText(no.getText().toString());
                Hoome_Layout.dismiss();
            }
        });

    }


    public void Filter_Buttons()
    {
        newest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Newest==false)
                {
                    newest.setBackgroundResource(R.drawable.button2_red);
                    newest.setTextColor(getResources().getColor(R.color.colorDefaultBackground));
                    Newest=true;
                }
                else {
                    newest.setBackgroundResource(R.drawable.button2);
                    newest.setTextColor(getResources().getColor(R.color.backColor));
                    Newest=false;
                }
            }
        });

        cheap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Cheap==false)
                {
                    cheap.setBackgroundResource(R.drawable.button2_right_red);
                    cheap.setTextColor(getResources().getColor(R.color.colorDefaultBackground));
                    Cheap=true;

                    if(Expensive==true)
                    {
                        expensive.setBackgroundResource(R.drawable.button2_left);
                        expensive.setTextColor(getResources().getColor(R.color.backColor));
                        Expensive=false;
                    }
                }
                else {
                    cheap.setBackgroundResource(R.drawable.button2_right);
                    cheap.setTextColor(getResources().getColor(R.color.backColor));
                    Cheap=false;
                }
            }
        });

        expensive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Expensive==false)
                {
                    expensive.setBackgroundResource(R.drawable.button2_left_red);
                    expensive.setTextColor(getResources().getColor(R.color.colorDefaultBackground));
                    Expensive=true;

                    if(Cheap==true)
                    {
                        cheap.setBackgroundResource(R.drawable.button2_right);
                        cheap.setTextColor(getResources().getColor(R.color.backColor));
                        Cheap=false;
                    }
                }
                else {
                    expensive.setBackgroundResource(R.drawable.button2_left);
                    expensive.setTextColor(getResources().getColor(R.color.backColor));
                    Expensive=false;
                }
            }
        });
    }

    public void Send_Filter_Home()
    {
        Intent i = new Intent();
        i.putExtra("AcName", "Home");
        i.putExtra("group", Group.getText().toString());
        i.putExtra("rooms", rooms.getText().toString());
        i.putExtra("meter", meter.getText().toString());
        i.putExtra("Type", Type.getText().toString());
        i.putExtra("gheimat", Gheimat.getText().toString());
        i.putExtra("hoome", hoome.getText().toString());
        i.putExtra("newest",newest.toString());
        i.putExtra("cheap",cheap.toString());
        i.putExtra("expensive",expensive.toString());
        setResult(RESULT_OK,i);
        finish();
    }
}
