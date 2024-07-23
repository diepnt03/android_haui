package com.example.myapplication.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ArrayList<String> arrList = null;
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView lv = findViewById(R.id.lvperson);
        arrList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adapter);
        arrList.add("Hà nội");
        arrList.add("Sài gòn");
        arrList.add("Sài gòn");
        arrList.add("Sài gòn");
        arrList.add("Sài gòn");
        arrList.add("Sài gòn");
        arrList.add("Sài gòn");
        arrList.add("Huế");
        arrList.add("Huế");
        arrList.add("Huế");
        arrList.add("Huế");
        arrList.add("Huế");
        arrList.add("Hải Phòng");
        arrList.add("Hải Phòng");
        arrList.add("Hải Phòng");
        arrList.add("Hải Phòng");
        arrList.add("Hải Phòng");
        arrList.add("Hải Phòng");
        arrList.add("Hải Phòng");
        arrList.add("Hải Phòng");
        arrList.add("Hải Phòng");
        adapter.notifyDataSetChanged();

        lv.setOnItemClickListener((parent, view, position, id) -> Log.e("TAG", "onItemClick: position : " + position + "; value =" + arrList.get(position)));
    }
}