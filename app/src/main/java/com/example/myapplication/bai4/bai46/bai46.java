package com.example.myapplication.bai4.bai46;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityBai46Binding;

import java.util.ArrayList;

public class bai46 extends AppCompatActivity {
    EditText editId, editName;
    Button btnNhap;
    RadioGroup radGroup;
    ListView lvNhanvien;
    ArrayList<Employee> arrEmployee = new ArrayList<>();
    ArrayAdapter<Employee> adapter = null;
    Employee employee = null;
    ActivityBai46Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bai46);
        getWidget();
        setAction();
    }

    private void getWidget() {
        editId = findViewById(R.id.edt_ma);
        editName = findViewById(R.id.edt_name);
        btnNhap = findViewById((R.id.btn_save));
        radGroup = findViewById((R.id.rad_loai_nv));
        lvNhanvien = findViewById((R.id.lv_nv));
    }

    void getInfo() {
        String id = editId.getText() + "";
        String ten = editName.getText() + "";

        String loaiNv = "";
        int result = radGroup.getCheckedRadioButtonId();
        if (result == -1) {
            showMessage("Phải chọn bằng cấp");
            return;
        }
        RadioButton rad = findViewById(result);
        loaiNv = rad.getText() + "";

        employee.setId(id);
        employee.setName(ten);
        if (loaiNv.equals("Chinh thuc")) {
            employee = new EmployeeFullTime();
        } else if (loaiNv.equals("Thoi vu")) {
            employee = new EmployeePartTime();
        }
        arrEmployee.add(employee);
    }

    private void setAction() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrEmployee);
        lvNhanvien.setAdapter(adapter);
        btnNhap.setOnClickListener(v -> {
            getInfo();
            adapter.notifyDataSetChanged();
        });
        lvNhanvien.setOnItemClickListener((parent, view, position, id) -> Log.e("TAG", "onItemClick: position : " + position + "; value =" + arrEmployee.get(position)));
    }

    private void showMessage(String mess) {
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
    }
}