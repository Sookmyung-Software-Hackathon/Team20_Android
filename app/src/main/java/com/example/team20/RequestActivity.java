package com.example.team20;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.AcitvityRegisterBinding;
import com.example.team20.databinding.ActivityChangeBinding;
import com.example.team20.databinding.ActivityJoinBinding;
import com.example.team20.databinding.ActivityRequestBinding;

import java.io.IOException;

public class RequestActivity extends AppCompatActivity {
    private OneDialog oneDialog;
    private ActivityRequestBinding binding;
    private ImageView imageView;
    private ActivityResultLauncher<Intent> resultLauncher;
    private Uri uri;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.8f;
        getWindow().setAttributes(layoutParams);

        binding.btnRequestFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oneDialog = new OneDialog(RequestActivity.this,"등록합니다","확인");
                oneDialog.show();
                Intent intent = new Intent(RequestActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
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