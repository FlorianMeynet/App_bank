package com.example.bank_app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataServiceMoney {
    //String API_ROUTE = "/accounts/"+id_client;
    String API_ROUTE = "/accounts";
    @GET(API_ROUTE)
    Call<List<Compte_bank>> getAllMoney();



}
