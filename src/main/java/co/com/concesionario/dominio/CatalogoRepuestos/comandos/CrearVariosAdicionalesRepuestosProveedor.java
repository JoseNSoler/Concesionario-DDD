package co.com.concesionario.dominio.CatalogoRepuestos.comandos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorReferencia;
import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearVariosAdicionalesRepuestosProveedor extends Command {
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private final Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales;

    public CrearVariosAdicionalesRepuestosProveedor(
            RepuestoProveedorID repuestoProveedorID, CatalogoRepuestosID catalogoRepuestosID,
            Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales) {
        this.repuestoProveedorID = repuestoProveedorID;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.repuestosProveedorAdicionales = repuestosProveedorAdicionales;
    }

    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }

    public RepuestoProveedorID getRepuestoProveedorID() {
        return repuestoProveedorID;
    }

    public Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> getRepuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }
}
