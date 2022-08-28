package com.example.team20;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.AcitvityRegisterBinding;
import com.example.team20.databinding.ActivityChangeBinding;
import com.example.team20.databinding.ActivityJoinBinding;

import java.io.IOException;

public class ChangeActivity extends AppCompatActivity {
    private TwoDialog twoDialog;
    private ActivityChangeBinding binding;
    private ImageView imageView;
    private ActivityResultLauncher<Intent> resultLauncher;
    private Uri uri;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        imageView = binding.imgItem;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                resultLauncher.launch(intent);
            }
        });

        binding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoDialog = new TwoDialog(ChangeActivity.this,"고치시겠습니까?","확인","취소");
                twoDialog.show();
            }
        });

        binding.txtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                twoDialog = new TwoDialog(ChangeActivity.this,"버리시겠습니까?","확인","취소");
                twoDialog.show();
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

    }
}