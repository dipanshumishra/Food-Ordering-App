package com.example.foodorderapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodorderapp.Adapters.OrdersAdapter;
import com.example.foodorderapp.Models.OrdersModel;
import com.example.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class orderActivity extends AppCompatActivity {

   ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



      DBHelper helper = new DBHelper(this);
      ArrayList<OrdersModel> list = helper.getorders();



//        list.add(new OrdersModel(R.drawable.pizza ,"Pizza","5","11312001"));
//        list.add(new OrdersModel(R.drawable.springrolls ,"Spring Rolls","5","11312001"));
//        list.add(new OrdersModel(R.drawable.nachos ,"Nachos","5","11312001"));
//        list.add(new OrdersModel(R.drawable.masalamaggie,"Masala Maggie","5","11312001"));
//        list.add(new OrdersModel(R.drawable.dosa ,"Dosa","5","11312001"));
//        list.add(new OrdersModel(R.drawable.chai ,"Chai","5","11312001"));
//        list.add(new OrdersModel(R.drawable.icecream ,"Ice-Cream","5","11312001"));


        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.ordersRecyclerView.setAdapter(adapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
       binding.ordersRecyclerView.setLayoutManager(layoutManager);
    }
}