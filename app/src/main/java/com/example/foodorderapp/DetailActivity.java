package com.example.foodorderapp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

   ActivityDetailBinding binding;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        final DBHelper helper = new DBHelper(this);

        if(getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");


            binding.activitydetailimage.setImageResource(image);
            binding.activitydetailprice.setText(String.format("%d", price));
            binding.activitydetailfoodname.setText(name);
            binding.activitydetaildescription.setText(description);


            binding.activitydetailorderbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = helper.insertOrder(
                            binding.activitydetailpersonname.getText().toString(),
                            binding.activitydetailphonenumber.getText().toString(),
                            price,
                            image,
                            description,
                            name,
                            Integer.parseInt(binding.activitydetailquantity.getText().toString())
                    );


                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "data Successfull", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } //if condition loop terminates here

        else{

            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);

            int image =cursor.getInt(2);
            binding.activitydetailimage.setImageResource(image);
            binding.activitydetailprice.setText(String.format("%d", cursor.getInt(3)));
            binding.activitydetailfoodname.setText(cursor.getString(7));
            binding.activitydetaildescription.setText(cursor.getString(6));

            binding.activitydetailpersonname.setText(cursor.getString(1));
            binding.activitydetailphonenumber.setText(cursor.getString(4));
            binding.activitydetailorderbtn.setText("Update Now");
            binding.activitydetailorderbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   boolean isUpdated =  helper.updateOrder(
                            binding.activitydetailpersonname.getText().toString(),
                            binding.activitydetailphonenumber.getText().toString(),
                            Integer.parseInt(binding.activitydetailprice.getText().toString()),
                            image,
                            binding.activitydetaildescription.getText().toString(),
                            binding.activitydetailfoodname.getText().toString(),
                            4,
                            id);

                    if(isUpdated)
                    {
                        Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(DetailActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}


//