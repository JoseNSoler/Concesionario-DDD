package co.com.concesionario.dominio.CatalogoRepuestos.comandos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorReferencia;
import co.com.sofka.domain.generic.Command;

public class AgregarRepuestosProveedorAdicionales extends Command {
    private final RepuestosProveedorAdicionales repuestosProveedorAdicionales;
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private final RepuestosProveedorReferencia repuestosProveedorReferencia;


    public AgregarRepuestosProveedorAdicionales(
            CatalogoRepuestosID catalogoRepuestosID, RepuestosProveedorAdicionales repuestosProveedorAdicionales,
            RepuestoProveedorID repuestoProveedorID, RepuestosProveedorReferencia repuestosProveedorReferencia) {
        this.repuestosProveedorAdicionales = repuestosProveedorAdicionales;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.repuestoProveedorID = repuestoProveedorID;
        this.repuestosProveedorReferencia = repuestosProveedorReferencia;
    }

    public RepuestosProveedorReferencia getRepuestosProveedorReferencia() {
        return repuestosProveedorReferencia;
    }

    public RepuestosProveedorAdicionales getRepuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }

    public RepuestoProveedorID getRepuestoProveedorID() {
        return repuestoProveedorID;
    }

    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }
}
