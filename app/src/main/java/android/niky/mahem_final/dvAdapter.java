package android.niky.mahem_final;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        holder.describtion.setText(advertising.getDetails());
        holder.time.setText(advertising.getTime());
        holder.imageView.setImageResource(advertising.getImage());

    }

    @Override
    public int getItemCount() {
        return AdvList.size();
    }

    class AdvViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView;
        TextView title,describtion, time;
        public AdvViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.image);
            title=(TextView)itemView.findViewById(R.id.title);
            describtion=(TextView)itemView.findViewById(R.id.detail);
            time=(TextView)itemView.findViewById(R.id.time);
        }
    }
}

