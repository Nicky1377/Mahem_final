package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;


import android.Manifest;
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
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Management_Panel extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Advertising> AdvList;
    panelAdapter adapter;
    CircleImageView AccountImage;
    public Bitmap SelectedProfileImage;


    TextView paneltxt;
    FloatingActionButton fab;
    private int counter=3;


    private ArrayList<String> title=new ArrayList<String>() {

    };
    private ArrayList<String> description=new ArrayList<String>() {

    };
    private ArrayList<String> time=new ArrayList<String>() {

    };
    private ArrayList<Integer> ads_image=new ArrayList<Integer>() {

    };


    private ArrayList<String> chat_time=new ArrayList<String>() {

    };
    private int userImage;

    private String family_name;

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




        AdvList=new ArrayList<>();

        for(int i=0;i<counter;++i) {

            ///////fill these strings with network information
            title.add("vvv");
            description.add("PPPPPPP");
            time.add("aaaaaaa");

            chat_time.add("eee");
            ads_image.add(R.drawable.two);


            ////////////////////////////////////////////
            recyclerView =  findViewById(R.id.RecyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            ///this line add search views to the list:
            AdvList.add(new Advertising(title.get(i), description.get(i), time.get(i), ads_image.get(i),family_name,chat_time.get(i),userImage));
            adapter = new panelAdapter(this, AdvList);
            recyclerView.setAdapter(adapter);
        }


        paneltxt=(TextView)findViewById(R.id.mp);
        paneltxt.setText(family_name+"پنل مدیریت");

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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


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
                    SelectedProfileImage = BitmapFactory.decodeFile(filePath, options);
                    AccountImage.setImageBitmap(SelectedProfileImage);




                }


        }
}
