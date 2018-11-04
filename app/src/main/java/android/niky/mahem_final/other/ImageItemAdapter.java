package android.niky.mahem_final.other;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.niky.mahem_final.R;
import android.widget.ImageView;

import java.util.List;

public class ImageItemAdapter extends ArrayAdapter {

    public ImageItemAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context,R.layout.page1_list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.page1_list_item,null,false);
        ImageView img=(ImageView)view.findViewById(R.id.img_item);

        return view;
    }
}
