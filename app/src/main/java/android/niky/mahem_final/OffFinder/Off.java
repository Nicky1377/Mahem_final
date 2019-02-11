package android.niky.mahem_final.OffFinder;

import android.niky.mahem_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;

import java.util.ArrayList;
import java.util.List;

public class Off extends AppCompatActivity {

    private View navigationBar;
    private TextView city_selection;
    PopupMenu popup;
    private ImageView Home, Add, Menu, MenuLine, Search;

    private RecyclerView recyclerView;

    List<Takhfif> TList;
    TAdapter adapter;

    private TextView distance;

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
        setContentView(R.layout.activity_off);
        city_selection=(TextView)findViewById(R.id.title);


        Toast.makeText(Off.this,"initialize counter variable that show how many (takhfif agahi) will be shown in layout",Toast.LENGTH_LONG).show();

        Toast.makeText(Off.this,"fill specific strings with network information in on create method",Toast.LENGTH_LONG).show();

        TList = new ArrayList<>();
                for(int i=0;i<counter;++i) {

                    ///////fill these strings with network information
                    last_c.add("vvv");
                    new_c.add("PPPPPPP");
                    t_city.add("aaaaaaa");
                    t_describe.add("ssssss");
                    t_percent.add("oooo"+"% تخفیف ");
                    t_imagess.add(R.drawable.add);
                    ///rate of takhfif... an integer between 0 to 5
                    t_rate.add(2);
                    ////////////////////////////////////////////



                    recyclerView = (RecyclerView) findViewById(R.id.n_recycler_view);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));

                    TList.add(new Takhfif(last_c.get(i), new_c.get(i), t_percent.get(i), t_describe.get(i), t_city.get(i),t_imagess.get(i)));

                    adapter = new TAdapter(this, TList, t_rate);
                    recyclerView.setAdapter(adapter);


        map();
        cities();
        Toast.makeText(this, getLocalClassName().toString() + "\nMohadese Salem", Toast.LENGTH_LONG).show();

    }}

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
                i.putExtra("title","جستجو");
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
