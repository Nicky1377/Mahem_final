package android.niky.mahem_final.Add;

import android.content.Context;
import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class SabtAgahi_Amlak_Office extends AppCompatActivity {
    EditText Group,Title,Amlak_type,meter,Type,AgahiDahande_type,Gheimat,call,Tozihat,location
            ,PhoneNum,Email,rahn,ejareh;
    View CallLayout,TypeLayout,AgahiDahandeLayout,GheimatLayout,MelkTypeLayout,GheimatMoredNazarLayout;
    TextView Type_1,Type_2,agahiD_1,agahiD_2,Gh_1,Gh_2,Gh_3,Gh_4,M_T_1,M_T_2,M_T_3,M_T_4;
    CheckBox rules,chat,email_check,rahn_To_ejareh;
    Button send,cam1,cam2,cam3,cam4,cam5,ok,ok_call;
    PopupWindow Type_Layout,Call_Layout,Gheimat_Layout,agahiD_Layout,Melk_type_Layout,Gheimat_Mored_Nazar_Layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi__amlak__office);



        Group=(EditText)findViewById(R.id.T1);
        Title=(EditText)findViewById(R.id.T2);
        Amlak_type=(EditText)findViewById(R.id.T3);
        meter=(EditText)findViewById(R.id.T4);
        Type=(EditText)findViewById(R.id.T5);
        AgahiDahande_type=(EditText)findViewById(R.id.T6);
        Gheimat=(EditText)findViewById(R.id.T7);
        call=(EditText)findViewById(R.id.T8);
        Tozihat=(EditText)findViewById(R.id.T9);
        location=(EditText)findViewById(R.id.T10);

        send=(Button)findViewById(R.id.send);
        cam1=(Button)findViewById(R.id.c1);
        cam2=(Button)findViewById(R.id.c2);
        cam3=(Button)findViewById(R.id.c3);
        cam4=(Button)findViewById(R.id.c4);
        cam5=(Button)findViewById(R.id.c5);
        rules=(CheckBox)findViewById(R.id.rule);

        LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CallLayout=inflater.inflate(R.layout.call_layout,null);
        TypeLayout=inflater.inflate(R.layout.type_layout,null);
        GheimatLayout=inflater.inflate(R.layout.gheimat_layout,null);
        AgahiDahandeLayout=inflater.inflate(R.layout.agahi_dahande_amlak_layout,null);
        MelkTypeLayout=inflater.inflate(R.layout.melk_type_layout_office,null);
        GheimatMoredNazarLayout=inflater.inflate(R.layout.ghimat_mored_nazar_layout,null);

        Gheimat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Gheimat_Layout=popupDisplay(GheimatLayout);
                Gheimat_Layout.showAsDropDown(view);
                Gheimat_map();

            }
        });

        AgahiDahande_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                agahiD_Layout=popupDisplay(AgahiDahandeLayout);
                agahiD_Layout.showAsDropDown(view);
                Agahi_D_map();

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call_Layout=popupDisplay(CallLayout);
                Call_Layout.showAsDropDown(view);
                Call_map();

            }
        });

        Type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Type_Layout=popupDisplay(TypeLayout);
                Type_Layout.showAsDropDown(view);
                Type_map();

            }
        });

        Amlak_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Melk_type_Layout=popupDisplay(MelkTypeLayout);
                Melk_type_Layout.showAsDropDown(view);
                AmlakType_map();

            }
        });



        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tt("ارسال شد.");
            }
        });
    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }
    public PopupWindow popupDisplay(View view)
    {
        final PopupWindow popupWindow=new PopupWindow(this);
        LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        popupWindow.setFocusable(true);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(view);
        return popupWindow;
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
                Gheimat_Mored_Nazar_Layout =popupDisplay(GheimatMoredNazarLayout);
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

    public  void Agahi_D_map()
    {

        agahiD_1=(TextView)AgahiDahandeLayout.findViewById(R.id.Tt1);
        agahiD_2=(TextView)AgahiDahandeLayout.findViewById(R.id.Tt2);



        agahiD_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgahiDahande_type.setText(agahiD_1.getText().toString());
                agahiD_Layout.dismiss();
            }
        });

        agahiD_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgahiDahande_type.setText(agahiD_2.getText().toString());
                agahiD_Layout.dismiss();
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

    public  void Call_map()
    {
        PhoneNum=(EditText)CallLayout.findViewById(R.id.call1);
        Email=(EditText)CallLayout.findViewById(R.id.Call2);

        ok_call=(Button)CallLayout.findViewById(R.id.ok);
        ok_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call_Layout.dismiss();
            }
        });

        chat=(CheckBox)CallLayout.findViewById(R.id.chat);
        email_check=(CheckBox)CallLayout.findViewById(R.id.Email_check);



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


   public void AmlakType_map()
    {
        M_T_1=(TextView)MelkTypeLayout.findViewById(R.id.Tt1);
        M_T_2=(TextView)MelkTypeLayout.findViewById(R.id.Tt2);
        M_T_3=(TextView)MelkTypeLayout.findViewById(R.id.Tt3);
        M_T_4=(TextView)MelkTypeLayout.findViewById(R.id.Tt4);




        Amlak_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Melk_type_Layout=popupDisplay(MelkTypeLayout);
                Melk_type_Layout.showAsDropDown(view);
            }
        });
        M_T_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amlak_type.setText(M_T_1.getText().toString());
                Melk_type_Layout.dismiss();
            }
        });
        M_T_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amlak_type.setText(M_T_2.getText().toString());
                Melk_type_Layout.dismiss();
            }
        });
        M_T_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amlak_type.setText(M_T_3.getText().toString());
                Melk_type_Layout.dismiss();
            }
        });
        M_T_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Amlak_type.setText(M_T_4.getText().toString());
                Melk_type_Layout.dismiss();
            }
        });

    }

}
