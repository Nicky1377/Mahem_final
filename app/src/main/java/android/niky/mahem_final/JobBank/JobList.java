package android.niky.mahem_final.JobBank;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class JobList extends AppCompatActivity {

    RecyclerView j_recyclerView;
    List<Jobs> JList;
    JAdapter adapter;
    TextView JobTitle;
    CircleImageView JobPic;
    private Integer[] photos;
    FloatingActionButton plus;


    /////fill with put extra
    private String JobCode;
    /////////

    private String JobName;
    private int j_code;
    ///////intialize counter variable that show how many (takhfif agahi) will be shown in layout
    private int counter=3;
    ///


    private ArrayList<String> row=new ArrayList<>();
    private ArrayList<String> title=new ArrayList<>();
    private ArrayList<String> manager=new ArrayList<>();
    private ArrayList<String> phone=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        JobPic=(CircleImageView)findViewById(R.id.job_pic) ;
        JobTitle=(TextView)findViewById(R.id.list_title);
        plus=(FloatingActionButton)findViewById(R.id.plus);

        Intent intent=getIntent();
        JobCode= intent.getStringExtra("id").toString();


        photos=new Integer[]{R.drawable.xxx,R.drawable.cccc,R.drawable.car,R.drawable.ar,
                R.drawable.graduate,R.drawable.piano,R.drawable.footbalist,R.drawable.teacher,R.drawable.garson,R.drawable.pc,
                R.drawable.cccc,R.drawable.cloths,R.drawable.building,R.drawable.cow,R.drawable.meeting,R.drawable.a,
                R.drawable.sedots,R.drawable.cccc,R.drawable.food,R.drawable.desk};

        JList=new ArrayList<>();
        for(int i=0;i<counter;++i) {


            ///////fill these strings with network information
            row.add("ed");
            title.add("ff");
            manager.add("gggg");
            phone.add("jjjjjjjjj");
            /////////////////////

            j_recyclerView = (RecyclerView) findViewById(R.id.JRecyclerView);
            j_recyclerView.setHasFixedSize(true);
            j_recyclerView.setLayoutManager(new LinearLayoutManager(this));
            JList.add(new Jobs(row.get(i), title.get(i), manager.get(i), phone.get(i)));
            adapter = new JAdapter(this, JList);
            j_recyclerView.setAdapter(adapter);

        }

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobBank_Sabt.class);
                startActivity(i);
            }
        });

        finder();

    }

    private void finder(){
        switch (JobCode){
            case "1":
                JobName=" پزشکی";
                j_code=0;
                break;
            case "2":
                JobName=" بازرگانی و تجارت";
                j_code=1;
                break;
            case "3":
                JobName=" اتومبیل";
                j_code=2;
                break;
            case "4":
                JobName=" آرایش و پیرایش";
                j_code=3;
                break;
            case "5":
                JobName=" مراکز تحصیلی";
                j_code=4;
                break;
            case "6":
                JobName=" مراکز هنری";
                j_code=5;
                break;
            case "7":
                JobName=" مراکز ورزشی";
                j_code=6;
                break;
            case "8":
                JobName=" آموزش و پژوهش";
                j_code=7;
                break;
            case "9":
                JobName=" خدمات مجلسی";
                j_code=8;
                break;
            case "10":
                JobName=" کامپیوتروموبایل";
                j_code=9;
                break;
            case "11":
                JobName=" برق";
                j_code=10;
                break;
            case "12":
                JobName=" پوشاک";
                j_code=11;
                break;
            case "13":
                JobName=" ساختمان";
                j_code=12;
                break;
            case "14":
                JobName=" کشاورزی دامپروری";
                j_code=13;
                break;
            case "15":
                JobName=" خدمات اجتماعی";
                j_code=14;
                break;
            case "16":
                JobName=" چاپ وتبلیغات";
                j_code=15;
                break;
            case "17":
                JobName=" سایرخدمات";
                j_code=16;
                break;
            case "18":
                JobName=" صنعت";
                j_code=17;
                break;
            case "19":
                JobName=" صنایع غذایی";
                j_code=18;
                break;
            case "20":
                JobName=" دکوراسیون";
                j_code=19;
                break;

        }

        JobTitle.setText("مشاغل"+JobName);
        JobPic.setImageResource(photos[j_code]);


    }
}