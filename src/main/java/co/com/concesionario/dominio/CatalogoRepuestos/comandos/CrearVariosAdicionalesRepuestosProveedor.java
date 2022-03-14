package co.com.concesionario.dominio.CatalogoRepuestos.comandos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearVariosAdicionalesRepuestosProveedor extends Command {
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private final Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales;

    public CrearVariosAdicionalesRepuestosProveedor(
            RepuestoProveedorID repuestoProveedorID, CatalogoRepuestosID catalogoRepuestosID,
            Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales) {
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

    public Map<Referencia, RepuestosProveedorAdicionales> getRepuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }
}
