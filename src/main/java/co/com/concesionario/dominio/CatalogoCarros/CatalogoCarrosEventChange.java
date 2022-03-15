package co.com.concesionario.dominio.CatalogoCarros;

import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosCreado;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class CatalogoCarrosEventChange extends EventChange {
    public CatalogoCarrosEventChange(CatalogoCarros catalogoCarros){

        apply((CatalogoCarrosCreado event) -> {
            catalogoCarros.carrosProveedor = new ArrayList<>();
        });

    }
}
