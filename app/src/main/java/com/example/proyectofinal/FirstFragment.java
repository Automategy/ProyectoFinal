package com.example.proyectofinal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.databinding.FragmentFirstBinding;
import com.example.proyectofinal.view.AdapterListadoPerro;
import com.example.proyectofinal.viewmodel.ViewModelPerro;

import java.util.List;

public class FirstFragment extends Fragment implements AdapterListadoPerro.PasarListaPerro {

    private RecyclerView recyclerView;
    private AdapterListadoPerro adapterListadoPerro;
    private FragmentFirstBinding fragmentFirstBinding;
    private ViewModelPerro viewModelPerro;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelPerro = new ViewModelProvider(this).get(ViewModelPerro.class);
        adapterListadoPerro = new AdapterListadoPerro(this);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        fragmentFirstBinding = FragmentFirstBinding.inflate(inflater, container, false);
        recyclerView = fragmentFirstBinding.rvPerro;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterListadoPerro);
        viewModelPerro.observerListPerro().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                Log.d("Error - onChanged 1", String.valueOf(strings));
                adapterListadoPerro.updateRazaPerro(strings);

            }
        });
        return fragmentFirstBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void pasarListaPerro(String nombreRaza) {
        Toast.makeText(getContext(), nombreRaza, Toast.LENGTH_SHORT).show();
    }
}