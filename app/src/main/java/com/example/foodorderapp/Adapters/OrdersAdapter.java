package com.example.foodorderapp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderapp.DBHelper;
import com.example.foodorderapp.DetailActivity;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder> {


    ArrayList<OrdersModel> OrderAdapterList;
    Context OrderAdapterContext;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.OrderAdapterList = list;
        this.OrderAdapterContext = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(OrderAdapterContext).inflate(R.layout.order_layout, parent , false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final OrdersModel model = OrderAdapterList.get(position);
        holder.OrderAdapterImage.setImageResource(model.getOrder_Model_Image());
        holder.OrderAdapterName.setText(model.getOrder_Model_Name());
        holder.OrderAdapterPrice.setText(model.getOrder_Model_Price());
        holder.OrderAdapterNumber.setText(model.getOrder_Model_Number());


        //updation part
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderAdapterContext, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(model.getOrder_Model_Number()));
                intent.putExtra("type",2);
                OrderAdapterContext.startActivity(intent);
            }
        });


        //deletion onlong click method
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                new AlertDialog.Builder(OrderAdapterContext)
                        .setTitle("Exit")
                        .setIcon(R.drawable.warning)
                        .setMessage("Are you sure you want to delete this item !!")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper helper = new DBHelper(OrderAdapterContext);
                                if(helper.deleteOrder(model.getOrder_Model_Number())>0){
                                    Toast.makeText(OrderAdapterContext, "Item is Deleted", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(OrderAdapterContext, "Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return OrderAdapterList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

       ImageView OrderAdapterImage;
       TextView OrderAdapterName , OrderAdapterPrice , OrderAdapterNumber;

       public viewHolder(@NonNull View itemView) {
           super(itemView);

           OrderAdapterImage = itemView.findViewById(R.id.order_layout_image);
           OrderAdapterName = itemView.findViewById(R.id.order_layout_name);
           OrderAdapterPrice = itemView.findViewById(R.id.order_layout_price);
           OrderAdapterNumber = itemView.findViewById(R.id.order_layout_number);

       }
   }



}
