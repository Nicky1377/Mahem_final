package android.niky.mahem_final.MenuItems;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.niky.mahem_final.Add.SabtAgahi_Amlak_Home;
import android.niky.mahem_final.Chat.ChatModel;
import android.niky.mahem_final.R;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.niky.mahem_final.Search_Filter.AdvAdapter;
import android.niky.mahem_final.Search_Filter.Advertising;
import android.niky.mahem_final.other.AppController;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.apache.http.HttpResponse;
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Management_Panel extends AppCompatActivity {

    ListView listView;
    List<Advertising> AdvList;
    AdvAdapter adapter;
    CircleImageView AccountImage;
    public Bitmap SelectedProfileImage;


    TextView paneltxt;
    FloatingActionButton fab;

    private int userImage;

    private String family_name;
    Intent ii;
    String url;
    private ProgressDialog pDialog;

    @Override
    protected void onResume() {
        super.onResume();
        if (SelectedProfileImage!=null){
            AccountImage.setImageBitmap(SelectedProfileImage);
        }else {
            userImage = R.drawable.cameraa;
            AccountImage.setImageResource(userImage);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management__panel);
        //fill this variables with information

        family_name="نوین فر";




getInfo("http://appmahem.eu-4.evennode.com/manageads");
        listView =(ListView)findViewById(R.id.RecyclerView);
        adapter = new AdvAdapter(this, AdvList);
        listView.setAdapter(adapter);

        ii=getIntent();


//        // Creating volley request obj
//        JsonArrayRequest productReq = new JsonArrayRequest(url,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        // Log.d(TAG, response.toString());
//                        hidePDialog();
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject obj = response.getJSONObject(i);
//                                Advertising adv = new Advertising();
//                                adv.setId(obj.getString("_id"));
//                                adv.setTitle(obj.getString("title"));
//                                adv.setTime(obj.getString("date"));
//                                adv.setNoe(obj.getString("noe"));
//                                JSONArray pic = obj.getJSONArray("pic");
//                                adv.setThumbnailUrl("http://" +pic.getString(0));
//
//
//                                AdvList.add(adv);
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                        adapter.notifyDataSetChanged();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                // VolleyLog.d(TAG, "Error: " + error.getMessage());
//                hidePDialog();
//            }
//        });
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(productReq);
//
//
//

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getBaseContext(), Ads_show.class);
                Advertising advertising= (Advertising) adapterView.getAdapter().getItem(i);

                intent.putExtra("id",advertising.getId());
                intent.putExtra("noe",advertising.getNoe());
                startActivity(intent);
            }
        });

        paneltxt=(TextView)findViewById(R.id.mp);
        paneltxt.setText(family_name+getResources().getString(R.string.panel));

        AccountImage=(CircleImageView)findViewById(R.id.AccoutImage);
        AccountImage.setImageResource(userImage);
        AccountImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final int ID_THIS_ACTIVITY=77;
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

        fab=(FloatingActionButton)findViewById(R.id.FAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    //pick picture...
    void pick() {

        final CharSequence[] options = {"دوربین", "گالری"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext()
        );

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
                            .getExternalStorageDirectory(), "temp"
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
                            + File.separator + "temp" + ".jpg";

                    Bitmap thumbnail = BitmapFactory.decodeFile(picturePath);

//                    Cameras.get(pic).setImageBitmap(thumbnail);
//                    pics[pic] = picturePath;

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

//                    Cameras.get(pic).setImageBitmap(thumbnail);
//                    pics[pic] = picturePath;

                } catch (Exception e) {
                    //
                }

            }
        }
    }


    void tt(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
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
    ///////////Network
    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    void getInfo(final String URL )
    {
        Log.d("req", "___send started");
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("لطفا صبر کنید");
        pDialog.show();

        final Map<String, String> postParam = new HashMap<String, String>();

        postParam.put("userid", readFileAsString());

        ////////////////////////////////////////////////////////

        final Thread send = new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject obj = new JSONObject(postParam);
                postData_getInfo(URL, obj, true);
            }
        });

        send.start();
    }

    public void postData_getInfo(final String url, final JSONObject obj, boolean reg) {



        // Create a new HttpClient and Post Header
        HttpParams myParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(myParams, 10000);
        HttpConnectionParams.setSoTimeout(myParams, 10000);
        HttpClient httpclient = new DefaultHttpClient(myParams);

        AdvList=new ArrayList<>();
        try {
            HttpPost httppost = new HttpPost(url.toString());
            httppost.setHeader("Content-type", "application/json");

            StringEntity se = new StringEntity(obj.toString(), HTTP.UTF_8);

            se.setContentType("application/json");
            httppost.setEntity(se);

            HttpResponse response = httpclient.execute(httppost);
            String temp1 = EntityUtils.toString(response.getEntity());
            JSONArray ja=new JSONArray(temp1);
            Log.d("temp1",ja.toString());

            for (int i = 0; i < ja.length(); i++) {
                try {
                    JSONObject obj1 = ja.getJSONObject(i);
                    JSONArray jsonArray=obj1.getJSONArray("ads");

                    for (int j = 0; j < jsonArray.length(); j++) {

                        JSONObject obj2 = jsonArray.getJSONObject(j);
                        Advertising adv = new Advertising();
                        adv.setId(obj2.getString("_id"));
                        adv.setTitle(obj2.getString("title"));
                        adv.setTime(obj2.getString("date"));
                        adv.setNoe(obj2.getString("noe"));
                        JSONArray pic = obj2.getJSONArray("pic");
                        adv.setThumbnailUrl("http://" + pic.getString(0));


                        AdvList.add(adv);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
//            customAdapter.notifyDataSetChanged();


        } catch (IOException e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tt("خطا در ورودی خروجی");
                    hidePDialog();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


}
