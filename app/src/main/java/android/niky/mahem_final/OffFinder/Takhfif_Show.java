package android.niky.mahem_final.OffFinder;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.niky.mahem_final.Chat.MessageList;
import android.niky.mahem_final.MenuItems.Contact;
import android.niky.mahem_final.MenuItems.ViewPagerAdapter;

public class Takhfif_Show extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private LinearLayout sliderDotspanel;
    private ImageView collection;
    private ImageView back;
    private ImageView share;
    private TextView new_cost;
    private TextView pre_cost;
    private LayoutInflater inflater;
    private RelativeLayout mapView;
    private TextView day;
    private TextView hour;
    private TextView minute;
    private TextView t_percent;
    private TextView options;
    private TextView description;
    private String searchingLocation;
    private Button calling_Information;
     Button chat;

    private boolean selected=true;
    private int dotscount;
    private ImageView[] dots;
    private String last_cost;
    private String cost;
    private String takhfif_description;
    private String takhfif_options;

    private String remainder_day;
    private String remainder_hour;
    private String remainder_minute;
    private String takhfif_percent;
    private String city;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takhfif_show);
/////////////variables should fill with network datas
        last_cost="";
        cost="";
        takhfif_description="";
        takhfif_options="";
        remainder_day="";
        remainder_hour="";
        remainder_minute="";
        takhfif_percent="";
        /////city of takhfif that display in bottom of image
        city="";
        ///for find location in google map
        searchingLocation="";
        /////////////////////////////////////


        pre_cost=(TextView)findViewById(R.id.p_cost);
        pre_cost.setText("تومان"+last_cost);


        new_cost=(TextView)findViewById(R.id.n_cost);
        new_cost.setText("تومان"+cost);


        description=(TextView)findViewById(R.id.t_des);
        description.setText(takhfif_description);
        options=(TextView)findViewById(R.id.t_optxt);
        options.setText(takhfif_options);

        ///timer
        day=(TextView)findViewById(R.id.day);
        day.setText(remainder_day);
        hour=(TextView)findViewById(R.id.hour);
        hour.setText(remainder_hour);
        minute=(TextView)findViewById(R.id.minute);
        minute.setText(remainder_minute);
        ///////
        t_percent=(TextView)findViewById(R.id.percent);
        t_percent.setText(takhfif_percent+"%تخفیف");



        viewPager=(ViewPager)findViewById(R.id.takhfif_view_pager);
        adapter=new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);




        sliderDotspanel=(LinearLayout)findViewById(R.id.t_SlideDots) ;
        dotscount=adapter.getCount();


        dots=new ImageView[dotscount];
        for(int i=0;i<dotscount;++i){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);
        }


        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        collection=(ImageView)findViewById(R.id.collections);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected){
                    collection.setImageResource(R.drawable.two);
                    selected=false;
                }else{
                    collection.setImageResource(R.drawable.one);
                    selected=true;
                }
            }
        });

        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Takhfif_Show.this,Off.class);
                startActivity(intent);

            }
        });
        share=(ImageView)findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
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
        calling_Information=(Button)findViewById(R.id.call_inform) ;
        calling_Information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent=new Intent(Takhfif_Show.this,Contact.class);
                startActivity(call_intent);
            }
        });


        mapView=(RelativeLayout)findViewById(R.id.map_view);
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent=new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse("geo:0,0?q="+searchingLocation));
                startActivity(mapIntent);
            }
        });

        chat=(Button)findViewById(R.id.chat_w);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),MessageList.class);
                startActivity(intent);
            }
        });


    }



}
