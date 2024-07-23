package com.example.myapplication.bai3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class bai31 extends AppCompatActivity {
    Button btnCong, btnTru, btnNhan, btnChia, btnDong;
    EditText editSoA, editSoB;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai31);
        getWidget();
        setAction();
    }

    private void getWidget() {
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnDong = findViewById(R.id.btnClose);
        editSoA = findViewById(R.id.editSoA);
        editSoB = findViewById(R.id.editSoB);
        txtKetQua = findViewById(R.id.txtKetQua);
    }

    private void setAction() {
        cong();
        tru();
        nhan();
        chia();
        close();
    }

    private void cong() {
        btnCong.setOnClickListener(v -> {
            Integer a = Integer.parseInt(String.valueOf(editSoA.getText()));
            Integer b = Integer.parseInt(String.valueOf(editSoB.getText()));
            txtKetQua.setText(String.valueOf(a+b));
        });
    }

    private void tru() {
        btnTru.setOnClickListener(v -> {
            Integer a = Integer.parseInt(String.valueOf(editSoA.getText()));
            Integer b = Integer.parseInt(String.valueOf(editSoB.getText()));
            txtKetQua.setText(String.valueOf(a-b));
        });
    }

    private void nhan() {
        btnNhan.setOnClickListener(v -> {
            Integer a = Integer.parseInt(String.valueOf(editSoA.getText()));
            Integer b = Integer.parseInt(String.valueOf(editSoB.getText()));
            txtKetQua.setText(String.valueOf(a*b));
        });
    }

    private void chia() {
        btnChia.setOnClickListener(v -> {
            int a = Integer.parseInt(String.valueOf(editSoA.getText()));
            int b = Integer.parseInt(String.valueOf(editSoB.getText()));
            if (b != 0) {
                txtKetQua.setText(String.valueOf((float) a /b));
            }
        });
    }

    private void close(){
        btnDong.setOnClickListener(v -> showDialog());
    }

    private void showDialog() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Dong");
        b.setMessage("Ban co chac chan muon dong khong!");
        b.setPositiveButton("OK", (dialog, which) -> {
            finish();
        });

        b.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.dismiss();
        });
        b.create().show();
    }
}