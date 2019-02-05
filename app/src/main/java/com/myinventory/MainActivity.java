package com.myinventory;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Fragment nav_host_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        nav_host_fragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        // NAC getting title into toolbar from label attribute
        NavigationUI.setupActionBarWithNavController(this, NavHostFragment.findNavController(nav_host_fragment));

    }

    @Override
    public boolean onSupportNavigateUp() {
        // toolbar back button navigate from fragments in NAC
        NavHostFragment.findNavController(nav_host_fragment).navigateUp();
        return super.onSupportNavigateUp();
    }
}
