package com.example;



import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/data")
    Call<List<Faculty>> getAllFaculty();
}