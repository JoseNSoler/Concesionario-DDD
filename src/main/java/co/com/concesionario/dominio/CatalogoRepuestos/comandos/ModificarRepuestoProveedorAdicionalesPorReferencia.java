package co.com.concesionario.dominio.CatalogoRepuestos.comandos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.Command;

public class ModificarRepuestoProveedorAdicionalesPorReferencia extends Command {
    private final Referencia referencia;
    private final RepuestosProveedorAdicionales repuestosProveedorAdicionales;
    private final RepuestoProveedorID repuestoProveedorID;
    private final CatalogoRepuestosID catalogoRepuestosID;

    public ModificarRepuestoProveedorAdicionalesPorReferencia(CatalogoRepuestosID catalogoRepuestosID, RepuestosProveedorAdicionales repuestosProveedorAdicionales,
                                                              RepuestoProveedorID repuestoProveedorID, Referencia referencia) {
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

    public Referencia getRepuestosProveedorReferencia() {
        return referencia;
    }

    public RepuestosProveedorAdicionales getRepuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }
}
