package com.egmvdev.testrsg.listaubicaciones.interfaces;

import android.content.Context;

import com.egmvdev.testrsg.listaubicaciones.models.Locations;
import com.egmvdev.testrsg.listaubicaciones.models.Products;

import java.util.ArrayList;

public interface listUbiPresenterInterface {

    void llenarRV(ArrayList<Locations> listaLocations, ArrayList<Products> listaProductos);
    void obtenerListaUbicacion(Context c);

}
