package com.example.myapplication.m2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;

public class M2Activity extends AppCompatActivity {
    EditText edtTenBaoThuc;
    Spinner spinner;
    RadioGroup radThoiGian;
    RadioButton radSang;
    RadioButton radChieu;
    ListView lv;
    ArrayList<BaoThuc> baoThucArrayList;
    BaoThucAdapter adapter;
    Button btnTongKet;
    String tongKet = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2);

        edtTenBaoThuc = findViewById(R.id.edtTenBaoThuc);
        spinner = findViewById(R.id.spinner);
        radThoiGian = findViewById(R.id.radThoiGian);
        radSang = findViewById(R.id.radSang);
        radChieu = findViewById(R.id.radChieu);
        lv = findViewById(R.id.lv);
        btnTongKet = findViewById(R.id.btnTongKet);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWidget();
    }

    public void getWidget() {
        edtTenBaoThuc.requestFocus();
        radSang.setChecked(true);
        try {
            ArrayList<String> listThuDo = new ArrayList<>();
            ArrayAdapter<String> adapter;
            listThuDo.add("Thứ hai");
            listThuDo.add("Thứ ba");
            listThuDo.add("Thứ tư");
            listThuDo.add("Thứ năm");
            listThuDo.add("Thứ sáu");
            listThuDo.add("Thứ bảy");
            listThuDo.add("Chủ nhật");

            adapter = new ArrayAdapter<>(
                    M2Activity.this,
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listThuDo);
            adapter.setDropDownViewResource(
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemClickListener(((parent, view, position, id) -> {
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }

        baoThucArrayList = new ArrayList<>();
        baoThucArrayList.add(new BaoThuc("Học Toán", true, "Thứ hai"));
        baoThucArrayList.add(new BaoThuc("Học Văn", true, "Thứ ba"));
        baoThucArrayList.add(new BaoThuc("Học Lý", false, "Thứ hai"));
        baoThucArrayList.add(new BaoThuc("Học Hóa", true, "Thứ hai"));

        adapter = new BaoThucAdapter(this, R.layout.custom_layout, baoThucArrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) -> {
            BaoThuc baoThuc = baoThucArrayList.get(position);
            edtTenBaoThuc.setText(baoThuc.getTenBaoThuc());
            if (baoThuc.isThoiGian()) {
                radSang.setChecked(true);
            } else {
                radChieu.setChecked(true);
            }
            spinner.setSelection(getIndex(spinner, baoThuc.getNgayTrongTuan()));
        });

        lv.setOnItemLongClickListener((parent, view, position, id) -> {
            M2Activity.this.registerForContextMenu(lv);
            return false;
        });

        btnTongKet.setOnClickListener(view -> {
            tongKet = "Tổng số báo thức: " + baoThucArrayList.size() + "\n";
            int[] thu = {0, 0, 0, 0, 0, 0, 0};
            for (BaoThuc baoThuc : baoThucArrayList) {
                if (baoThuc.getNgayTrongTuan().equals("Thứ hai")) thu[0]++;
                if (baoThuc.getNgayTrongTuan().equals("Thứ ba")) thu[1]++;
                if (baoThuc.getNgayTrongTuan().equals("Thứ tư")) thu[2]++;
                if (baoThuc.getNgayTrongTuan().equals("Thứ năm")) thu[3]++;
                if (baoThuc.getNgayTrongTuan().equals("Thứ sáu")) thu[4]++;
                if (baoThuc.getNgayTrongTuan().equals("Thứ bảy")) thu[5]++;
                if (baoThuc.getNgayTrongTuan().equals("Chủ nhật")) thu[6]++;
            }
            int max = -10000;
            int vt = -1;
            for (int i = 0; i < thu.length; i++) {
                if (thu[i] > max) {
                    max = thu[i];
                    vt = i;
                }
            }
            tongKet = tongKet + "Ngày bị đặt báo thức nhiều nhất: Thứ " + (vt + 2);

//                startActivity(new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","0384722155","HEllo")));
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "0384722155", null));

            intent.putExtra("sms_body", tongKet);
            startActivity(intent);
        });
    }

    private int getIndex(Spinner spinner, String value) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).equals(value)) {
                return i;
            }
        }
        return 0;
    }

    //Xử lý Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuThem) {
            them();
            return true;
        } else if (id == R.id.menuThoat) {
            thoat();
            return true;
        } else if (id == R.id.menuGuiKQ) {
            guiKQ(tongKet);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void guiKQ(String msg) {
//        String thongtin = "Thông tin báo thức";
//        String phoneNumber = "0388074132";
//        // Kiểm tra dữ liệu nhập vào
//
//
//        // Tạo nội dung tin nhắn
//        String smsContent = thongtin;
//
//        // Tạo intent để gửi tin nhắn
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse(phoneNumber)); // Đặt số điện thoại cần gửi tin nhắn
//        intent.putExtra("sms_body", smsContent); // Đặt nội dung tin nhắn
//
//        // Kiểm tra xem có ứng dụng tin nhắn nào có sẵn để xử lý intent hay không
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent); // Mở ứng dụng tin nhắn
//        } else {
//            Toast.makeText(this, "Không tìm thấy ứng dụng tin nhắn", Toast.LENGTH_SHORT).show();
//        }
//        startActivity(new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","0384722155","HEllo")));

//        try{
//            Intent smsIntent = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","0384722155",null));
//            smsIntent.putExtra("sms_body",msg);
//            startActivity(smsIntent);
//        }catch (Exception e){
//            e.printStackTrace();
//
//        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "0384722155", null));

        intent.putExtra("sms_body", tongKet);
        startActivity(intent);
    }

    private void thoat() {
        finish();
    }

    private void them() {
        String ngayTrongTuan = spinner.getSelectedItem().toString();
        String tenBaoThuc = edtTenBaoThuc.getText().toString().trim();
        boolean thoiGian;
        thoiGian = radSang.isChecked();

        if (tenBaoThuc.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tên báo thức", Toast.LENGTH_SHORT).show();
            return;
        }

        baoThucArrayList.add(new BaoThuc(tenBaoThuc, thoiGian, ngayTrongTuan));
        adapter.notifyDataSetChanged();

        Toast.makeText(this, "Đã thêm sản phẩm mới", Toast.LENGTH_SHORT).show();
    }

    //Context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        assert info != null;
        int position = info.position;
        int id = item.getItemId();
        if (id == R.id.menuXoa) {
            xoa(position);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

    private void xoa(int position) {
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc chắn muốn xóa báo thức này?")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    baoThucArrayList.remove(position);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(M2Activity.this, "Đã xóa báo thức thành công", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}