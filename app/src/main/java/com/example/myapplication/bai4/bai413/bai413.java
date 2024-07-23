package com.example.myapplication.bai4.bai413;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;

import java.util.ArrayList;

public class bai413 extends AppCompatActivity {
    RecyclerView recyclerView;
    StudentAdapter adapter;
    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai413);
        recyclerView = findViewById(R.id.studentsList);
        students = new ArrayList<>();
        students = getListStudent();

        adapter = new StudentAdapter(students, this);
        LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private ArrayList<Student> getListStudent() {
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(new Student("Student Name" + i, 2000 + (i % 2)));
        }
        return list;
    }
}