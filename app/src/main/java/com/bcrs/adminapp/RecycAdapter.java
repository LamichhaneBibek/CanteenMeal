package com.bcrs.adminapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycAdapter extends RecyclerView.Adapter<RecycAdapter.MyViewHolder> {
private List<recyclerNewOrders> recyclerNewOrdersList;

    public RecycAdapter(List<recyclerNewOrders> recyclerNewOrdersList) {
        this.recyclerNewOrdersList = recyclerNewOrdersList;
    }

    @NonNull
    @Override
    public RecycAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_new_orders,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecycAdapter.MyViewHolder holder, int position) {

        holder.cusName.setText(recyclerNewOrdersList.get(position).getCusName());
        holder.orderId.setText(recyclerNewOrdersList.get(position).getOrderId());
        holder.time .setText(recyclerNewOrdersList.get(position).getTime());
        holder.total.setText(recyclerNewOrdersList.get(position).getTotal());
        holder.message.setText(recyclerNewOrdersList.get(position).getMessage());

    }

    @Override
    public int getItemCount() {
        return recyclerNewOrdersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView cusName;
        TextView orderId;
        TextView time;
        TextView total;
        TextView message;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cusName = itemView.findViewById(R.id.tvCusName);
            orderId = itemView.findViewById(R.id.tvOrderid);
            time = itemView.findViewById(R.id.tvTime);
            total = itemView.findViewById(R.id.tvTotal);
            message = itemView.findViewById(R.id.tvMessage);

        }
    }
}
