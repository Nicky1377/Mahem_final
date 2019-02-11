package android.niky.mahem_final.Add;

import android.niky.mahem_final.R;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;

public class SabtAgahi_Car extends AppCompatActivity {
    EditText Group,Title,brand,shasy_typpe,naghd,year,K_meter,Gheimat,AgahiDahande_type,Type,call,Tozihat,location
            ,PhoneNum,Email;
    View CallLayout,TypeLayout,AgahiDahandeLayout,GheimatLayout,NaghdLayout,ShasyTypeLayout;
    TextView Type_1,Type_2,Type_3,agahiD_1,agahiD_2,Gh_1,Gh_2,Gh_3,Gh_4,Sh_1,Sh_2,Sh_3,Sh_4,Sh_5,Sh_6,Sh_7
            ,naghd_1,naghd_2;
    CheckBox rules,chat,email_check;
    ImageView cam1,cam2,cam3,cam4,cam5;
    Button send,ok_call;
    PopupWindow Type_Layout,Call_Layout,Gheimat_Layout,agahiD_Layout,Shasy_type_Layout,Naghd_Layout;
    ArrayList<ImageView> Cameras;
    ImageView map_img;
    private Bitmap yourSelectedImage;
    private String searchingLocation;


    int pic=0;
    private int IdPic=0;

    Drawable d;
    PopupMenu popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi__car);



        Group=(EditText)findViewById(R.id.T1);
        Title=(EditText)findViewById(R.id.T2);
        brand=(EditText)findViewById(R.id.T3);
        shasy_typpe=(EditText)findViewById(R.id.T4);
        naghd=(EditText)findViewById(R.id.T5);
        year=(EditText)findViewById(R.id.T6);
        K_meter=(EditText)findViewById(R.id.T7);
        Gheimat=(EditText)findViewById(R.id.T8);
        AgahiDahande_type=(EditText)findViewById(R.id.T9);
        Type=(EditText)findViewById(R.id.T10);
        call=(EditText)findViewById(R.id.T11);
        Tozihat=(EditText)findViewById(R.id.T12);
        location=(EditText)findViewById(R.id.T13);

        map_img=(ImageView)findViewById(R.id.map_img);


        send=findViewById(R.id.send);
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


        Type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                TypeLayout=inflater.inflate(R.layout.type_agahi_layout,null);
                Type_Layout= new PopupWindow(TypeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Type_Layout.showAsDropDown(view);
                Type_map();

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                CallLayout=inflater.inflate(R.layout.call_layout,null);

                Call_Layout= new PopupWindow(CallLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,true);
                Call_Layout.showAsDropDown(view);
                Call_map();

            }
        });

        AgahiDahande_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                AgahiDahandeLayout=inflater.inflate(R.layout.agahi_dahande_layout,null);
                agahiD_Layout= new PopupWindow(AgahiDahandeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                agahiD_Layout.showAsDropDown(view);
                Agahi_D_map();

            }
        });

        shasy_typpe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ShasyTypeLayout=inflater.inflate(R.layout.shasy_layout,null);
                Shasy_type_Layout= new PopupWindow(ShasyTypeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Shasy_type_Layout.showAsDropDown(view);

                Shasy_map();

            }
        });

        Gheimat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                GheimatLayout=inflater.inflate(R.layout.gheimat_layout,null);
                Gheimat_Layout= new PopupWindow(GheimatLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Gheimat_Layout.showAsDropDown(view);
                Gheimat_map();

            }
        });
        naghd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                NaghdLayout=inflater.inflate(R.layout.naghd_layout,null);
                Naghd_Layout= new PopupWindow(NaghdLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Naghd_Layout.showAsDropDown(view);

                Naghd_map();

            }
        });

        Brand_map();


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




    public void Type_map()
    {
        Type_1=(TextView)TypeLayout.findViewById(R.id.Tt1);
        Type_2=(TextView)TypeLayout.findViewById(R.id.Tt2);
        Type_3=(TextView)TypeLayout.findViewById(R.id.Tt3);



        Type_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Type.setText(Type_1.getText().toString());
                Type_Layout.dismiss();
            }
        });

        Type_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Type.setText(Type_2.getText().toString());
                Type_Layout.dismiss();
            }
        });

        Type_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Type.setText(Type_3.getText().toString());
                Type_Layout.dismiss();
            }
        });

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

    public  void Agahi_D_map()
    {

        agahiD_1=(TextView)AgahiDahandeLayout.findViewById(R.id.Tt1);
        agahiD_2=(TextView)AgahiDahandeLayout.findViewById(R.id.Tt2);


        agahiD_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgahiDahande_type.setText(agahiD_1.getText().toString());
                agahiD_Layout.dismiss();
            }
        });

        agahiD_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgahiDahande_type.setText(agahiD_2.getText().toString());
                agahiD_Layout.dismiss();
            }
        });

    }

    public  void Shasy_map()
    {
        Sh_1=(TextView)ShasyTypeLayout.findViewById(R.id.Tt1);
        Sh_2=(TextView)ShasyTypeLayout.findViewById(R.id.Tt2);
        Sh_3=(TextView)ShasyTypeLayout.findViewById(R.id.Tt3);
        Sh_4=(TextView)ShasyTypeLayout.findViewById(R.id.Tt4);
        Sh_5=(TextView)ShasyTypeLayout.findViewById(R.id.Tt5);
        Sh_6=(TextView)ShasyTypeLayout.findViewById(R.id.Tt6);
        Sh_7=(TextView)ShasyTypeLayout.findViewById(R.id.Tt7);



        Sh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_1.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_2.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_3.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_4.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_5.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_6.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });
        Sh_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shasy_typpe.setText(Sh_7.getText().toString());
                Shasy_type_Layout.dismiss();
            }
        });



    }

    public  void Gheimat_map()
    {
        Gh_1=(TextView)GheimatLayout.findViewById(R.id.Tt1);
        Gh_2=(TextView)GheimatLayout.findViewById(R.id.Tt2);
        Gh_3=(TextView)GheimatLayout.findViewById(R.id.Tt3);
        Gh_4=(TextView)GheimatLayout.findViewById(R.id.Tt4);


        Gh_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_1.getText().toString());
                Gheimat_Layout.dismiss();
            }
        });

        Gh_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_2.getText().toString());
                Gheimat_Layout.dismiss();
            }
        });

        Gh_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_3.getText().toString());
                Gheimat_Layout.dismiss();
            }
        });

        Gh_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gheimat.setText(Gh_4.getText().toString());
                Gheimat_Layout.dismiss();
            }
        });

    }

    public void Naghd_map()
    {

    naghd_1=(TextView)NaghdLayout.findViewById(R.id.Tt1);
    naghd_2=(TextView)NaghdLayout.findViewById(R.id.Tt2);

    naghd_1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            naghd.setText(naghd_1.getText().toString());
            Naghd_Layout.dismiss();
        }
    });

    naghd_2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            naghd.setText(naghd_2.getText().toString());
            Naghd_Layout.dismiss();
        }
    });


}

    public void Brand_map()
    {
        brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                popup = new PopupMenu(SabtAgahi_Car.this, brand);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.brands, popup.getMenu());


                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        brand.setText(item.getTitle());
                        popup.dismiss();
                        return true;
                    }
                });
                popup.show();
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

