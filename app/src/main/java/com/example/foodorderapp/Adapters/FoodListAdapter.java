package com.example.foodorderapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodorderapp.DetailActivity;
import com.example.foodorderapp.Models.FoodListModel;
import com.example.foodorderapp.R;

import java.util.ArrayList;

public class FoodListAdapter  extends RecyclerView.Adapter<FoodListAdapter.viewHolder> {

    ArrayList<FoodListModel> FoodListAdapterlist ;
    Context FoodListAdaptercontext ;

    public FoodListAdapter(ArrayList<FoodListModel> list, Context context) {
        this.FoodListAdapterlist = list;
        this.FoodListAdaptercontext = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(FoodListAdaptercontext).inflate(R.layout.food_sample_ayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final FoodListModel model = FoodListAdapterlist.get(position);
        holder.FoodListAdapterImage.setImageResource(model.getFoodListModelPic());
        holder.FoodListAdapterName.setText(model.getFoodListModelName());
        holder.FoodListAdapterPrice.setText(model.getFoodListModelPrice());
        holder.FoodListAdapterDescription.setText(model.getFoodListModelDescription());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FoodListAdaptercontext, DetailActivity.class);
                intent.putExtra("image",model.getFoodListModelPic());
                intent.putExtra("price",model.getFoodListModelPrice());
                intent.putExtra("description",model.getFoodListModelDescription());
                intent.putExtra("name",model.getFoodListModelName());
                intent.putExtra("type",1);
                FoodListAdaptercontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return FoodListAdapterlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView FoodListAdapterImage;
        TextView FoodListAdapterName , FoodListAdapterPrice , FoodListAdapterDescription ;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            FoodListAdapterImage = itemView.findViewById(R.id.food_sample_image);
            FoodListAdapterName = itemView.findViewById(R.id.food_Sample_name);
            FoodListAdapterPrice = itemView.findViewById(R.id.food_sample_rprice);
            FoodListAdapterDescription = itemView.findViewById(R.id.food_sample_description);
        }
    }

}
