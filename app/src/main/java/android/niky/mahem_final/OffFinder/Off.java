package android.niky.mahem_final.OffFinder;

import android.app.ProgressDialog;
import android.niky.mahem_final.MenuItems.Ads_show;
import android.niky.mahem_final.R;

import android.content.Intent;
import android.niky.mahem_final.other.AppController;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Off extends AppCompatActivity {

    private View navigationBar;
    private TextView city_selection;
    PopupMenu popup;
    private ImageView Home, Add, Menu, MenuLine, Search;

    private ListView listView;

    List<Takhfif> TList;
    TAdapter adapter;

    private TextView distance;
    Intent ii;
    String url;

    private ProgressDialog pDialog;
    ///////intialize counter variable that show how many (takhfif agahi) will be shown in layout
    int counter=3;
    ///

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_off);
        city_selection=(TextView)findViewById(R.id.title);

        TList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.n_recycler_view);
        adapter = new TAdapter(this, TList);
        listView.setAdapter(adapter);

        ii=getIntent();

//        if(ii.getStringExtra("id").equals(""))
            url = "http://appmahem.eu-4.evennode.com/list/all/6";
//        else
//        url = "http://appmahem.eu-4.evennode.com/listbadaste/all/"+ii.getStringExtra("id");
        //url="http://madresetavangari.ir/getproduct/";


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
                                Takhfif T = new Takhfif();
                                T.setId(obj.getString("_id"));
                                T.setNoe(obj.getString("noe"));
                                T.setNew_c(obj.getString("secondprice"));
                                T.setLast_c(obj.getString("mainprice"));
                                T.setT_describe(obj.getString("comment"));
                                T.setT_city(obj.getString("city"));
                                T.setT_percent(obj.getString("darsad"));

                                JSONArray pic = obj.getJSONArray("pic");
                                T.setT_image("http://" +pic.getString(0));



                                TList.add(T);

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
                Intent intent=new Intent(getBaseContext(), Takhfif_Show.class);
                Takhfif Ta= (Takhfif) adapterView.getAdapter().getItem(i);
                //intent.putExtra("title",advertising.getTitle());
                intent.putExtra("id",Ta.getId());
                intent.putExtra("noe",Ta.getNoe());

                startActivity(intent);
            }
        });


//
//                    ///////fill these strings with network information
//                    last_c.add("vvv");
//                    new_c.add("PPPPPPP");
//                    t_city.add("aaaaaaa");
//                    t_describe.add("ssssss");
//                    t_percent.add("oooo"+"% تخفیف ");
//                    t_imagess.add(R.drawable.add);
//                    ///rate of takhfif... an integer between 0 to 5
//                    t_rate.add(2);
//                    ////////////////////////////////////////////



//                    recyclerView.setHasFixedSize(true);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(this));

                   // TList.add(new Takhfif(last_c.get(i), new_c.get(i), t_percent.get(i), t_describe.get(i), t_city.get(i),t_imagess.get(i)));

                   // adapter = new TAdapter(this, TList, t_rate);
                    listView.setAdapter(adapter);


        map();
        cities();
        Toast.makeText(this, getLocalClassName().toString() + "\nMohadese Salem", Toast.LENGTH_LONG).show();

//    }
}

    public void cities()
    {
        city_selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                popup = new PopupMenu(Off.this, city_selection);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.cities, popup.getMenu());


                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                Off.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();

                        city_selection.setText(item.getTitle());
                        popup.dismiss();
                        return true;
                    }
                });
                popup.show();
            }


        });

    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    public void Bottom_click()
    {
        Bottom_Sheet bottom_sheet=new Bottom_Sheet(getBaseContext());
        bottom_sheet.show(getSupportFragmentManager(),"");
        ImageView imageView=new ImageView(getBaseContext());
        imageView.setImageResource(R.drawable.logo);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_TOP,R.layout.near_me_bottom_sheet);
        imageView.setLayoutParams(params);
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
             //Bottom_click();
                Intent i = new Intent(getBaseContext(), android.niky.mahem_final.Search_Filter.Search.class);
                i.putExtra("title",getResources().getString(R.string.title_search));
                startActivity(i);
            }
        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //Bottom_click();
                Intent i = new Intent(getBaseContext(), Menu1.class);
                startActivity(i);
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bottom_click();
            }
        });

        MenuLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bottom_click();
                Intent i = new Intent(getBaseContext(), Group.class);
                startActivity(i);
            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bottom_click();
                Intent i = new Intent(getBaseContext(), Off.class);
                startActivity(i);
            }
        });
    }

}
