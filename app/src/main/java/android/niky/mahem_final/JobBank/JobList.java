package android.niky.mahem_final.JobBank;

import android.app.ProgressDialog;
import android.niky.mahem_final.Chat.ChatModel;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.niky.mahem_final.Search_Filter.Advertising;
import android.niky.mahem_final.other.AppController;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class JobList extends AppCompatActivity {

    RecyclerView j_recyclerView;
    List<Job_Sabt_Class> JList;
    JAdapter adapter;
    TextView JobTitle;
    CircleImageView JobPic;
    private Integer[] photos;
    FloatingActionButton plus;


    /////fill with put extra
    private String JobCode;
    /////////

    String url;
    private ProgressDialog pDialog;

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
        JobPic = (CircleImageView) findViewById(R.id.job_pic);
        JobTitle = (TextView) findViewById(R.id.list_title);
        plus = (FloatingActionButton) findViewById(R.id.plus);

        Intent intent = getIntent();
        JobCode = intent.getStringExtra("id").toString();



        photos = new Integer[]{R.drawable.xxx, R.drawable.cccc, R.drawable.car, R.drawable.ar,
                R.drawable.graduate, R.drawable.piano, R.drawable.footbalist, R.drawable.teacher, R.drawable.garson, R.drawable.pc,
                R.drawable.cccc, R.drawable.cloths, R.drawable.building, R.drawable.cow, R.drawable.meeting, R.drawable.a,
                R.drawable.sedots, R.drawable.cccc, R.drawable.food, R.drawable.desk};

        JList = new ArrayList<>();

        getData("http://appmahem.eu-4.evennode.com/getbanklist");
        j_recyclerView = (RecyclerView) findViewById(R.id.JRecyclerView);
        j_recyclerView.setHasFixedSize(true);
        j_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new JAdapter(this, JList);
        j_recyclerView.setAdapter(adapter);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobBank_Sabt.class);
                i.putExtra("session",JobCode);
                startActivity(i);
            }
        });

        finder();

    }

    private void finder(){
        switch (JobCode){
            case "1_Job":
                JobName=" پزشکی";
                j_code=0;
                break;
            case "2_Job":
                JobName=" بازرگانی و تجارت";
                j_code=1;
                break;
            case "3_Job":
                JobName=" اتومبیل";
                j_code=2;
                break;
            case "4_Job":
                JobName=" آرایش و پیرایش";
                j_code=3;
                break;
            case "5_Job":
                JobName=" مراکز تحصیلی";
                j_code=4;
                break;
            case "6_Job":
                JobName=" مراکز هنری";
                j_code=5;
                break;
            case "7_Job":
                JobName=" مراکز ورزشی";
                j_code=6;
                break;
            case "8_Job":
                JobName=" آموزش و پژوهش";
                j_code=7;
                break;
            case "9_Job":
                JobName=" خدمات مجلسی";
                j_code=8;
                break;
            case "10_Job":
                JobName=" کامپیوتروموبایل";
                j_code=9;
                break;
            case "11_Job":
                JobName=" برق";
                j_code=10;
                break;
            case "12_Job":
                JobName=" پوشاک";
                j_code=11;
                break;
            case "13_Job":
                JobName=" ساختمان";
                j_code=12;
                break;
            case "14_Job":
                JobName=" کشاورزی دامپروری";
                j_code=13;
                break;
            case "15_Job":
                JobName=" خدمات اجتماعی";
                j_code=14;
                break;
            case "16_Job":
                JobName=" چاپ وتبلیغات";
                j_code=15;
                break;
            case "17_Job":
                JobName=" سایرخدمات";
                j_code=16;
                break;
            case "18_Job":
                JobName=" صنعت";
                j_code=17;
                break;
            case "19_Job":
                JobName=" صنایع غذایی";
                j_code=18;
                break;
            case "20_Job":
                JobName=" دکوراسیون";
                j_code=19;
                break;

        }

        JobTitle.setText("مشاغل"+JobName);
        JobPic.setImageResource(photos[j_code]);


    }
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    void tt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    void getData(final String URL )
    {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
//        pDialog.setMessage("لطفا صبر کنید");
//        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("session", JobCode);


        ////////////////////////////////////////////////////////

        final Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject obj = new JSONObject(postParam);
                postData_getData(URL, obj, true);
            }
        });

        send.start();
    }

    public void postData_getData(final String url, final JSONObject obj, boolean reg) {
        // Create a new HttpClient and Post Header
        HttpParams myParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(myParams, 10000);
        HttpConnectionParams.setSoTimeout(myParams, 10000);
        HttpClient httpclient = new DefaultHttpClient(myParams);


        try {
            HttpPost httppost = new HttpPost(url.toString());
            httppost.setHeader("Content-type", "application/json");

            StringEntity se = new StringEntity(obj.toString(), HTTP.UTF_8);

            se.setContentType("application/json");
            httppost.setEntity(se);

            HttpResponse response = httpclient.execute(httppost);
            String temp1 = EntityUtils.toString(response.getEntity());
            JSONArray ja=new JSONArray(temp1);

            Log.d("temp1",ja.toString());

            for (int i = 0; i < ja.length(); i++) {
                try {
                    JSONObject obj1 = ja.getJSONObject(i);
                    Job_Sabt_Class job = new Job_Sabt_Class();

                    job.setModiriat(obj1.getString("modiriat"));
                    job.setName(obj1.getString("senf"));
                    job.setPhone_office(obj1.getString("tamas"));
                    job.setRow((i+1)+"");
                    job.setPicUrl("http://"+obj1.getString("picurl"));
                    job.setAddress(obj1.getString("address"));
                    job.setSenf_type(obj1.getString("session"));
                    job.setDate(obj1.getString("date"));
                    job.setEmail(obj1.getString("email"));
                    job.setFax(obj1.getString("fax"));
                    job.setInsta(obj1.getString("instagram"));
                    job.setMobile(obj1.getString("mobile"));
                    job.setTelegram(obj1.getString("telegram"));
                    job.setSabt_num(obj1.getString("numsabt"));
                    job.setTozihat(obj1.getString("comment"));



                    JList.add(job);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
//            customAdapter.notifyDataSetChanged();


        } catch (IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tt("خطا در ورودی خروجی");
                    hidePDialog();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}