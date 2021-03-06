package android.niky.mahem_final.other;

import android.content.Context;
import android.content.Intent;
import android.niky.mahem_final.MenuItems.Ads_show;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.niky.mahem_final.R;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 * Created by mohsal on 6/5/2018.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context context;
    private Intent intent;
    private List<ImageItem> imageList;
    private LayoutInflater inflater;


    public ImageAdapter(Context context, List<ImageItem> ImageItemList,Intent C) {
        this.context = context;
        this.intent=C;
        this.imageList = ImageItemList;
    }
    public ImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.image_list,null);
        ImageAdapter.ImageViewHolder imageViewHolder=new ImageAdapter.ImageViewHolder(view);
        return imageViewHolder;
    }
    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        final ImageItem imageItem=imageList.get(position);
        holder.imageView.setImageUrl(imageItem.getImage(), holder.imageLoader);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=intent;
                i.putExtra("id",imageItem.getId());
                i.putExtra("noe",imageItem.getNoe());
                context.startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView image_list;
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

        NetworkImageView imageView;


        public ImageViewHolder(View itemView) {
            super(itemView);

            image_list=itemView.findViewById(R.id.img_list);
            if (inflater == null)
            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (itemView == null)
            itemView = inflater.inflate(R.layout.image_list, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        imageView=(NetworkImageView) itemView.findViewById(R.id.img_list);


        }
    }
}
//public class ImageAdapter extends BaseAdapter {
//    private Context context;
//    private List<ImageItem> imageList;
//    private LayoutInflater inflater;
//    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
//
//    NetworkImageView imageView;
//
//    public ImageAdapter(Context context, List<ImageItem> ImageItemList) {
//        this.context = context;
//        this.imageList = ImageItemList;
//    }
//
//    @Override
//    public int getCount() {
//        return imageList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return imageList.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        if (inflater == null)
//            inflater = (LayoutInflater) context
//                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        if (view == null)
//            view = inflater.inflate(R.layout.image_list, null);
//
//        if (imageLoader == null)
//            imageLoader = AppController.getInstance().getImageLoader();
//        imageView=(NetworkImageView) view.findViewById(R.id.img_list);
//
//        ImageItem m=imageList.get(i);
//
//        // thumbnail image
//        imageView.setImageUrl(m.getImage(), imageLoader);
//
//
//        return view;
//    }
//    }
//    public ImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        LayoutInflater inflater=LayoutInflater.from(context);
//        View view=inflater.inflate(R.layout.image_list,null);
//        ImageAdapter.ImageViewHolder imageViewHolder=new ImageAdapter.ImageViewHolder(view);
//        return imageViewHolder;
//    }
//    @Override
//    public void onBindViewHolder(ImageViewHolder holder, int position) {
//        ImageItem imageItem=imageList.get(position);
//        holder.image_list.setImageResource(imageItem.getImage());
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return imageList.size();
//    }
//
//    class ImageViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView image_list;
//        private TextView title,description, time;
//        private RelativeLayout list_item;
//
//
//        public ImageViewHolder(View itemView) {
//            super(itemView);
//            image_list=itemView.findViewById(R.id.img_list);
//
//        }
//    }

