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
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;
import android.niky.mahem_final.OffFinder.Off;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class Search extends AppCompatActivity {
    View navigationBar;
    ImageView Home,Add,Menu,MenuLine,Search;
    ImageView Filter,searching_icon;

    ListView listView;
    List<Advertising> AdvList;
    AdvAdapter adapter;
    private int counter=3;


    private ArrayList<String> title=new ArrayList<String>() {

    };
    private ArrayList<String> description=new ArrayList<String>() {

    };
    private ArrayList<String> time=new ArrayList<String>() {

    };
    private ArrayList<String> ThumbnailUrl=new ArrayList<String>() {

    };

    EditText search;
    String url;
    Intent ii;
    private ProgressDialog pDialog;


    private String activity_title;
    private TextView ActivityTitle;
    Intent title_intent;
    String id="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        ActivityTitle=findViewById(R.id.activity_title);

        init();
        title_intent=getIntent();
        activity_title=title_intent.getExtras().get("title").toString();
        if(activity_title!=null){
            ActivityTitle.setText(activity_title);

            if(activity_title.equals(getResources().getString(R.string.title_search)))
            {
                url = "http://mahem.ir/listbadaste/all/"+id;
            }
            else{
                Filter.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
                searching_icon.setVisibility(View.GONE);
                url = "http://appmahem.eu-4.evennode.com/list/all/1";
            }
        }




        AdvList=new ArrayList<>();
        listView =(ListView)findViewById(R.id.RecyclerView);
        adapter = new AdvAdapter(this, AdvList);
        listView.setAdapter(adapter);

        ii=getIntent();
        url = "http://mahem.ir/listbadaste/all/"+id;



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
                //intent.putExtra("title",advertising.getTitle());
                intent.putExtra("id",advertising.getId());
                intent.putExtra("noe",advertising.getNoe());
//
                startActivity(intent);
            }
        });


        Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Search.this,Filter_other.class);
                startActivityForResult(i,1);

            }
        });

        Toast.makeText(this, getLocalClassName().toString() + "\nMohadese Salem", Toast.LENGTH_LONG).show();
        map();
    }

    private void init()
    {
        Filter=(ImageView)findViewById(R.id.filter);
        search=(EditText)findViewById(R.id.search_word);
        searching_icon=(ImageView)findViewById(R.id.search_icon);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==1)
        {
            if(resultCode==RESULT_FIRST_USER)
            {
             id=(data.getStringExtra("id"));
            }
            else
            {
//                    if(data.getStringExtra("src")=="")
            }
        }

    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


}
