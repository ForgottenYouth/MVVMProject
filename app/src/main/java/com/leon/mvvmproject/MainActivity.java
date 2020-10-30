package com.leon.mvvmproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.leon.module_recyvleview.RecycleViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.mvvm_recyvleview) {
            Intent intent = new Intent(this, RecycleViewActivity.class);
            this.startActivity(intent);
        }
    }
}