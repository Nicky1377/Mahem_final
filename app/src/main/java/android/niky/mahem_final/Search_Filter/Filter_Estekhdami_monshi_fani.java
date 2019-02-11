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


public class Filter_Estekhdami_monshi_fani extends AppCompatActivity {

    EditText Group,Gharardad,EducationLevel,city,pic;
    View CityLayout,EducationLayout,GharardadLayout,YesNoLayout;
    TextView city_1,city_2,city_3,city_4,city_5,city_6,city_7,city_8,city_9
            ,city_10,city_11,city_12,city_13,city_14,Ed_1,Ed_2,Ed_3,Ed_4,Ed_5,Ed_6,Gh_1,Gh_2,Gh_3,Gh_4
            ,yes,no;
    Button send,newest,expensive,cheap;
    PopupWindow City_Layout,Ed_Layout,Gh_Layout,YesNo_Layout;

    boolean Newest=false,Expensive=false,Cheap=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter__estekhdami_monshi_fani);

        Group=(EditText)findViewById(R.id.T1);
        Gharardad=(EditText)findViewById(R.id.T2);
        EducationLevel=(EditText)findViewById(R.id.T3);
        city=(EditText)findViewById(R.id.T4);
        pic=(EditText)findViewById(R.id.T5);

        send=(Button)findViewById(R.id.send);
        expensive=(Button)findViewById(R.id.c1);
        newest=(Button)findViewById(R.id.c2);
        cheap=(Button)findViewById(R.id.c3);

        LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CityLayout=inflater.inflate(R.layout.city_layout,null);
        GharardadLayout=inflater.inflate(R.layout.gharardad_layout,null);
        EducationLayout=inflater.inflate(R.layout.education_level_layout,null);
        YesNoLayout=inflater.inflate(R.layout.yes_no_layout,null);

        Intent i=getIntent();
       Group.setText(i.getStringExtra("name"));

        EducationLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                EducationLayout=inflater.inflate(R.layout.education_level_layout,null);
                Ed_Layout= new PopupWindow(EducationLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Ed_Layout.showAsDropDown(view);
                Education_map();
            }
        });

        Gharardad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                GharardadLayout=inflater.inflate(R.layout.gharardad_layout,null);
                Gh_Layout= new PopupWindow(GharardadLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Gh_Layout.showAsDropDown(view);

                Gharardad_map();

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

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Send_Filter_Estekhdami();
                tt("اعمال شد.");
            }
        });
        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();
        Filter_Buttons();

    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }


    public void Education_map()
    {
        Ed_1=(TextView)EducationLayout.findViewById(R.id.Tt1);
        Ed_2=(TextView)EducationLayout.findViewById(R.id.Tt2);
        Ed_3=(TextView)EducationLayout.findViewById(R.id.Tt3);
        Ed_4=(TextView)EducationLayout.findViewById(R.id.Tt4);
        Ed_5=(TextView)EducationLayout.findViewById(R.id.Tt5);
        Ed_6=(TextView)EducationLayout.findViewById(R.id.Tt6);

        Ed_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_1.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_2.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_3.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_4.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_5.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_6.getText().toString());
                Ed_Layout .dismiss();
            }
        });

    }

    public void Gharardad_map()
    {
        Gh_1=(TextView)GharardadLayout.findViewById(R.id.Tt1);
        Gh_2=(TextView)GharardadLayout.findViewById(R.id.Tt2);
        Gh_3=(TextView)GharardadLayout.findViewById(R.id.Tt3);
        Gh_4=(TextView)GharardadLayout.findViewById(R.id.Tt4);


        Gh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gharardad.setText(Gh_1.getText().toString());
                Gh_Layout .dismiss();
            }
        });

        Gh_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gharardad.setText(Gh_2.getText().toString());
                Gh_Layout .dismiss();
            }
        });

        Gh_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gharardad.setText(Gh_3.getText().toString());
                Gh_Layout .dismiss();
            }
        });

        Gh_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gharardad.setText(Gh_4.getText().toString());
                Gh_Layout .dismiss();
            }
        });

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

    public void Send_Filter_Estekhdami()
    {
        Intent i = new Intent();
        i.putExtra("AcName", "Estekhdami");
        i.putExtra("group","استخدامی/"+ Group.getText().toString());
        i.putExtra("Gharardad", Gharardad.getText().toString());
        i.putExtra("EducationLevel", EducationLevel.getText().toString());
        i.putExtra("city", city.getText().toString());
        i.putExtra("newest",newest.toString());
        i.putExtra("cheap",cheap.toString());
        i.putExtra("expensive",expensive.toString());
        setResult(RESULT_FIRST_USER,i);
        finish();
    }
}
