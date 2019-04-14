package android.niky.mahem_final.other;

import android.niky.mahem_final.R;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
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

import java.util.ArrayList;
import java.util.List;

public class Page1 extends AppCompatActivity {

    private TextView city_selection;

    private TextView Estekhdami, Agahi;

    ListView image_listView;
    List<ImageItem> ImageList1;
    List<ImageItem> ImageList2;

    private LayoutInflater inflater;

    private ViewPager viewPager;

    private ViewPagerAdapter viewPagerAdapter;

    private LinearLayout sliderDotspanel;
    private int dotscount=5;
    private ImageView[] dots;
    private ImageAdapter adapter;
    PopupMenu popup;
    private View navigationBar;
    private ImageView Home, Add, Menu, MenuLine, Search;

    private ArrayList<String> image= new ArrayList<String>() {
    };

    private int counter=10;
    Intent ii;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        ii=getIntent();

        city_selection = (TextView) findViewById(R.id.title);
//        Image = (ImageView) findViewById(R.id.image);
//
//        Image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getBaseContext(), Splash_Sc.class);
//                startActivity(i);
//
//            }
//        });
        viewPager=findViewById(R.id.image);
        viewPagerAdapter=new ViewPagerAdapter(this,new String[]
        {ii.getStringExtra("img1"),
                ii.getStringExtra("img2"),
                ii.getStringExtra("img3"),
                ii.getStringExtra("img4"),
                ii.getStringExtra("img5")});
        viewPager.setAdapter(viewPagerAdapter);






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


        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ImageList1=new ArrayList<>();
        for(int i=0;i<counter;++i) {

            ///////fill these strings with network information
            
            //image.add(R.drawable.two);

            ////////////////////////////////////////////

            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);



            image_listView =  findViewById(R.id.List1);
//            image_listView.setHasFixedSize(true);
//            image_recyclerView .setLayoutManager(layoutManager);
            ///this line add search views to the list:
//            ImageList1.add(new ImageItem( image.get(i)));
            adapter = new ImageAdapter(this,ImageList1);
            image_listView.setAdapter(adapter);
        }
        ImageList2=new ArrayList<>();
        for(int i=0;i<counter;++i) {

            ///////fill these strings with network information

//            image.add(R.drawable.two);

            ////////////////////////////////////////////

            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);



            image_listView =  findViewById(R.id.List2);
//            image_recyclerView .setHasFixedSize(true);
//            image_recyclerView .setLayoutManager(layoutManager);
            ///this line add search views to the list:
//            ImageList2.add(new ImageItem( image.get(i)));
            adapter = new ImageAdapter(this,ImageList2);
            image_listView .setAdapter(adapter);
        }
        Estekhdami=(TextView)findViewById(R.id.es_tv);
        Estekhdami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Page1.this,android.niky.mahem_final.Search_Filter.Search.class);
                i.putExtra("title",getResources().getString(R.string.Estekhdami_title));
                startActivity(i);
            }
        });
        Agahi=findViewById(R.id.ag_tv);
        Agahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getBaseContext(), Ads.class);
                startActivity(intent);
            }
        });
        map();
        cities();
        Toast.makeText(this, getLocalClassName().toString() + "\nNiky", Toast.LENGTH_LONG).show();
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

                Intent i = new Intent(getBaseContext(), Menu1.class);
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
                Intent i = new Intent(getBaseContext(), Group.class);
                startActivity(i);

            }
        });

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Off.class);
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
}
