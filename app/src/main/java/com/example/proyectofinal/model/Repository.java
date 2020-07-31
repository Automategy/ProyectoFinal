package com.example.proyectofinal.model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.proyectofinal.model.networking.ApiClient;
import com.example.proyectofinal.model.networking.IApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private IApiInterface apiInterface;
    private List<String> razaPerro;
    private MutableLiveData<List<String>> listMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<List<String>> listMutableLiveDataFoto = new MutableLiveData<>();


    public Repository() {
        apiInterface = ApiClient.getRetrofifClient().create(IApiInterface.class);
    }

    public LiveData<List<String>> getRazaPerro() {
        Call<ListadoPerros> call = apiInterface.getListadoPerro();
        call.enqueue(new Callback<ListadoPerros>() {
            @Override
            public void onResponse(Call<ListadoPerros> call, Response<ListadoPerros> response) {
                listMutableLiveData.setValue(response.body().message);
            }

            @Override
            public void onFailure(Call<ListadoPerros> call, Throwable t) {
                Log.d("Error - getRazaPerro", t.getMessage());
            }
        });
        return listMutableLiveData;
    }

    public LiveData<List<String>> getFotoPerro(String nombreRaza) {
        Call<ListadoFotosPerros> call = apiInterface.getListadoFotos(nombreRaza);
        call.enqueue(new Callback<ListadoFotosPerros>() {
            @Override
            public void onResponse(Call<ListadoFotosPerros> call, Response<ListadoFotosPerros> response) {
                listMutableLiveDataFoto.setValue(response.body().message);
            }

            @Override
            public void onFailure(Call<ListadoFotosPerros> call, Throwable t) {
                Log.d("Error - getFotoPerro", t.getMessage());
            }
        });
        return listMutableLiveDataFoto;
    }

}
