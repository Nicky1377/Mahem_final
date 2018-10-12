package android.niky.mahem_final;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class Splash_Sc extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__sc);

        img = (ImageView) findViewById(R.id.spl_scr_img);
        if (!isNetworkAvailable(getBaseContext())) {
            tt("دستگاه به اینترنت متصل نیست");
//            img.setBackground(R.drawable.splash_dis);
        } else {
           tran(Page1.class);
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
}