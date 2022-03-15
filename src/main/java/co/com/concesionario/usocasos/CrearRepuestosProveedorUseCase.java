package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearRepuestosProveedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearRepuestosProveedorUseCase extends UseCase<RequestCommand<CrearRepuestosProveedor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRepuestosProveedor> input) {
        var command = input.getCommand();

        var catalogoRepuestos = CatalogoRepuestos.from(command.getCatalogoRepuestosID(), retrieveEvents());

        System.out.println(catalogoRepuestos.repuestosProveedor());

        catalogoRepuestos.crearRepuestosProveedor(command.getRepuestoProveedorID(), command.getCatalogoRepuestosID(), command.repuestosProveedorAdicionales());

        emit().onResponse(new ResponseEvents(catalogoRepuestos.getUncommittedChanges()));

    }
}
