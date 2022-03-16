package co.com.concesionario.dominio.CatalogoCarros.comandos;

import co.com.concesionario.dominio.CatalogoCarros.valor.*;
import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearCatalogoCarrosConCarrosLocal extends Command {
    private final CatalogoCarrosID catalogoCarrosID;
    private final Map<CarrosLocalID, FichaTecnicaCarroLocal> listaArgsCarroLocal;


    public CrearCatalogoCarrosConCarrosLocal(CatalogoCarrosID catalogoCarrosID,  Map<CarrosLocalID, FichaTecnicaCarroLocal> listaArgsCarroLocal) {
        this.catalogoCarrosID = catalogoCarrosID;
        this.listaArgsCarroLocal = listaArgsCarroLocal;
    }


    public CatalogoCarrosID catalogoCarrosID() {
        return catalogoCarrosID;
    }

    public Map<CarrosLocalID, FichaTecnicaCarroLocal> listaArgsCarroLocal() {
        return listaArgsCarroLocal;
    }
}
