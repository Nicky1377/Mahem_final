package android.niky.mahem_final;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Menu1 extends AppCompatActivity {

    RelativeLayout JobBank,OffFinder,Register,Laws,ads,Estekhdami,MyAds,Share,Favorite,aboutUs,Setting,ContactUs;

    View navigationBar;
    ImageView Home, Add, Menu, MenuLine, Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

       JobBank=(RelativeLayout)findViewById(R.id.btn_bank);
        OffFinder=(RelativeLayout)findViewById(R.id.btn_off);
        Register=(RelativeLayout)findViewById(R.id.btn_register);
        Laws=(RelativeLayout)findViewById(R.id.btn_law);
        ads=(RelativeLayout)findViewById(R.id.btn_ads);
        Estekhdami=(RelativeLayout)findViewById(R.id.btn_employment);
        MyAds=(RelativeLayout)findViewById(R.id.btn_my_ads);
        Share=(RelativeLayout)findViewById(R.id.btn_share);
        Favorite=(RelativeLayout)findViewById(R.id.btn_favorite);
        aboutUs=(RelativeLayout)findViewById(R.id.btn_about_us);
        Setting=(RelativeLayout)findViewById(R.id.btn_setting);
        ContactUs=(RelativeLayout)findViewById(R.id.btn_contact_us);

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
                Intent i=new Intent(Menu1.this,Off_Finder.class);
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

//        ads.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(Menu1.this,Ads.class);
//                startActivity(i);
//            }
//        });
//
//
//        Estekhdami.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(Menu1.this,Estekhdami_menu.class);
//                startActivity(i);
//            }
//        });
//
//        MyAds.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(Menu1.this,Ads_show.class);
//                startActivity(i);
//            }
//        });
//
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
                Intent i = new Intent(getBaseContext(), Search.class);
                startActivity(i);

            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Menu1.class);
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
                Intent i = new Intent(getBaseContext(), Group.class);
                startActivity(i);

            }
        });


    }


}
