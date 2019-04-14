package android.niky.mahem_final.OffFinder;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;

import java.util.ArrayList;
import java.util.List;

public class Near_me extends AppCompatActivity {

    View navigationBar;
    ImageView Home, Add, Menu, MenuLine, Search;


    RecyclerView recyclerView;
    TextView city_selection;
    List<Takhfif> TList;
    TAdapter adapter;
    SeekBar seek_bar;
    TextView distance;

    private ArrayList<String> last_c=new ArrayList<String>() {

    };
    private ArrayList<String> new_c=new ArrayList<String>() {

    };
    private ArrayList<String> t_city=new ArrayList<String>() {

    };
    private ArrayList<String> t_describe=new ArrayList<String>() {

    };
    private ArrayList<String> t_percent=new ArrayList<String>() {

    };


    private ArrayList<Integer> t_rate= new ArrayList<Integer>() {
    };
    private ArrayList<Integer> t_imagess= new ArrayList<Integer>() {
    };


    ///////intialize counter variable that show how many (takhfif agahi) will be shown in layout
    int counter=3;
    ///
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_near_me);
        Toast.makeText(Near_me.this, "initialize counter variable that show how many (takhfif agahi) will be shown in layout", Toast.LENGTH_LONG).show();

        Toast.makeText(Near_me.this, "fill specific strings with network information in on create method", Toast.LENGTH_LONG).show();

        TList = new ArrayList<>();
        for (int i = 0; i < counter; ++i) {

            ///////fill these strings with network information
            last_c.add("vvv");
            new_c.add("PPPPPPP");
            t_city.add("aaaaaaa");
            t_describe.add("ssssss");
            t_percent.add("oooo" + "% تخفیف ");
            t_imagess.add(R.drawable.add);
            ///rate of takhfif... an integer between 0 to 5
            t_rate.add(2);
            ////////////////////////////////////////////


            recyclerView = (RecyclerView)findViewById(R.id.n_recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

           // TList.add(new Takhfif(last_c.get(i), new_c.get(i), t_percent.get(i), t_describe.get(i), t_city.get(i), t_imagess.get(i)));

           // adapter = new TAdapter(this, TList, t_rate);
            //recyclerView.setAdapter(adapter);


        }


        seekbarr();
        city_selection = (TextView) findViewById(R.id.select_city);
        city_selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Near_me.this, city_selection);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.cities, popup.getMenu());


                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                Near_me.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                popup.show();
            }


        });

        Toast.makeText(this, getLocalClassName().toString() + "\nMohadese Salem", Toast.LENGTH_LONG).show();
        map();
    }

    public void seekbarr( ){
        seek_bar = (SeekBar)findViewById(R.id.seekBar);
        distance =(TextView)findViewById(R.id.dis);
        distance.setText("0کیلومتر ");

        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        distance.setText(progress_value+"کیلومتر ");

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        distance.setText(progress_value+"کیلومتر " );

                    }
                }
        );
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
                Intent i = new Intent(getBaseContext(),android.niky.mahem_final.Search_Filter.Search.class);
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
        });

    }
}
