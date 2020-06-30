package com.carrot.budget.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface MonthDetailsDAO {

    @Insert
    void addEvent(MonthDetailsEntity monthDetailsEntity);

    @Update
    void updateEvent(MonthDetailsEntity monthDetailsEntity);

    @Delete
    void deleteEvent(MonthDetailsEntity monthDetailsEntity);

    @Query("SELECT * FROM MONTH_DETAILS")
    LiveData<List<MonthDetailsEntity>> getallEvents();

}
