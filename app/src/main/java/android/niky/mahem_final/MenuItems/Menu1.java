package android.niky.mahem_final.MenuItems;

import android.niky.mahem_final.R;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.JobBank.JobBankMenu;
import android.niky.mahem_final.OffFinder.Off;
import android.niky.mahem_final.Search_Filter.Ads;
import android.niky.mahem_final.Search_Filter.Collections;
import android.niky.mahem_final.Search_Filter.Management_Panel;

public class Menu1 extends AppCompatActivity {

    RelativeLayout JobBank,OffFinder,Register,Laws,ads,Estekhdami,MyAds,Share,Favorite,aboutUs,Setting,ContactUs;

    View navigationBar;
    ImageView Home, Add, Menu, MenuLine, Search;
    ImageView imgR;
    TextView tv;
    ImageView Background;
    LinearLayout backgroundPhoto;
    Management_Panel management_panel;
    Setting setting;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        JobBank=findViewById(R.id.btn_bank);
        OffFinder=findViewById(R.id.btn_off);
        Register=findViewById(R.id.btn_register);
        Laws=findViewById(R.id.btn_law);
        ads=findViewById(R.id.btn_ads);
        Estekhdami=findViewById(R.id.btn_employment);
        MyAds=findViewById(R.id.btn_my_ads);
        Share=findViewById(R.id.btn_share);
        Favorite=findViewById(R.id.btn_favorite);
        aboutUs=findViewById(R.id.btn_about_us);
        Setting=findViewById(R.id.btn_setting);
        ContactUs=findViewById(R.id.btn_contact_us);
        Background=findViewById(R.id.menu_back);
        backgroundPhoto=findViewById(R.id.menu_back_photo);

         imgR=(ImageView)findViewById(R.id.img_register);
         tv=(TextView)findViewById(R.id.TV1);




        Favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu1.this,Collections.class);
                startActivity(intent);
            }
        });
        Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "";
                String shareSub = "";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });
        JobBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,JobBankMenu.class);
                startActivity(i);
            }
        });

        OffFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,Off.class);
                startActivity(i);
            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(Menu1.this,Register.class);
                startActivity(i);

            }
        });


        Laws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,Laws.class);
                startActivity(i);
            }
        });

        ads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,Ads.class);
                startActivity(i);

            }
        });


        Estekhdami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,android.niky.mahem_final.Search_Filter.Search.class);
                i.putExtra("title","استخدامی");
                startActivity(i);

            }
        });

        MyAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,Management_Panel.class);
                startActivity(i);
            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,AboutUs.class);
                startActivity(i);
            }
        });
        Setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,Setting.class);
                startActivity(i);
            }
        });

        ContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu1.this,ContactUs.class);
                startActivity(i);
            }
        });





        map();


        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();
 }

    @SuppressLint("Range")
    @Override
    protected void onResume() {
        super.onResume();
        setting=new Setting();
        if(setting.yourSelectedImage!=null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                backgroundPhoto.setBackground(new BitmapDrawable(setting.yourSelectedImage));
                backgroundPhoto.setAlpha((float) 90);

            }
        }else if(setting.camera_image!=null){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                backgroundPhoto.setBackground(new BitmapDrawable(setting.yourSelectedImage));
            }
            backgroundPhoto.setAlpha((float) 90);
        }

        management_panel=new Management_Panel();
        if(management_panel.SelectedProfileImage!=null){
            //imgR.setImageBitmap(management_panel.SelectedProfileImage);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

                imgR.setImageBitmap(management_panel.SelectedProfileImage);

            }
        }
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
                i.putExtra("title","جستجو");
                startActivity(i);
                finish();
            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Menu1.class);
                startActivity(i);
                finish();
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), SabtAgahi.class);
                startActivity(i);
                finish();
            }
        });

        MenuLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Group.class);
                startActivity(i);
                finish();
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Off.class);
                startActivity(i);
                finish();
            }
        });

    }


}
