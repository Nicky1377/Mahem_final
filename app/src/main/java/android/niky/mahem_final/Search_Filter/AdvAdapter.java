package android.niky.mahem_final.Search_Filter;

import android.niky.mahem_final.R;




import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.niky.mahem_final.MenuItems.Ads_show;

import java.util.List;



class AdvAdapter extends RecyclerView.Adapter<AdvAdapter.AdvViewHolder> {

    private Context context;
    private List<Advertising> AdvList;


    public AdvAdapter(Context context, List<Advertising> AdvertisingList) {
        this.context = context;
        this.AdvList = AdvertisingList;
    }
    @Override
    public AdvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.list_layout,null);
        AdvViewHolder AdvViewHolder=new AdvViewHolder(view);
        return AdvViewHolder;
    }

    @Override
    public void onBindViewHolder(AdvViewHolder holder, int position) {

        Advertising advertising=AdvList.get(position);
        holder.title.setText(advertising.getTitle());
        holder.description.setText(advertising.getDetails());
        holder.time.setText(advertising.getTime());
        holder.imageView.setImageResource(advertising.getImage());
        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Ads_show.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return AdvList.size();
    }

    class AdvViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        private TextView title,description, time;
        private RelativeLayout list_item;


        public AdvViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            title=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.detail);
            time=itemView.findViewById(R.id.time);
            list_item=itemView.findViewById(R.id.list_item);
        }
    }
}

