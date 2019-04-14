package android.niky.mahem_final.MenuItems;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.niky.mahem_final.R;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.niky.mahem_final.other.Save_File_Lang;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class Setting extends AppCompatActivity {

    Button cam,gallery,send;
    EditText city;
    View CityLayout;
    TextView city_1,city_2,city_3,city_4,city_5,city_6,city_7,city_8,city_9
            ,city_10,city_11,city_12,city_13,city_14;
    PopupWindow City_Layout;
    RadioButton selected_lang;
    RadioGroup lang;
    int image_select;
    final int CAMERA_PIC_REQUEST=234;
    private String selected_city;
    String Lang;
    Save_File_Lang s;

    Locale myLocale;
    ImageView logo;
    RelativeLayout F;
    public static Bitmap yourSelectedImage,camera_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        cam=(Button)findViewById(R.id.cam);
        gallery=(Button)findViewById(R.id.gallery);
        send=(Button)findViewById(R.id.send);

        city=(EditText)findViewById(R.id.T);
        logo=(ImageView)findViewById(R.id.ic_logo);

        F=findViewById(R.id.fr);

        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                CityLayout=inflater.inflate(R.layout.city_layout,null);

                City_Layout =new PopupWindow(CityLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                 City_Layout.showAsDropDown(city);
                City_map();

            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int ID_THIS_ACTIVITY=40;
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
        });
        cam.setOnClickListener(new View.OnClickListener() {
            final int CAMERA_PIC_REQUEST=234;
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
            }
        });


        s=new Save_File_Lang(this,getFilesDir());
        lang=(RadioGroup)findViewById(R.id.lang);
        selected_lang=(RadioButton)findViewById(lang.getCheckedRadioButtonId());

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (image_select)
                {
                    case 1:
                        break;
                }


                if(lang.getCheckedRadioButtonId()==R.id.eng)
                {
                    Lang="en";
                }else if(lang.getCheckedRadioButtonId()==R.id.per)
                {
                    Lang="per";
                }


                if(!s.readFileAsString().contains(Lang))
                {
                    setLocale(Lang);
                    s.saveStringToFile(Lang);

                }else
                {
                    tt("زبان مورد نظر قبلا انتخاب شده بود...");
                }

                    tt("اعمال شد.");
                finish();
            }
        });

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();




    }
    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
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
                    //Cameras.get(pic).setImageBitmap(yourSelectedImage);




                }


                }
                if (requestCode == CAMERA_PIC_REQUEST) {
                    camera_image = (Bitmap) data.getExtras().get("data");


                }




        }

    public void City_map()
    {

        city_1=(TextView)CityLayout.findViewById(R.id.Tt1);
        city_2=(TextView)CityLayout.findViewById(R.id.Tt2);
        city_3=(TextView)CityLayout.findViewById(R.id.Tt3);
        city_4=(TextView)CityLayout.findViewById(R.id.Tt4);
        city_5=(TextView)CityLayout.findViewById(R.id.Tt5);
        city_6=(TextView)CityLayout.findViewById(R.id.Tt6);
        city_7=(TextView)CityLayout.findViewById(R.id.Tt7);
        city_8=(TextView)CityLayout.findViewById(R.id.Tt8);
        city_9=(TextView)CityLayout.findViewById(R.id.Tt9);
        city_10=(TextView)CityLayout.findViewById(R.id.Tt10);
        city_11=(TextView)CityLayout.findViewById(R.id.Tt11);
        city_12=(TextView)CityLayout.findViewById(R.id.Tt12);
        city_13=(TextView)CityLayout.findViewById(R.id.Tt13);
        city_14=(TextView)CityLayout.findViewById(R.id.Tt14);



        city_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_1.getText().toString());
                City_Layout .dismiss();
            }
        });


        city_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_2.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_3.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_1.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_4.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_1.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_5.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_6.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_1.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_7.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_8.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_9.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_10.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_11.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_12.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_13.getText().toString());
                City_Layout .dismiss();
            }
        });

        city_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                city.setText(city_14.getText().toString());
                City_Layout .dismiss();
            }
        });

        selected_city=city.getText().toString();

    }

    public void setLocale(String locale)
    {

        myLocale =new Locale(locale);
        Resources res=getResources();
        DisplayMetrics dm=res.getDisplayMetrics();
        Configuration conf=res.getConfiguration();
        conf.setLocale(myLocale);
        res.updateConfiguration(conf,dm);

    }
}


