package co.com.concesionario.dominio.CatalogoRepuestos.comandos;

import co.com.concesionario.dominio.CatalogoRepuestos.RepuestosProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.sofka.domain.generic.Command;

public class CrearCatalogoRepuestos extends Command{
    private final CatalogoRepuestosID catalogoRepuestosID;


    public CrearCatalogoRepuestos(CatalogoRepuestosID catalogoRepuestosID) {
        this.catalogoRepuestosID = catalogoRepuestosID;

    }

    public CatalogoRepuestosID getCatalogoRepuestosID() {
        return catalogoRepuestosID;
    }


}
