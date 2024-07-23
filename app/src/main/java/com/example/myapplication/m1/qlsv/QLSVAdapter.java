package com.example.myapplication.m1.qlsv;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class QLSVAdapter extends ArrayAdapter<SinhVien> {
    Activity context;
    ArrayList<SinhVien> listSV;
    int layoutId;
    public QLSVAdapter(@NonNull Activity context, int resource, @NonNull ArrayList<SinhVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.listSV = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId,null);
        TextView tvInfo = convertView.findViewById(R.id.tv_info);
        SinhVien sv = listSV.get(position);
        tvInfo.setText(sv.toString());
        return convertView;
    }
}
