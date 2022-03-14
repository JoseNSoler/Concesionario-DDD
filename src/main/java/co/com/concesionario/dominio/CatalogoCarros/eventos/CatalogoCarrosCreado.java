package co.com.concesionario.dominio.CatalogoCarros.eventos;

import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;
import co.com.sofka.domain.generic.DomainEvent;

public class CatalogoCarrosCreado extends DomainEvent {
    private final CatalogoCarrosID catalogoCarrosID;

    public CatalogoCarrosCreado(CatalogoCarrosID catalogoCarrosID){
        super("catalogocarros.catalogocarroscreado");
        this.catalogoCarrosID = catalogoCarrosID;
    }

    public CatalogoCarrosID getCatalogoCarrosID() {
        return catalogoCarrosID;
    }
}
