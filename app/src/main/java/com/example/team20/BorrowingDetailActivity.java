package com.example.team20;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.ActivityBorrowingDetailBinding;

public class BorrowingDetailActivity extends AppCompatActivity {

    private @NonNull ActivityBorrowingDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBorrowingDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}