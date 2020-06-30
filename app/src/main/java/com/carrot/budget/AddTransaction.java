package com.carrot.budget;

import androidx.appcompat.app.AppCompatActivity;


import androidx.lifecycle.ViewModelProvider;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.carrot.budget.database.MonthDetailsEntity;

import com.carrot.budget.recycleviewAdapter.AddRecycleAdapter;
import com.carrot.budget.recycleviewAdapter.AddRecycleAdapter2;

public class AddTransaction extends AppCompatActivity implements AddRecycleAdapter.onCatClick2  , AddRecycleAdapter2.onCatClick{


    private AddTransactionViewModel viewModel;
    private Button save;
    private EditText editText;
    private Button cancel;
    int type1;
    int type2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        RecyclerView recyclerView2 = findViewById(R.id.add_cat_recycle2);
        RecyclerView recyclerView = findViewById(R.id.add_cat_recycle);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL , false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));
        recyclerView.setAdapter(new AddRecycleAdapter(this));
        recyclerView2.setAdapter(new AddRecycleAdapter2(this));

        viewModel = new ViewModelProvider(this).get(AddTransactionViewModel.class);
        save = findViewById(R.id.savebtn);
        editText = findViewById(R.id.add_amount);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.saveClicked(new MonthDetailsEntity(0, 0 , type1 , type2 ,Double.parseDouble(editText.getText().toString())));
                startActivity(new Intent(AddTransaction.this , Main.class));
            }
        });


    }

    @Override
    public void onCatClicked(int position) {
        type2 = position;
        type1 = 1;
    }

    @Override
    public void onCatClicked2(int position) {
        type2 = position;
        type1 = 2;
    }
}