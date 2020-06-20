package com.example.qrcodelabel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void create(View view) {
        Intent intent = new Intent(MainActivity.this, BuatActivity.class);
        startActivity(intent);
    }

    public void insert(View view) {
    }
}
