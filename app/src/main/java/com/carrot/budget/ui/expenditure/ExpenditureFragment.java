package com.carrot.budget.ui.expenditure;

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

import com.carrot.budget.R;

public class ExpenditureFragment extends Fragment {

    private ExpenditureViewModel expenditureViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        expenditureViewModel = new ViewModelProvider(this).get(ExpenditureViewModel.class);
        View root = inflater.inflate(R.layout.fragment_expenditure, container, false);

        return root;
    }
}