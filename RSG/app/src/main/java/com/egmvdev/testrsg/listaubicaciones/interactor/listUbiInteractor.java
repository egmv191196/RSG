package com.egmvdev.testrsg.listaubicaciones.interactor;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import com.egmvdev.testrsg.listaubicaciones.interfaces.listUbiInteractorInterface;
import com.egmvdev.testrsg.listaubicaciones.interfaces.listUbiPresenterInterface;
import com.egmvdev.testrsg.listaubicaciones.models.Locations;
import com.egmvdev.testrsg.listaubicaciones.models.Products;
import com.egmvdev.testrsg.util.UTFile;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class listUbiInteractor implements listUbiInteractorInterface {

    private listUbiPresenterInterface presenter;

    public listUbiInteractor() {
    }

    public listUbiInteractor(listUbiPresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void obtenerListaUbicacion(Context c) {
        obtenerDatos(c);
    }

    public void obtenerDatos(Context c) {
        ArrayList<Locations> locationsList = new ArrayList<>();
        ArrayList<Products> productsList = new ArrayList<>();

        JsonObject jsonObject = new Gson().fromJson(UTFile.readFileFromAssets(c, "data.json"), JsonObject.class);

        JsonArray locationsArray = jsonObject.getAsJsonArray("locations");

        for (int i = 0; i < locationsArray.size(); i++) {
            JsonObject ubicacion = locationsArray.get(i).getAsJsonObject();
            Locations ubicaciones = new Locations(ubicacion.get("name").getAsString(),
                    ubicacion.get("type").getAsString());
            locationsList.add(ubicaciones);
        }

        JsonArray productsArray = jsonObject.getAsJsonArray("products");

        for (int i = 0; i < productsArray.size(); i++) {
            JsonObject product = productsArray.get(i).getAsJsonObject();
            Products ubicaciones = new Products(product.get("name").getAsString(),
                    product.get("weight").getAsInt(),
                    product.get("volume").getAsInt());
            productsList.add(ubicaciones);
        }
//        ssPorProducto(locationsList, productsList);
        ssPorUbicacion(locationsList, productsList);
    }

    public void ssPorProducto(ArrayList<Locations> locationsList, ArrayList<Products> productsList) {
        ArrayList<Locations> locationsListFilter = new ArrayList<>();
        ArrayList<Products> productsListFilter = new ArrayList<>();

        int idUbicacionActual = 0;
        for (int i = 0; i < productsList.size(); i++) { //Recorrer arreglo de productos
            double ssFinal = 0.0, ssAux = 0.0;
            for (int j = 0; j < locationsList.size(); j++) { //Recorrer  y comparar contra ubicaciones
                if (locationsList.get(j).getEstado() == 0) {
                    ssAux = calcularSS(locationsList.get(j), productsList.get(i));
                    if (ssAux > ssFinal) {
                        idUbicacionActual = j;
                        ssFinal = ssAux;
                    }
                }

            }
            locationsList.get(idUbicacionActual).setEstado(1);
            productsList.get(i).setSs(ssFinal);
            locationsListFilter.add(locationsList.get(idUbicacionActual));
            productsListFilter.add(productsList.get(i));
        }
        double totalSS = 0;
        for (int i = 0; i < locationsListFilter.size(); i++) {
            Log.i("Lista Final", " Location: " + locationsListFilter.get(i).getName() + " Producto: " + productsListFilter.get(i).getName() + " SS: " +productsListFilter.get(i).getSs());
            totalSS += productsListFilter.get(i).getSs();
        }
        Log.i("Lista Final", "Valor de SS: " + totalSS);
        presenter.llenarRV(locationsListFilter, productsListFilter);
    }

    public void ssPorUbicacion(ArrayList<Locations> locationsList, ArrayList<Products> productsList) {
        ArrayList<Locations> locationsListFilter = new ArrayList<>();
        ArrayList<Products> productsListFilter = new ArrayList<>();

        int idProductoActual = 0;
        for (int i = 0; i <  locationsList.size(); i++) {//Recorrer lista de ubicaciones
            double ssFinal = 0.0, ssAux = 0.0;
            for (int j = 0; j < productsList.size(); j++) {//Recorrer y comparar contra productos
                if (productsList.get(j).getSs() == 0) {
                    ssAux = calcularSS(locationsList.get(j), productsList.get(i));
                    if (ssAux > ssFinal) {
                        idProductoActual = j;
                        ssFinal = ssAux;
                    }
                }

            }
            locationsListFilter.add(locationsList.get(i));
            productsList.get(idProductoActual).setSs(ssFinal);
            productsListFilter.add(productsList.get(idProductoActual));
        }
        double totalSS = 0;
        for (int i = 0; i < locationsListFilter.size(); i++) {
            Log.i("Lista Final", " Location: " + locationsListFilter.get(i).getName() + " Producto: " + productsListFilter.get(i).getName() + " SS: " +productsListFilter.get(i).getSs());
            totalSS += productsListFilter.get(i).getSs();
        }
        Log.i("Lista Final", "Valor de SS: " + totalSS);

        presenter.llenarRV(locationsListFilter, productsListFilter);
    }

    public double calcularSS(Locations loc, Products pro) {
        double ssBase = pro.getWeight() % 2 == 0 ? loc.getName().replace(" ", "").length() * 1.5 : loc.getName().replace(" ", "").length();
        double ssBase5 = ssBase / 2;
        ssBase += pro.getVolume() == loc.getName().replace(" ", "").length() ? ssBase5 : 0;
        return ssBase;
    }
}
