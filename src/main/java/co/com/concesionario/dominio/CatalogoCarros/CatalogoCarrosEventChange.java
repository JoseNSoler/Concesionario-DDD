package co.com.concesionario.dominio.CatalogoCarros;

import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosConCarrosLocalCreado;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosConCarrosProveedorCreado;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosCreado;
import co.com.sofka.domain.generic.EventChange;

import java.util.ArrayList;

public class CatalogoCarrosEventChange extends EventChange {
    public CatalogoCarrosEventChange(CatalogoCarros catalogoCarros) {

        apply((CatalogoCarrosCreado event) -> {
            catalogoCarros.carrosProveedor = new ArrayList<>();
        });

        apply((CatalogoCarrosConCarrosProveedorCreado event) -> {
            event.listaArgsCarroProveedor().forEach((carrosProveedorID, fichaTecnicaCarroProveedor) -> {
                catalogoCarros.carrosProveedor.add(new CarroProveedor(carrosProveedorID, fichaTecnicaCarroProveedor));
            });
        });

        apply((CatalogoCarrosConCarrosLocalCreado event) -> {
            event.listaArgsCarroLocal().forEach((carrosLocalID, fichaTecnicaCarroLocal) -> {
                catalogoCarros.carrosLocal.add(new CarroLocal(carrosLocalID, fichaTecnicaCarroLocal));
            });
        });
    }
}
