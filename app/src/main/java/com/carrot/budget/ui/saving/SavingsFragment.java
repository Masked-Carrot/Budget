package com.carrot.budget.ui.saving;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.carrot.budget.database.MonthDetailsDAO;
import com.carrot.budget.database.MonthDetailsEntity;
import com.carrot.budget.recycleviewAdapter.transactionRecycleAdapter;

import com.carrot.budget.R;

import java.util.List;

public class SavingsFragment extends Fragment {

    private SavingsViewModel savingsViewModel;
    private transactionRecycleAdapter transactionRecycleAdapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        savingsViewModel =
                new ViewModelProvider(this).get(SavingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_saving, container, false);;

        recyclerView = root.findViewById(R.id.transaction_recycle);
        savingsViewModel.getAllEvents().observe(getViewLifecycleOwner(), new Observer<List<MonthDetailsEntity>>() {
            @Override
            public void onChanged(List<MonthDetailsEntity> monthDetailsEntities) {
                transactionRecycleAdapter.setTransaction(savingsViewModel.getAllEvents().getValue());
                System.out.println(savingsViewModel.getAllEvents().getValue().size());
            }
        });
        init();

        return root;
    }
    private void init(){
        transactionRecycleAdapter = new transactionRecycleAdapter();
        recyclerView.setAdapter(transactionRecycleAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }
}