package android.niky.mahem_final.MenuItems;

import android.content.Intent;
import android.niky.mahem_final.R;
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
import android.widget.Toast;


public class Ads_show extends AppCompatActivity {
    private ViewPager viewPager;
    //private ViewPagerAdapter adapter;
    private LinearLayout sliderDotspanel;
    private ImageView collection;
    private ImageView back;
    private ImageView share;

    private RelativeLayout report_problem;
    private Button call_Information;
    private Button chat;

    private TextView job_name;
    private TextView agahi_time;
    private TextView option_title;
    private TextView option_detail;
    private TextView description;
    private TextView agahi_title;
    private LayoutInflater inflater;

    private boolean selected=true;
    private int dotscount;
    private ImageView[] dots;
    private String JobName;
    private String TimeOfAgahi;
    private String TitleOfOption;
    private String OptionDetails;
    private String Description;
    private String AgahiName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_show);
        job_name=(TextView)findViewById(R.id.jobname);
        agahi_time=(TextView)findViewById(R.id.time) ;
        option_title=(TextView)findViewById(R.id.option_title) ;
        option_detail=(TextView)findViewById(R.id.option_detail) ;
        description=(TextView)findViewById(R.id.details);
        agahi_title=(TextView)findViewById(R.id.jobtitle) ;
        /////////////fill this variables from network data
        ///under image textview
        JobName="";
        TimeOfAgahi="";
        ////second textview
        TitleOfOption="";
        OptionDetails="";
        ///third text view
        Description="";
        ///toolbar
        AgahiName="";
        //////////////////////////
        job_name.setText(JobName);
        agahi_time.setText(TimeOfAgahi);
        option_title.setText(TitleOfOption);
        option_detail.setText(OptionDetails);
        description.setText(Description);
        agahi_title.setText(AgahiName);

        viewPager=(ViewPager)findViewById(R.id.view_pager);
//        adapter=new ViewPagerAdapter(this);
//        viewPager.setAdapter(adapter);



        sliderDotspanel=(LinearLayout)findViewById(R.id.SlideDots) ;
        //dotscount=adapter.getCount();


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
                    Toast.makeText(getBaseContext(),"در آگهی های نشان شده ذخیره شد.",Toast.LENGTH_SHORT).show();
                    selected=false;
                }else{
                    collection.setImageResource(R.drawable.one);
                    Toast.makeText(getBaseContext(),"از آگهی های نشان شده حذف شد.",Toast.LENGTH_SHORT).show();
                    selected=true;
                }
            }
        });

        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //should fill with network data

                Toast.makeText(getBaseContext(),"NETWORK",Toast.LENGTH_SHORT).show();
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



        report_problem=(RelativeLayout)findViewById(R.id.report);
        report_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //should fill with network data

                Toast.makeText(getBaseContext(),"NETWORK",Toast.LENGTH_SHORT).show();
            }
        });




        call_Information=(Button)findViewById(R.id.call_inf);
        call_Information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Ads_show.this,Contact.class);
                startActivity(intent);



            }
        });

        chat=(Button)findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //should fill with network data

                Toast.makeText(getBaseContext(),"NETWORK",Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(this, getLocalClassName().toString() + "\nMohadese Salem", Toast.LENGTH_LONG).show();
    }
}
