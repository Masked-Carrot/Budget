package com.carrot.budget.database;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.Calendar;
import java.util.List;

public class Repository {
    private MonthDetailsDAO monthDetailsDAO;
    private YearDetailsDAO yearDetailsDAO;
    private LiveData<List<MonthDetailsEntity>> liveMonthData;
    private LiveData<List<YearDetailsEntity>> liveYearData;
    private static final String LOG_TAG = "Database>>Repository";

    public Repository(Application application){
        Database database = Database.getInstance(application);
        monthDetailsDAO = database.monthDetailsDAO();
        yearDetailsDAO = database.yearDetailsDAO();
        liveMonthData = monthDetailsDAO.getallEvents();
        liveYearData = yearDetailsDAO.getdata();
    }


    public void add_year(YearDetailsEntity yearDetailsEntity){
        new InsertAsyncTask(yearDetailsDAO).execute(yearDetailsEntity);

    }
    public void delete_year(YearDetailsEntity yearDetailsEntity){
        new DeleteAsyncTask(yearDetailsDAO).execute(yearDetailsEntity);
    }
    public void update_year(YearDetailsEntity yearDetailsEntity){
        new UpdateAsyncTask(yearDetailsDAO).execute(yearDetailsEntity);
    }
    public void checkExistance(YearDetailsEntity yearDetailsEntity){
          new CheckExistanceAsyncTask(yearDetailsDAO).execute(yearDetailsEntity);
    }
    public LiveData<List<YearDetailsEntity>> getLiveYearData(){
        return liveYearData;
    }




    public void addEvent(MonthDetailsEntity monthDetailsEntity){
        new addEventAsyncTask(monthDetailsDAO).execute(monthDetailsEntity);
        Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        List<YearDetailsEntity> list = getLiveYearData().getValue();
        YearDetailsEntity yearDetailsEntity = list.get(list.size()-1);
        double income;
        double spent;
        double remaining;
        if(monthDetailsEntity.getType1() == 1){
            income = yearDetailsEntity.getIncome()+monthDetailsEntity.getAmount();
            remaining = yearDetailsEntity.getRemaining()+monthDetailsEntity.getAmount();
            spent = yearDetailsEntity.getSpent();
        }
        else{
            spent = yearDetailsEntity.getSpent() + monthDetailsEntity.getAmount();
            remaining = yearDetailsEntity.getRemaining()-monthDetailsEntity.getAmount();
            income = yearDetailsEntity.getIncome();
        }
        update_year(new YearDetailsEntity(month , year , spent ,remaining , income));



    }
    public void deleteEvent(MonthDetailsEntity monthDetailsEntity){

    }
    public void updateEvent(MonthDetailsEntity monthDetailsEntity){

    }
    public LiveData<List<MonthDetailsEntity>> getAllEvents(){
        return liveMonthData;
    }



    private static class CheckExistanceAsyncTask extends  AsyncTask<YearDetailsEntity , Void , Void>{
        private YearDetailsDAO yearDetailsDAO;
        public CheckExistanceAsyncTask(YearDetailsDAO yearDetailsDAO){
            this.yearDetailsDAO = yearDetailsDAO;
        }

        @Override
        protected Void doInBackground(YearDetailsEntity... yearDetailsEntities) {
            int m = yearDetailsEntities[0].getMonth();
            int y = yearDetailsEntities[0].getYear();
            YearDetailsEntity yearDetailsEntity1 = yearDetailsDAO.checkExistance(m , y);
            if(yearDetailsEntity1 == null) {
                yearDetailsDAO.add_year(yearDetailsEntities[0]);
            }
            return null;
        }
    }

    private static class InsertAsyncTask extends AsyncTask<YearDetailsEntity, Void, Void> {
        private YearDetailsDAO yearDetailsDAO;
        public InsertAsyncTask(YearDetailsDAO yearDetailsDAO){
            this.yearDetailsDAO = yearDetailsDAO;
        }

        @Override
        protected Void doInBackground(YearDetailsEntity... yearDetailsEntities) {
            yearDetailsDAO.add_year(yearDetailsEntities[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<YearDetailsEntity , Void , Void>{
        private YearDetailsDAO yearDetailsDAO;
        public UpdateAsyncTask(YearDetailsDAO yearDetailsDAO){
            this.yearDetailsDAO = yearDetailsDAO;

        }
        @Override
        protected Void doInBackground(YearDetailsEntity... yearDetailsEntities) {
            System.out.println("updating year=============================================");
            yearDetailsDAO.updateYear(yearDetailsEntities[0].getIncome() , yearDetailsEntities[0].getRemaining() ,
                    yearDetailsEntities[0].getSpent() , yearDetailsEntities[0].getMonth() , yearDetailsEntities[0].getYear());
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<YearDetailsEntity , Void , Void>{
        private YearDetailsDAO yearDetailsDAO;
        public DeleteAsyncTask(YearDetailsDAO yearDetailsDAO){
            this.yearDetailsDAO = yearDetailsDAO;
        }

        @Override
        protected Void doInBackground(YearDetailsEntity... yearDetailsEntities) {
            yearDetailsDAO.add_year(yearDetailsEntities[0]);
            return null;
        }
    }





    private static class addEventAsyncTask extends AsyncTask<MonthDetailsEntity , Void , Void>{
        private MonthDetailsDAO monthDetailsDAO;
        public addEventAsyncTask(MonthDetailsDAO monthDetailsDAO){
            this.monthDetailsDAO = monthDetailsDAO;
        }
        @Override
        protected Void doInBackground(MonthDetailsEntity... monthDetailsEntities) {
            System.out.println("=======================adding event now======================");
            monthDetailsDAO.addEvent(monthDetailsEntities[0]);
            return null;
        }
    }

    private static class deleteEventAsyncTask extends AsyncTask<MonthDetailsEntity , Void , Void>{
        private MonthDetailsDAO monthDetailsDAO;
        public deleteEventAsyncTask(MonthDetailsDAO monthDetailsDAO){
            this.monthDetailsDAO = monthDetailsDAO;
        }
        @Override
        protected Void doInBackground(MonthDetailsEntity... monthDetailsEntities) {
            monthDetailsDAO.deleteEvent(monthDetailsEntities[0]);
            return null;
        }
    }

    private static class updateEventAsyncTask extends AsyncTask<MonthDetailsEntity , Void , Void>{
        private MonthDetailsDAO monthDetailsDAO;
        public updateEventAsyncTask(MonthDetailsDAO monthDetailsDAO){
            this.monthDetailsDAO = monthDetailsDAO;
        }
        @Override
        protected Void doInBackground(MonthDetailsEntity... monthDetailsEntities) {
            monthDetailsDAO.updateEvent(monthDetailsEntities[0]);
            return null;
        }
    }
}
