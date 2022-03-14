package co.com.concesionario.dominio.CatalogoRepuestos.eventos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.DomainEvent;

public class RepuestosProveedorAdicionalesAgregado extends DomainEvent{
    
    private RepuestosProveedorAdicionales repuestosProveedorAdicionales ;
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private final Referencia referencia;

    public RepuestosProveedorAdicionalesAgregado(
            CatalogoRepuestosID catalogoRepuestosID, RepuestosProveedorAdicionales repuestosProveedorAdicionales,
            RepuestoProveedorID repuestoProveedorID, Referencia referencia
    ){
        super("catalogorepuestos.repuestosproveedoradicionalesagregado");
        this.repuestosProveedorAdicionales = repuestosProveedorAdicionales;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.repuestoProveedorID = repuestoProveedorID;
        this.referencia = referencia;

    }

    public Referencia getRepuestosProveedorReferencia() {
        return referencia;
    }

    public RepuestosProveedorAdicionales getRepuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }

    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }

    public RepuestoProveedorID getRepuestoProveedorID() {
        return repuestoProveedorID;
    }
}
