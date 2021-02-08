package com.smartwebarts.swarealadmin.dashboard.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.smartwebarts.swarealadmin.R;
import com.smartwebarts.swarealadmin.flat.FlatActivity;
import com.smartwebarts.swarealadmin.model.DashboardModel;

import java.util.ArrayList;
import java.util.List;

public class OurAssociateAdpter  extends RecyclerView.Adapter<OurAssociateAdpter.MYViewHolder> {
    ArrayList ourplots = new ArrayList<>();
    private Context context;

    public OurAssociateAdpter(ArrayList ourplots, Context context) {
        this.ourplots = ourplots;
        this.context = context;
    }

    @NonNull
    @Override
    public MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MYViewHolder(LayoutInflater.from(context).inflate(R.layout.dashboard_item_layout, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MYViewHolder holder, int position) {
       // holder.textView.setText(dashboardModels.get(position).getIconName());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Press "+position, Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(context, FlatActivity.class);
//        intent.putExtra("title",title);
        context.startActivity(intent);
    }
});
    }

    @Override
    public int getItemCount() {
        return 60;
    }

    public class MYViewHolder extends RecyclerView.ViewHolder {
        ImageView productImages;
        TextView textView;

        public MYViewHolder(@NonNull View itemView) {
            super(itemView);
            productImages=itemView.findViewById(R.id.productImages);
            textView=itemView.findViewById(R.id.textView);
        }
    }
}
