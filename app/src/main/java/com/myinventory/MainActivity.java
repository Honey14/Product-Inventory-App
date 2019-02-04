package com.myinventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
//    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        toolbar = findViewById(R.id.toolbar);
//        Objects.requireNonNull(getSupportActionBar()).setTitle("Product Inventory");
//        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));

    }
}
