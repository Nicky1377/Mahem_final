package android.niky.mahem_final.Add;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
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


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SabtAgahi_Takhfif extends AppCompatActivity {

    EditText Group,Title,off_percent,Real_price,Off_price,city,call,attributes,Tozihat,location
            ,PhoneNum,Email,off_time,day,hour,min;
    View CallLayout,CityLayout,TimeLayout;
    TextView city_1,city_2,city_3,city_4,city_5,city_6,city_7,city_8,city_9,city_10,city_11,city_12,city_13,city_14;
    CheckBox rules,chat,email_check;
    ImageView cam1,cam2,cam3,cam4,cam5;
    Button send,ok_call,time_ok;
    Bitmap yourSelectedImage;
    PopupWindow City_Layout,Call_Layout,Time_Layout;
    ArrayList<ImageView> Cameras;
    ImageView map_img;
    private String searchingLocation;
    Intent ii;

    String[] pics;
    int pic=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabt_agahi__takhfif);

        init();
        ii=getIntent();
        Group.setText(ii.getStringExtra("group"));
        pics=new String[5];


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

        map_img=(ImageView)findViewById(R.id.map_img);
        map_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent=new Intent(Intent.ACTION_VIEW);
                searchingLocation="";
                mapIntent.setData(Uri.parse("geo:0,0?q="+searchingLocation));
                startActivity(mapIntent);
            }
        });

        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                CityLayout=inflater.inflate(R.layout.city_layout,null);
                City_Layout= new PopupWindow(CityLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                City_Layout.showAsDropDown(view);

                City_map();

            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                CallLayout=inflater.inflate(R.layout.call_layout,null);
                Call_Layout= new PopupWindow(CallLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,true);
                Call_Layout.showAsDropDown(view);

                Call_map();

            }
        });

        off_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Time_Layout= new PopupWindow(TimeLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT,true);
                Time_Layout.showAsDropDown(view);

                Time_map();

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Send("http://appmahem.eu-4.evennode.com/setads/5",Tozihat.getText().toString(),Title.getText().toString(),
                        off_percent.getText().toString(),Real_price.getText().toString(),Off_price.getText().toString(),
                        attributes.getText().toString(),city.getText().toString(),PhoneNum.getText().toString(),
                        Email.getText().toString(),chat.isChecked(),email_check.isChecked());
                tt("ارسال شد.");
            }
        });

        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }


    void init()
    {
        Group=(EditText)findViewById(R.id.T1);
        Title=(EditText)findViewById(R.id.T2);
        off_percent=(EditText)findViewById(R.id.T3);
        Real_price=(EditText)findViewById(R.id.T4);
        Off_price=(EditText)findViewById(R.id.T5);
        city=(EditText)findViewById(R.id.T6);
        call=(EditText)findViewById(R.id.T7);
        attributes=(EditText)findViewById(R.id.T8);
        Tozihat=(EditText)findViewById(R.id.T9);
        location=(EditText)findViewById(R.id.T10);
        off_time=(EditText)findViewById(R.id.T11) ;

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

        //////pop up layouts

        LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CallLayout=inflater.inflate(R.layout.call_layout,null);

        LayoutInflater inflater1=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TimeLayout=inflater1.inflate(R.layout.off_time_layout,null);
        ///////////popup items

        PhoneNum=(EditText)CallLayout.findViewById(R.id.call1);
        Email=(EditText)CallLayout.findViewById(R.id.Call2);

        day=(EditText)TimeLayout.findViewById(R.id.day);
        hour=(EditText)TimeLayout.findViewById(R.id.hour);
        min=(EditText)TimeLayout.findViewById(R.id.min);

    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
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

    }

    public  void Call_map()
    {
        ok_call=(Button)CallLayout.findViewById(R.id.ok);
        ok_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    call.setText(PhoneNum.getText().toString());
                    Call_Layout.dismiss();

            }
        });

        chat=(CheckBox)CallLayout.findViewById(R.id.chat);
        email_check=(CheckBox)CallLayout.findViewById(R.id.Email_check);



    }

    public  void Time_map()
    {
        time_ok=(Button)TimeLayout.findViewById(R.id.ok_time);
        time_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                off_time.setText(day.getText().toString()+"روز");
                Time_Layout.dismiss();

            }
        });

    }


    //pick picture...
    void pick() {

        final CharSequence[] options = {"دوربین", "گالری"};

        AlertDialog.Builder builder = new AlertDialog.Builder(SabtAgahi_Takhfif.this);

        builder.setTitle("Select Photo");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("دوربین"))

                {

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (Build.VERSION.SDK_INT >= 24) {
                        try {
                            Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                            m.invoke(null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    File f = new File(Environment
                            .getExternalStorageDirectory(), "temp" + pic
                            + ".jpg");

                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));

                    startActivityForResult(intent, 1);

                } else if (options[item].equals("گالری")) {

                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    startActivityForResult(intent, 2);

                }

            }

        });

        builder.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == 1) {

                try {

                    String picturePath = Environment
                            .getExternalStorageDirectory().getAbsolutePath()
                            + File.separator + "temp" + pic + ".jpg";

                    Bitmap thumbnail = BitmapFactory.decodeFile(picturePath);

                    Cameras.get(pic).setImageBitmap(thumbnail);
                    pics[pic] = picturePath;

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (requestCode == 2) {

                Uri selectedImage = data.getData();

                String[] filePath = {MediaStore.Images.Media.DATA};

                Cursor c = getContentResolver().query(selectedImage, filePath,
                        null, null, null);

                c.moveToFirst();

                int columnIndex = c.getColumnIndex(filePath[0]);

                String picturePath = c.getString(columnIndex);

                c.close();

                Bitmap thumbnail;
                try {
                    thumbnail = BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage));

                    Cameras.get(pic).setImageBitmap(thumbnail);
                    pics[pic] = picturePath;

                } catch (Exception e) {
                    //
                }

            }
        }
    }


    public String readFileAsString() {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File( getFilesDir().getAbsolutePath() + "/.MahemProg/phn.txt")));
            while ((line = in.readLine()) != null) stringBuilder.append(line);

        } catch (FileNotFoundException e) {
            tt(e.getMessage());
        } catch (IOException e) {
            tt(e.getMessage());
        }

        String[] a=stringBuilder.toString().split("\n");
        String b=a[a.length-1];
        return b;
    }

    /////network///////
    private ProgressDialog pDialog;

    void Send(final String URL,String Tozih,String Title,String off_percent,String Real_price,
              String Off_price,String attributes,String location
            ,String PhoneNum,String Email,Boolean chat,Boolean email_check)
    {


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("لطفا صبر کنید");
        pDialog.show();
        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("daste",ii.getStringExtra("id"));
        //pics
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();

            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inDither = true;
            options.inSampleSize = 8;

            Bitmap bm1 = BitmapFactory.decodeFile(pics[0], options);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm1.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] b = baos.toByteArray();

            String encodedImage1 = Base64.encodeToString(b,
                    Base64.DEFAULT);
            // tt(encodedImage1.length()+"");

            postParam.put("pic1", encodedImage1);

            Bitmap bm2 = BitmapFactory.decodeFile(pics[1], options);
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
            bm2.compress(Bitmap.CompressFormat.JPEG, 100, baos2);
            byte[] b2 = baos2.toByteArray();

            String encodedImage2 = Base64.encodeToString(b2,
                    Base64.DEFAULT);
            postParam.put("pic2", encodedImage2);

            Bitmap bm3 = BitmapFactory.decodeFile(pics[2], options);
            ByteArrayOutputStream baos3 = new ByteArrayOutputStream();
            bm3.compress(Bitmap.CompressFormat.JPEG, 100, baos3);
            byte[] b3 = baos3.toByteArray();

            String encodedImage3 = Base64.encodeToString(b3,
                    Base64.DEFAULT);
            postParam.put("pic3", encodedImage3);

            Bitmap bm4 = BitmapFactory.decodeFile(pics[3], options);
            ByteArrayOutputStream baos4 = new ByteArrayOutputStream();
            bm3.compress(Bitmap.CompressFormat.JPEG, 100, baos3);
            byte[] b4 = baos3.toByteArray();

            String encodedImage4 = Base64.encodeToString(b3,
                    Base64.DEFAULT);
            postParam.put("pic4", encodedImage3);

            Bitmap bm5 = BitmapFactory.decodeFile(pics[4], options);
            ByteArrayOutputStream baos5 = new ByteArrayOutputStream();
            bm3.compress(Bitmap.CompressFormat.JPEG, 100, baos3);
            byte[] b5 = baos3.toByteArray();

            String encodedImage5 = Base64.encodeToString(b3,
                    Base64.DEFAULT);
            postParam.put("pic5", encodedImage3);

        } catch (Exception e) {
            Log.d("ppppppppiiiiiiiicccc", e.getMessage());
            tt("خطا در ارسال عکس");
        }


        ////////////////////////////////////////////////////////

        postParam.put( "title",Title);
        postParam.put( "darsad",off_percent);
        postParam.put("mainprice" ,Real_price);
        postParam.put( "secondprice",Off_price);
        postParam.put( "googlepath","147-258-369-321");
        postParam.put(  "tamasphone" ,PhoneNum);
        postParam.put( "tamasemail",Email);
        postParam.put( "activechat",chat.toString());
        postParam.put( "activeemail",email_check.toString());
        postParam.put( "city",location);
        postParam.put( "propertis" ,attributes);
        postParam.put("comment",Tozih);
        postParam.put( "userid",readFileAsString());


        final Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject obj = new JSONObject(postParam);
                postData(URL, obj, true);
            }
        });

        send.start();
    }


    public void postData(String url, JSONObject obj, boolean reg) {
        // Create a new HttpClient and Post Header
        HttpParams myParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(myParams, 10000);
        HttpConnectionParams.setSoTimeout(myParams, 10000);
        HttpClient httpclient = new DefaultHttpClient(myParams);

        try {
            HttpPost httppost = new HttpPost(url.toString());
            httppost.setHeader("Content-type", "application/json");

            StringEntity se = new StringEntity(obj.toString(), HTTP.UTF_8);
//            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json; charset=utf-8"));
//            se.setContentEncoding("UTF-8");
            se.setContentType("application/json");
            httppost.setEntity(se);

            HttpResponse response = httpclient.execute(httppost);
            String temp = EntityUtils.toString(response.getEntity());

            if (reg) {
                if (temp.contains("ok")) {
                    runOnUiThread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void run() {
                            hidePDialog();
                            // close();
                            tt("data sent...");
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hidePDialog();
                            tt("خطا در ارسال داده\nدوباره امتحان کنید");
                        }
                    });
                }
            } else {
                //login
                if (temp.contains("ok")) {
                    // String id = temp.substring(21, temp.length() - 2);
                    //  tran(id);
                    tt("data sent...");
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hidePDialog();
                            tt("خطا در ارسال داده\nدوباره امتحان کنید");
                        }
                    });

                }

            }
        } catch (ClientProtocolException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tt("خطا در برقراری ارتباط");
                    hidePDialog();
                }
            });

        } catch (IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tt("خطا در ورودی خروجی");
                    hidePDialog();
                }
            });
        }


    }
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


}
