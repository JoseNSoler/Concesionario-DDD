package co.com.concesionario.dominio.CatalogoCarros;

import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class CatalogoCarros extends AggregateEvent<CatalogoCarrosID> {
    protected List<CarroProveedor> carrosProveedor;

    public CatalogoCarros(CatalogoCarrosID entityId) {
        super(entityId);
        this.carrosProveedor = new ArrayList<>();
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
