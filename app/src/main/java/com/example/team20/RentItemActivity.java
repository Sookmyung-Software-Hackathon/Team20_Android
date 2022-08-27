package com.example.team20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.ActivityRentItemBinding;
import com.google.android.material.navigation.NavigationView;

public class RentItemActivity extends AppCompatActivity {
    private ActivityRentItemBinding binding;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRentItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RentItemActivity.this, RequestActivity.class);
                startActivity(intent);
            }
        });

        binding.nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_my_page:
                        Intent intent_my_page = new Intent(RentItemActivity.this,MainActivity.class);
                        startActivity(intent_my_page);
                        break;
                    case R.id.item_borrow:
                        Intent intent_borrow = new Intent(RentItemActivity.this, RentPageActivity.class);
                        startActivity(intent_borrow);
                        break;
                    case R.id.item_registration:
                        Intent intent_registration = new Intent(RentItemActivity.this,RegisterActivity.class);
                        startActivity(intent_registration);
                        break;
                    case R.id.item_return:
                        Intent intent_return = new Intent(RentItemActivity.this,ReturnActivity.class);
                        startActivity(intent_return);
                        break;
                }
                return false;
            }
        });

        Intent intent_data = getIntent();
        String name = intent_data.getStringExtra("이름");
        byte[] img = intent_data.getByteArrayExtra("사진");
        String price = intent_data.getStringExtra("금액");
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);

        binding.txtMyItemName.setText(name);
        binding.imgItem.setImageBitmap(bitmap);
        binding.txtPriceRent.setText(price);
    }

}
