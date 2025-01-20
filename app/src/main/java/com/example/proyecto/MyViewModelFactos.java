package com.example.proyecto;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModelFactos extends AndroidViewModel
{
    MutableLiveData<List<String>>favoritos = new MutableLiveData<>(new ArrayList<>());
    MutableLiveData<String> fact = new MutableLiveData<>();
    DogApiService dogApiService;
    public MyViewModelFactos(@NonNull Application application) {
        super(application);
        dogApiService = RetrofitClient.getClient().create(DogApiService.class);
    }
    public void getFacto(){
        Call<DogFact> factoCall = dogApiService.getDogFact();
        factoCall.enqueue(new Callback<DogFact>() {
            @Override
            public void onResponse(Call<DogFact> call, Response<DogFact> response) {
                DogFact respuesta = response.body();
                Log.d("api", "Respuesta JSON: " + response.raw().toString());

                if (respuesta != null) {
                    if (respuesta.getData().isEmpty()) {
                        Log.d("api","esta vacio");
                    } else {
                        Log.d("api","esta llrno");
                    }
                    fact.postValue(respuesta.getData().get(0).getAttributes().getBody());
                }

            }

            @Override
            public void onFailure(Call<DogFact> call, Throwable t) {
                Log.d("api",t.getMessage());
            }
        });
    }

    public MutableLiveData<String> getFact() {
        return fact;
    }

    public MutableLiveData<List<String>> getFavoritos() {
        return favoritos;
    }
}
