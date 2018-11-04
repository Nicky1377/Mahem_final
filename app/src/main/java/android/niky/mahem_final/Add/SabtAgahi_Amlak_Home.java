package android.niky.mahem_final.Add;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.niky.mahem_final.R;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SabtAgahi_Amlak_Home extends AppCompatActivity {

    EditText Group,Title,Amlak_type,meter,Type,AgahiDahande_type,Gheimat,call,Tozihat,location
            ,PhoneNum,Email,rahn,ejareh;
    View CallLayout,TypeLayout,AgahiDahandeLayout,GheimatLayout,MelkTypeLayout,GheimatMoredNazarLayout;
    TextView Type_1,Type_2,agahiD_1,agahiD_2,Gh_1,Gh_2,Gh_3,Gh_4,M_T_1,M_T_2,M_T_3;
    CheckBox rules,chat,email_check,rahn_To_ejareh;
    Button send,cam1,cam2,cam3,cam4,cam5,ok,ok_call;
    PopupWindow Type_Layout,Call_Layout,Gheimat_Layout,agahiD_Layout,Melk_type_Layout,Gheimat_Mored_Nazar_Layout;
    ArrayList<Button> btns;
    ImageView map_img;

    int pic=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi__amlak__home);


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

        map_img=(ImageView)findViewById(R.id.map_img);

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

        AgahiDahande_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                AgahiDahandeLayout=inflater.inflate(R.layout.agahi_dahande_amlak_layout,null);
                agahiD_Layout= new PopupWindow(AgahiDahandeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                agahiD_Layout.showAsDropDown(view);
                Agahi_D_map();

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                CallLayout=inflater.inflate(R.layout.call_layout,null);

                Call_Layout= new PopupWindow(CallLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,true);
                Call_Layout.showAsDropDown(view);
                Call_map();

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

        Amlak_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                MelkTypeLayout=inflater.inflate(R.layout.melk_type_layout_home,null);
                Melk_type_Layout= new PopupWindow(MelkTypeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Melk_type_Layout.showAsDropDown(view);
                AmlakType_map();

            }
        });

    map_img.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //intent to google map
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
                Gheimat_Mored_Nazar_Layout = new PopupWindow(GheimatMoredNazarLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,true);
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

            if(PhoneNum.getText().toString().equals(""))
            {
                PhoneNum.setError("لطفا شماره تماس را وارد کنید.");
            }
            else{
                call.setText(PhoneNum.getText().toString());
            Call_Layout.dismiss();
            }
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

    }


    //pick picture...
    void pick() {

        final CharSequence[] options = {"دوربین", "گالری"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());

        builder.setTitle("Select Photo");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("دوربین"))

                {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (Build.VERSION.SDK_INT >= 24) {
                        try {
                            Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                            m.invoke(null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    File f = new File(Environment
                            .getExternalStorageDirectory(), "temp" + pic
                            + ".jpg");

                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));

                    startActivityForResult(intent, 1);

                } else if (options[item].equals("گالری")) {

                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(intent, 2);

                }

            }

        });

        builder.show();

    }
}