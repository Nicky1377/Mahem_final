package android.niky.mahem_final.MenuItems;

import android.niky.mahem_final.R;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.niky.mahem_final.other.Page1;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.OffFinder.Off;

import java.util.Locale;



@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Contact extends AppCompatActivity {
    View navigationBar;
    ImageView Home,Add,Menu,MenuLine,Search;
    private RelativeLayout Call_us,Message_us,Email_us;
    private TextView call_tv,sms_tv,mail_tv;

    Button ExitBtn;
    //should fill with network data
    String ph_number="";
    String formattedNumber = PhoneNumberUtils.formatNumber(ph_number,
            Locale.getDefault().getCountry());
    String email_address="";
    Intent ii;
    ////
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contact);
            ii=getIntent();
            ph_number=ii.getStringExtra("phoneNum");
            email_address=ii.getStringExtra("Email");


        call_tv=(TextView)findViewById(R.id.call_txt);
        call_tv.setText("تماس با"+ph_number);

        sms_tv=(TextView)findViewById(R.id.sms_txt);
        sms_tv.setText("ارسال پیامک به"+ph_number);

        mail_tv=(TextView)findViewById(R.id.mail_txt);
        mail_tv.setText("ایمیل به"+email_address);

        ExitBtn=(Button)findViewById(R.id.exitBtn);

        ExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Call_us=(RelativeLayout)findViewById(R.id.call);
        Call_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + formattedNumber));

                final int ID_THIS_ACTIVITY=10;
                if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.CALL_PHONE};
                        requestPermissions(permission, ID_THIS_ACTIVITY);
                    }
                    else{
                        startActivity(i);
                    }
                }
            }
        });
        Message_us=(RelativeLayout)findViewById(R.id.Message);
        Message_us.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                final int Id_this_activity=20;
                try {
                    if(checkSelfPermission(Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_DENIED){
                        String[] permission = {Manifest.permission.SEND_SMS};
                        requestPermissions(permission, Id_this_activity);
                    }
                    else{


                        String smsNumber = String.format("smsto: %s",
                                ph_number);
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO);

                        smsIntent.setData(Uri.parse(smsNumber));

                        if (smsIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(smsIntent);
                        } else {
                            Log.e("tag","Can't resolve app for ACTION_SENDTO Intent");
                        }


                    }
                }catch(Exception e){
                    Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        Email_us=(RelativeLayout)findViewById(R.id.Email);
        Email_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "";
                String message = "";
                String to ="";

                Intent emailActivity = new Intent(Intent.ACTION_SEND);

                emailActivity.putExtra(Intent.EXTRA_EMAIL, new String[]{to});

                emailActivity.putExtra(Intent.EXTRA_SUBJECT, subject);

                emailActivity.putExtra(Intent.EXTRA_TEXT, message);

                emailActivity.setType("message/rfc822");

                startActivity(Intent.createChooser
                        (emailActivity, "Select your Email Provider :"));
            }
        });

            map();
            Toast.makeText(this, getLocalClassName().toString() + "\nMohadese Salem", Toast.LENGTH_LONG).show();
        }


    public void map() {

        navigationBar=findViewById(R.id.rr);
        Home = (ImageView) navigationBar.findViewById(R.id.home);
        Add = (ImageView) navigationBar.findViewById(R.id.add);
        Menu = (ImageView) navigationBar.findViewById(R.id.menu_f);
        MenuLine = (ImageView) navigationBar.findViewById(R.id.menuLine_f);
        Search =(ImageView)navigationBar.findViewById(R.id.search_f);



        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), android.niky.mahem_final.Search_Filter.Search.class);
                i.putExtra("title",getResources().getString(R.string.title_search));
                startActivity(i);

            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext(), Group.class);
                startActivity(i);
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), SabtAgahi.class);
                startActivity(i);

            }
        });

        MenuLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Menu1.class);
                startActivity(i);

            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Page1.class);
                startActivity(i);

            }
        });


    }




//
//        call_Information=(Button)findViewById(R.id.call_inf);
//                call_Information.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        Intent intent=new Intent(AgahiShow.this,contact.class);
//        startActivity(intent);
//
//
//
//        }
//        });
//}
}
//        }

