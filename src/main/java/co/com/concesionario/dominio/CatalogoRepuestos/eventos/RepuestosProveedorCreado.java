package co.com.concesionario.dominio.CatalogoRepuestos.eventos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Map;

public class RepuestosProveedorCreado extends DomainEvent {
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales;



    public RepuestosProveedorCreado(RepuestoProveedorID repuestoProveedorID, CatalogoRepuestosID catalogoRepuestosID,
                                    Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales){
        super("catalogorepuestos.repuestosproveedorcreado");
        this.repuestoProveedorID = repuestoProveedorID;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.repuestosProveedorAdicionales = repuestosProveedorAdicionales;
    }

    public RepuestoProveedorID repuestoProveedorID() {
        return repuestoProveedorID;
    }

    public CatalogoRepuestosID catalogoRepuestosID() {
        return catalogoRepuestosID;
    }

    public Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }
}
