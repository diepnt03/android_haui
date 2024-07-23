package com.example.myapplication.bai3.tuybienlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class TuyBienListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuy_bien_list_view);
        ListView lvNhanVien = findViewById(R.id.lv_employee);
        ArrayList<Employee> myArr = new ArrayList<>();
        myArr.add(new Employee("1","Ngueyn a",false));
        myArr.add(new Employee("2","Ngueyn b",true));
        myArr.add(new Employee("3","Ngueyn c",false));
        myArr.add(new Employee("4","Ngueyn d",false));
        myArr.add(new Employee("5","Ngueyn e",false));
        myArr.add(new Employee("6","Ngueyn f",true));
        myArr.add(new Employee("7","Ngueyn g",true));
        myArr.add(new Employee("8","Ngueyn h",false));
        myArr.add(new Employee("9","Ngueyn i",true));
        MyArrayAdapter adapter = new MyArrayAdapter(this,R.layout.item_nhanvien,myArr);
        lvNhanVien.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}