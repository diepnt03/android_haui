package com.example.myapplication.bai4.bai48;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Bai48 extends AppCompatActivity {
    EditText editId, editName;
    Button btnNhap;
    RadioGroup radGroup;
    ListView lvNhanvien;
    ArrayList<Employee> arrEmployee = new ArrayList<>();
    ArrayAdapter<Employee> adapter = null;
    Employee employee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai48);

        editId = findViewById(R.id.edt_ma);
        editName = findViewById(R.id.edt_name);
        btnNhap = findViewById((R.id.btn_save));
        radGroup = findViewById((R.id.rad_loai_nv));
        lvNhanvien = findViewById((R.id.lv_nv));

        adapter = new Bai48Adapter(this, R.layout.item_bai48, arrEmployee);
        lvNhanvien.setAdapter(adapter);

        btnNhap.setOnClickListener(v -> {
            getInfo();
            adapter.notifyDataSetChanged();
        });
        lvNhanvien.setOnItemClickListener((parent, view, position, id) -> Log.e("TAG", "onItemClick: position : " + position + "; value =" + arrEmployee.get(position)));
    }

    void getInfo() {
        String id = editId.getText() + "";
        String ten = editName.getText() + "";

        String loaiNv = "";
        int result = radGroup.getCheckedRadioButtonId();
        if (result == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = (RadioButton) findViewById(result);
        loaiNv = rad.getText() + "";

        if (loaiNv.equals("Chinh thuc")) {
            employee = new EmployeeFullTime();
            employee.setId(id);
            employee.setName(ten);
        } else if (loaiNv.equals("Thoi vu")) {
            employee = new EmployeePartTime();
            employee.setId(id);
            employee.setName(ten);
        }
        arrEmployee.add(employee);
    }
}