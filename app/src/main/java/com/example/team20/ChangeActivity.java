package com.example.team20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.ActivityChangeBinding;
import com.example.team20.databinding.ActivityJoinBinding;

public class ChangeActivity extends AppCompatActivity {

    private ActivityChangeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}