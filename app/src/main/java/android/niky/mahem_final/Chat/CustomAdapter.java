package android.niky.mahem_final.Chat;

import android.niky.mahem_final.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;



import java.util.List;

public class CustomAdapter extends BaseAdapter{

    private List<ChatModel> chatModels;
    private Context context;
    private LayoutInflater layoutInflater;

    TextView ed;
    TextView time;

    public CustomAdapter(List<ChatModel> lst,Context con)
    {
        chatModels=lst;
        context=con;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return chatModels.size();
    }

    @Override
    public Object getItem(int i) {
        return chatModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1=view;
        if (view1==null)
        {
            if(chatModels.get(i).isSend())
                view1=layoutInflater.inflate(R.layout.item_message_sent,null);
            else
                view1=layoutInflater.inflate(R.layout.item_message_received,null);

            ed=(TextView)view1.findViewById(R.id.text_message_body);
            ed.setText(chatModels.get(i).getMessage());
            time=(TextView)view1.findViewById(R.id.time);
            time.setText(chatModels.get(i).getTime().toString().split(" ")[3]);
        }

        return view1;
    }


}
