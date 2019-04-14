package android.niky.mahem_final.MenuItems;

import android.niky.mahem_final.R;


import android.content.Context;
import android.content.Intent;
import android.niky.mahem_final.Search_Filter.Advertising;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.niky.mahem_final.OffFinder.Off;


import java.util.List;


public class panelAdapter extends RecyclerView.Adapter<panelAdapter.AdvViewHolder> {

    private Context context;
    private List<Advertising> AdvList;

    public panelAdapter(Context context, List<Advertising> advList) {
        this.context = context;
        AdvList = advList;
    }

    @Override
    public AdvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.panel_layout,null);
        AdvViewHolder AdvViewHolder=new AdvViewHolder(view);
        return AdvViewHolder;
    }

    @Override
    public void onBindViewHolder(AdvViewHolder holder, int position) {

        Advertising advertising=AdvList.get(position);
        holder.title.setText(advertising.getTitle());
        holder.description.setText(advertising.getDetails());
        holder.time.setText(advertising.getTime());
        //holder.imageView.setImageResource(advertising.getImage());

        holder.FamilyName.setText(advertising.getFamily_name());
        holder.chatTime.setText(advertising.getChat_time());
        holder.userImageView.setImageResource(advertising.getUserImage());
        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Off.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return AdvList.size();
    }

    class AdvViewHolder extends RecyclerView.ViewHolder{


        ImageView imageView,userImageView;
        TextView title, description, time,FamilyName,chatTime;
        private RelativeLayout list_item;
        public AdvViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.image);
            title=(TextView)itemView.findViewById(R.id.title);
            description =(TextView)itemView.findViewById(R.id.detail);
            time=(TextView)itemView.findViewById(R.id.time);

            userImageView=(ImageView)itemView.findViewById(R.id.userImage);
            FamilyName=(TextView)itemView.findViewById(R.id.family_name);
            chatTime=(TextView)itemView.findViewById(R.id.time_chat);
            list_item=(RelativeLayout)itemView.findViewById(R.id.agahi);
        }
    }
}
