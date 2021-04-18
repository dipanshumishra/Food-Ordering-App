package com.example.foodorderapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.foodorderapp.Adapters.FoodListAdapter;
import com.example.foodorderapp.Models.FoodListModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayList<FoodListModel> list = new ArrayList<>();


        list.add(new FoodListModel(R.drawable.pizza,"Pizza","4","Best Taste of it in the town"));
        list.add(new FoodListModel(R.drawable.springrolls,"Spring Rolls","5","Gonna addicted of this,the must try"));
        list.add(new FoodListModel(R.drawable.nachos,"Nachos","5","New dish in the town"));
        list.add(new FoodListModel(R.drawable.masalamaggie,"french Fries Maggie","5","Get your favourite dish with extra masala"));
        list.add(new FoodListModel(R.drawable.dosa,"Dosa","5","do you love south dishes ?? then go for it"));
        list.add(new FoodListModel(R.drawable.chai,"Chai","5","No one says no for it "));
        list.add(new FoodListModel(R.drawable.icecream,"Ice-Cream","5","Go for it , New flavours with  the best taste"));

        FoodListAdapter adapter = new FoodListAdapter(list,this);
       binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.ordersToolbar:
                startActivity(new Intent(MainActivity.this,orderActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    //Complete dialoge box code
    @Override
    public void onBackPressed() {
           new AlertDialog.Builder(MainActivity.this)
                   .setTitle("Exit")
                   .setIcon(R.drawable.warning)
                   .setMessage("Are you sure you want to exit !!")
                   .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                            finish();
                       }
                   })
                   .setNeutralButton("Help", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           Toast.makeText(MainActivity.this, "Soon you will be contacted by us !!", Toast.LENGTH_SHORT).show();
                       }
                   })
                   .setNegativeButton("No", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           dialog.cancel();
                       }
                   }).show();
    }
}





