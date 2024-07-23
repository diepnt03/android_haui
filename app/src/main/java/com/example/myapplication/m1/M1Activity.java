package com.example.myapplication.m1;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityM1Binding;

import java.util.ArrayList;
import java.util.List;

public class M1Activity extends AppCompatActivity {
    EditText edtTen, edtNoiDen;
    RadioGroup radGioiTinh;
    RadioButton radNam, radNu;
    Button btnXoa, btnThem, btnTongKet;
    CheckBox cbGame, cbNgheNhac, cbDocSach, cbLapTrinh;

    TextView txtSoLanNhap;
    List<Integer> list = new ArrayList<>();
    int dem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_m1);

        ActivityM1Binding binding = DataBindingUtil.setContentView(this,R.layout.activity_m1);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWidget();
        doWork();
        Display();
    }

    public void getWidget() {
        edtTen = findViewById(R.id.edtTen);
        edtNoiDen = findViewById(R.id.edtNoiDen);
        cbGame = findViewById(R.id.cbGame);
        cbNgheNhac = findViewById(R.id.cbNgheNhac);
        cbDocSach = findViewById(R.id.cbDocSach);
        cbLapTrinh = findViewById(R.id.cbLapTrinh);
        radGioiTinh = findViewById(R.id.radGioiTinh);
        radNam = findViewById(R.id.radNam);
        radNu = findViewById(R.id.radNu);
        txtSoLanNhap = findViewById(R.id.txtSoLanNhap);
        btnXoa = findViewById(R.id.btnXoa);
        btnThem = findViewById(R.id.btnThem);
        btnTongKet = findViewById(R.id.btnTongKet);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        edtTen.requestFocus();
        edtNoiDen.setText("Hà Nội");
        txtSoLanNhap.setText(dem + "");
    }

    public void doWork() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTen.requestFocus();
                edtNoiDen.setText("Hà Nội");
                radNu.setChecked(true);
                cbGame.setChecked(false);
                cbDocSach.setChecked(false);
                cbLapTrinh.setChecked(false);
                cbNgheNhac.setChecked(false);
                dem = 0;
                txtSoLanNhap.setText(dem + "");
                list.set(0, 0);
                list.set(1, 0);
                list.set(2, 0);
                list.set(3, 0);

            }
        });

        btnThem.setOnClickListener(view -> {

            if (edtTen.getText().toString().length() == 0) {
                Toast.makeText(M1Activity.this, "Bạn chưa nhập tên", Toast.LENGTH_LONG).show();
                return;
            }
            if (edtNoiDen.getText().toString().length() == 0) {
                Toast.makeText(M1Activity.this, "Bạn chưa chọn nơi đến", Toast.LENGTH_LONG).show();
                return;
            }
            if (!cbGame.isChecked() && !cbNgheNhac.isChecked() && !cbDocSach.isChecked() && !cbLapTrinh.isChecked()) {
                Toast.makeText(M1Activity.this, "Chọn ít nhất một sở thích", Toast.LENGTH_LONG).show();
                return;
            }
            if (cbGame.isChecked()) {
                int val = list.get(0);
                list.set(0, val + 1);
            }
            if (cbNgheNhac.isChecked()) {
                int val = list.get(1);
                list.set(1, val + 1);
            }
            if (cbDocSach.isChecked()) {
                int val = list.get(2);
                list.set(2, val + 1);
            }
            if (cbLapTrinh.isChecked()) {
                int val = list.get(3);
                list.set(3, val + 1);
            }
            dem = dem + 1;
            txtSoLanNhap.setText(dem + "");
        });
        try {
            Spinner spinThuDo;
            ArrayList<String> listThuDo = new ArrayList<>();
            ArrayAdapter<String> adapter = null;
            //chuẩn bị dữ liệu
            listThuDo.add("Hà nội");
            listThuDo.add("Hải Phòng");
            listThuDo.add("Đà nẵng");
            listThuDo.add("Huế");
            listThuDo.add("Hồ Chí Minh");
            listThuDo.add("Sơn La");
            listThuDo.add("Thái Bình");

            //lấy điều khiển
            spinThuDo = findViewById(R.id.spinner);

            //set adapter
            adapter = new ArrayAdapter<>(
                    M1Activity.this,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listThuDo);
            adapter.setDropDownViewResource(
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            spinThuDo.setAdapter(adapter);

            //gán sự kiện cho spiner
            spinThuDo.setOnItemSelectedListener(
                    new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent,
                                                   View view, int position, long id) {
                            edtNoiDen.setText(listThuDo.get(position));
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void Display() {
        btnTongKet.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(M1Activity.this);
            builder.setTitle("Thông báo");
            builder.setPositiveButton("Đóng", (dialogInterface, i) -> dialogInterface.cancel());
            int min = 100000, max = -10000;
            for (int i = 0; i <= 3; i++) {
                if (list.get(i) > max) max = list.get(i);
                if (list.get(i) < min) min = list.get(i);
            }
            String s1 = "Sở thích chọn nhiều nhất: ";
            String s2 = "Sở thích chọn ít nhất: ";

            if (max == 0) {
                builder.setMessage("Không có sở thích nào được chọn");
            } else {
                for (int i = 0; i <= 3; i++) {
                    if (list.get(i) == max) {
                        if (i == 0) {
                            s1 += "Game, ";
                        } else if (i == 1) {
                            s1 += "Nghe Nhac, ";
                        } else if (i == 2) {
                            s1 += "Đọc Sách, ";
                        } else {
                            s1 += "Lập trình, ";
                        }
                    }
                    if (list.get(i) == min) {
                        if (i == 0) {
                            s2 += "Game, ";
                        } else if (i == 1) {
                            s2 += "Nghe Nhac, ";
                        } else if (i == 2) {
                            s2 += "Đọc Sách, ";
                        } else {
                            s2 += "Lập trình, ";
                        }
                    }
                }
                s1 = s1.substring(0, s1.length() - 2);
                s2 = s2.substring(0, s2.length() - 2);

                String msg = s1 + "\n" + s2;

                builder.setMessage(msg);
            }

            builder.create().show();
        });
    }
}