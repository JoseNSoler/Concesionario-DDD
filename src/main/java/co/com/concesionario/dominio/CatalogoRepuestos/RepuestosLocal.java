package co.com.concesionario.dominio.CatalogoRepuestos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoLocalID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosLocalAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.Entity;

import java.util.Map;

public class RepuestosLocal extends Entity<RepuestoLocalID> {
    private Referencia referencia;
    private Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales;

    public RepuestosLocal(RepuestoLocalID entityId, Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales) {
        this(entityId);
        //TODO Auto-generated constructor stub
        this.repuestosLocalAdicionales = repuestosLocalAdicionales;

    }

    public RepuestosLocal(RepuestoLocalID entityId) {
        super(entityId);
        //TODO Auto-generated constructor stub
    }

    public Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales() {
        return repuestosLocalAdicionales;
    }
}
