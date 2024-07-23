package com.example.myapplication.bai5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.myapplication.R;

public class Bai51 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai51);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.add) {
            newAdd();
            return true;
        } else if (itemId == R.id.exit) {
            Exit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void Exit() {
        Log.e("TAG", "onOptionsItemSelected Exit: ");
    }

    private void newAdd() {
        Log.e("TAG", "onOptionsItemSelected newAdd: ");
    }
}