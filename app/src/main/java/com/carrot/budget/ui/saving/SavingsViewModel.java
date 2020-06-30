package com.carrot.budget.ui.saving;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.carrot.budget.database.MonthDetailsEntity;
import com.carrot.budget.database.Repository;

import java.util.List;

public class SavingsViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    public LiveData<List<MonthDetailsEntity>>  liveData;
    private static Repository repository;

    public SavingsViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }


    public LiveData<List<MonthDetailsEntity>> getAllEvents(){
        liveData = repository.getAllEvents();

        return liveData;
    }
}