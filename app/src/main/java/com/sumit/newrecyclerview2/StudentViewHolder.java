package com.sumit.newrecyclerview2;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private ImageView mivStudentImg;
    private TextView mtvName;
    private TextView mtvAge;
    private TextView mtvAddress;
    private TextView mtvdob;
    private RelativeLayout relative;
    private itemClickListner itemClickListner;
    public StudentViewHolder(@NonNull @NotNull View itemView, itemClickListner itemClickListner)  {
        super(itemView);
        this.itemClickListner = itemClickListner;
        initView(itemView);
    }



    private void initView(View itemView) {
        mivStudentImg = itemView.findViewById(R.id.ivStudentImg);
        mtvName = itemView.findViewById(R.id.tvName);
        mtvAge = itemView.findViewById(R.id.tvAge);
        mtvAddress = itemView.findViewById(R.id.tvAddress);
        mtvdob = itemView.findViewById(R.id.tvdob);
        relative = itemView.findViewById(R.id.relative);

    }
    public void setData(StudentModel studentModel){
        mivStudentImg.setImageResource(studentModel.getImageId());
        mtvName.setText(studentModel.getName());
        mtvAddress.setText(studentModel.getAddress());
        mtvAge .setText(studentModel.getAge()+" ");
        mtvdob.setText(studentModel.getDob());
        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           itemClickListner.onItemClicked(studentModel , getAdapterPosition());

            }
        });

    }
}
