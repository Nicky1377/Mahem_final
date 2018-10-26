package android.niky.mahem_final.JobBank;
import android.content.Context;
import android.niky.mahem_final.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class JAdapter extends RecyclerView.Adapter<JAdapter.JViewHolder> {

    private Context context;
    private List<Jobs> JList;

    public JAdapter(Context context, List<Jobs> JobsList) {
        this.context = context;
        this.JList = JobsList;
    }

    @Override
    public JViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.job_list,null);
        JViewHolder jViewHolder=new JViewHolder(view);
        return jViewHolder;
    }

    @Override
    public void onBindViewHolder(JViewHolder holder, int position) {

        Jobs Jobs=JList.get(position);
        holder.j_row.setText(Jobs.getRow());
        holder.j_title.setText(Jobs.getName());
        holder.j_manage.setText(Jobs.getManagment());
        holder.j_phone.setText(Jobs.getPhone());

    }

    @Override
    public int getItemCount() {
        return JList.size();
    }

    class JViewHolder extends RecyclerView.ViewHolder{



        TextView j_row,j_title,j_manage,j_phone;
        public JViewHolder(View itemView) {
            super(itemView);

            j_title=(TextView)itemView.findViewById(R.id.name_d);
            j_row=(TextView)itemView.findViewById(R.id.row_d);
            j_manage=(TextView)itemView.findViewById(R.id.manage_d);
            j_phone=(TextView)itemView.findViewById(R.id.phone_d);
        }
    }
}
