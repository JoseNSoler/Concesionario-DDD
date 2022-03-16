package co.com.concesionario.dominio.CatalogoCarros.comandos;

import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosProveedorID;
import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroProveedor;
import co.com.concesionario.valorglobal.Kilometraje;
import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearCatalogoCarrosConCarrosProveedor extends Command {

    private final CatalogoCarrosID catalogoCarrosID;
    private final Map<CarrosProveedorID,FichaTecnicaCarroProveedor> listaArgsCarroProveedor;


    public CrearCatalogoCarrosConCarrosProveedor(CatalogoCarrosID catalogoCarrosID,  Map<CarrosProveedorID ,FichaTecnicaCarroProveedor> listaArgsCarroProveedor) {
        this.catalogoCarrosID = catalogoCarrosID;
        this.listaArgsCarroProveedor = listaArgsCarroProveedor;
    }




    public CatalogoCarrosID catalogoCarrosID() {
        return catalogoCarrosID;
    }

    public Map<CarrosProveedorID,FichaTecnicaCarroProveedor> listaArgsCarroProveedor() {
        return listaArgsCarroProveedor;
    }
}
