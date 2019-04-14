package android.niky.mahem_final.JobBank;

import android.content.Intent;
import android.niky.mahem_final.CustomComponents.CircleImageView;
import android.niky.mahem_final.R;
import android.niky.mahem_final.other.AppController;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

public class JobBank_Show extends AppCompatActivity {
    ImageView L_img;
    android.niky.mahem_final.CustomComponents.CircleImageView S_img;
    Button send;
    TextView name,modiriat,senf_type,sabt_num,phone_office,mobile,fax,address,telegram,insta,email,tozihat;

    Job_Sabt_Class job_sabt_class;
    String Senf;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_bank__show);

        init();
        setInformation();

    }

    void init()
    {
        job_sabt_class=new Job_Sabt_Class();
        L_img=(ImageView)findViewById(R.id.img);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        S_img=(CircleImageView) findViewById(R.id.job_pic);
        send=(Button)findViewById(R.id.send);

        name=(TextView)findViewById(R.id.E12);
        modiriat=(TextView)findViewById(R.id.E1);
        senf_type=(TextView)findViewById(R.id.E2);
        sabt_num=(TextView)findViewById(R.id.E3);
        phone_office=(TextView)findViewById(R.id.E4);
        mobile=(TextView)findViewById(R.id.E5);
        fax=(TextView)findViewById(R.id.E6);
        address=(TextView)findViewById(R.id.E7);
        telegram=(TextView) findViewById(R.id.E8);
        insta=(TextView)findViewById(R.id.E9);
        email=(TextView)findViewById(R.id.E10);
        tozihat=(TextView)findViewById(R.id.E11);

    }

    void setInformation()
    {
        Intent ii=getIntent();
        name.setText(ii.getStringExtra("name"));
        modiriat.setText(ii.getStringExtra("modiriat"));
        //senf_type.setText(ii.getStringExtra(""));
        sabt_num.setText(ii.getStringExtra("numsabt"));
        phone_office.setText(ii.getStringExtra("tamas"));
        mobile.setText(ii.getStringExtra("mobile"));
        fax.setText(ii.getStringExtra("fax"));
        address.setText(ii.getStringExtra("address"));
        telegram.setText(ii.getStringExtra("telegram"));
        insta.setText(ii.getStringExtra("instagram"));
        email.setText(ii.getStringExtra("email"));
        tozihat.setText(ii.getStringExtra("comment"));

        S_img.setImageUrl(ii.getStringExtra("picurl"), imageLoader);

        Senf=ii.getStringExtra("session");
        setSenf();
    }

    void setSenf()
    {
        switch (Senf){
            case "1_Job":
                senf_type.setText(" پزشکی");
                break;
            case "2_Job":
                senf_type.setText(" بازرگانی و تجارت");
                break;
            case "3_Job":
                senf_type.setText(" اتومبیل");
                break;
            case "4_Job":
                senf_type.setText(" آرایش و پیرایش");
                break;
            case "5_Job":
                senf_type.setText(" مراکز تحصیلی");
                break;
            case "6_Job":
                senf_type.setText(" مراکز هنری");
                break;
            case "7_Job":
                senf_type.setText(" مراکز ورزشی");
                break;
            case "8_Job":
                senf_type.setText(" آموزش و پژوهش");
                break;
            case "9_Job":
                senf_type.setText(" خدمات مجلسی");
                break;
            case "10_Job":
                senf_type.setText(" کامپیوتروموبایل");
                break;
            case "11_Job":
                senf_type.setText(" برق");
                break;
            case "12_Job":
                senf_type.setText(" پوشاک");
                break;
            case "13_Job":
                senf_type.setText(" ساختمان");
                break;
            case "14_Job":
                senf_type.setText(" کشاورزی دامپروری");
                break;
            case "15_Job":
                senf_type.setText(" خدمات اجتماعی");
                break;
            case "16_Job":
                senf_type.setText(" چاپ وتبلیغات");
                break;
            case "17_Job":
                senf_type.setText(" سایرخدمات");
                break;
            case "18_Job":
                senf_type.setText(" صنعت");
                break;
            case "19_Job":
                senf_type.setText(" صنایع غذایی");
                break;
            case "20_Job":
                senf_type.setText(" دکوراسیون");
                break;

        }
    }
}
