package com.carrot.budget.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MONTH_DETAILS")
public class MonthDetailsEntity {

    public int getId() {
        return id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int month;
    private int day;
    private int type1;
    private int type2;
    private double amount;

    public MonthDetailsEntity(int month, int day, int type1, int type2, double amount) {
        this.month = month;
        this.day = day;
        this.type1 = type1;
        this.type2 = type2;
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getType1() {
        return type1;
    }

    public int getType2() {
        return type2;
    }

    public double getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }
}
