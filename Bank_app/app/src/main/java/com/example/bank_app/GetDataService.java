package com.example.bank_app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/config")
    Call<List<Client>> getAllCompte();



}
