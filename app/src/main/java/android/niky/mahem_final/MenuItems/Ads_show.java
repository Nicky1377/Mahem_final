package android.niky.mahem_final.MenuItems;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.niky.mahem_final.OffFinder.Takhfif_Show;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Chat.MessageList;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Ads_show extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private LinearLayout sliderDotspanel;
    private ImageView collection;
    private ImageView back;
    private ImageView share;

    private RelativeLayout report_problem;
    private Button call_Information;
    private Button chat;

    private TextView job_name;
    private TextView agahi_time;

    private TextView option_detail1,option_detail2,option_detail3,option_detail4,option_detail5,option_detail6,option_detail7,option_detail8;
    private TextView description;
    private TextView agahi_title;
    private LayoutInflater inflater;

    private boolean selected=true;
    private int dotscount=5;
    private ImageView[] dots;
    Intent ii;

    Button accept,deny;

    String googlePath;
    String url;
    String[] imgs;
    String userId,phoneNum,Email,noe;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_show);
        init();

        /////////////fill this variables from network data

        ii=getIntent();
        noe=ii.getStringExtra("noe");
        url="http://appmahem.eu-4.evennode.com/getadsinfo/"+ii.getStringExtra("id")+"/"+ii.getStringExtra("noe");



        imgs=new String[5];

        fill_data();

        viewPager=findViewById(R.id.view_pager);
        adapter=new ViewPagerAdapter(this,imgs);
        viewPager.setAdapter(adapter);



        sliderDotspanel=(LinearLayout)findViewById(R.id.SlideDots) ;
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

        collection=findViewById(R.id.collections);
        collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selected){
                    collection.setImageResource(R.drawable.two);
                    selected=false;
                    Send_favorite("http://mahem.ir/addtofavorit",readFileAsString(),ii.getStringExtra("id"));
                }
            }
        });

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //should fill with network data

                Intent i=new Intent(Ads_show.this, android.niky.mahem_final.Search_Filter.Search.class);
                i.putExtra("title",getResources().getString(R.string.Estekhdami_title));
                startActivity(i);
            }
        });
        share=findViewById(R.id.share);
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



        report_problem=findViewById(R.id.report);
        report_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //should fill with network data
                show_alert();

                Toast.makeText(getBaseContext(),"NETWORK",Toast.LENGTH_SHORT).show();
            }
        });



        call_Information=findViewById(R.id.call_inf);
        call_Information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent=new Intent(getBaseContext(),Contact.class);
                call_intent.putExtra("Email",Email);
                call_intent.putExtra("phoneNum",phoneNum);
                startActivity(call_intent);


            }
        });

        chat=findViewById(R.id.chat);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getBaseContext(),MessageList.class);
                intent.putExtra("creater_id",userId);
                intent.putExtra("adsId",ii.getStringExtra("id"));
                intent.putExtra("phoneNum",phoneNum);
                startActivity(intent);
            }
        });

       // Toast.makeText(this, getLocalClassName().toString() + "\nMohadese Salem", Toast.LENGTH_LONG).show();
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public void fill_data()
    {
        if(noe.equals("1"))////Estekhdam
        {
            StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        Log.d("result",s);

                        try{
                            JSONArray result=new JSONArray(s);
                            hidePDialog();
                            for (int j=0;j<result.length();j++) {
                                JSONObject obj = result.getJSONObject(j);


/////////////variables should fill with network datas
                                job_name.setText(obj.getString("title"));
                                agahi_time.setText("دیروز");
                                description.setText(obj.getString("comment"));
                                googlePath=obj.getString("googlepath");
                             //   agahi_title.setText(AgahiName);
                                option_detail1.setText("شهر:  "+obj.getString("city"));
                                       option_detail2.setText("میزان تحصیلات:  "
                                        +obj.getString("tahsil"));
                                       option_detail3.setText("نوع قرارداد:  "
                                               +obj.getString("garardad"));

                                ///for find location in google map
                                // searchingLocation="";
                                /////////////////////////////////////
                                JSONArray pic = obj.getJSONArray("pic");
                                for (int i = 0; i < 5; i++) {
                                    if (!pic.getString(i).equals("")) {
                                        imgs[i] = "http://" + pic.getString(i);
                                    }
                                }

                                if (obj.getBoolean("activechat")==false) {
                                    chat.setClickable(false);
                                } else
                                    userId = obj.getString("userid");

                                if (obj.getBoolean("activeemail")==true) {
                                    Email = "";
                                } else
                                    Email = obj.getString("tamasemail");

                                phoneNum = obj.getString("tamasphone");

                            }
                        }catch (Exception e)
                        {

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

//
           // tt("1");
        }else if(noe.equals("2"))//////home
        {

            StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {

                            Log.d("result",s);

                            try{
                                JSONArray result=new JSONArray(s);
                                hidePDialog();
                                for (int j=0;j<result.length();j++) {
                                    JSONObject obj = result.getJSONObject(j);


/////////////variables should fill with network datas
                                    job_name.setText(obj.getString("title"));
                                    agahi_time.setText("دیروز");
                                    description.setText(obj.getString("comment"));
                                    googlePath=obj.getString("googlepath");
                                    //   agahi_title.setText(AgahiName);
                                    option_detail1.setText("شهر:  "+obj.getString("city"));
                                option_detail2.setText("نوع ملک:  "+obj.getString("noemelk"));
                                option_detail3.setText("متراژ:  "
                                        +obj.getString("metr"));
                                option_detail4.setText("نوع آگهی:  "
                                        +obj.getString("typeads"));
                                option_detail5.setText("میزان رهن:  "
                                        +obj.getString("pricerahn"));
                                option_detail6.setText("میزان اجاره:  "
                                        +obj.getString("priceegare"));
//
                                    ///for find location in google map
                                    // searchingLocation="";
                                    /////////////////////////////////////
                                    JSONArray pic = obj.getJSONArray("pic");
                                    for (int i = 0; i < 5; i++) {
                                        if (!pic.getString(i).equals("")) {
                                            imgs[i] = "http://" + pic.getString(i);
                                        }
                                    }

                                    if (obj.getBoolean("activechat")==false) {
                                        chat.setClickable(false);
                                    } else
                                        userId = obj.getString("userid");

                                    if (obj.getBoolean("activeemail")==true) {
                                        Email = "";
                                    } else
                                        Email = obj.getString("tamasemail");

                                    phoneNum = obj.getString("tamasphone");

                                }
                            }catch (Exception e)
                            {

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {

                        }
                    });
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

//
           // tt("2");

        }else if(noe.equals("3"))///////car
        {
            StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {

                            Log.d("result",s);

                            try{
                                JSONArray result=new JSONArray(s);
                                hidePDialog();
                                for (int j=0;j<result.length();j++) {
                                    JSONObject obj = result.getJSONObject(j);


/////////////variables should fill with network datas
                                    job_name.setText(obj.getString("title"));
                                    agahi_time.setText("دیروز");
                                    description.setText(obj.getString("comment"));
                                    googlePath=obj.getString("googlepath");
                                    //   agahi_title.setText(AgahiName);
                                    option_detail1.setText("شهر:  "+obj.getString("city"));
                                       option_detail2.setText("برند:  "
                                        +obj.getString("brand"));
                                       option_detail3.setText("نوع شاسی:  "
                                               +obj.getString("shasi"));
                                       option_detail4.setText("سال تولید:  "
                                        +obj.getString("saltolid"));
                                       option_detail5.setText("کارکرد:  "
                                        +obj.getString("karkard"));
                                       option_detail6.setText("قیمت:  "
                                        +obj.getString("priceegare"));
                                       option_detail7.setText("نوع آگهی:  "
                                        +obj.getString("typeads"));

                                       if(obj.getBoolean("nagdornat")==true)
                                           option_detail8.setText("نقد یا اقساط: نقد");
                                       else option_detail8.setText("نقد یا اقساط: اقساط");

                                    ///for find location in google map
                                    // searchingLocation="";
                                    /////////////////////////////////////
                                    JSONArray pic = obj.getJSONArray("pic");
                                    for (int i = 0; i < 5; i++) {
                                        if (!pic.getString(i).equals("")) {
                                            imgs[i] = "http://" + pic.getString(i);
                                        }
                                    }

                                    if (obj.getBoolean("activechat")==false) {
                                        chat.setClickable(false);
                                    } else
                                        userId = obj.getString("userid");

                                    if (obj.getBoolean("activeemail")==true) {
                                        Email = "";
                                    } else
                                        Email = obj.getString("tamasemail");

                                    phoneNum = obj.getString("tamasphone");

                                }
                            }catch (Exception e)
                            {

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {

                        }
                    });
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

            //tt("3");
        }else if(noe.equals("4"))//////other
        {
            StringRequest stringRequest=new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {

                            Log.d("result",s);

                            try{
                                JSONArray result=new JSONArray(s);
                                hidePDialog();
                                for (int j=0;j<result.length();j++) {
                                    JSONObject obj = result.getJSONObject(j);


/////////////variables should fill with network datas
                                    job_name.setText(obj.getString("title"));
                                    agahi_time.setText("دیروز");
                                    description.setText(obj.getString("comment"));
                                    googlePath=obj.getString("googlepath");
                                    //   agahi_title.setText(AgahiName);
                                    option_detail1.setText("شهر:  "+obj.getString("city"));
                                    option_detail2.setText("قیمت:" +obj.getString("price"));
                                    option_detail3.setText("نوع آگهی:"+obj.getString("typeads"));
                                    option_detail4.setText("نوع آگهی دهنده:" +obj.getString("setasdser"));

                                    ///for find location in google map
                                    // searchingLocation="";
                                    /////////////////////////////////////
                                    JSONArray pic = obj.getJSONArray("pic");
                                    for (int i = 0; i < 5; i++) {
                                        if (!pic.getString(i).equals("")) {
                                            imgs[i] = "http://" + pic.getString(i);
                                        }
                                    }

                                    if (obj.getBoolean("activechat")==false) {
                                        chat.setClickable(false);
                                    } else
                                        userId = obj.getString("userid");

                                    if (obj.getBoolean("activeemail")==true) {
                                        Email = "";
                                    } else
                                        Email = obj.getString("tamasemail");

                                    phoneNum = obj.getString("tamasphone");

                                }
                            }catch (Exception e)
                            {

                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {

                        }
                    });
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

            //tt("4");
        }
    }


//////////////////////////////////////////////////////////////
    void Send_favorite(final String URL, final String username, final String adsId) {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("لطفا صبر کنید");
        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("id", username);
        postParam.put("adsid", adsId);


        ////////////////////////////////////////////////////////

        final Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject obj = new JSONObject(postParam);
                postData(URL, obj, true);
            }
        });

        send.start();
    }

    void Send_Report(final String URL, final String noe, final String adsId) {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("لطفا صبر کنید");
        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("id", adsId);
        postParam.put("noe", noe);


        ////////////////////////////////////////////////////////

        final Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject obj = new JSONObject(postParam);
                postData(URL, obj, true);
            }
        });

        send.start();
    }

    public String readFileAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File( getFilesDir().getAbsolutePath() + "/.MahemProg/phn.txt")));
            while ((line = in.readLine()) != null) stringBuilder.append(line);

        } catch (FileNotFoundException e) {
            tt(e.getMessage());
        } catch (IOException e) {
            tt(e.getMessage());
        }

        String[] a=stringBuilder.toString().split("\n");
        String b=a[a.length-1];
        return b;
    }
    String temp;

    public void postData(final String url, final JSONObject obj, boolean reg) {
        // Create a new HttpClient and Post Header
        HttpParams myParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(myParams, 10000);
        HttpConnectionParams.setSoTimeout(myParams, 10000);
        HttpClient httpclient = new DefaultHttpClient(myParams);

        try {
            HttpPost httppost = new HttpPost(url.toString());
            httppost.setHeader("Content-type", "application/json");

            StringEntity se = new StringEntity(obj.toString(), HTTP.UTF_8);
//            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json; charset=utf-8"));
//            se.setContentEncoding("UTF-8");
            se.setContentType("application/json");
            httppost.setEntity(se);

            HttpResponse response = httpclient.execute(httppost);
            temp = EntityUtils.toString(response.getEntity());


            if (reg) {
                if (temp.contains("ok")) {

                    runOnUiThread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void run() {
                            hidePDialog();
                            tt("در علاقه مندی ها ثبت شد...");
                            hidePDialog();
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hidePDialog();
                            tt("خطا در اطلاعات وارد شده");
                        }
                    });
                }
            } else {
                //login
                if (temp.contains("ok")) {

                    JsonArrayRequest productReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                                JSONObject obj=response.getJSONObject(0);
                                //   tran(id, etPhone.getText().toString(), obj.getString( "registertoken"));
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // VolleyLog.d(TAG, "Error: " + error.getMessage());
                            hidePDialog();
                        }
                    });

                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hidePDialog();
                            tt("شما تصدیق نشدید\nدوباره سعی کنید");
                        }
                    });

                }

            }
        } catch (ClientProtocolException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tt("خطا در برقراری ارتباط");
                    hidePDialog();
                }
            });

        } catch (IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tt("خطا در ورودی خروجی");
                    hidePDialog();
                }
            });
        }


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

    void init()
    {

        job_name=findViewById(R.id.jobname);
        agahi_time=findViewById(R.id.time) ;
        option_detail1=findViewById(R.id.option_detail1) ;
        option_detail2=findViewById(R.id.option_detail2) ;
        option_detail3=findViewById(R.id.option_detail3) ;
        option_detail4=findViewById(R.id.option_detail4) ;
        option_detail5=findViewById(R.id.option_detail5) ;
        option_detail6=findViewById(R.id.option_detail6) ;
        option_detail7=findViewById(R.id.option_detail7) ;
        option_detail8=findViewById(R.id.option_detail8) ;
        description=findViewById(R.id.details);
        agahi_title=findViewById(R.id.jobtitle) ;

    }


    private void show_alert(){

        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        final int myW = (width * 20) / 21;
        final int myH = (height)*4 / 5;


        AlertDialog.Builder gbuilder = new AlertDialog.Builder(Ads_show.this);
        View gView = getLayoutInflater().inflate(R.layout.problem_report_layout, null);

        accept=gView.findViewById(R.id.yes);
        deny=gView.findViewById(R.id.No);



        gView.setMinimumWidth(myW);
        gView.setMinimumHeight(myH);
        gbuilder.setView(gView);
        final Dialog alertDialog = gbuilder.create();
        alertDialog.show();
        alertDialog.getWindow().setLayout(myW, myH);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Send_Report("http://appmahem.eu-4.evennode.com//problemreport/"+ii.getStringExtra("id")+"/"+ii.getStringExtra("noe"),ii.getStringExtra("noe"),ii.getStringExtra("id"));
                alertDialog.cancel();
            }
        });
        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                alertDialog.cancel();
                // Toast.makeText(Buy_Coins.this, "denied !", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
