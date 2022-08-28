package com.example.team20;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.LoginInfo;
import com.example.team20.databinding.ActivityMainBinding;
import com.example.team20.retrofit.MemberApi;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

import java.io.IOException;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private retrofit2.Retrofit retrofit;
    private ActivityMainBinding binding;
    private ImageView imageView;
    private ActivityResultLauncher<Intent> resultLauncher;
    private Uri uri;
    private Bitmap bitmap;
    private MainBorrowedAdapter mainBorrowedAdapter;
    private MainBorrowingAdapter mainBorrowingAdapter;
    private MainMyItemAdapter mainMyItemAdapter;
    private ArrayList<MainData> my_item_arrayList;
    private ArrayList<MainData> borrowing_arrayList;
    private ArrayList<MainData> borrowed_arrayList;
    LoginInfo loginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://192.168.219.110:9000") //cmd 창에서 확인 가능 - ipv4 주소 :9000
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        MemberApi service = retrofit.create(MemberApi.class);

        imageView = binding.circleImgMyPage;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                resultLauncher.launch(intent);
            }
        });

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            uri = result.getData().getData();
                            try {
                                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                                imageView.setImageBitmap(bitmap);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

        Call<byte[]> memberCall = service.changeProfileImage(loginInfo.getCurrentMember(),bitmapToByteArray(bitmap));

        binding.nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_my_page:
                        Intent intent_my_page = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent_my_page);
                        break;
                    case R.id.item_borrow:
                        Intent intent_borrow = new Intent(MainActivity.this, RentPageActivity.class);
                        startActivity(intent_borrow);
                        break;
                    case R.id.item_registration:
                        Intent intent_registration = new Intent(MainActivity.this,RegisterActivity.class);
                        startActivity(intent_registration);
                        break;
                    case R.id.item_return:
                        Intent intent_return = new Intent(MainActivity.this,ReturnActivity.class);
                        startActivity(intent_return);
                        break;
                }
                return false;
            }
        });
//푸마 임의 프로필
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.profile);
//        byte[] byteArray = bitmapToByteArray(bitmap);

        my_item_arrayList = new ArrayList<>();

        borrowing_arrayList = new ArrayList<>();

        borrowed_arrayList = new ArrayList<>();

        mainMyItemAdapter = new MainMyItemAdapter(my_item_arrayList);
        binding.rcMyItem.setAdapter(mainMyItemAdapter);

        mainBorrowingAdapter = new MainBorrowingAdapter(borrowing_arrayList);
        binding.rcBorrowing.setAdapter(mainBorrowingAdapter);

        mainBorrowedAdapter = new MainBorrowedAdapter(borrowed_arrayList);
        binding.rcBorrowed.setAdapter(mainBorrowedAdapter);

    }
    public byte[] bitmapToByteArray(Bitmap bitmap) { //img>bitmap>byte[] 함수 필요
        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
        bitmap.compress( Bitmap.CompressFormat.JPEG, 100, stream) ;
        byte[] byteArray = stream.toByteArray() ;
        return byteArray ;
    }
}