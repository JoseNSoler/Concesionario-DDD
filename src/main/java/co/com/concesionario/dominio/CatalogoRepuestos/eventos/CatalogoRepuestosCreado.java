package co.com.concesionario.dominio.CatalogoRepuestos.eventos;

import co.com.concesionario.dominio.CatalogoRepuestos.RepuestosProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.sofka.domain.generic.DomainEvent;

public class CatalogoRepuestosCreado extends DomainEvent{

    private final CatalogoRepuestosID catalogoRepuestosID;

    
    public CatalogoRepuestosCreado(CatalogoRepuestosID catalogoRepuestosID){
        super("catalogorepuestos.catalogorepuestoscreado");
        this.catalogoRepuestosID = catalogoRepuestosID;

    }


    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }
}
