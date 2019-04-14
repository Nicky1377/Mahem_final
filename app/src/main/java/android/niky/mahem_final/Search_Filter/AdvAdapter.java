package android.niky.mahem_final.Search_Filter;

import android.app.Activity;
import android.niky.mahem_final.R;
import android.content.Context;
import android.niky.mahem_final.other.AppController;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import java.util.List;

public class AdvAdapter extends BaseAdapter {

    private Activity context;
    private List<Advertising> AdvList;
    private LayoutInflater inflater;
    ImageLoader  imageLoader = AppController.getInstance().getImageLoader();

       // NetworkImageView imageView;
        private TextView title,description, time;
        private RelativeLayout list_item;

    public AdvAdapter(Activity context, List<Advertising> AdvertisingList) {
        this.context = context;
        this.AdvList = AdvertisingList;

    }

    @Override
    public int getCount() {
        return AdvList.size();
    }

    @Override
    public Object getItem(int i) {
        return AdvList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null)
            view = inflater.inflate(R.layout.list_layout, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView  imageView=(NetworkImageView) view.findViewById(R.id.image);
            title=view.findViewById(R.id.title);
            description=view.findViewById(R.id.detail);
            time=view.findViewById(R.id.time);
            list_item=view.findViewById(R.id.list_item);

        // getting movie data for the row
        Advertising m = AdvList.get(i);

        // thumbnail image
        imageView.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // title
        title.setText(m.getTitle());

        // detaile
        description.setText(m.getDetails());

        //city
        time.setText(m.getTime());



        return view;
    }
}



//
//class AdvAdapter extends RecyclerView.Adapter<AdvAdapter.AdvViewHolder> {
//
//    private Context context;
//    private List<Advertising> AdvList;
//    ImageLoader  imageLoader = AppController.getInstance().getImageLoader();
//
//    public AdvAdapter(Context context, List<Advertising> AdvertisingList) {
//        this.context = context;
//        this.AdvList = AdvertisingList;
//    }
//    @Override
//    public AdvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        LayoutInflater inflater=LayoutInflater.from(context);
//        View view=inflater.inflate(R.layout.list_layout,null);
//        AdvViewHolder AdvViewHolder=new AdvViewHolder(view);
//        return AdvViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(AdvViewHolder holder, int position) {
//
//        Advertising advertising=AdvList.get(position);
//        holder.title.setText(advertising.getTitle());
//        holder.description.setText(advertising.getDetails());
//        holder.time.setText(advertising.getCity());
//        holder.imageView.setImageUrl(advertising.getThumbnailUrl(), imageLoader);
//        holder.list_item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(context, Ads_show.class);
//                context.startActivity(intent);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return AdvList.size();
//    }
//
//    class AdvViewHolder extends RecyclerView.ViewHolder{
//
//        NetworkImageView imageView;
//        private TextView title,description, time;
//        private RelativeLayout list_item;
//
//
//        public AdvViewHolder(View itemView) {
//            super(itemView);
//            imageView=itemView.findViewById(R.id.image);
//            title=itemView.findViewById(R.id.title);
//            description=itemView.findViewById(R.id.detail);
//            time=itemView.findViewById(R.id.time);
//            list_item=itemView.findViewById(R.id.list_item);
//        }
//    }
//}
//
//
//
