package com.example.team20;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.ActivityReturnBinding;

public class ReturnActivity extends AppCompatActivity {
    private ActivityReturnBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReturnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
