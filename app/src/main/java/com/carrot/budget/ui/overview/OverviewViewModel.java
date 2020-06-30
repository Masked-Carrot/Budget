package com.carrot.budget.ui.overview;

import android.app.Application;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.carrot.budget.database.Repository;
import com.carrot.budget.database.YearDetailsEntity;

import java.util.List;

public class OverviewViewModel extends AndroidViewModel {

    private Repository repository;
    public LiveData<List<YearDetailsEntity>>  liveData;

    public OverviewViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void setViews(TextView balance , TextView income , TextView spent ,ProgressBar progressBar ,TextView textView){
        List<YearDetailsEntity> list = repository.getLiveYearData().getValue();
        if(list == null)
            return;
        YearDetailsEntity yearDetailsEntity = list.get(list.size()-1);
        double balanceamt = yearDetailsEntity.getRemaining()+yearDetailsEntity.getSpent();
        balance.setText(String.valueOf(balanceamt));
        income.setText(String.valueOf(yearDetailsEntity.getIncome()));
        spent.setText(String.valueOf(yearDetailsEntity.getSpent()));
        double percent;
        if(yearDetailsEntity.getIncome() == 0)
            percent = 100;
        else
            percent = yearDetailsEntity.getSpent()/yearDetailsEntity.getIncome()* 100;
        textView.setText(String.valueOf(percent));
        progressBar.setProgress(((int) percent));
        String t = ((int) percent) +"% spent of income";
        textView.setText(t);
    }

    public LiveData<List<YearDetailsEntity>> getAllEvents(){
        liveData = repository.getLiveYearData();

        return liveData;
    }

}