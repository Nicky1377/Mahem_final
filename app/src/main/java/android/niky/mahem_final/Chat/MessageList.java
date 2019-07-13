package android.niky.mahem_final.Chat;

import android.app.ProgressDialog;
import android.niky.mahem_final.R;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.niky.mahem_final.Search_Filter.Advertising;
import android.niky.mahem_final.other.AppController;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

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
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MessageList extends AppCompatActivity {

    ListView list;
    EditText msg;

    String text;
    ChatModel chatModelssss;

    List<ChatModel> chatModels;
    CustomAdapter customAdapter;

    Intent ii;
    String ph_number;
    String formattedNumber ;

    RelativeLayout SendMessage;
    ImageView back,ShareMedia,Call;
    CircleImageView ProfileImg;
    TextView Name;
    EditText MessageText;
    String temp;
    boolean flag=false;
    int messageCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        init();

        ii=getIntent();
        ph_number=ii.getStringExtra("phoneNum");
       // formattedNumber = PhoneNumberUtils.formatNumber(ph_number, Locale.getDefault().getCountry());
        formattedNumber =ph_number;
        list=(ListView)findViewById(R.id.message_list);
        msg=(EditText)findViewById(R.id.MessageText);

        SendMessage=(RelativeLayout)findViewById(R.id.SendBtn);
        chatModels=new ArrayList<>();
        //////////////handler every 10 seconds....
        final Handler handler=new Handler();
        final int delay=1000*10;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

               // GetPic("http://appmahem.eu-4.evennode.com/getchat");
         getChat("http://appmahem.eu-4.evennode.com/getchat",readFileAsString(), ii.getStringExtra("creater_id"),ii.getStringExtra("adsId"));
//                getChat("http://appmahem.eu-4.evennode.com/getchat","5ca5fe828ea1570012bca176", "5ca5fe828ea1570012bca177","ggggggdd");

                if(flag==false){
        customAdapter=new CustomAdapter(chatModels,getApplicationContext());
        list.setAdapter(customAdapter);

                }
                handler.postDelayed(this,delay);
            }
        },delay);


//        chatModels.add(new ChatModel("سلام" + "\n" +"  شرایط فروش خودرو و اقساطش رو توضیح میدین؟؟"
//                ,false, Calendar.getInstance().getTime()));
//        chatModels.add(new ChatModel("سلام ، زنگ بزنین تا بتونم بهتر توضیح بدم",true,Calendar.getInstance().getTime()));

        SendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(msg.getText().toString().equals(""))
                {
                    msg.setHint("افزودن متن");
                }
                else {
//                    Toast.makeText(getBaseContext(), "sent", Toast.LENGTH_LONG).show();

                    text = msg.getText().toString();

                    Sendr("http://appmahem.eu-4.evennode.com/addchat",readFileAsString(),
                            ii.getStringExtra("creater_id"),text,ii.getStringExtra("adsId"));

                    chatModelssss = new ChatModel(text, true);

                    chatModels.add(chatModelssss);

                    msg.setText("");
                    msg.setHint("افزودن متن");


                    list.setAdapter(customAdapter);
                }
            }
        });

        back=(ImageView)findViewById(R.id.flsh);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Call=(ImageView)findViewById(R.id.calllll);
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + formattedNumber));

                final int ID_THIS_ACTIVITY=11;
                if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.CALL_PHONE};
                        requestPermissions(permission, ID_THIS_ACTIVITY);
                    }
                    else{
                        startActivity(i);
                    }
                }
            }
        });



    }

    private  void init()
    {
        Name=(TextView)findViewById(R.id.Name);
        MessageText=(EditText)findViewById(R.id.MessageText);
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
    ///////////////////////Network//////////////

    private ProgressDialog pDialog;


    void Sendr(final String URL, final String buyerId,final String createrId,
               String message,String AdsId) {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("لطفا صبر کنید");
        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("sender", buyerId);
        postParam.put("ads_id", AdsId);
        postParam.put("creater_id", createrId);
        postParam.put("buyer_id", buyerId);
        postParam.put("text", message);


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
    String id;
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
                    //id = temp.substring(21, temp.length() - 14);
                    runOnUiThread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void run() {
                            hidePDialog();
                            //  tt("ثبت نام با موفقیت انجام شد\nلطفا وارد حساب خود شوید");
                            String code=temp.substring(temp.length()-5,temp.length()-1);

                            tt("data sent");
                           // tt(code +"\n"+id);

                          //  String userId=temp.toString().split("\"")[7];


                            tt("message Sent...");
                           // tran(id, etPhone.getText().toString(),code);

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
                    id = temp.substring(21, temp.length() - 2);
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


    void getChat(final String URL ,final String buyerId,final String createrId,String AdsId)
    {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
//        pDialog.setMessage("لطفا صبر کنید");
//        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("ads_id", AdsId);
        postParam.put("creater_id", createrId);
        postParam.put("buyer_id", buyerId);



        ////////////////////////////////////////////////////////

        final Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject obj = new JSONObject(postParam);
                postData_getChat(URL, obj, true);
            }
        });

        send.start();
    }

    public void postData_getChat(final String url, final JSONObject obj, boolean reg) {
        // Create a new HttpClient and Post Header
        HttpParams myParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(myParams, 10000);
        HttpConnectionParams.setSoTimeout(myParams, 10000);
        HttpClient httpclient = new DefaultHttpClient(myParams);

        chatModels=new ArrayList<>();
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
            if(ja.length()==messageCount)
                flag=true;
            else
                flag=false;

            messageCount=ja.length();
            for (int i = 0; i < ja.length(); i++) {
                try {
                    JSONObject obj1 = ja.getJSONObject(i);
                    ChatModel adv = new ChatModel();

                    adv.setMessage(obj1.getString("text"));

                    if(obj1.getString("sender").equals(readFileAsString()))
                        adv.setSend(true);
                    else
                        adv.setSend(false);

                    chatModels.add(adv);

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

    void GetPic(final String URL, final String createrId) {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("لطفا صبر کنید");
        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("id", createrId);

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
}

