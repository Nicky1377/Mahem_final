package android.niky.mahem_final.JobBank;

import android.niky.mahem_final.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.MenuItems.Menu1;

public class JobBankMenu extends AppCompatActivity {
    Button medical,meeting,car,arayesh,uni,art,sport,teach,majles,computer,jewels,
            dress,office,damdari,khadamat,copy,other,industry,food,design;

    View navigationBar;
    ImageView Home, Add, Menu, MenuLine, Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_bank_menu);

        medical=(Button)findViewById(R.id.medicine);
        meeting=(Button)findViewById(R.id.meeting);
        car=(Button)findViewById(R.id.car);
        arayesh=(Button)findViewById(R.id.arayesh);
        uni=(Button)findViewById(R.id.uni);
        art=(Button)findViewById(R.id.music);
        sport=(Button)findViewById(R.id.sport);
        teach=(Button)findViewById(R.id.teach);
        majles=(Button)findViewById(R.id.majles);
        computer=(Button)findViewById(R.id.computer);
        jewels=(Button)findViewById(R.id.jewels);
        dress=(Button)findViewById(R.id.dress);
        office=(Button)findViewById(R.id.office);
        damdari=(Button)findViewById(R.id.damdari);
        khadamat=(Button)findViewById(R.id.khadamat);
        copy=(Button)findViewById(R.id.copy);
        other=(Button)findViewById(R.id.other);
        industry=(Button)findViewById(R.id.industry);
        food=(Button)findViewById(R.id.food);
        design=(Button)findViewById(R.id.design);

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();
        map();
        clicks();

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
    }

    void clicks()
    {
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","1");
                startActivity(i);
            }
        });

        meeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","2");
                startActivity(i);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","3");
                startActivity(i);
            }
        });

        arayesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","4");
                startActivity(i);
            }
        });

        uni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","5");
                startActivity(i);
            }
        });

        art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","6");
                startActivity(i);
            }
        });

        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","7");
                startActivity(i);
            }
        });

        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","8");
                startActivity(i);
            }
        });

        majles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","9");
                startActivity(i);
            }
        });

        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","10");
                startActivity(i);
            }
        });

        jewels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","11");
                startActivity(i);
            }
        });

        dress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","12");
                startActivity(i);
            }
        });

        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","13");
                startActivity(i);
            }
        });

        damdari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","14");
                startActivity(i);
            }
        });

        khadamat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","15");
                startActivity(i);
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","16");
                startActivity(i);
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","17");
                startActivity(i);
            }
        });

        industry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","18");
                startActivity(i);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","19");
                startActivity(i);
            }
        });

        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),JobList.class);
                i.putExtra("id","20");
                startActivity(i);
            }
        });
    }
}
