package com.egmvdev.testrsg.detailproduct.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.egmvdev.testrsg.databinding.ActivityDetailProviewBinding;
import com.egmvdev.testrsg.listaubicaciones.models.Products;

public class detailProView extends AppCompatActivity {

    private ActivityDetailProviewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailProviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cargarInformacion();
    }

    public void cargarInformacion() {
        Bundle extras = getIntent().getExtras();
        Products product;
        if (extras != null) {
            product = (Products) extras.get("Product");

            binding.tvNombreProducto.setText(product.getName());
            binding.tvPesoProducto.setText("Peso: " + product.getWeight());
            binding.tvVolumenProducto.setText("Volume: " + product.getVolume());
            binding.tvSsProducto.setText("Base de aptitud SS: " + product.getSs());
        }
    }
}