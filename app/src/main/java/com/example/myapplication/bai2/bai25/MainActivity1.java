package com.example.myapplication.bai2.bai25;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity1 extends AppCompatActivity {
    final String TAG = "MainActivity Lifecycle";
    Button btnSub1, btnSub2, btnCls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        btnSub1 = findViewById(R.id.btn_sub1);
        btnSub2 = findViewById(R.id.btn_sub2);
        btnCls = findViewById(R.id.btn_close);

        btnCls.setOnClickListener(v -> finish());
        btnSub1.setOnClickListener(v -> {
            Intent intent1 = new Intent(MainActivity1.this, SubActivity1.class);
            startActivity(intent1);
        });
        btnSub2.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity1.this, SubActivity2.class);
            startActivity(intent2);
        });
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "đang gọi tới  MainActivity.onRestart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "===== onRestart =====");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "===== onStart =====");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "===== onResume =====");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "===== onPause =====");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "===== onStop =====");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "===== onDestroy =====");
    }
}