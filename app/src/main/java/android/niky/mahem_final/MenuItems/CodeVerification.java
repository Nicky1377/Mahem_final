package android.niky.mahem_final.MenuItems;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.niky.mahem_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.OffFinder.Off;
import android.niky.mahem_final.other.Page1;
import android.widget.Toast;

public class CodeVerification extends AppCompatActivity {
    EditText etCode;
    Button btnVerify;
    View navigationBar;
    ImageView Home,Add,Menu,MenuLine,Search;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_verification);

        init();
        i=getIntent();


//        if(i.getStringExtra("phn").contains("@"))
//        {
//           Intent mailIntent=new Intent(Intent.ACTION_VIEW);
//           Uri data=Uri.parse("mailto:?subject=" + "Mahem Prog"+ "&body=" + i.getStringExtra("code") + "&to=" + i.getStringExtra("phn"));
//            mailIntent.setData(data);
//            startActivity(Intent.createChooser(mailIntent,"send mail..."));
//
//        }else{


        try {
            String tel = i.getStringExtra("phn");
            String body = i.getStringExtra("code");
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(tel,null,body,null,null);
            tt("SMS sent...");
        } catch (Exception e) {
            //handle
                   tt(e.getMessage());
        }

//        }

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCode.getText().toString().equals("")) {
                    etCode.setError("کد را وارد کنید");
                    return;
                }else if(etCode.getText().toString().equals(i.getStringExtra("code")))
                {

                save(etCode.getText().toString());
            Intent i=new Intent(CodeVerification.this,Page1.class);
            startActivity(i);
            CodeVerification.this.finish();
                }else {
                    etCode.setError("کد وارد شده اشتباه است .");
                }
            }
        });
        map();
//

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

    private void init() {

        etCode = (EditText) findViewById(R.id.et_code);
        btnVerify = (Button) findViewById(R.id.btn_verify);
    }

    private void save(String code) {
        //
    }

    void tt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


}
