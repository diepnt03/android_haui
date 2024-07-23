package com.example.myapplication.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityBai44Binding;

public class bai44Activity extends AppCompatActivity {
    ActivityBai44Binding binding;
    EditText editTen, editCMND, editBoSung;
    CheckBox chkDocBao, chkDocSach, chkDocCode;
    Button btnGuiTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bai44);
        getWidget();
        btnGuiTT.setOnClickListener(v -> doShowInformation());
    }

    public void getWidget() {
        editTen = findViewById(R.id.edt_name);
        editCMND = findViewById(R.id.edt_id);
        editBoSung = findViewById(R.id.edt_ttbs);
        chkDocBao = findViewById(R.id.chk_doc_bao);
        chkDocSach = findViewById(R.id.chk_doc_sach);
        chkDocCode = findViewById(R.id.chk_doc_code);
        btnGuiTT = findViewById(R.id.btn_submit);
    }

    public void doShowInformation() {
        String ten = editTen.getText() + "";
        ten = ten.trim();
        if (ten.length() < 3) {
            editTen.requestFocus();
            editTen.selectAll();
            showMessage("Tên phải lớn hơn 3 ký tự");
            return;
        }
        String cmnd = editCMND.getText() + "";
        cmnd = cmnd.trim();
        if (cmnd.length() != 9) {
            editCMND.requestFocus();
            editCMND.selectAll();
            showMessage("CMND phải đúng 9 ký tự");
            return;
        }
        String bangCap = "";
        RadioGroup group = binding.radBangCap;
        int id = group.getCheckedRadioButtonId();
        if (id == -1) {
            showMessage("Phải chọn bằng cấp");
            return;
        }
        RadioButton rad = findViewById(id);
        bangCap = rad.getText() + "";
        String soThich = "";
        if (chkDocBao.isChecked())
            soThich += chkDocBao.getText() + "\n";
        if (chkDocSach.isChecked())
            soThich += chkDocSach.getText() + "\n";
        if (chkDocCode.isChecked())
            soThich += chkDocCode.getText() + "\n";
        String boSung = editBoSung.getText() + "";

        String msg = ten + "\n";
        msg += cmnd + "\n";
        msg += bangCap + "\n";
        msg += soThich + "\n";
        msg += "-------------------------------\n";
        msg += "Thông tin bổ sung\n";
        msg += boSung + "\n";
        msg += "-------------------------------\n";
        showDialog(msg);
    }

    private void showDialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", (dialog, which) -> dialog.cancel());
        builder.setMessage(msg);
        builder.create().show();
    }

    private void showMessage(String mess){
        Toast.makeText(this,mess,Toast.LENGTH_LONG).show();
    }
}