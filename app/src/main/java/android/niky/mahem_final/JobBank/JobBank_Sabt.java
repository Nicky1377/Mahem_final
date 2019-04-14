package android.niky.mahem_final.JobBank;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.niky.mahem_final.R;


import android.content.Context;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class JobBank_Sabt extends AppCompatActivity {

ImageView L_img;
CircleImageView S_img;
Button send;
EditText name,modiriat,senf_type,sabt_num,phone_office,mobile,fax,address,telegram,insta,email,tozihat;

PopupWindow Senf_layout;
View SenfLayout;

TextView senf_1,senf_2,senf_3,senf_4,senf_5,senf_6,senf_7,senf_8,senf_9,senf_10,senf_11
        ,senf_12,senf_13,senf_14,senf_15,senf_16,senf_17,senf_18,senf_19,senf_20;

Job_Sabt_Class job_sabt_class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_bank__sabt);

        job_sabt_class=new Job_Sabt_Class();
        L_img=(ImageView)findViewById(R.id.img);
        S_img=(CircleImageView)findViewById(R.id.job_pic);
        send=(Button)findViewById(R.id.send);

        name=(EditText)findViewById(R.id.E12);
        modiriat=(EditText)findViewById(R.id.E1);
        senf_type=(EditText)findViewById(R.id.E2);
        sabt_num=(EditText)findViewById(R.id.E3);
        phone_office=(EditText)findViewById(R.id.E4);
        mobile=(EditText)findViewById(R.id.E5);
        fax=(EditText)findViewById(R.id.E6);
        address=(EditText)findViewById(R.id.E7);
        telegram=(EditText)findViewById(R.id.E8);
        insta=(EditText)findViewById(R.id.E9);
        email=(EditText)findViewById(R.id.E10);
        tozihat=(EditText)findViewById(R.id.E11);

        senf_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                SenfLayout=inflater.inflate(R.layout.asnaf_list,null);
                Senf_layout= new PopupWindow(SenfLayout, LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                Senf_layout.showAsDropDown(view);

                Senf_map();

            }
        });

        S_img.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                pick();
            }
        });


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(modiriat.getText().toString().equals("")) {
                modiriat.setError("لطفا نام مدیر را وارد کنید.");
                return;
            } else if(senf_type.getText().toString().equals("")) {
                senf_type.setError("لطفا نوع صنف را انتخاب کنید.");
                return;
            }else if(phone_office.getText().toString().equals("")) {
                phone_office.setError("لطفا تلفن ثابت را وارد کنید.");
                return;
            }else if(address.getText().toString().equals("")) {
                address.setError("لطفا آدرس را وارد کنید.");
                return;
            }else if(name.getText().toString().equals("")) {
                senf_type.setError("لطفا نام واحد را انتخاب کنید.");
                return;
            }else{



                job_sabt_class.setModiriat(modiriat.getText().toString());
                job_sabt_class.setPhone_office( phone_office.getText().toString());
                job_sabt_class.setAddress(address.getText().toString());
                    job_sabt_class.setName(name.getText().toString());
                    job_sabt_class.setSabt_num(sabt_num.getText().toString());
                    job_sabt_class.setMobile(mobile.getText().toString());
                    job_sabt_class.setFax(fax.getText().toString());
                    job_sabt_class.setTelegram(telegram.getText().toString());
                    job_sabt_class.setInsta(insta.getText().toString());
                    job_sabt_class.setEmail(email.getText().toString());
                    job_sabt_class.setTozihat(tozihat.getText().toString());

                job_sabt_class.Network();
                tt("اعمال شد.");


                Send("http://appmahem.eu-4.evennode.com/addtobank",job_sabt_class.getName(),
                        job_sabt_class.getModiriat(),job_sabt_class.getSenf_type(),job_sabt_class.getSabt_num()
                ,job_sabt_class.getPhone_office(),job_sabt_class.getMobile(),job_sabt_class.getFax(),
                        job_sabt_class.getAddress(),job_sabt_class.getTelegram(),job_sabt_class.getInsta(),
                        job_sabt_class.getEmail(),job_sabt_class.getTozihat(),job_sabt_class.getPicUrl());

            }
            }
        });
        Toast.makeText(this,getLocalClassName().toString()+"\nNiky",Toast.LENGTH_LONG).show();

    }

    public void tt(String s)
    {
        Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
    }

    public void Senf_map()
    {
        senf_1=(TextView) SenfLayout.findViewById(R.id.Tt1);
        senf_2=(TextView)SenfLayout.findViewById(R.id.Tt2);
        senf_3=(TextView)SenfLayout.findViewById(R.id.Tt3);
        senf_4=(TextView)SenfLayout.findViewById(R.id.Tt4);
        senf_5=(TextView)SenfLayout.findViewById(R.id.Tt5);
        senf_6=(TextView)SenfLayout.findViewById(R.id.Tt6);
        senf_7=(TextView)SenfLayout.findViewById(R.id.Tt7);
        senf_8=(TextView)SenfLayout.findViewById(R.id.Tt8);
        senf_9=(TextView)SenfLayout.findViewById(R.id.Tt9);
        senf_10=(TextView)SenfLayout.findViewById(R.id.Tt10);
        senf_11=(TextView)SenfLayout.findViewById(R.id.Tt11);
        senf_12=(TextView)SenfLayout.findViewById(R.id.Tt12);
        senf_13=(TextView)SenfLayout.findViewById(R.id.Tt13);
        senf_14=(TextView)SenfLayout.findViewById(R.id.Tt14);
        senf_15=(TextView)SenfLayout.findViewById(R.id.Tt15);
        senf_16=(TextView)SenfLayout.findViewById(R.id.Tt16);
        senf_17=(TextView)SenfLayout.findViewById(R.id.Tt17);
        senf_18=(TextView)SenfLayout.findViewById(R.id.Tt18);
        senf_19=(TextView)SenfLayout.findViewById(R.id.Tt19);
        senf_20=(TextView)SenfLayout.findViewById(R.id.Tt20);

        senf_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_1.getText().toString());
                job_sabt_class.setSenf_type("4_Job");
                Senf_layout .dismiss();
            }
        });

        senf_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_2.getText().toString());
                job_sabt_class.setSenf_type("3_Job");
                Senf_layout .dismiss();
            }
        });

        senf_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_3.getText().toString());
                job_sabt_class.setSenf_type("2_Job");
                Senf_layout .dismiss();
            }
        });

        senf_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_4.getText().toString());
                job_sabt_class.setSenf_type("1_Job");
                Senf_layout .dismiss();
            }
        });

        senf_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_5.getText().toString());
                job_sabt_class.setSenf_type("8_Job");
                Senf_layout .dismiss();
            }
        });

        senf_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_6.getText().toString());
                job_sabt_class.setSenf_type("7_Job");
                Senf_layout .dismiss();
            }
        });

        senf_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_7.getText().toString());
                job_sabt_class.setSenf_type("6_Job");
                Senf_layout .dismiss();
            }
        });

        senf_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_8.getText().toString());
                job_sabt_class.setSenf_type("5_Job");
                Senf_layout .dismiss();
            }
        });

        senf_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_9.getText().toString());
                job_sabt_class.setSenf_type("12_Job");
                Senf_layout .dismiss();
            }
        });

        senf_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_10.getText().toString());
                job_sabt_class.setSenf_type("11_Job");
                Senf_layout .dismiss();
            }
        });

        senf_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_11.getText().toString());
                job_sabt_class.setSenf_type("10_Job");
                Senf_layout .dismiss();
            }
        });


        senf_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_12.getText().toString());
                job_sabt_class.setSenf_type("9_Job");
                Senf_layout .dismiss();
            }
        });

        senf_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_13.getText().toString());
                job_sabt_class.setSenf_type("16_Job");
                Senf_layout .dismiss();
            }
        });

        senf_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_14.getText().toString());
                job_sabt_class.setSenf_type("15_Job");
                Senf_layout .dismiss();
            }
        });

        senf_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_15.getText().toString());
                job_sabt_class.setSenf_type("14_Job");
                Senf_layout .dismiss();
            }
        });

        senf_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_16.getText().toString());
                job_sabt_class.setSenf_type("13_Job");
                Senf_layout .dismiss();
            }
        });
        senf_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_17.getText().toString());
                job_sabt_class.setSenf_type("20_Job");
                Senf_layout .dismiss();
            }
        });

        senf_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_18.getText().toString());
                job_sabt_class.setSenf_type("19_Job");
                Senf_layout .dismiss();
            }
        });

        senf_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_19.getText().toString());
                job_sabt_class.setSenf_type("18_Job");
                Senf_layout .dismiss();
            }
        });

        senf_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senf_type.setText(senf_20.getText().toString());
                job_sabt_class.setSenf_type("17_Job");
                Senf_layout .dismiss();
            }
        });

    }

    /////network///////
    private ProgressDialog pDialog;

    void Send(final String URL,String name,String modiriat,String senf_type,String sabt_num,String phone_office,
              String mobile,String fax,String address,String telegram,String insta,String email,String tozihat
    ,String pic)
    {


        pDialog = new ProgressDialog(this);
        pDialog.setMessage("لطفا صبر کنید");
        pDialog.show();
        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("modiriat",modiriat);
        postParam.put( "senf",name);
        postParam.put("numsabt",sabt_num);
        postParam.put( "tamas",phone_office);
        postParam.put( "mobile",mobile);
        postParam.put( "fax",fax);
        postParam.put( "address",address);
        postParam.put( "telegram",telegram);
        postParam.put( "instagram",insta);
        postParam.put( "email",email);
        postParam.put( "comment",tozihat);
        postParam.put( "session" ,senf_type);

        //pics
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();

            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inDither = true;
            options.inSampleSize = 8;

            Bitmap bm1 = BitmapFactory.decodeFile(pic, options);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm1.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] b = baos.toByteArray();

            String encodedImage1 = Base64.encodeToString(b,
                    Base64.DEFAULT);
            // tt(encodedImage1.length()+"");

            postParam.put("pic", encodedImage1);

        } catch (Exception e) {
            Log.d("ppppppppiiiiiiiicccc", e.getMessage());
            tt("خطا در ارسال عکس");
        }


        ////////////////////////////////////////////////////////



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

    Bitmap yourSelectedImage;
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
                    S_img.setImageBitmap(yourSelectedImage);
                   job_sabt_class.setPicUrl(yourSelectedImage.toString());


                }
        }
    }


}
