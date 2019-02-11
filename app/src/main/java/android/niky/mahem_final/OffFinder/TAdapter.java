package android.niky.mahem_final.OffFinder;

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


import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class TAdapter extends RecyclerView.Adapter<TAdapter.TViewHolder> {

    private Context context;
    private List<Takhfif> AdvList;

    private ArrayList<Integer> ratingg;
    private View view;

    private ImageView moon_1,moon_2,moon_3,moon_4,moon_5;
    private ImageView[] moons;

    public TAdapter(Context context, List<Takhfif> TakhfifList, ArrayList<Integer> ratingg) {

        this.context = context;
        this.AdvList = TakhfifList;

        this.ratingg=ratingg;
    }
    @Override
    public TViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(R.layout.activity_t_list,null);
        TViewHolder TViewHolder=new TViewHolder(view,ratingg);

        return TViewHolder;
    }

    @Override
    public void onBindViewHolder(TViewHolder holder, int position) {

        Takhfif Takhfif=AdvList.get(position);
        holder.new_cost.setText(Takhfif.getNew_c());
        holder.pre_cost.setText(Takhfif.getLast_c());
        holder.t_describtion.setText(Takhfif.getT_describe());
        holder.t_city.setText(Takhfif.getT_city());
        holder.t_percent.setText((CharSequence) Takhfif.gett_percent());
        holder.t_image.setImageResource(Takhfif.getT_image());
        holder.T_list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Takhfif_Show.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return AdvList.size();
    }

    class TViewHolder extends RecyclerView.ViewHolder {


        private WeakReference<View.OnClickListener> listenerRef;

        TextView new_cost, pre_cost, t_describtion, t_percent, t_city;
        ImageView t_image;
        RelativeLayout T_list_item;

        public TViewHolder(View itemView, ArrayList<Integer> rating) {
            super(itemView);


            new_cost = itemView.findViewById(R.id.new_cost);
            pre_cost = itemView.findViewById(R.id.last_cost);
            t_describtion =  itemView.findViewById(R.id.t_des);
            t_percent =  itemView.findViewById(R.id.t_percent);
            t_city = itemView.findViewById(R.id.t_city);
            moon_1 = itemView.findViewById(R.id.moon_one);
            moon_2 = itemView.findViewById(R.id.moon_two);
            moon_3 = itemView.findViewById(R.id.moon_three);
            moon_4 = itemView.findViewById(R.id.moon_four);
            moon_5 = itemView.findViewById(R.id.moon_five);
            t_image= itemView.findViewById(R.id.t_image);
            T_list_item=itemView.findViewById(R.id.t_list_item);

            moons = new ImageView[]{moon_1, moon_2, moon_3, moon_4, moon_5};

            for (ImageView v:moons
                    ) {
                v.setImageResource(R.drawable.one);
            }
            for(int i=0;i<rating.get(i);++i){
                moons[i].setImageResource(R.drawable.two);
            }
        }

    }

}
