package com.example.team20;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.ActivityRentPageBinding;

public class RentPageActivity extends AppCompatActivity {
    private ActivityRentPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRentPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}
