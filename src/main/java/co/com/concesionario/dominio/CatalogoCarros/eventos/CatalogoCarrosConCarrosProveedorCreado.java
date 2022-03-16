package co.com.concesionario.dominio.CatalogoCarros.eventos;

import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosProveedorID;
import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroProveedor;
import co.com.concesionario.valorglobal.Kilometraje;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class CatalogoCarrosConCarrosProveedorCreado extends DomainEvent {
    private final CatalogoCarrosID catalogoCarrosID;
    private final Map<CarrosProveedorID,FichaTecnicaCarroProveedor> listaArgsCarroProveedor;



    public CatalogoCarrosConCarrosProveedorCreado(CatalogoCarrosID catalogoCarrosID, Map<CarrosProveedorID ,FichaTecnicaCarroProveedor> listaArgsCarroProveedor) {
        super("catalogocarros.catalogocarrosconcarrosproveedorcreado");
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
