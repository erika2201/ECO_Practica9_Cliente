package com.example.eco_practica9_cliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.gson.Gson;

import model.Order;

public class MainActivity extends AppCompatActivity {

    private Button juiceBtn, sandwichBtn, yogurtBtn, hotdogBtn;
    private UDPConection UDP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        juiceBtn = findViewById(R.id.juiceBtn);
        sandwichBtn = findViewById(R.id.sandwichBtn);
        yogurtBtn = findViewById(R.id.yogurtBtn);
        hotdogBtn = findViewById(R.id.hotdogBtn);

        UDP = new UDPConection();
        UDP.start();
        item();

    }


    protected void item(){
        juiceBtn.setOnClickListener(
                (v) ->{
                    Order order = new Order("JUICE");
                    Gson gson = new Gson();
                    String json = gson.toJson(order);
                    UDP.sendMessage(json);
                });

        sandwichBtn.setOnClickListener(
                (v) ->{
                    Order order = new Order("SANDWICH");
                    Gson gson = new Gson();
                    String json = gson.toJson(order);
                    UDP.sendMessage(json);
                });

        yogurtBtn.setOnClickListener(
                (v) ->{
                    Order order = new Order("YOGURT");
                    Gson gson = new Gson();
                    String json = gson.toJson(order);
                    UDP.sendMessage(json);
                });

        hotdogBtn.setOnClickListener(
                (v) ->{
                    Order order = new Order("HOTDOG");
                    Gson gson = new Gson();
                    String json = gson.toJson(order);
                    UDP.sendMessage(json);
                });
    }
}