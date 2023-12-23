package com.task.roomdbtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.task.roomdbtask.Adapter.RootAdapter;
import com.task.roomdbtask.Network.Api;
import com.task.roomdbtask.Repository.RootRespository;
import com.task.roomdbtask.ViewModel.RootViewModel;
import com.task.roomdbtask.model.Root;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private static final String URL_DATA = "https://fakestoreapi.com/products";

    private RootAdapter rootAdapter;
    private RootRespository rootRespository;
    private List<Root> rootList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        rootRespository = new RootRespository(getApplication());
        rootAdapter = new RootAdapter(this,rootList);
        rootList = new ArrayList<>();

        RootViewModel rootViewModel = new ViewModelProvider(this).get(RootViewModel.class);

        rootViewModel.getAllRoot().observe(this, new Observer<List<Root>>() {
            @Override
            public void onChanged(List<Root> rootList) {
                rootAdapter.getAllRoots(rootList);
                recyclerView.setAdapter(rootAdapter);

            }
        });

        networkRequest();

    }

    private void networkRequest() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URL_DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Root>> call = api.getAllRoots();
        call.enqueue(new Callback<List<Root>>() {
            @Override
            public void onResponse(Call<List<Root>> call, Response<List<Root>> response) {

                rootRespository.insert(response);

            }

            @Override
            public void onFailure(Call<List<Root>> call, Throwable t) {
                Toast.makeText(MainActivity,this"somthing went wront..",Toast.LENGTH_SHORT).show();
            }
        });

    }
}