package android.niky.mahem_final.JobBank;

import android.content.Context;
import android.niky.mahem_final.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class JobBank_Sabt extends AppCompatActivity {

ImageView L_img;
CircleImageView S_img;
Button send;
EditText modiriat,senf_type,sabt_num,phone_office,mobile,fax,address,telegram,insta,email,tozihat;

PopupWindow Senf_layout;
View SenfLayout;

TextView senf_1,senf_2,senf_3,senf_4,senf_5,senf_6,senf_7,senf_8,senf_9,senf_10,senf_11,senf_12,senf_13,senf_14,senf_15,senf_16;

Job_Sabt_Class job_sabt_class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_bank__sabt);

        L_img=(ImageView)findViewById(R.id.img);
        S_img=(CircleImageView)findViewById(R.id.job_pic);
        send=(Button)findViewById(R.id.send);

        modiriat=(EditText)findViewById(R.id.E1);
        senf_type=(EditText)findViewById(R.id.E2);
        sabt_num=(EditText)findViewById(R.id.E3);
        phone_office=(EditText)findViewById(R.id.E4);
        mobile=(EditText)findViewById(R.id.E5);
        fax=(EditText)findViewById(R.id.E6);
        address=(EditText)findViewById(R.id.E7);
        telegram=(EditText)findViewById(R.id.E8);
        insta=(EditText)findViewById(R.id.E9);
        email=(EditText)findViewById(R.id.E10);
        tozihat=(EditText)findViewById(R.id.E11);

        senf_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                SenfLayout=inflater.inflate(R.layout.asnaf_list,null);
                Senf_layout= new PopupWindow(SenfLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Senf_layout.showAsDropDown(view);

                Senf_map();

            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(modiriat.getText().toString().equals("")) {
                modiriat.setError("لطفا نام مدیر را وارد کنید.");
                return;
            } else if(senf_type.getText().toString().equals("")) {
                senf_type.setError("لطفا نوع صنف را انتخاب کنید.");
                return;
            }else if(phone_office.getText().toString().equals("")) {
                phone_office.setError("لطفا تلفن ثابت را وارد کنید.");
                return;
            }else if(address.getText().toString().equals("")) {
                address.setError("لطفا آدرس را وارد کنید.");
                return;
            }else {
                job_sabt_class=new Job_Sabt_Class(modiriat.getText().toString(),senf_type.getText().toString(),
                        phone_office.getText().toString(),address.getText().toString());

                if(sabt_num.getText().toString()!="")
                    job_sabt_class.setSabt_num(sabt_num.getText().toString());
                if(mobile.getText().toString()!="")
                    job_sabt_class.setMobile(mobile.getText().toString());
                if(fax.getText().toString()!="")
                    job_sabt_class.setFax(fax.getText().toString());
                if(telegram.getText().toString()!="")
                    job_sabt_class.setTelegram(telegram.getText().toString());
                if (insta.getText().toString()!="")
                    job_sabt_class.setInsta(insta.getText().toString());
                if(email.getText().toString()!="")
                    job_sabt_class.setEmail(email.getText().toString());
                if(tozihat.getText().toString()!="")
                    job_sabt_class.setTozihat(tozihat.getText().toString());

                job_sabt_class.Network();
                tt("اعمال شد.");



            }
            }
        });
        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }

    public void Senf_map()
    {
        senf_1=(EditText)SenfLayout.findViewById(R.id.Tt1);
        senf_2=(EditText)SenfLayout.findViewById(R.id.Tt2);
        senf_3=(EditText)SenfLayout.findViewById(R.id.Tt3);
        senf_4=(EditText)SenfLayout.findViewById(R.id.Tt4);
        senf_5=(EditText)SenfLayout.findViewById(R.id.Tt5);
        senf_6=(EditText)SenfLayout.findViewById(R.id.Tt6);
        senf_7=(EditText)SenfLayout.findViewById(R.id.Tt7);
        senf_8=(EditText)SenfLayout.findViewById(R.id.Tt8);
        senf_9=(EditText)SenfLayout.findViewById(R.id.Tt9);
        senf_10=(EditText)SenfLayout.findViewById(R.id.Tt10);
        senf_11=(EditText)SenfLayout.findViewById(R.id.Tt11);
        senf_12=(EditText)SenfLayout.findViewById(R.id.Tt12);
        senf_13=(EditText)SenfLayout.findViewById(R.id.Tt13);
        senf_14=(EditText)SenfLayout.findViewById(R.id.Tt14);
        senf_15=(EditText)SenfLayout.findViewById(R.id.Tt15);
        senf_16=(EditText)SenfLayout.findViewById(R.id.Tt16);

        senf_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_1.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_2.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_3.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_4.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_5.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_6.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_7.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_8.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_9.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_10.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_11.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_1.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_12.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_13.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_14.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_15.getText().toString());
                Senf_layout .dismiss();
            }
        });

        senf_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_16.getText().toString());
                Senf_layout .dismiss();
            }
        });


    }

//    public void Send_JobBank_Sabt(String modiriat,String Senf,String Phone_Office,String Address)
//    {
//
//    }

}
