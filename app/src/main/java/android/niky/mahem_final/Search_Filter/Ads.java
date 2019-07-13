package android.niky.mahem_final.Search_Filter;

import android.app.ProgressDialog;
import android.niky.mahem_final.MenuItems.Ads_show;
import android.niky.mahem_final.R;

import android.content.Intent;
import android.niky.mahem_final.other.AppController;
import android.niky.mahem_final.other.Page1;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;
import android.niky.mahem_final.OffFinder.Off;


import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Ads extends AppCompatActivity {
    private View navigationBar;
    private ImageView Home,Add,Menu,MenuLine,Search;

    EditText find;

    private ListView listView;
    private List<Advertising> AdvList;
    private AdvAdapter adapter;
    private int counter=5;
    ImageView search;
    String url;
    Intent ii;
    private ProgressDialog pDialog;

    String Noe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        AdvList=new ArrayList<>();
        listView =(ListView)findViewById(R.id.RecyclerView);
        adapter = new AdvAdapter(this, AdvList);
        listView.setAdapter(adapter);

        ii=getIntent();
       url = "http://appmahem.eu-4.evennode.com/listbadaste/all/"+ii.getStringExtra("id");


        find=(EditText)findViewById(R.id.search_word);
        Search=(ImageView)findViewById(R.id.search_icon);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ////////////
            }
        });



        ///////////////////////////////////////////network
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("لطفا صبر کنید ..");
        pDialog.show();

        // Creating volley request obj
        JsonArrayRequest productReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       // Log.d(TAG, response.toString());
                        hidePDialog();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject obj = response.getJSONObject(i);
                                Advertising adv = new Advertising();
                               adv.setId(obj.getString("_id"));
                              adv.setTitle(obj.getString("title"));
                              adv.setNoe(obj.getString("noe"));
                                adv.setTime(obj.getString("date"));
                                 JSONArray pic = obj.getJSONArray("pic");
                              adv.setThumbnailUrl("http://" +pic.getString(0));


                                AdvList.add(adv);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(productReq);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getBaseContext(), Ads_show.class);
                Advertising advertising= (Advertising) adapterView.getAdapter().getItem(i);
                //tt(advertising.getDetails());
                intent.putExtra("id",advertising.getId());
                intent.putExtra("noe",advertising.getNoe());
                startActivity(intent);
            }
        });



        map();


        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();
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
