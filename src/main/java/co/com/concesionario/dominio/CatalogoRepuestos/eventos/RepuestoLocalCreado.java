package co.com.concesionario.dominio.CatalogoRepuestos.eventos;

import co.com.concesionario.dominio.CatalogoRepuestos.RepuestosLocal;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.*;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Map;

public class RepuestoLocalCreado extends DomainEvent {
    private final RepuestoLocalID repuestoLocalID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales;



    public RepuestoLocalCreado(RepuestoLocalID repuestoLocalID, CatalogoRepuestosID catalogoRepuestosID,
                               Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales){
        super("catalogorepuestos.repuestoslocalcreado");
        this.repuestoLocalID = repuestoLocalID;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.repuestosLocalAdicionales = repuestosLocalAdicionales;
    }

    public RepuestoLocalID repuestoLocalID() {
        return repuestoLocalID;
    }

    public CatalogoRepuestosID catalogoRepuestosID() {
        return catalogoRepuestosID;
    }

    public Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales() {
        return repuestosLocalAdicionales;
    }
}
