package com.example.myapplication.bai3.tuybienlistview;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Employee> {
    Activity context = null;
    ArrayList<Employee> myArr = null;
    int layoutId;
    public MyArrayAdapter(@NonNull Activity context, int resource, ArrayList<Employee> arr) {
        super(context, resource, arr);
        this.context = context;
        this.layoutId = resource;
        this.myArr = arr;
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        Log.e("TAG", "getView: layoutId " + layoutId);
        TextView txtDisplay = convertView.findViewById(R.id.txt_item);
        Log.e("TAG", "getView: txtDisplay " + txtDisplay);
        Employee emp = myArr.get(position);
        txtDisplay.setText(emp.toString());
        ImageView imgItem = convertView.findViewById(R.id.img_item);
        if(emp.isGender()) imgItem.setImageResource(R.drawable.meocon);
        else imgItem.setImageResource(R.drawable.ic_camera_ezviz);
        return convertView;
    }
}
