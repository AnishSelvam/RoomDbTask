package com.task.roomdbtask.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.task.roomdbtask.Dao.RootDao;
import com.task.roomdbtask.Database.RootDB;
import com.task.roomdbtask.model.Root;

import java.util.List;

public class RootRespository {
    private RootDB database;
    private LiveData<List<Root>> getAllRoots;
    public RootRespository (Application application)
    {
        database=RootDB.getInstance(application);
        getAllRoots=database.rootDao().getAllRoots();}
    public void insert(List<Root> rootList){
        new InsertAsynTask(database).execute(rootList);
    }
    public LiveData<List<Root>> getAllRoots()
    {
        return getAllRoots;
    }
    static class InsertAsynTask extends AsyncTask<List<Root>,Void,Void> implements com.task.roomdbtask.Repository.InsertAsynTask {

        private RootDao rootDao;

        InsertAsynTask(RootDB rootDB)

        {
            rootDao=rootDB.rootDao();
        }

        @Override
        protected Void doInBackground(List<Root>... lists) {
            rootDao.insert(lists[0]);
            return null;
        }

    }

}