package co.com.concesionario.dominio.CatalogoRepuestos.comandos;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoLocalID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosLocalAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearRepuestoLocal extends Command {
    private final RepuestoLocalID repuestoLocalID;
    private final CatalogoRepuestosID catalogoRepuestosID;
    private Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales;


    public CrearRepuestoLocal(RepuestoLocalID repuestoLocalID, CatalogoRepuestosID catalogoRepuestosID, Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales) {
        this.repuestoLocalID = repuestoLocalID;
        this.catalogoRepuestosID = catalogoRepuestosID;
        this.repuestosLocalAdicionales = repuestosLocalAdicionales;
    }



    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }

    public Map<Referencia, RepuestosLocalAdicionales> getRepuestosLocalAdicionales() {
        return repuestosLocalAdicionales;
    }

    public RepuestoLocalID getRepuestoLocalID() {
        return repuestoLocalID;
    }
}
