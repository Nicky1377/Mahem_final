package android.niky.mahem_final.Add;

import android.niky.mahem_final.R;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

public class SabtAgahi_Estekhdam extends AppCompatActivity {

    EditText Group,Title,EducationLevel,Gharardad,Tozihat,call,location
            ,PhoneNum,Email;
    View CallLayout,EducationLayout,GharardadLayout;
    TextView Ed_1,Ed_2,Ed_3,Ed_4,Ed_5,Ed_6,Gh_1,Gh_2,Gh_3,Gh_4;
    CheckBox rules,chat,email_check;
    ImageView cam1,cam2,cam3,cam4,cam5;
    Button send,ok_call;
    Bitmap yourSelectedImage;
    PopupWindow Ed_Layout,Call_Layout,Gh_Layout;
    ArrayList<ImageView> Cameras;
    ImageView map_img;
    private String searchingLocation;

    int pic=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi__estekhdam);


        Group=(EditText)findViewById(R.id.T1);
        Title=(EditText)findViewById(R.id.T2);
        EducationLevel=(EditText)findViewById(R.id.T3);
        Gharardad=(EditText)findViewById(R.id.T4);
        Tozihat=(EditText)findViewById(R.id.T5);
        call=(EditText)findViewById(R.id.T6);
        location=(EditText)findViewById(R.id.T7);

        map_img=(ImageView)findViewById(R.id.map_img);

        send=(Button)findViewById(R.id.send);
        cam1=findViewById(R.id.c1);
        cam2=findViewById(R.id.c2);
        cam3=findViewById(R.id.c3);
        cam4=findViewById(R.id.c4);
        cam5=findViewById(R.id.c5);
        rules=(CheckBox)findViewById(R.id.rule);


        Cameras=new ArrayList<ImageView>(5);
        Cameras.add(cam1);
        Cameras.add(cam2);
        Cameras.add(cam3);
        Cameras.add(cam4);
        Cameras.add(cam5);

        for(final ImageView item:Cameras)
        {item.setImageResource(R.drawable.icons88);
            item.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onClick(View view) {
                    pic=Cameras.indexOf(item);
                    pick();




                }
            });
        }



        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                CallLayout=inflater.inflate(R.layout.call_layout,null);
                Call_Layout= new PopupWindow(CallLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Call_Layout.showAsDropDown(view);

                Call_map();

            }
        });

        EducationLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                EducationLayout=inflater.inflate(R.layout.education_level_layout,null);
                Ed_Layout= new PopupWindow(EducationLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Ed_Layout.showAsDropDown(view);
                Education_map();
            }
        });

        Gharardad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                GharardadLayout=inflater.inflate(R.layout.gharardad_layout,null);
                Gh_Layout= new PopupWindow(GharardadLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Gh_Layout.showAsDropDown(view);

                Gharardad_map();

            }
        });

        map_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent=new Intent(Intent.ACTION_VIEW);
                searchingLocation="";
                mapIntent.setData(Uri.parse("geo:0,0?q="+searchingLocation));
                startActivity(mapIntent);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tt("ارسال شد.");
            }
        });

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }

    public  void Call_map()
    {
        PhoneNum=(EditText)CallLayout.findViewById(R.id.call1);
        Email=(EditText)CallLayout.findViewById(R.id.Call2);

        ok_call=(Button)CallLayout.findViewById(R.id.ok);
        ok_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(PhoneNum.getText().toString().equals(""))
                {
                    PhoneNum.setError("لطفا شماره تماس را وارد کنید.");
                }
                else{
                    call.setText(PhoneNum.getText().toString());
                    Call_Layout.dismiss();
                }
            }
        });

        chat=(CheckBox)CallLayout.findViewById(R.id.chat);
        email_check=(CheckBox)CallLayout.findViewById(R.id.Email_check);



    }

    public void Education_map()
    {
        Ed_1=(TextView)EducationLayout.findViewById(R.id.Tt1);
        Ed_2=(TextView)EducationLayout.findViewById(R.id.Tt2);
        Ed_3=(TextView)EducationLayout.findViewById(R.id.Tt3);
        Ed_4=(TextView)EducationLayout.findViewById(R.id.Tt4);
        Ed_5=(TextView)EducationLayout.findViewById(R.id.Tt5);
        Ed_6=(TextView)EducationLayout.findViewById(R.id.Tt6);

        Ed_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_1.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_2.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_3.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_4.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_5.getText().toString());
                Ed_Layout .dismiss();
            }
        });

        Ed_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EducationLevel.setText(Ed_6.getText().toString());
                Ed_Layout .dismiss();
            }
        });

    }

    public void Gharardad_map()
    {
        Gh_1=(TextView)GharardadLayout.findViewById(R.id.Tt1);
        Gh_2=(TextView)GharardadLayout.findViewById(R.id.Tt2);
        Gh_3=(TextView)GharardadLayout.findViewById(R.id.Tt3);
        Gh_4=(TextView)GharardadLayout.findViewById(R.id.Tt4);


        Gh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gharardad.setText(Gh_1.getText().toString());
                Gh_Layout .dismiss();
            }
        });

        Gh_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gharardad.setText(Gh_2.getText().toString());
                Gh_Layout .dismiss();
            }
        });

        Gh_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gharardad.setText(Gh_3.getText().toString());
                Gh_Layout .dismiss();
            }
        });

        Gh_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gharardad.setText(Gh_4.getText().toString());
                Gh_Layout .dismiss();
            }
        });

    }
    //pick picture...
    public void pick()
    {

        final int ID_THIS_ACTIVITY=30;
        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        i.setType("image/*");
        final int ACTIVITY_SELECT_IMAGE = 1234;
        try {
            if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(permission, ID_THIS_ACTIVITY);
                } else {

                    startActivityForResult(i, ACTIVITY_SELECT_IMAGE);
                }
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 1234:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);

                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;

                    cursor.close();
                    yourSelectedImage = BitmapFactory.decodeFile(filePath, options);
                    Cameras.get(pic).setImageBitmap(yourSelectedImage);



                }
        }
    }
}
