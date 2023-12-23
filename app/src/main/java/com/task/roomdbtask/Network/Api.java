package com.task.roomdbtask.Network;

import android.telecom.Call;

import com.task.roomdbtask.model.Root;

import java.util.List;

import retrofit2.http.GET;

public interface Api {

    @GET("/products")
    Call<List<Root>> getAllRoots();

}
