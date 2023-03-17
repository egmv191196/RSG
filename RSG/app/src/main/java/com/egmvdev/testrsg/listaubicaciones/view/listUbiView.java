package com.egmvdev.testrsg.listaubicaciones.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.egmvdev.testrsg.databinding.ActivityListaUbicacionesViewBinding;
import com.egmvdev.testrsg.listaubicaciones.interfaces.listUbiPresenterInterface;
import com.egmvdev.testrsg.listaubicaciones.interfaces.listUbiViewInterface;
import com.egmvdev.testrsg.listaubicaciones.models.Locations;
import com.egmvdev.testrsg.listaubicaciones.models.Products;
import com.egmvdev.testrsg.listaubicaciones.presenter.listUPresenter;

import java.util.ArrayList;

public class listUbiView extends AppCompatActivity implements listUbiViewInterface {

    private ActivityListaUbicacionesViewBinding binding;
    private listUbiPresenterInterface presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaUbicacionesViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new listUPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.obtenerListaUbicacion(this);
    }

    public void cargarRV(ArrayList<Locations> listaUbicaciones, ArrayList<Products> listaProductos) {
        LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvListaUbicaciones.setLayoutManager(layout);
        binding.rvListaUbicaciones.setHasFixedSize(true);
        ubicacionItemAdapter adapter = new ubicacionItemAdapter(listaUbicaciones, listaProductos);
        binding.rvListaUbicaciones.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void llenarRV(ArrayList<Locations> listaLocations, ArrayList<Products> listaProductos) {
        cargarRV(listaLocations, listaProductos);
    }
}