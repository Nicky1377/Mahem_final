package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.niky.mahem_final.other.Page1;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;
import android.niky.mahem_final.OffFinder.Off;

import java.util.ArrayList;
import java.util.List;

public class Estekhdami_menu extends AppCompatActivity {
    View navigationBar;
    ImageView Home,Add,Menu,MenuLine,Search;
    ImageView Filter;

    ListView listView;
    List<Advertising> AdvList;
    AdvAdapter adapter;
    String ThumbnailUrl;



    //fill this variables with information
    private String title, describtion, time;
    //private int image;
    ///////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        AdvList=new ArrayList<>();
        listView=(ListView) findViewById(R.id.RecyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ///this line add search views to the list:
        AdvList.add(new Advertising(title,describtion,time,ThumbnailUrl));
        adapter=new AdvAdapter(this,AdvList);
        listView.setAdapter(adapter);

        Filter=(ImageView)findViewById(R.id.filter);
        Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),Filter_other.class);
                startActivity(i);

            }
        });

        Toast.makeText(this, getLocalClassName().toString() + "\nMohadese Salem", Toast.LENGTH_LONG).show();
        map();
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
}
