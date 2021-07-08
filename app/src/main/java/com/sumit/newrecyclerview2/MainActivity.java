package com.sumit.newrecyclerview2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements itemClickListner {
private RecyclerView recyclerView;
private ArrayList<StudentModel> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        StudentAdapter studentAdapter = new StudentAdapter(studentList , this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    private void buildList() {
        for(int i =0; i<100; i++){
            StudentModel studentModel =new StudentModel("sumit", 35 ,
                    "rajpur khur new delhi" , "26-02-1997" ,  R.drawable.jeff);
            studentList.add(studentModel);
        }
    }

    private  void initView(){
        recyclerView = findViewById(R.id.recylerView);


    }

    @Override
    public void onItemClicked(StudentModel model, int position) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Hey this is the Data")
                .setMessage(
                        model.getName() + "\n"
                                + model.getAge() + "\n"
                                + model.getDob() + "\n"
                                + model.getAddress()
                ).
                        setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).
                        show();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}