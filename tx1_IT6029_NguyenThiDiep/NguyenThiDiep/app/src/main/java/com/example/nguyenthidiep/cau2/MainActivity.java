package com.example.nguyenthidiep.cau2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nguyenthidiep.R;
import com.example.nguyenthidiep.login.Account;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtTenSach, edtSoLuongSach;
    Button btnThem, btnSua, btnXoa;
    ListView lvSach;
    ArrayList<Sach> listSach = new ArrayList<>();
    ArrayAdapter<Sach> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        setupView();
        setAction();
    }

    private void getWidget() {
        edtTenSach = findViewById(R.id.edt_ten_sach);
        edtSoLuongSach = findViewById(R.id.edt_so_luong);
        btnThem = findViewById(R.id.btn_them);
        btnSua = findViewById(R.id.btn_sua);
        btnXoa = findViewById(R.id.btn_xoa);
        lvSach = findViewById(R.id.lv_sach);
    }

    private void setupView() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listSach);
        lvSach.setAdapter(adapter);
    }

    private void setAction() {
        lvSach.setOnItemClickListener(((parent, view, position, id) -> {
            Sach item = listSach.get(position);
            edtTenSach.setText(item.getTenSach());
            edtSoLuongSach.setText(item.getSoLuong());
            btnSua.setOnClickListener(v -> sua(position));
            btnXoa.setOnClickListener(v -> xoa(position));
        }));
        btnThem.setOnClickListener(v -> {
            them();
            resetView();
        });

    }

    private void them() {
        String tenSach = edtTenSach.getText().toString().trim();
        String soLuongSach = edtSoLuongSach.getText().toString().trim();

        if (tenSach.isEmpty()) {
            showMessage("Bạn chưa nhập tên sách");
            return;
        }

        if (soLuongSach.isEmpty()) {
            showMessage("Bạn chưa nhập số lượng sách");
            return;
        }

        Sach sach = new Sach(tenSach, soLuongSach);
        listSach.add(sach);
        adapter.notifyDataSetChanged();
        showMessage("Thêm thành công");
    }

    private void sua(int pos) {
        String tenSach = edtTenSach.getText().toString().trim();
        String soLuongSach = edtSoLuongSach.getText().toString().trim();
        if (tenSach.isEmpty()) {
            showMessage("Bạn chưa nhập tên sách");
            return;
        }

        if (soLuongSach.isEmpty()) {
            showMessage("Bạn chưa nhập số lượng sách");
            return;
        }

        Sach sach = new Sach(tenSach, soLuongSach);
        listSach.set(pos, sach);
        adapter.notifyDataSetChanged();
        showMessage("Sửa thành công");
    }

    private void xoa(int pos) {
        listSach.remove(pos);
        adapter.notifyDataSetChanged();
        showMessage("Xóa thành công");
    }

    private void showMessage(String mess) {
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
    }

    private void resetView() {
        edtTenSach.setText("");
        edtTenSach.requestFocus();
        edtSoLuongSach.setText("");
    }
}