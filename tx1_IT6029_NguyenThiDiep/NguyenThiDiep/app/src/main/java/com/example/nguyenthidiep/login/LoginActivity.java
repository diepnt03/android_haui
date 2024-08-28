package com.example.nguyenthidiep.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.nguyenthidiep.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText edtName, edtPassword;
    Button btnLogin;
    ListView lvAccount;
    ArrayList<Account> listAcc = new ArrayList<>();
    ArrayAdapter<Account> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWidget();
        setupView();
        setAction();
    }

    private void getWidget() {
        edtName = findViewById(R.id.edt_name);
        edtPassword = findViewById(R.id.edt_pass_word);
        btnLogin = findViewById(R.id.btn_login);
        lvAccount = findViewById(R.id.lv_account);
    }

    private void setupView() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listAcc);
        lvAccount.setAdapter(adapter);
    }

    private void setAction(){
        btnLogin.setOnClickListener(v ->{
            handleLogin();
            resetView();
        });
    }

    private void handleLogin() {
        String name = edtName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (name.isEmpty()) {
            showMessage("Bạn chưa nhập tên đăng nhập");
            edtName.requestFocus();
        }

        if (password.isEmpty()) {
            showMessage("Bạn chưa nhập mật khẩu");
            edtPassword.requestFocus();
            return;
        }

        Account acc = new Account(name, password);
        listAcc.add(acc);
        adapter.notifyDataSetChanged();
        showMessage("Đăng nhập thành công");
    }

    private void resetView(){
        edtName.setText("");
        edtName.requestFocus();
        edtPassword.setText("");
    }

    private void showMessage(String mess) {
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
    }
}