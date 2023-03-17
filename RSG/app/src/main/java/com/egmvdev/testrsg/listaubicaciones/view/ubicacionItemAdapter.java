package com.egmvdev.testrsg.listaubicaciones.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.egmvdev.testrsg.databinding.UbicacionItemBinding;
import com.egmvdev.testrsg.detailproduct.view.detailProView;
import com.egmvdev.testrsg.listaubicaciones.models.Locations;
import com.egmvdev.testrsg.listaubicaciones.models.Products;

import java.util.ArrayList;
import java.util.List;

public class ubicacionItemAdapter extends RecyclerView.Adapter<ubicacionItemViewHolder> {
    private List<Locations> ubicaciones;
    private List<Products> productos;

    public ubicacionItemAdapter(List<Locations> ubicaciones, ArrayList<Products> productos) {
        this.ubicaciones = ubicaciones;
        this.productos = productos;
    }

    @NonNull
    @Override
    public ubicacionItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ubicacionItemViewHolder(parent.getContext(), UbicacionItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ubicacionItemViewHolder holder, int position) {
        holder.setDatos(ubicaciones.get(position), productos.get(position));
    }

    @Override
    public int getItemCount() {
        return ubicaciones.size();
    }
}

class ubicacionItemViewHolder extends RecyclerView.ViewHolder {

    private UbicacionItemBinding binding;
    Context con;

    public ubicacionItemViewHolder(Context c, UbicacionItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        con = c;
    }

    void setDatos(Locations ubicacion, Products products) {
        binding.tvNombreUbicacion.setText("Ubicación: " + ubicacion.getName());
        binding.tvTypeUbicacion.setText("Tipo: " + ubicacion.getType());

        binding.contenedor.setOnClickListener(v -> {
            Intent intent = new Intent(con, detailProView.class);
            intent.putExtra("Product", products);
            con.startActivity(intent);
        });
    }
}
