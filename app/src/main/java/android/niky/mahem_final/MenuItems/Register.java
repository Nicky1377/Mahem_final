package android.niky.mahem_final.MenuItems;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.niky.mahem_final.R;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.niky.mahem_final.Add.SabtAgahi;
import android.niky.mahem_final.Groups.Group;
import android.niky.mahem_final.OffFinder.Off;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class Register extends AppCompatActivity {
    View navigationBar;
    ImageView Home,Add,Menu,MenuLine,Search;

    EditText etUserName, etPhone;
    Button btnRegister;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPhone.getText().toString().equals("")) {
                    etPhone.setError("لطفا شماره تلفن خود را وارد کنید");
                    return;
                } else if (etPhone.getText().toString().length() != 11) {
                    etPhone.setError("لطفا شماره تلفن معتبر وارد کنید");
                    return;
                }
                if (etUserName.getText().toString().equals("")) {
                    etUserName.setError("لطفا نام کاربری خود را وارد کنید");
                    return;
                } else if (etUserName.getText().toString().length() > 12 || etUserName.getText().toString().length() < 3) {
                    etUserName.setError("لطفا نام کاربری معتبر وارد کنید");
                    return;
                }

                permissionSMS();
                reg(etUserName.getText().toString(), etPhone.getText().toString());



            }
        });
        map();
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
                i.putExtra("title",getResources().getString(R.string.title_search));
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
        });

    }
    private void init() {
        etUserName = (EditText) findViewById(R.id.et_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }

   void reg(String username, String phone) {
Sendr("http://appmahem.eu-4.evennode.com/singupwithphone",username,phone);
    }




    ///////////////////////Network//////////////

    private ProgressDialog pDialog;


    void Sendr(final String URL, final String username, final String phn) {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("لطفا صبر کنید");
        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("name", username);
        postParam.put("phone", phn);


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
    String id;
    public void postData(final String url, final JSONObject obj, boolean reg) {
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
              temp = EntityUtils.toString(response.getEntity());


            if (reg) {
                if (temp.contains("ok")) {
                            id = temp.substring(21, temp.length() - 14);
                    runOnUiThread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void run() {
                            hidePDialog();
                          //  tt("ثبت نام با موفقیت انجام شد\nلطفا وارد حساب خود شوید");
                            String code=temp.substring(temp.length()-5,temp.length()-1);

                            tt("data sent");
                            tt(code +"\n"+id);

                            String userId=temp.toString().split("\"")[7];


                                  tran(id, etPhone.getText().toString(),code);

                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hidePDialog();
                            tt("خطا در اطلاعات وارد شده");
                        }
                    });
                }
            } else {
                //login
                if (temp.contains("ok")) {
                    id = temp.substring(21, temp.length() - 2);
                    JsonArrayRequest productReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            try {
                            JSONObject obj=response.getJSONObject(0);
                             //   tran(id, etPhone.getText().toString(), obj.getString( "registertoken"));
                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                           // VolleyLog.d(TAG, "Error: " + error.getMessage());
                            hidePDialog();
                        }
                    });

                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hidePDialog();
                            tt("شما تصدیق نشدید\nدوباره سعی کنید");
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

    void tt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    void tran(String id,String phn,String Code) {
        hidePDialog();
        SaveMe(id);
        SaveAccess();
        Intent i = new Intent(Register.this, CodeVerification.class);
       i.putExtra("phn", phn);
        i.putExtra("code", Code);
        startActivity(i);
        this.finish();
    }

    void SaveMe(String user) {

        File root = getFilesDir();
        File dir = new File(root.getAbsolutePath() + "/.MahemProg");
        dir.mkdirs();
        File file = new File(dir, "phn.txt");

        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println(user);
            pw.flush();
            pw.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //tt(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            //tt(e.getMessage());
        }

    }

    void SaveAccess() {

        File root = getFilesDir();
        File dir = new File(root.getAbsolutePath() + "/.MahemProg");
        dir.mkdirs();
        File file = new File(dir, "acc.txt");

        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.println("BRONZE");
            pw.flush();
            pw.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            //tt(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            //tt(e.getMessage());
        }

    }

    void permissionSMS() {
        final int ID_THIS_ACTIVITY = 10;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.SEND_SMS)
                    == PackageManager.PERMISSION_DENIED) {
                String[] permissions = {Manifest.permission.SEND_SMS};
                requestPermissions(permissions, ID_THIS_ACTIVITY);
            }
        }
    }

}

