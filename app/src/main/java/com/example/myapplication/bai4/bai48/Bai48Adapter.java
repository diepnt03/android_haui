package com.example.myapplication.bai4.bai48;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.myapplication.R;
import java.util.ArrayList;

public class Bai48Adapter extends ArrayAdapter<Employee> {

    Activity context;
    ArrayList<Employee> myArr;
    int layoutId;
    public Bai48Adapter(@NonNull Activity context, int resource, ArrayList<Employee> arr) {
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
        TextView tvMaNV = convertView.findViewById(R.id.tv_ma_nv);
        TextView loaiNV = convertView.findViewById(R.id.tv_loai_nv);
        TextView tvTenNV = convertView.findViewById(R.id.tv_ten_nv);
        TextView tvLuong = convertView.findViewById(R.id.tv_tien_luong);
        Employee emp = myArr.get(position);
        tvMaNV.setText(emp.getId());
        tvTenNV.setText(emp.getName());
        tvLuong.setText((int) emp.tinhLuong() + "");
        if((int)emp.tinhLuong() == 150){
            loaiNV.setText("Thoi vu");
        }else if((int)emp.tinhLuong() == 500){
            loaiNV.setText("Chinh thuc");
        }
        return convertView;
    }
}
