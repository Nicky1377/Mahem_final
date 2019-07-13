package android.niky.mahem_final.Search_Filter;

import android.app.ProgressDialog;
import android.niky.mahem_final.Chat.ChatModel;
import android.niky.mahem_final.MenuItems.Ads_show;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.niky.mahem_final.other.AppController;
import android.niky.mahem_final.other.Page1;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;
import android.niky.mahem_final.OffFinder.Off;
import android.widget.ListView;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Collections extends AppCompatActivity {
    private ImageView Home,Add,Menu,MenuLine,Search;
    ListView listView;
    List<Advertising> AdvList;
    AdvAdapter adapter;
    private int counter=3;

    private View navigationBar;

    String url;
    Intent ii;
    private ProgressDialog pDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);


        AdvList=new ArrayList<>();
        ii=getIntent();
        url = "http://appmahem.eu-4.evennode.com/getfavorit";
        getData(url,readFileAsString());
        listView =(ListView)findViewById(R.id.List);
        adapter = new AdvAdapter(this, AdvList);
        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getBaseContext(), Ads_show.class);
                Advertising advertising= (Advertising) adapterView.getAdapter().getItem(i);

                intent.putExtra("id",advertising.getId());
                intent.putExtra("noe",advertising.getNoe());
                startActivity(intent);
            }
        });

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
                Intent i = new Intent(getBaseContext(), android.niky.mahem_final.Search_Filter.Search.class);
                i.putExtra("title",getResources().getString(R.string.title_search));
                startActivity(i);

            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext(), Group.class);
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
                Intent i = new Intent(getBaseContext(), Menu1.class);
                startActivity(i);

            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Page1.class);
                startActivity(i);

            }
        });


    }


    public void postData_getChat(final String url, final JSONObject obj, boolean reg) {
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
                    Advertising adv = new Advertising();
                    adv.setId(obj1.getString("_id"));
                    adv.setTitle(obj1.getString("title"));
                    adv.setTime(obj1.getString("date"));
                    adv.setNoe(obj1.getString("noe"));
                    JSONArray pic = obj1.getJSONArray("pic");
                    adv.setThumbnailUrl("http://" +pic.getString(0));
                    adv.setThumbnailUrl2("http://" +pic.getString(1));
                    adv.setThumbnailUrl3("http://" +pic.getString(2));
                    adv.setThumbnailUrl4("http://" +pic.getString(3));
                    adv.setThumbnailUrl5("http://" +pic.getString(4));


                    AdvList.add(adv);

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
    void getData(final String URL ,final String Id)
    {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
//        pDialog.setMessage("لطفا صبر کنید");
//        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("id", Id);


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

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    void tt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
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
}
