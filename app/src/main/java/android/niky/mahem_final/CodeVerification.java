package android.niky.mahem_final;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.ImageView;

public class CodeVerification extends AppCompatActivity {
//    EditText etCode;
//    Button btnVerify;
//    View navigationBar;
//    ImageView Home,Add,Menu,MenuLine,Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_verification);

//        init();
//
//        btnVerify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (etCode.getText().toString().equals("")) {
//                    etCode.setError("کد را وارد کنید");
//                    return;
//                }
//                save(etCode.getText().toString());
//            Intent i=new Intent(CodeVerification.this,Ads.class);
//            startActivity(i);
//            CodeVerification.this.finish();
//            }
//        });
//        map();
//

    }

//
//    public void map() {
//
//        navigationBar=findViewById(R.id.rr);
//        Home = (ImageView) navigationBar.findViewById(R.id.home);
//        Add = (ImageView) navigationBar.findViewById(R.id.add);
//        Menu = (ImageView) navigationBar.findViewById(R.id.menu_f);
//        MenuLine = (ImageView) navigationBar.findViewById(R.id.menuLine_f);
//        Search =(ImageView)navigationBar.findViewById(R.id.search_f);
//
////        Search.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent i = new Intent(getBaseContext(), Splash_Sc.class);
////                startActivity(i);
////
////            }
////        });
//
//        Menu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getBaseContext(), Menu1.class);
//                startActivity(i);
//
//            }
//        });
//
////        Add.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent i = new Intent(getBaseContext(), SabtAgahi_other.class);
////                startActivity(i);
////
////            }
////        });
////
//        MenuLine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getBaseContext(), Group.class);
//                startActivity(i);
//
//            }
//        });
//
//
//    }
//
//    private void init() {
//
//        etCode = (EditText) findViewById(R.id.et_code);
//        btnVerify = (Button) findViewById(R.id.btn_verify);
//    }
//
//    private void save(String code) {
//        //
//    }
}
