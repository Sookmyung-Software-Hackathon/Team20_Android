package com.example.team20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.team20.databinding.ActivityReturnBinding;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ReturnActivity extends AppCompatActivity {

    private ActivityReturnBinding binding;
    private ReturnAdapter returnAdapter;
    private ArrayList<ReturnData> return_arrayList;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReturnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_my_page:
                        Intent intent_my_page = new Intent(ReturnActivity.this,MainActivity.class);
                        startActivity(intent_my_page);
                        break;
                    case R.id.item_borrow:
                        Intent intent_borrow = new Intent(ReturnActivity.this, RentPageActivity.class);
                        startActivity(intent_borrow);
                        break;
                    case R.id.item_registration:
                        Intent intent_registration = new Intent(ReturnActivity.this,RegisterActivity.class);
                        startActivity(intent_registration);
                        break;
                    case R.id.item_return:
                        Intent intent_return = new Intent(ReturnActivity.this,ReturnActivity.class);
                        startActivity(intent_return);
                        break;
                }
                return false;
            }
        });

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.profile);
        byte[] byteArray = bitmapToByteArray(bitmap);

        return_arrayList = new ArrayList<>();
        return_arrayList.add(new ReturnData("시도","10000",byteArray));
        return_arrayList.add(new ReturnData("시도2","20000",byteArray));
        return_arrayList.add(new ReturnData("시도3","30000",byteArray));
        return_arrayList.add(new ReturnData("시도4","40000",byteArray));
        return_arrayList.add(new ReturnData("시도5","10000",byteArray));
        return_arrayList.add(new ReturnData("시도6","20000",byteArray));
        return_arrayList.add(new ReturnData("시도7","30000",byteArray));
        return_arrayList.add(new ReturnData("시도8","40000",byteArray));

        returnAdapter = new ReturnAdapter(return_arrayList);
        binding.rcItemsList.setAdapter(returnAdapter);
        linearLayoutManager = new LinearLayoutManager(this);
        binding.rcItemsList.setLayoutManager(linearLayoutManager);
    }
    public byte[] bitmapToByteArray(Bitmap bitmap) { //img>bitmap>byte[] 함수 필요
        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
        bitmap.compress( Bitmap.CompressFormat.JPEG, 100, stream) ;
        byte[] byteArray = stream.toByteArray() ;
        return byteArray ;
    }
}
