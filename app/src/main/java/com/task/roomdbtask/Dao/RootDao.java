package com.task.roomdbtask.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.task.roomdbtask.model.Root;

import java.util.List;
import java.util.Queue;

@Dao
public interface RootDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Root>rootList);

    @Query("SELECT * FROM root")
    LiveData<List<Root>> getAllRoot();

    @Query("DELETE FROM root")
    void deleteAll();


    LiveData<List<Root>> getAllRoots();
}
