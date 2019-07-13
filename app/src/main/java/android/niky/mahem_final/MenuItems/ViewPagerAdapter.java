package android.niky.mahem_final.MenuItems;

import android.niky.mahem_final.R;


import android.content.Context;
import android.niky.mahem_final.other.AppController;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;


public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] images;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();



    public ViewPagerAdapter(Context context,String[] image){
        this.context=context;
        images=image;
    }
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater =(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.swipe,container,false);
        NetworkImageView imageView=(NetworkImageView) v.findViewById(R.id.image_view);

        imageView.setImageUrl((images[position]), imageLoader);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
