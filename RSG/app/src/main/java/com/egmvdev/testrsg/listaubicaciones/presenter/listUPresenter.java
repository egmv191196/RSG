package com.egmvdev.testrsg.listaubicaciones.presenter;

import android.content.Context;

import com.egmvdev.testrsg.listaubicaciones.interactor.listUbiInteractor;
import com.egmvdev.testrsg.listaubicaciones.interfaces.listUbiInteractorInterface;
import com.egmvdev.testrsg.listaubicaciones.interfaces.listUbiPresenterInterface;
import com.egmvdev.testrsg.listaubicaciones.interfaces.listUbiViewInterface;
import com.egmvdev.testrsg.listaubicaciones.models.Locations;
import com.egmvdev.testrsg.listaubicaciones.models.Products;

import java.util.ArrayList;

public class listUPresenter implements listUbiPresenterInterface {

    private listUbiViewInterface viewInterface;
    private listUbiInteractorInterface interactorInterface;

    public listUPresenter(listUbiViewInterface view) {
        this.viewInterface = view;
        interactorInterface = new listUbiInteractor(this);
    }

    @Override
    public void llenarRV(ArrayList<Locations> listaLocations, ArrayList<Products> listaProductos) {
        if (viewInterface != null){
            viewInterface.llenarRV(listaLocations, listaProductos);
        }
    }

    @Override
    public void obtenerListaUbicacion(Context c) {
        if (viewInterface != null){
            interactorInterface.obtenerListaUbicacion(c);
        }
    }
}
