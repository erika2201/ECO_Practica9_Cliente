package com.example.eco_practica9_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button juiceBtn, sandwichBtn, yogurtBtn, hotdogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        juiceBtn = findViewById(R.id.juiceBtn);
        sandwichBtn = findViewById(R.id.sandwichBtn);
        yogurtBtn = findViewById(R.id.yogurtBtn);
        hotdogBtn = findViewById(R.id.hotdogBtn);
    }
}