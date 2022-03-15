package co.com.concesionario.dominio.CatalogoRepuestos.comandos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearRepuestosProveedor extends Command {

    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales;

    public CrearRepuestosProveedor(RepuestoProveedorID repuestoProveedorID, CatalogoRepuestosID catalogoRepuestosID,
                                   Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales) {
        this.repuestoProveedorID = repuestoProveedorID;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.repuestosProveedorAdicionales = repuestosProveedorAdicionales;
    }

    public RepuestoProveedorID getRepuestoProveedorID() {
        return repuestoProveedorID;
    }

    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }
    public Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }
}
