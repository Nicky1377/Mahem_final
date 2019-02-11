package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;
import android.niky.mahem_final.OffFinder.Off;

import java.util.ArrayList;
import java.util.List;

public class Collections extends AppCompatActivity {
    private ImageView Home,Add,Menu,MenuLine,Search;
    RecyclerView recyclerView;
    List<Advertising> AdvList;
    AdvAdapter adapter;
    private int counter=3;


    private ArrayList<String> title=new ArrayList<String>() {

    };
    private ArrayList<String> description=new ArrayList<String>() {

    };
    private ArrayList<String> time=new ArrayList<String>() {

    };
    private ArrayList<Integer> image=new ArrayList<Integer>() {

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);


        AdvList=new ArrayList<>();
        for(int i=0;i<counter;++i) {

            ///////fill these strings with network information
            title.add("vvv");
            description.add("PPPPPPP");
            time.add("aaaaaaa");
            image.add(R.drawable.two);

            ////////////////////////////////////////////
            recyclerView =  findViewById(R.id.cRecyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            ///this line add search views to the list:
            AdvList.add(new Advertising(title.get(i), description.get(i), time.get(i), image.get(i)));
            adapter = new AdvAdapter(this, AdvList);
            recyclerView.setAdapter(adapter);
        }
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
}
