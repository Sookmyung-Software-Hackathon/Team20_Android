package com.example.team20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.team20.databinding.AcitvityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private AcitvityRegisterBinding binding;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AcitvityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

}
