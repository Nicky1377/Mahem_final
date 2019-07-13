package android.niky.mahem_final.OffFinder;

import android.app.ProgressDialog;
import android.niky.mahem_final.Chat.ChatModel;
import android.niky.mahem_final.MenuItems.CodeVerification;
import android.niky.mahem_final.MenuItems.Register;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.net.Uri;
import android.niky.mahem_final.Search_Filter.Advertising;
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

import android.niky.mahem_final.Chat.MessageList;
import android.niky.mahem_final.MenuItems.Contact;
import android.niky.mahem_final.MenuItems.ViewPagerAdapter;
import android.widget.Toast;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

Intent ii;

    String url;
    private ProgressDialog pDialog;


    String[] imgs;
    String userId,phoneNum,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takhfif_show);
        init();

        ii=getIntent();
        url="http://appmahem.eu-4.evennode.com/getadsinfo/"+ii.getStringExtra("id")+"/"+ii.getStringExtra("noe");


        imgs=new String[5];

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

                                searchingLocation=obj.getString("googlepath");
                                pre_cost.setText("تومان"+obj.getString("mainprice"));
                                new_cost.setText("تومان"+obj.getString("secondprice"));
                                description.setText(obj.getString("comment"));
                                options.setText(obj.getString("propertis"));
                                day.setText("2");
                                hour.setText("3");
                                minute.setText("4");
                                t_percent.setText(obj.getString("darsad")+"%تخفیف");
                                /////////////////////////////////////
                                JSONArray pic = obj.getJSONArray("pic");
                                for (int i = 0; i < 5; i++) {
                                    if (!pic.getString(i).equals("")) {
                                        imgs[i] = "http://" + pic.getString(i);
                                    }
                                }

                                if (obj.getString("activechat").equals("false")) {
                                    chat.setClickable(false);
                                } else
                                    userId = obj.getString("userid");

                                if (obj.getString("activeemail").equals("false")) {
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






        adapter=new ViewPagerAdapter(this,imgs);
        viewPager.setAdapter(adapter);




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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               finish();

            }
        });
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

        calling_Information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent=new Intent(Takhfif_Show.this,Contact.class);
                call_intent.putExtra("Email",Email);
                call_intent.putExtra("phoneNum",phoneNum);
                startActivity(call_intent);
            }
        });



        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent=new Intent(Intent.ACTION_VIEW);
                mapIntent.setData(Uri.parse("geo:0,0?q="+searchingLocation));
                startActivity(mapIntent);
            }
        });


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


    }


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



    void init()
    {

        pre_cost=(TextView)findViewById(R.id.p_cost);
        new_cost=(TextView)findViewById(R.id.n_cost);
        description=(TextView)findViewById(R.id.t_des);
        day=(TextView)findViewById(R.id.day);
        hour=(TextView)findViewById(R.id.hour);
        minute=(TextView)findViewById(R.id.minute);
        t_percent=(TextView)findViewById(R.id.percent);
        options=(TextView)findViewById(R.id.t_optxt);
        viewPager=(ViewPager)findViewById(R.id.takhfif_view_pager);
        sliderDotspanel=(LinearLayout)findViewById(R.id.t_SlideDots) ;
        collection=(ImageView)findViewById(R.id.collections);
        share=(ImageView)findViewById(R.id.share);
        back=(ImageView)findViewById(R.id.back);
        calling_Information=(Button)findViewById(R.id.call_inform) ;
        mapView=(RelativeLayout)findViewById(R.id.map_view);
        chat=(Button)findViewById(R.id.chat_w);
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
}
