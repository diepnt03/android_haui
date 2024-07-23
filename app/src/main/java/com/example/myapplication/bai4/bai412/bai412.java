package com.example.myapplication.bai4.bai412;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class bai412 extends AppCompatActivity {
    TextView txtDate, txtTime;
    EditText editCv, editNd;
    Button btnDate, btnTime, btnAdd;
    ArrayList<JobInWeek> arrJob = new ArrayList<>();
    ArrayAdapter<JobInWeek> adapter = null;
    ListView lvCv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai412);
        getDefaultInfor();
        getFormWidgets();
        addEventFormWidgets();
    }

    private void getFormWidgets() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrJob);
        lvCv.setAdapter(adapter);
    }

    private void getDefaultInfor() {
        txtDate = findViewById(R.id.tv_ngay_ht);
        txtTime = findViewById(R.id.tv_gio_ht);
        editCv = findViewById(R.id.edt_cv);
        editNd = findViewById(R.id.edt_noi_dung);
        btnDate = findViewById(R.id.btn_date);
        btnTime = findViewById(R.id.btn_time);
        btnAdd = findViewById(R.id.btn_save);
        lvCv = findViewById(R.id.lv_cv);
    }

    private void addEventFormWidgets() {
        btnDate.setOnClickListener(new MyButtonEvent());
        btnTime.setOnClickListener(new MyButtonEvent());
        btnAdd.setOnClickListener(new MyButtonEvent());
        lvCv.setOnItemClickListener(new MyListViewEvent());
        lvCv.setOnItemLongClickListener(new MyListViewEvent());
    }

    private class MyButtonEvent implements
            View.OnClickListener {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btn_date) {
                showDatePickerDialog();
            } else if (id == R.id.btn_time) {
                showTimePickerDialog();
            } else if (id == R.id.btn_save) {
                processAddJob();
            }
        }
    }

    /**
     * Class sự kiện của ListView
     */
    private class MyListViewEvent implements
            AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?>
                                        adapterView, View view, int i, long l) {
            Toast.makeText(bai412.this,
                    arrJob.get(i).getDesciption(),
                    Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            arrJob.remove(i);
            adapter.notifyDataSetChanged();
            return false;
        }
    }

    public void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callback = (datePicker, i, i1, i2) -> txtDate.setText(i2 + "/" + i1 + "/" + i);
        DatePickerDialog pic = new DatePickerDialog(
                bai412.this, callback,
                2020, 11, 10);
        pic.setTitle("my datetime picker");
        pic.show();
    }

    public void showTimePickerDialog() {
        TimePickerDialog.OnTimeSetListener callback =
                (timePicker, i, i1) -> txtTime.setText(i + "-" + i1);
        TimePickerDialog time = new TimePickerDialog(
                bai412.this, callback,
                11, 30, true);
        time.setTitle("my time picker");
        time.show();
    }

    //Hàm xử lý đưa công việc vào ListView khi nhấn nút Thêm Công việc
    public void processAddJob() {
        String title = editCv.getText() + "";
        String description = editNd.getText() + "";
        String dateFinish = txtDate.getText() + "";
        String hourFinish = txtTime.getText() + "";
        JobInWeek job = new JobInWeek(title, description, dateFinish, hourFinish);
        arrJob.add(job);
        adapter.notifyDataSetChanged();
        editCv.setText("");
        editNd.setText("");
        editCv.requestFocus();
    }

}