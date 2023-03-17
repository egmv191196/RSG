package com.egmvdev.testrsg.listaubicaciones.interfaces;

import com.egmvdev.testrsg.listaubicaciones.models.Locations;
import com.egmvdev.testrsg.listaubicaciones.models.Products;

import java.util.ArrayList;

public interface listUbiViewInterface {

    void llenarRV(ArrayList<Locations> listaLocations, ArrayList<Products> listaProductos);
}
