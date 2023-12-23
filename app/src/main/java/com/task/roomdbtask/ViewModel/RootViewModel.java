package com.task.roomdbtask.ViewModel;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.task.roomdbtask.Repository.RootRespository;
import com.task.roomdbtask.model.Root;
import java.util.List;

public class RootViewModel extends AndroidViewModel {

    private final RootRespository rootRespository;
    private final LiveData<List<Root>> getAllRoots;

    public RootViewModel(@NonNull Application application) {
        super(application);
        rootRespository = new RootRespository(application);
        getAllRoots = rootRespository.getAllRoots();
    }

    public void insert(List<Root> list) {
        rootRespository.insert(list);
    }
    public LiveData<List<Root>> getAllRoot()
    {
        return getAllRoots;
    }
}


