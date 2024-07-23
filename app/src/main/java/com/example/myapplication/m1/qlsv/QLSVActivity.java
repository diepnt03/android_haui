package com.example.myapplication.m1.qlsv;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityQlsvactivityBinding;
import com.example.myapplication.m1.M1Activity;

import java.util.ArrayList;

public class QLSVActivity extends AppCompatActivity {
    ActivityQlsvactivityBinding binding;
    EditText hoTen;
    EditText queQuan;
    Spinner spnQueQuan;
    RadioGroup bangCap;
    CheckBox chkDocBao, chkDocSach, chkDocCode;
    Button guiThongTin;
    ListView lvSinhVien;
    ArrayList<SinhVien> listSV = new ArrayList<>();
    ArrayList<String> listQueQuan = new ArrayList<>();
    ArrayAdapter<SinhVien> adapter;
    ArrayAdapter<String> adapterThuDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_qlsvactivity);
        getWidget();
        setupView();
        setAction();
    }

    private void getWidget() {
        hoTen = binding.edtName;
        queQuan = binding.edtQueQuan;
        spnQueQuan = binding.spnQueQuan;
        bangCap = binding.radBangCap;
        chkDocBao = binding.chkDocBao;
        chkDocCode = binding.chkDocCode;
        chkDocSach = binding.chkDocSach;
        guiThongTin = binding.btnSubmit;
        lvSinhVien = binding.lvSv;
    }

    private void fakeData(){
        listQueQuan.add("Hà nội");
        listQueQuan.add("Hải Phòng");
        listQueQuan.add("Đà nẵng");
        listQueQuan.add("Huế");
        listQueQuan.add("Hồ Chí Minh");
        listQueQuan.add("Sơn La");
        listQueQuan.add("Thái Bình");
        adapterThuDo.notifyDataSetChanged();
    }

    private void setupView() {
        adapterThuDo = new ArrayAdapter<>(
                this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                listQueQuan);
        fakeData();
        adapterThuDo.setDropDownViewResource(
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spnQueQuan.setAdapter(adapterThuDo);
        spnQueQuan.setOnItemClickListener((parent, view, position, id) -> queQuan.setText(listQueQuan.get(position)));

        adapter = new QLSVAdapter(this, R.layout.item_sinhvien, listSV);
        lvSinhVien.setAdapter(adapter);
    }

    private void getInfo() {
        String name = hoTen.getText() + "";
        if (isNotValidData(name)) {
            showMessage("Ban chua nhap ten");
            hoTen.requestFocus();
            return;
        }

        String address = queQuan.getText() + "";
        if (isNotValidData(name)) {
            showMessage("Ban chua nhap que quan");
            queQuan.requestFocus();
            return;
        }

        int id = bangCap.getCheckedRadioButtonId();
        if (id == -1) {
            showMessage("Ban chua chon bang cap");
            return;
        }

        RadioButton radBangCap = findViewById(id);
        String degree = radBangCap.getText() + "";

        String hobby = "";
        if (chkDocBao.isChecked()) {
            hobby += chkDocBao.getText();
        } else if (chkDocSach.isChecked()) {
            hobby += chkDocSach.getText();
        } else if (chkDocCode.isChecked()) {
            hobby += chkDocCode.getText();
        }

        SinhVien sv = new SinhVien(name, address, degree, hobby);
        listSV.add(sv);
        adapter.notifyDataSetChanged();
    }

    private void setAction() {
        guiThongTin.setOnClickListener(v -> {
            getInfo();
            clearView();
        });

        lvSinhVien.setOnItemClickListener(((parent, view, position, id) ->
                showMessage(listSV.get(position).hoTen)));

        lvSinhVien.setOnItemLongClickListener(((parent, view, position, id) -> {
            hienThiDialog(position);
            return false;
        }));
    }

    private void hienThiDialog(int pos) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("xac nhan xoa");
        dialog.setPositiveButton("Xoa", ((dialog1, which) -> {
            listSV.remove(pos);
            adapter.notifyDataSetChanged();
            dialog1.dismiss();
        }));
        dialog.setMessage("Ban co chac chan muon xoa khong");
        dialog.create().show();
    }

    private void clearView() {
        hoTen.requestFocus();
        hoTen.setText("");
        queQuan.setText("");
        chkDocCode.setChecked(false);
        chkDocSach.setChecked(false);
        chkDocBao.setChecked(false);
    }

    private Boolean isNotValidData(String data) {
        return data.trim().isEmpty();
    }

    private void showMessage(String mess) {
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
    }
}