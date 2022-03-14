package co.com.concesionario.dominio.CatalogoCarros.comandos;

import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;
import co.com.sofka.domain.generic.Command;

public class CrearCatalogoCarros extends Command {
    private final CatalogoCarrosID catalogoCarrosID;

    public CrearCatalogoCarros(CatalogoCarrosID catalogoCarrosID) {
        this.catalogoCarrosID = catalogoCarrosID;
    }

    public CatalogoCarrosID getCatalogoCarrosID() {
        return catalogoCarrosID;
    }
}
