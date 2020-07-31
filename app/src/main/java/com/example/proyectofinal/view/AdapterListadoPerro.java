package com.example.proyectofinal.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.databinding.RazaPerroListBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterListadoPerro extends RecyclerView.Adapter<AdapterListadoPerro.ListadoPerroViewHolder> {


    private List<String> listPerro = new ArrayList<>();
    private PasarListaPerro listenerListaPerro;

    public AdapterListadoPerro(PasarListaPerro pasarListaPerro) {
        listenerListaPerro = pasarListaPerro;
    }

    @NonNull
    @Override
    public ListadoPerroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RazaPerroListBinding binding = RazaPerroListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListadoPerroViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListadoPerroViewHolder holder, int position) {
        String razaPerro = listPerro.get(position);
        holder.tv.setText(razaPerro);
    }

    @Override
    public int getItemCount() {
        if (listPerro != null) {
            return listPerro.size();
        } else {
            return 0;
        }
    }

    public void updateRazaPerro(List<String> lista){
        listPerro = lista;
        notifyDataSetChanged();
    }


    public class ListadoPerroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv;

        public ListadoPerroViewHolder(@NonNull RazaPerroListBinding itemView) {
            super(itemView.getRoot());
            tv = itemView.tvListadoPerro;
            itemView.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String nombrePerro = listPerro.get(getAdapterPosition());
            listenerListaPerro.pasarListaPerro(nombrePerro);
        }
    }

    public interface PasarListaPerro{
        void pasarListaPerro(String nombreRaza);


    }


}
