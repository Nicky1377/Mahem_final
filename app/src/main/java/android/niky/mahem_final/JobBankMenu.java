package android.niky.mahem_final;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

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
        other=(Button)findViewById(R.id.other);
        industry=(Button)findViewById(R.id.industry);
        food=(Button)findViewById(R.id.food);
        design=(Button)findViewById(R.id.design);

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();
        map();

    }
    public void map() {

        navigationBar=findViewById(R.id.rr);
        Home = (ImageView) navigationBar.findViewById(R.id.home);
        Add = (ImageView) navigationBar.findViewById(R.id.add);
        Menu = (ImageView) navigationBar.findViewById(R.id.menu_f);
        MenuLine = (ImageView) navigationBar.findViewById(R.id.menuLine_f);
        Search =(ImageView)navigationBar.findViewById(R.id.search_f);

//        Search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getBaseContext(), Splash_Sc.class);
//                startActivity(i);
//
//            }
//        });

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Menu1.class);
                startActivity(i);

            }
        });

//        Add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getBaseContext(), SabtAgahi_other.class);
//                startActivity(i);
//
//            }
//        });
//
        MenuLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), Group.class);
                startActivity(i);

            }
        });


    }
}
