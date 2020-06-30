package com.carrot.budget.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "YEAR_DETAILS")
public class YearDetailsEntity {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    public int getID() {
        return ID;
    }

    public int month;
    public int year;
    private double spent;
    private double remaining;
    private double income;


    public YearDetailsEntity(int month, int year, double spent, double remaining ,double income) {
        this.month = month;
        this.year = year;
        this.spent = spent;
        this.remaining = remaining;
        this.income  = income;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getSpent() {
        return spent;
    }

    public double getRemaining() {
        return remaining;
    }

    public double getIncome(){
        return income;
    }

}
