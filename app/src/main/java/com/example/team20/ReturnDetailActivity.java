package com.example.team20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.ActivityReturnDetailBinding;
import com.google.android.material.navigation.NavigationView;

public class ReturnDetailActivity extends AppCompatActivity {
    private TwoDialog twoDialog;
    private ActivityReturnDetailBinding binding;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReturnDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);

        binding.btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoDialog = new TwoDialog(ReturnDetailActivity.this,"반납하시겠습니까?","확인","취소");
                twoDialog.show();
                Intent intent = new Intent(ReturnDetailActivity.this, ReturnActivity.class);
                startActivity(intent);
                finish();
            }
        });


        binding.nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_my_page:
                        Intent intent_my_page = new Intent(ReturnDetailActivity.this,MainActivity.class);
                        startActivity(intent_my_page);
                        break;
                    case R.id.item_borrow:
                        Intent intent_borrow = new Intent(ReturnDetailActivity.this, RentPageActivity.class);
                        startActivity(intent_borrow);
                        break;
                    case R.id.item_registration:
                        Intent intent_registration = new Intent(ReturnDetailActivity.this,RegisterActivity.class);
                        startActivity(intent_registration);
                        break;
                    case R.id.item_return:
                        Intent intent_return = new Intent(ReturnDetailActivity.this,ReturnActivity.class);
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
