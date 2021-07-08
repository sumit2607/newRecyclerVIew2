package com.sumit.newrecyclerview2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private final itemClickListner itemClickListner;
    private ArrayList<StudentModel> studentList;


    public StudentAdapter(ArrayList<StudentModel> studentList, itemClickListner itemClickListner){

    this.studentList = studentList;
    this. itemClickListner =  itemClickListner;

    }
    @NonNull
    @NotNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout , parent, false);

        return new StudentViewHolder(view  , itemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StudentViewHolder holder, int position) {
 StudentModel studentModel = studentList.get(position);
   holder.setData(studentModel);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
