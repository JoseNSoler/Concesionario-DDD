package co.com.concesionario.dominio.CatalogoRepuestos.comandos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.Command;

public class AgregarRepuestosProveedorAdicionales extends Command {
    private final RepuestosProveedorAdicionales repuestosProveedorAdicionales;
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private final Referencia referencia;


    public AgregarRepuestosProveedorAdicionales(
            CatalogoRepuestosID catalogoRepuestosID, RepuestosProveedorAdicionales repuestosProveedorAdicionales,
            RepuestoProveedorID repuestoProveedorID, Referencia referencia) {
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

    public RepuestoProveedorID getRepuestoProveedorID() {
        return repuestoProveedorID;
    }

    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }
}
