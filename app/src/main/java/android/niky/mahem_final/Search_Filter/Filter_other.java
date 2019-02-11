package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Filter_other extends AppCompatActivity {
    EditText Group,city,Gheimat,pic;
    View CityLayout,GheimatLayout,YesNoLayout;
    TextView city_1,city_2,city_3,city_4,city_5,city_6,city_7,city_8,city_9
            ,city_10,city_11,city_12,city_13,city_14,Gh_1,Gh_2,Gh_3,Gh_4
            ,yes,no;
    Button send,newest,expensive,cheap;
    PopupWindow City_Layout,Gheimat_Layout,YesNo_Layout;

    int Src;

    boolean Newest=false,Expensive=false,Cheap=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_other);

        Group=(EditText)findViewById(R.id.T1);
        city=(EditText)findViewById(R.id.T2);
        Gheimat=(EditText)findViewById(R.id.T3);
        pic=(EditText)findViewById(R.id.T4);

        send=(Button)findViewById(R.id.send);
        expensive=(Button)findViewById(R.id.c1);
        newest=(Button)findViewById(R.id.c2);
        cheap=(Button)findViewById(R.id.c3);


        Group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Filter_other.this,Filter_group.class);
                startActivityForResult(i,1);
            }
        });

        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                YesNoLayout=inflater.inflate(R.layout.yes_no_layout,null);
                YesNo_Layout= new PopupWindow(YesNoLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                YesNo_Layout.showAsDropDown(view);

                Pic_map();

            }
        });


        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                CityLayout=inflater.inflate(R.layout.city_layout,null);
                City_Layout= new PopupWindow(CityLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                City_Layout.showAsDropDown(view);

                City_map();

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



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tt("اعمال شد.");
                Src_check();
            }
        });

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

        Filter_Buttons();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            if(requestCode==1)
            {
                if(resultCode==RESULT_FIRST_USER)
                {
                    Group.setText(data.getStringExtra("name"));
                   Src=1;
                }
               else if(resultCode==RESULT_OK)
                {
                     if(data.getStringExtra("AcName").equals("Home")) {
                         Intent i = new Intent();
                         i.putExtra("AcName", "Home");
                         i.putExtra("group", data.getStringExtra("group"));
                         i.putExtra("rooms", data.getStringExtra("rooms"));
                         i.putExtra("meter", data.getStringExtra("meter"));
                         i.putExtra("Type", data.getStringExtra("Type"));
                         i.putExtra("gheimat", data.getStringExtra("gheimat"));
                         i.putExtra("hoome", data.getStringExtra("hoome"));
                         i.putExtra("newest", data.getStringExtra("newest"));
                         i.putExtra("cheap", data.getStringExtra("cheap"));
                         i.putExtra("expensive", data.getStringExtra("expensive"));
                         setResult(RESULT_FIRST_USER, i);
                         finish();
                     }else if(data.getStringExtra("AcName").equals("Car"))
                     {
                         Intent i = new Intent();
                         i.putExtra("AcName", "Car");
                         i.putExtra("group", data.getStringExtra("group"));
                         i.putExtra("brand", data.getStringExtra("brand"));
                         i.putExtra("year", data.getStringExtra("year"));
                         i.putExtra("Type", data.getStringExtra("Type"));
                         i.putExtra("gheimat", data.getStringExtra("gheimat"));
                         i.putExtra("K_meter", data.getStringExtra("K_meter"));
                         i.putExtra("city", data.getStringExtra("city"));
                         i.putExtra("newest", data.getStringExtra("newest"));
                         i.putExtra("cheap", data.getStringExtra("cheap"));
                         i.putExtra("expensive", data.getStringExtra("expensive"));
                         // estekhdam.setText(data.getStringExtra("group"));
                         setResult(RESULT_FIRST_USER,i);
                         finish();
                     }
                     else if(data.getStringExtra("AcName").equals("Estekhdami"))
                     {
                         Intent i = new Intent();
                         i.putExtra("AcName", "Estekhdami");
                         i.putExtra("group",data.getStringExtra("group"));
                         i.putExtra("Gharardad", data.getStringExtra("Gharardad"));
                         i.putExtra("EducationLevel", data.getStringExtra("EducationLevel"));
                         i.putExtra("city", data.getStringExtra("city"));
                         i.putExtra("newest",data.getStringExtra("newest"));
                         i.putExtra("cheap",data.getStringExtra("cheap"));
                         i.putExtra("expensive",data.getStringExtra("expensive"));
                         setResult(RESULT_FIRST_USER,i);
                         finish();
                     }
                }
            }

    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }


    public void City_map()
    {

        city_1=(TextView)CityLayout.findViewById(R.id.Tt1);
        city_2=(TextView)CityLayout.findViewById(R.id.Tt2);
        city_3=(TextView)CityLayout.findViewById(R.id.Tt3);
        city_4=(TextView)CityLayout.findViewById(R.id.Tt4);
        city_5=(TextView)CityLayout.findViewById(R.id.Tt5);
        city_6=(TextView)CityLayout.findViewById(R.id.Tt6);
        city_7=(TextView)CityLayout.findViewById(R.id.Tt7);
        city_8=(TextView)CityLayout.findViewById(R.id.Tt8);
        city_9=(TextView)CityLayout.findViewById(R.id.Tt9);
        city_10=(TextView)CityLayout.findViewById(R.id.Tt10);
        city_11=(TextView)CityLayout.findViewById(R.id.Tt11);
        city_12=(TextView)CityLayout.findViewById(R.id.Tt12);
        city_13=(TextView)CityLayout.findViewById(R.id.Tt13);
        city_14=(TextView)CityLayout.findViewById(R.id.Tt14);



        city_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_1.getText().toString());
                City_Layout .dismiss();
            }
        });


        city_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_2.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_3.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_1.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_4.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_1.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_5.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_6.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_1.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_7.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_8.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_9.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_10.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_11.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_12.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_13.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_14.getText().toString());
                City_Layout .dismiss();
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

    public void Pic_map()
    {
        yes=(TextView)YesNoLayout.findViewById(R.id.Tt1);
        no=(TextView)YesNoLayout.findViewById(R.id.Tt2);



        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pic.setText(yes.getText().toString());
                YesNo_Layout.dismiss();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pic.setText(no.getText().toString());
                YesNo_Layout.dismiss();
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

   public void Src_check()
   {
       if(Src==1)
       {
           Intent ii=new Intent();
           ii.putExtra("group",Group.getText().toString());
           ii.putExtra("city",city.getText().toString());
           ii.putExtra("gheimat",Gheimat.getText().toString());
           ii.putExtra("pic",pic.getText().toString());
           ii.putExtra("newest",newest.toString());
           ii.putExtra("cheap",cheap.toString());
           ii.putExtra("expensive",expensive.toString());
           setResult(RESULT_FIRST_USER,ii);
           finish();
       }
   }

}

