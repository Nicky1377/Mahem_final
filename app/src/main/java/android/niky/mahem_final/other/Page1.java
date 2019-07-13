package android.niky.mahem_final.other;

import android.app.ProgressDialog;
import android.niky.mahem_final.MenuItems.Ads_show;
import android.niky.mahem_final.R;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.niky.mahem_final.Search_Filter.AdvAdapter;
import android.niky.mahem_final.Search_Filter.Advertising;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;
import android.niky.mahem_final.MenuItems.ViewPagerAdapter;
import android.niky.mahem_final.OffFinder.Off;
import android.niky.mahem_final.Search_Filter.Ads;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Page1 extends AppCompatActivity {

    private TextView city_selection;

    private TextView Estekhdami, Agahi;

    RecyclerView image_listView1,image_listView2;
    List<ImageItem> ImageList1;
    List<ImageItem> ImageList2;

    private LayoutInflater inflater;

    private ViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;

    private LinearLayout sliderDotspanel;
    private int dotscount=5;
    private ImageView[] dots;
    private ImageAdapter adapter1,adapter2;
    PopupMenu popup;
    private View navigationBar;
    private ImageView Home, Add, Menu, MenuLine, Search;

    private ArrayList<String> image= new ArrayList<String>() {
    };

    private int counter=10;
    String[] images;
    String url1,url2,url3;
    Intent ii,adapterIntent;
    private ProgressDialog pDialog;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        ii = getIntent();
        adapterIntent=new Intent(getBaseContext(),Ads_show.class);

        city_selection = (TextView) findViewById(R.id.title);
//
        ///////////////////////////ViewPager
        images = new String[5];
        viewPager = findViewById(R.id.image);
        url1 = "http://appmahem.eu-4.evennode.com/mainpage/3";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        Log.d("result", s);

                        try {
                            JSONArray result = new JSONArray(s);
                            hidePDialog();
                            for (int j = 0; j < 5; j++) {
                                JSONObject obj = result.getJSONObject(j);
                                images[j] = "http://" + obj.getString("pic");
                            }

                            viewPagerAdapter = new ViewPagerAdapter(Page1.this, images);
                            viewPager.setAdapter(viewPagerAdapter);
                        } catch (Exception e) {

                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                Toast.makeText(Page1.this, "page selected", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//////////////////////////////////////////////////////////////////list1

            Thread t1=new Thread(){
                @Override
                public void run() {
                    try{
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false);
                        ImageList1 = new ArrayList<>();
                        image_listView1 = (RecyclerView) findViewById(R.id.List1);
                        image_listView1.setHasFixedSize(true);
                        image_listView1.setLayoutManager(layoutManager);
                        adapter1 = new ImageAdapter(getBaseContext(), ImageList1,adapterIntent);
                        image_listView1.setAdapter(adapter1);
                        url2 = "http://appmahem.eu-4.evennode.com/mainpage/1";

                        pDialog = new ProgressDialog(getBaseContext());
                        // Showing progress dialog before making http request
                        pDialog.setMessage("لطفا صبر کنید ..");
                        pDialog.show();

                        // Creating volley request obj
                        JsonArrayRequest productReq = new JsonArrayRequest(url2,
                                new Response.Listener<JSONArray>() {
                                    @Override
                                    public void onResponse(JSONArray response) {
                                         Log.d("response1", response.toString());
                                        hidePDialog();
                                        for (int i = 0; i < response.length(); i++) {
                                            try {
                                                JSONObject obj = response.getJSONObject(i);
                                                ImageItem img = new ImageItem();
                                                img.setId(obj.getString("id"));
                                                img.setImage("http://"+obj.getString("pic"));
                                                img.setNoe(obj.getString("noe"));
                                                tt(img.getImage());

                                                ImageList1.add(img);

                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        adapter1.notifyDataSetChanged();
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // VolleyLog.d(TAG, "Error: " + error.getMessage());
                                hidePDialog();
                            }
                        });

                       //  Adding request to request queue
                            AppController.getInstance().addToRequestQueue(productReq);

                    }catch (Exception e)
                    {

                    }
                }
            };
            t1.start();


////////////////////////////////////////////////////////////////////////////////////////////////
       Thread t2=new Thread(){
           @Override
           public void run() {

               try
               {
                   LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false);
                   ImageList2 = new ArrayList<>();
//                   ImageList2.add(new ImageItem("http://appmahem.eu-4.evennode.com/getpictures/1557484699298-6.jpg"));
//                   ImageList2.add(new ImageItem("http://appmahem.eu-4.evennode.com/getpictures/1557484699298-6.jpg"));
//                   ImageList2.add(new ImageItem("http://appmahem.eu-4.evennode.com/getpictures/1557484699298-6.jpg"));
//                   ImageList2.add(new ImageItem("http://appmahem.eu-4.evennode.com/getpictures/1557484699298-6.jpg"));
                   image_listView2 = (RecyclerView) findViewById(R.id.List2);
                   image_listView2.setHasFixedSize(true);
                   image_listView2.setLayoutManager(layoutManager);
                   adapter2 = new ImageAdapter(getBaseContext(), ImageList2,adapterIntent);
                   image_listView2.setAdapter(adapter2);
                   url3 = "http://appmahem.eu-4.evennode.com/mainpage/2";


                   pDialog = new ProgressDialog(getBaseContext());
                   // Showing progress dialog before making http request
                   pDialog.setMessage("لطفا صبر کنید ..");
                   pDialog.show();

                   // Creating volley request obj
                   JsonArrayRequest productReq1 = new JsonArrayRequest(url3,
                           new Response.Listener<JSONArray>() {
                               @Override
                               public void onResponse(JSONArray response) {
                                   // Log.d(TAG, response.toString());
                                   hidePDialog();
                                   for (int i = 0; i < response.length(); i++) {
                                       try {
                                           JSONObject obj = response.getJSONObject(i);
                                           ImageItem img = new ImageItem();
                                           img.setId(obj.getString("id"));
                                           img.setImage("http://"+obj.getString("pic"));
                                           img.setNoe(obj.getString("noe"));


                                           ImageList2.add(img);

                                       } catch (JSONException e) {
                                           e.printStackTrace();
                                       }
                                   }
                                   adapter2.notifyDataSetChanged();
                               }
                           }, new Response.ErrorListener() {
                       @Override
                       public void onErrorResponse(VolleyError error) {
                           // VolleyLog.d(TAG, "Error: " + error.getMessage());
                           hidePDialog();
                       }
                   });

                   // Adding request to request queue
                     AppController.getInstance().addToRequestQueue(productReq1);

               }
               catch (Exception e)
               {

               }
           }
       };
       t2.start();



        /////////////////////////////////////////////////////////////////////////
            Estekhdami = (TextView) findViewById(R.id.es_tv);
            Estekhdami.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Page1.this, android.niky.mahem_final.Search_Filter.Search.class);
                    i.putExtra("title", getResources().getString(R.string.Estekhdami_title));
                    startActivity(i);
                }
            });
            Agahi = findViewById(R.id.ag_tv);
            Agahi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), Group.class);
                    startActivity(intent);
                }
            });
            map();
            cities();
          //  Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
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


    public void cities()
    {
                city_selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                 popup = new PopupMenu(Page1.this, city_selection);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.cities, popup.getMenu());


                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                Page1.this,
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

    void tt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    }


