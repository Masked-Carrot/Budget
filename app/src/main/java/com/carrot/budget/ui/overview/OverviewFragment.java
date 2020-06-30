package com.carrot.budget.ui.overview;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.carrot.budget.AddTransaction;
import com.carrot.budget.R;
import com.carrot.budget.database.MonthDetailsEntity;
import com.carrot.budget.database.YearDetailsEntity;
import com.carrot.budget.ui.expenditure.ExpenditureViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class OverviewFragment extends Fragment {

    private OverviewViewModel overviewViewModel;
    private FloatingActionButton addBtn;
    private TextView balance;
    private TextView income;
    private TextView spent;
    private ProgressBar  progressBar;
    private TextView Progressbar_text;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_overview, container, false);
        overviewViewModel = new ViewModelProvider(this).get(OverviewViewModel.class);
        progressBar = root.findViewById(R.id.ov_progressbar);
        Progressbar_text = root.findViewById(R.id.ov_progresstext);
        income =  root.findViewById(R.id.ov_income_text);
        balance = root.findViewById(R.id.ov_balance_text);
        spent = root.findViewById(R.id.ov_spent_text);
        addBtn = root.findViewById(R.id.ov_addbtn);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity() , AddTransaction.class));
            }
        });
        overviewViewModel.getAllEvents().observe(getViewLifecycleOwner(), new Observer<List<YearDetailsEntity>>() {
            @Override
            public void onChanged(List<YearDetailsEntity> monthDetailsEntities) {
                overviewViewModel.setViews(balance , income , spent , progressBar , Progressbar_text);
            }
        });



        return root;
    }
}