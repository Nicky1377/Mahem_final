package android.niky.mahem_final.Add;

import android.content.Context;
import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class SabtAgahi_Car extends AppCompatActivity {
    EditText Group,Title,brand,shasy_typpe,naghd,year,K_meter,Gheimat,AgahiDahande_type,Type,call,Tozihat,location
            ,PhoneNum,Email;
    View CallLayout,TypeLayout,AgahiDahandeLayout,GheimatLayout,NaghdLayout,ShasyTypeLayout;
    TextView Type_1,Type_2,Type_3,agahiD_1,agahiD_2,Gh_1,Gh_2,Gh_3,Gh_4,Sh_1,Sh_2,Sh_3,Sh_4,Sh_5,Sh_6,Sh_7
            ,naghd_1,naghd_2;
    CheckBox rules,chat,email_check;
    Button send,cam1,cam2,cam3,cam4,cam5,ok_call;
    PopupWindow Type_Layout,Call_Layout,Gheimat_Layout,agahiD_Layout,Shasy_type_Layout,Naghd_Layout;

    PopupMenu popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi__car);


        Group=(EditText)findViewById(R.id.T1);
        Title=(EditText)findViewById(R.id.T2);
        brand=(EditText)findViewById(R.id.T3);
        shasy_typpe=(EditText)findViewById(R.id.T4);
        naghd=(EditText)findViewById(R.id.T5);
        year=(EditText)findViewById(R.id.T6);
        K_meter=(EditText)findViewById(R.id.T7);
        Gheimat=(EditText)findViewById(R.id.T8);
        AgahiDahande_type=(EditText)findViewById(R.id.T9);
        Type=(EditText)findViewById(R.id.T10);
        call=(EditText)findViewById(R.id.T11);
        Tozihat=(EditText)findViewById(R.id.T12);
        location=(EditText)findViewById(R.id.T13);


        send=(Button)findViewById(R.id.send);
        cam1=(Button)findViewById(R.id.c1);
        cam2=(Button)findViewById(R.id.c2);
        cam3=(Button)findViewById(R.id.c3);
        cam4=(Button)findViewById(R.id.c4);
        cam5=(Button)findViewById(R.id.c5);
        rules=(CheckBox)findViewById(R.id.rule);


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

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                CallLayout=inflater.inflate(R.layout.call_layout,null);

                Call_Layout= new PopupWindow(CallLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Call_Layout.showAsDropDown(view);
                Call_map();

            }
        });

        AgahiDahande_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                AgahiDahandeLayout=inflater.inflate(R.layout.agahi_dahande_layout,null);
                agahiD_Layout= new PopupWindow(AgahiDahandeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                agahiD_Layout.showAsDropDown(view);
                Agahi_D_map();

            }
        });

        shasy_typpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ShasyTypeLayout=inflater.inflate(R.layout.shasy_layout,null);
                Shasy_type_Layout= new PopupWindow(ShasyTypeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Shasy_type_Layout.showAsDropDown(view);

                Shasy_map();

            }
        });

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
        naghd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                NaghdLayout=inflater.inflate(R.layout.naghd_layout,null);
                Naghd_Layout= new PopupWindow(NaghdLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Naghd_Layout.showAsDropDown(view);

                Naghd_map();

            }
        });

        Brand_map();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tt("ارسال شد.");
            }
        });

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }
    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
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

    public  void Shasy_map()
    {
        Sh_1=(TextView)ShasyTypeLayout.findViewById(R.id.Tt1);
        Sh_2=(TextView)ShasyTypeLayout.findViewById(R.id.Tt2);
        Sh_3=(TextView)ShasyTypeLayout.findViewById(R.id.Tt3);
        Sh_4=(TextView)ShasyTypeLayout.findViewById(R.id.Tt4);
        Sh_5=(TextView)ShasyTypeLayout.findViewById(R.id.Tt5);
        Sh_6=(TextView)ShasyTypeLayout.findViewById(R.id.Tt6);
        Sh_7=(TextView)ShasyTypeLayout.findViewById(R.id.Tt7);



        Sh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_1.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_2.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_3.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_4.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_5.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_6.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_7.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });



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

    public void Naghd_map()
    {

    naghd_1=(TextView)NaghdLayout.findViewById(R.id.Tt1);
    naghd_2=(TextView)NaghdLayout.findViewById(R.id.Tt2);

    naghd_1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            naghd.setText(naghd_1.getText().toString());
            Naghd_Layout.dismiss();
        }
    });

    naghd_2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            naghd.setText(naghd_2.getText().toString());
            Naghd_Layout.dismiss();
        }
    });


}

    public void Brand_map()
    {
        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                popup = new PopupMenu(SabtAgahi_Car.this, brand);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.brands, popup.getMenu());


                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        brand.setText(item.getTitle());
                        popup.dismiss();
                        return true;
                    }
                });
                popup.show();
            }


        });

    }
}
