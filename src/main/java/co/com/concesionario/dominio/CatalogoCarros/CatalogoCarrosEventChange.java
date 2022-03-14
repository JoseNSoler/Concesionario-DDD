package co.com.concesionario.dominio.CatalogoCarros;

import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosCreado;
import co.com.sofka.domain.generic.EventChange;

public class CatalogoCarrosEventChange extends EventChange {
    public CatalogoCarrosEventChange(CatalogoCarros catalogoCarros){

        apply((CatalogoCarrosCreado event) -> {

        });

    }
}
