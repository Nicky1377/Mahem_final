package android.niky.mahem_final.other;

import android.niky.mahem_final.R;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



import java.util.List;

/**
 * Created by mohsal on 6/5/2018.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context context;
    private List<ImageItem> imageList;


    public ImageAdapter(Context context, List<ImageItem> ImageItemList) {
        this.context = context;
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
        ImageItem imageItem=imageList.get(position);
        holder.image_list.setImageResource(imageItem.getImage());
    }



    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView image_list;
        private TextView title,description, time;
        private RelativeLayout list_item;


        public ImageViewHolder(View itemView) {
            super(itemView);
            image_list=itemView.findViewById(R.id.img_list);

        }
    }
}
