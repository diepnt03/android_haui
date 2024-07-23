package com.example.myapplication.bai4.bai413;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.UserViewHolder> {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List mStutents;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;
    @SuppressLint("NotifyDataSetChanged")
    public StudentAdapter(List dsStudent, Context mContext) {
        this.mStutents = dsStudent;
        this.mContext = mContext;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Nạp layout cho View biểu diễn phần tử sinh viên
        View studentView =
                inflater.inflate(R.layout.student_item, parent, false);
        UserViewHolder viewHolder = new UserViewHolder(studentView);
        return viewHolder;
    }

    //chuyển dữ liệu phần tử vào ViewHolder
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Student student = (Student) mStutents.get(position);
        if (student ==null)
            return;
        holder.studentname.setText(student.getmName());
        holder.birthyear.setText(student.getBirthYear()+"");
    }

    @Override
    public int getItemCount() {
        Log.e("TAG", "getItemCount: size " + mStutents.size());
        if (mStutents ==null)
            return 0;
        else
            return mStutents.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public TextView studentname;
        public TextView birthyear;
        public Button detail_button;

        public UserViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            studentname = itemView.findViewById(R.id.studentname);
            birthyear = itemView.findViewById(R.id.birthyear);
            detail_button = itemView.findViewById(R.id.detail_button);
            //Xử lý khi nút Chi tiết được bấm
            detail_button.setOnClickListener(view -> Toast.makeText(view.getContext(), studentname.getText() + " - sinh năm: " + birthyear, Toast.LENGTH_SHORT).show());
        }
    }


}
