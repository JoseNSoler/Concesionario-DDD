package co.com.concesionario.dominio.CatalogoRepuestos.eventos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorReferencia;
import co.com.sofka.domain.generic.DomainEvent;

public class RepuestosProveedorAdicionalesPorReferenciaModificados extends DomainEvent {

    private final RepuestosProveedorReferencia repuestosProveedorReferencia;
    private final RepuestosProveedorAdicionales repuestosProveedorAdicionales;
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;

    public RepuestosProveedorAdicionalesPorReferenciaModificados(
            CatalogoRepuestosID catalogoRepuestosID, RepuestosProveedorAdicionales repuestosProveedorAdicionales,
            RepuestoProveedorID repuestoProveedorID, RepuestosProveedorReferencia repuestosProveedorReferencia
    ){
        super("catalogorepuestos.repuestosproveedoradicionalesporreferenciamodificados");
        this.repuestosProveedorReferencia = repuestosProveedorReferencia;
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

    public RepuestosProveedorReferencia getRepuestosProveedorReferencia() {
        return repuestosProveedorReferencia;
    }
}
