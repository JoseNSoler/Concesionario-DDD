package co.com.concesionario.dominio.CatalogoRepuestos.eventos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorReferencia;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Map;

public class VariosAdicionalesRepuestosProveedorCreados extends DomainEvent {
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private final Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> mapRepuestosProveedorAdicionales;

    public VariosAdicionalesRepuestosProveedorCreados(
            RepuestoProveedorID repuestoProveedorID, CatalogoRepuestosID catalogoRepuestosID,
            Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> mapRepuestosProveedorAdicionales) {
        super("catalogorepuestos.variosrepuestosproveedoradicionalesagregados");
        this.repuestoProveedorID = repuestoProveedorID;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.mapRepuestosProveedorAdicionales = mapRepuestosProveedorAdicionales;
    }

    public RepuestoProveedorID getRepuestoProveedorID() {
        return repuestoProveedorID;
    }

    public Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> getMapRepuestosProveedorAdicionales() {
        return mapRepuestosProveedorAdicionales;
    }

    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }

}
