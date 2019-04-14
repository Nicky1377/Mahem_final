package android.niky.mahem_final.JobBank;

import android.content.Intent;
import android.niky.mahem_final.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class JAdapter extends RecyclerView.Adapter<JAdapter.JViewHolder> {

    private Context context;
    private List<Job_Sabt_Class> JList;

    public JAdapter(Context context, List<Job_Sabt_Class> JobsList) {
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

        final Job_Sabt_Class Jobs=JList.get(position);
        holder.j_row.setText(Jobs.getRow());
        holder.j_title.setText(Jobs.getName());
        holder.j_manage.setText(Jobs.getModiriat());
        holder.j_phone.setText(Jobs.getPhone_office());
        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, JobBank_Show.class);
                i.putExtra("numsabt",Jobs.getSabt_num());
                i.putExtra("name",Jobs.getName());
                i.putExtra("mobile",Jobs.getMobile());
                i.putExtra("fax",Jobs.getFax());
                i.putExtra("telegram",Jobs.getTelegram());
                i.putExtra("instagram",Jobs.getInsta());
                i.putExtra("email",Jobs.getEmail());
                i.putExtra("comment",Jobs.getTozihat());
                i.putExtra("picurl",Jobs.getPicUrl());
                //i.putExtra("noe",Jobs.);
                i.putExtra("date",Jobs.getDate());
                i.putExtra("tamas",Jobs.getPhone_office());
                i.putExtra("address",Jobs.getAddress());
                i.putExtra("modiriat",Jobs.getModiriat());
                i.putExtra("session",Jobs.getSenf_type());

                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return JList.size();
    }

    class JViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout list_item;

        TextView j_row,j_title,j_manage,j_phone;
        public JViewHolder(View itemView) {
            super(itemView);

            j_title=(TextView)itemView.findViewById(R.id.name_d);
            j_row=(TextView)itemView.findViewById(R.id.row_d);
            j_manage=(TextView)itemView.findViewById(R.id.manage_d);
            j_phone=(TextView)itemView.findViewById(R.id.phone_d);
            list_item=itemView.findViewById(R.id.listItm);
        }
    }
}
