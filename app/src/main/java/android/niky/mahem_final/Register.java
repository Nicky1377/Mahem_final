package android.niky.mahem_final;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class Register extends AppCompatActivity {
//    View navigationBar;
//    ImageView Home,Add,Menu,MenuLine,Search;
//
//    EditText etUserName, etPhone;
//    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (etPhone.getText().toString().equals("")) {
//                    etPhone.setError("لطفا شماره تلفن خود را وارد کنید");
//                    return;
//                } else if (etPhone.getText().toString().length() != 11) {
//                    etPhone.setError("لطفا شماره تلفن معتبر وارد کنید");
//                    return;
//                }
//                if (etUserName.getText().toString().equals("")) {
//                    etUserName.setError("لطفا ام کاربری خود را وارد کنید");
//                    return;
//                } else if (etUserName.getText().toString().length() > 12 || etUserName.getText().toString().length() < 3) {
//                    etUserName.setError("لطفا نام کاربری معتبر وارد کنید");
//                    return;
//                }
//                reg(etUserName.getText().toString(), etPhone.getText().toString());
//
//                Intent i = new Intent(Register.this, CodeVerification.class);
//                startActivity(i);
//
//            }
//        });
//        map();
    }


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
//        etUserName = (EditText) findViewById(R.id.et_name);
//        etPhone = (EditText) findViewById(R.id.et_phone);
//        btnRegister = (Button) findViewById(R.id.btn_register);
//    }
//
//    void reg(String username, String phone) {
//
//    }
}

