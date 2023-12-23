package com.task.roomdbtask.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.task.roomdbtask.Dao.RootDao;
import com.task.roomdbtask.model.Root;

@Database(entities = {Root.class},version = 1)
public abstract class RootDB extends RoomDatabase {

  private static final String DATABASE_NAME="RootDB";

  public abstract RootDao rootDao();

  private static volatile RootDB INSTANCE;

    public static RootDB getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (RootDB.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context,
                            RootDB.class,
                            DATABASE_NAME)
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
        }
        static Callback callback = new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                new PopulateAsyncTask(INSTANCE);
            }
        };
    static class PopulateAsyncTask extends AsyncTask<Void,Void,Void >
    {
        private RootDao rootDao;
        PopulateAsyncTask(RootDB rootDB){
            rootDao = rootDB.rootDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            rootDao.deleteAll();
            return null;
        }
    }

}
