package com.example.proyectofinal.model.networking;

import com.example.proyectofinal.model.ListadoFotosPerros;
import com.example.proyectofinal.model.ListadoPerros;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IApiInterface {

    @GET("breeds/list/")
    Call<ListadoPerros> getListadoPerro();

    @GET("breed/{nombreRaza}/images")
    Call<ListadoFotosPerros> getListadoFotos(@Path("nombreRaza")
                                             String nombreRaza
                                             );


}
