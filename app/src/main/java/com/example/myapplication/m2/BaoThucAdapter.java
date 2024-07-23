package com.example.myapplication.m2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class BaoThucAdapter extends ArrayAdapter<BaoThuc> {
    private Context mContext;
    private int mResource;

    public BaoThucAdapter(Context context, int resource, ArrayList<BaoThuc> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Lấy thông tin sản phẩm ở vị trí position
        BaoThuc baoThuc = getItem(position);

        // Khởi tạo LayoutInflater cho layout inflater
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        // Ánh xạ các thành phần trong layout của mỗi hàng
        TextView txtThongTin = convertView.findViewById(R.id.txtThongTin);

        // Thiết lập dữ liệu cho các thành phần
        String thoiGian;
        if(baoThuc.isThoiGian()){
            thoiGian = "Sáng";
        }else{
            thoiGian = "Chiều";
        }
        txtThongTin.setText(baoThuc.getTenBaoThuc() + " - " + thoiGian + " - " + baoThuc.getNgayTrongTuan());

        return convertView;
    }
}

