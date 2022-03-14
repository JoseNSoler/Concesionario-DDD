package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearVariosAdicionalesRepuestosProveedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearVariosRepuestosProveedorAdicionalesUseCase extends UseCase<RequestCommand<CrearVariosAdicionalesRepuestosProveedor>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearVariosAdicionalesRepuestosProveedor>input) {
        var command = input.getCommand();

        var catalogoRepuestos = CatalogoRepuestos.from(command.getCatalogoRepuestosID(), retrieveEvents());

        System.out.println(catalogoRepuestos.repuestosProveedor());

        catalogoRepuestos.crearVariosRepuestosProveedorAdicionales(command.getRepuestoProveedorID(),
                command.getCatalogoRepuestosID(), command.getRepuestosProveedorAdicionales());

        emit().onResponse(new ResponseEvents(catalogoRepuestos.getUncommittedChanges()));
    }
}
