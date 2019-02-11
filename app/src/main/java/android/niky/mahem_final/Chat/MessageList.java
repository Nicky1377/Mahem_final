package android.niky.mahem_final.Chat;

import android.niky.mahem_final.R;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MessageList extends AppCompatActivity {

    ListView list;
    EditText msg;

    String text;
    ChatModel chatModelssss;

    List<ChatModel> chatModels;
    CustomAdapter customAdapter;

    String ph_number="";
    String formattedNumber = PhoneNumberUtils.formatNumber(ph_number, Locale.getDefault().getCountry());

    RelativeLayout SendMessage;
    ImageView back,ShareMedia,Call;
    CircleImageView ProfileImg;
    TextView Name;
    EditText MessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        init();

        chatModels=new ArrayList<>();
        list=(ListView)findViewById(R.id.message_list);
        msg=(EditText)findViewById(R.id.MessageText);

        SendMessage=(RelativeLayout)findViewById(R.id.SendBtn);

        chatModels.add(new ChatModel("سلام" + "\n" +"  شرایط فروش خودرو و اقساطش رو توضیح میدین؟؟"
                ,false, Calendar.getInstance().getTime()));
        chatModels.add(new ChatModel("سلام ، زنگ بزنین تا بتونم بهتر توضیح بدم",true,Calendar.getInstance().getTime()));
        customAdapter=new CustomAdapter(chatModels,getApplicationContext());
        list.setAdapter(customAdapter);
        SendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(msg.getText().toString().equals(""))
                {
                    msg.setHint("افزودن متن");
                }
                else {
                    Toast.makeText(getBaseContext(), "sent", Toast.LENGTH_LONG).show();

                    text = msg.getText().toString();

                    chatModelssss = new ChatModel(text, true, Calendar.getInstance().getTime());

                    chatModels.add(chatModelssss);

                    msg.setText("");
                    msg.setHint("افزودن متن");


                    list.setAdapter(customAdapter);
                }
            }
        });

        back=(ImageView)findViewById(R.id.flsh);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Call=(ImageView)findViewById(R.id.calllll);
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + formattedNumber));

                final int ID_THIS_ACTIVITY=11;
                if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.CALL_PHONE};
                        requestPermissions(permission, ID_THIS_ACTIVITY);
                    }
                    else{
                        startActivity(i);
                    }
                }
            }
        });



    }

    private  void init()
    {
        Name=(TextView)findViewById(R.id.Name);
        MessageText=(EditText)findViewById(R.id.MessageText);
    }
}

