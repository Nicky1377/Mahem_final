package android.niky.mahem_final.OffFinder;

import android.app.Activity;
import android.niky.mahem_final.R;


import android.content.Context;
import android.content.Intent;
import android.niky.mahem_final.Search_Filter.Advertising;
import android.niky.mahem_final.other.AppController;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class TAdapter extends BaseAdapter{

    private Activity context;
    private List<Takhfif> TList;
    private LayoutInflater inflater;
    ImageLoader  imageLoader = AppController.getInstance().getImageLoader();

    // NetworkImageView imageView;
    private TextView new_cost, pre_cost, t_describtion, t_percent, t_city;;

    private ImageView moon_1,moon_2,moon_3,moon_4,moon_5;
    private ImageView[] moons;

    public TAdapter(Activity context1,List<Takhfif> TaList)
    {
        context=context1;
        TList=TaList;

    }

    @Override
    public int getCount() {
        return TList.size();
    }

    @Override
    public Object getItem(int position) {
        return TList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.takfif_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView  imageView=(NetworkImageView) convertView.findViewById(R.id.takhfif_image);
        new_cost = convertView.findViewById(R.id.new_cost);
        pre_cost = convertView.findViewById(R.id.last_cost);
        t_describtion =  convertView.findViewById(R.id.t_des);
        t_percent =  convertView.findViewById(R.id.t_percent);
        t_city = convertView.findViewById(R.id.t_city);
        moon_1 = convertView.findViewById(R.id.moon_one);
        moon_2 = convertView.findViewById(R.id.moon_two);
        moon_3 = convertView.findViewById(R.id.moon_three);
        moon_4 = convertView.findViewById(R.id.moon_four);
        moon_5 = convertView.findViewById(R.id.moon_five);

        moons = new ImageView[]{moon_1, moon_2, moon_3, moon_4, moon_5};

        // getting movie data for the row
        Takhfif m = TList.get(position);

        // thumbnail image
        imageView.setImageUrl(m.getT_image(), imageLoader);

        // new Cost
        new_cost.setText(m.getNew_c());

        // pre Cost
        pre_cost.setText(m.getLast_c());

        //description
        t_describtion.setText(m.getT_describe());

        // city
        t_city.setText((m.getT_city()));

        // percent
        t_percent.setText(m.getT_percent());



        return convertView;
    }
}