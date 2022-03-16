package co.com.concesionario.dominio.CatalogoCarros.eventos;

import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosLocalID;
import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroLocal;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Map;

public class CatalogoCarrosConCarrosLocalCreado extends DomainEvent {
    private final CatalogoCarrosID catalogoCarrosID;
    private final Map<CarrosLocalID, FichaTecnicaCarroLocal> listaArgsCarroLocal;


    public CatalogoCarrosConCarrosLocalCreado(CatalogoCarrosID catalogoCarrosID,  Map<CarrosLocalID, FichaTecnicaCarroLocal> listaArgsCarroLocal) {
        super("catalogocarros.catalogocarrosconcarroslocalcreado");
        this.catalogoCarrosID = catalogoCarrosID;
        this.listaArgsCarroLocal = listaArgsCarroLocal;
    }


    public CatalogoCarrosID catalogoCarrosID() {
        return catalogoCarrosID;
    }

    public Map<CarrosLocalID, FichaTecnicaCarroLocal> listaArgsCarroLocal() {
        return listaArgsCarroLocal;
    }
}
