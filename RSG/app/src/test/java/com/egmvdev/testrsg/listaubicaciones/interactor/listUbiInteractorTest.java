package com.egmvdev.testrsg.listaubicaciones.interactor;

import com.egmvdev.testrsg.listaubicaciones.models.Locations;
import com.egmvdev.testrsg.listaubicaciones.models.Products;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class listUbiInteractorTest {
    private listUbiInteractor listUbiInteractor;

    private static final double DELTA = 1e-15;

    @Before
    public void setUp(){
        listUbiInteractor = new listUbiInteractor();
    }

    @Test
    public void interactorNotNull(){
        if (listUbiInteractor == null) {
            throw new AssertionError();
        }
    }

    @Test
    public void calcularSS() {

        Locations l = new Locations("Estado de México", "TUU_IOLI9");
        Products p = new Products("Enchufes en hogar inteligente",18,9);
        assertEquals(21.0,listUbiInteractor.calcularSS(l,p), DELTA);

    }
}