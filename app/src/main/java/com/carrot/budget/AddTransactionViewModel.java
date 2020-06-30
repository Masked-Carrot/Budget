package com.carrot.budget;

import android.app.Application;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.carrot.budget.database.MonthDetailsEntity;
import com.carrot.budget.database.Repository;
public class AddTransactionViewModel extends AndroidViewModel {

    private Repository repository;

    public AddTransactionViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }


    public void saveClicked(MonthDetailsEntity monthDetailsEntity){
        repository.addEvent(monthDetailsEntity);

    }

}
