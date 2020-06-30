package com.carrot.budget.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Calendar;


@androidx.room.Database(entities = { YearDetailsEntity.class, MonthDetailsEntity.class} , version = 2)
public abstract class Database extends RoomDatabase {

    private static Database instance;
    public abstract YearDetailsDAO yearDetailsDAO();
    public abstract MonthDetailsDAO monthDetailsDAO();

    public static synchronized Database getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext() , Database.class , "WALLET_DATABASE")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new CheckDbAsyncTask(instance).execute();
        }
    };
    private static class CheckDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private YearDetailsDAO yearDetailsDAO;
        private CheckDbAsyncTask(Database db) {
            yearDetailsDAO = db.yearDetailsDAO();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            yearDetailsDAO.checkExistance(month , year);
            return null;
        }
    }
}

