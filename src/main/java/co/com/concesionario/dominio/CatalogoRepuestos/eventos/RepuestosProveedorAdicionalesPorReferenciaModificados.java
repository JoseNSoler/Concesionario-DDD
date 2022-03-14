package co.com.concesionario.dominio.CatalogoRepuestos.eventos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.DomainEvent;

public class RepuestosProveedorAdicionalesPorReferenciaModificados extends DomainEvent {

    private final Referencia referencia;
    private final RepuestosProveedorAdicionales repuestosProveedorAdicionales;
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;

    public RepuestosProveedorAdicionalesPorReferenciaModificados(
            CatalogoRepuestosID catalogoRepuestosID, RepuestosProveedorAdicionales repuestosProveedorAdicionales,
            RepuestoProveedorID repuestoProveedorID, Referencia referencia
    ){
        super("catalogorepuestos.repuestosproveedoradicionalesporreferenciamodificados");
        this.referencia = referencia;
        this.repuestosProveedorAdicionales = repuestosProveedorAdicionales;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.repuestoProveedorID = repuestoProveedorID;
    }

    public RepuestoProveedorID getRepuestoProveedorID() {
        return repuestoProveedorID;
    }

    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }

    public RepuestosProveedorAdicionales getRepuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }

    public Referencia getRepuestosProveedorReferencia() {
        return referencia;
    }
}
