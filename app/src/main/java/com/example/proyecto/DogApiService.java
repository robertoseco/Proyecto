package com.example.proyecto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DogApiService {
    @GET("facts")
    Call<DogFact> getDogFact();
}
