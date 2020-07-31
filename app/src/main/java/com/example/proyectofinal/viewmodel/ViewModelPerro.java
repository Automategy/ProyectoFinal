package com.example.proyectofinal.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectofinal.model.ListadoFotosPerros;
import com.example.proyectofinal.model.Repository;

import java.util.List;

public class ViewModelPerro extends ViewModel {
    private Repository repository;

    public ViewModelPerro() {
        repository = new Repository();
    }

    public LiveData<List<String>> observerListPerro(){
        return repository.getRazaPerro();
    }
}
