package com.carrot.budget.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.time.Year;
import java.util.List;

@Dao
public interface YearDetailsDAO {

    @Insert
    public void add_year(YearDetailsEntity yearDetailsEntity);


    @Delete
    public void delete_year(YearDetailsEntity yearDetailsEntity);

    @Query("SELECT * FROM YEAR_DETAILS")
    public LiveData<List<YearDetailsEntity>> getdata();



    @Query("UPDATE YEAR_DETAILS SET income =:income AND remaining =:remaining AND spent =:spent WHERE month =:month AND year =:year ")
    public void updateYear(double income , double spent , double remaining , int month , int year);

    @Query("SELECT * FROM YEAR_DETAILS WHERE month = :month AND year = :year")
    public YearDetailsEntity checkExistance(int month, int year);

}
