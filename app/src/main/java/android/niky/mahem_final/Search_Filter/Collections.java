package android.niky.mahem_final.Search_Filter;

import android.app.ProgressDialog;
import android.niky.mahem_final.MenuItems.Ads_show;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.niky.mahem_final.other.AppController;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;
import android.niky.mahem_final.OffFinder.Off;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Collections extends AppCompatActivity {
    private ImageView Home,Add,Menu,MenuLine,Search;
    ListView listView;
    List<Advertising> AdvList;
    AdvAdapter adapter;
    private int counter=3;

    String url;
    Intent ii;
    private ProgressDialog pDialog;


    private ArrayList<String> title=new ArrayList<String>() {

    };
    private ArrayList<String> description=new ArrayList<String>() {

    };
    private ArrayList<String> time=new ArrayList<String>() {

    };
    private ArrayList<String> ThumbnailUrl=new ArrayList<String>() {

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);


        AdvList=new ArrayList<>();
        listView =(ListView)findViewById(R.id.RecyclerView);
        adapter = new AdvAdapter(this, AdvList);
        listView.setAdapter(adapter);

        ii=getIntent();
        url = "http://appmahem.eu-4.evennode.com//getfavorit";


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
                                adv.setTime(obj.getString("date"));
                                adv.setNoe(obj.getString("noe"));
                                JSONArray pic = obj.getJSONArray("pic");
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

                intent.putExtra("id",advertising.getId());
                intent.putExtra("noe",advertising.getNoe());
                startActivity(intent);
            }
        });

    }

    public void map() {


        Home =  findViewById(R.id.home);
        Add =  findViewById(R.id.add);
        Menu =  findViewById(R.id.menu_f);
        MenuLine =  findViewById(R.id.menuLine_f);
        Search =findViewById(R.id.search_f);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), android.niky.mahem_final.Search_Filter.Search.class);
                i.putExtra("title","جستجو");
                startActivity(i);
                finish();
            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Menu1.class);
                startActivity(i);
                finish();
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), SabtAgahi.class);
                startActivity(i);
                finish();
            }
        });

        MenuLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Group.class);
                startActivity(i);
                finish();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Off.class);
                startActivity(i);
                finish();

            }
        });}

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
}
