package android.niky.mahem_final.other;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.niky.mahem_final.Chat.MessageList;
import android.niky.mahem_final.R;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;


public class Splash_Sc extends AppCompatActivity {
    ImageView img;
    Save_File_Lang s;
    Locale myLocale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__sc);

        img = (ImageView) findViewById(R.id.spl_scr_img);

        s=new Save_File_Lang(this,getFilesDir());
        if(!s.readFileAsString().equals("")) {
            setLocale(s.readFileAsString());
        }else
        {
            setLocale("per");
        }


        if (!isNetworkAvailable(getBaseContext())) {
            tt("دستگاه به اینترنت متصل نیست");
//            img.setBackground(R.drawable.splash_dis);
        } else {
           tran(Page1.class);
//            tran(MessageList.class);
        }

    }

    void tran(final Class c) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_Sc.this, c);
                startActivity(i);
                Splash_Sc.this.finish();
            }
        }, 3000);

    }

    public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    void tt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void setLocale(String locale)
    {

        myLocale =new Locale(locale);
        Resources res=getResources();
        DisplayMetrics dm=res.getDisplayMetrics();
        Configuration conf=res.getConfiguration();
        conf.setLocale(myLocale);
        res.updateConfiguration(conf,dm);

    }
}