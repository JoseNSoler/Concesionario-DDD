package co.com.concesionario.dominio.CatalogoCarros;

import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosConCarrosLocalCreado;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosConCarrosProveedorCreado;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosCreado;
import co.com.concesionario.dominio.CatalogoCarros.valor.*;
import co.com.concesionario.valorglobal.Kilometraje;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CatalogoCarros extends AggregateEvent<CatalogoCarrosID> {
    protected List<CarroProveedor> carrosProveedor;
    protected List<CarroLocal> carrosLocal;



    public CatalogoCarros(CatalogoCarrosID entityId) {
        super(entityId);
        this.carrosProveedor = new ArrayList<>();
        appendChange(new CatalogoCarrosCreado(entityId)).apply();
        subscribe(new CatalogoCarrosEventChange(this));
    }

    public CatalogoCarros(CatalogoCarrosID entityId, Map<CarrosLocalID,FichaTecnicaCarroLocal> listaArgsCarroLocal, String Arg) {
        super(entityId);
        appendChange(new CatalogoCarrosConCarrosLocalCreado(entityId, listaArgsCarroLocal)).apply();
        subscribe(new CatalogoCarrosEventChange(this));
    }


    public CatalogoCarros(CatalogoCarrosID entityId, Map<CarrosProveedorID,FichaTecnicaCarroProveedor> listaArgsCarroProveedor) {
        this(entityId);
        appendChange(new CatalogoCarrosConCarrosProveedorCreado(entityId, listaArgsCarroProveedor)).apply();
        subscribe(new CatalogoCarrosEventChange(this));
    }





    public List<CarroProveedor> getCarrosProveedor() {
        return carrosProveedor;
    }

    public static CatalogoCarros from(CatalogoCarrosID entityId, List<DomainEvent> events){
        var catalogoCarros = new CatalogoCarros(entityId);
        events.forEach(catalogoCarros::applyEvent);
        return catalogoCarros;
    }

}
