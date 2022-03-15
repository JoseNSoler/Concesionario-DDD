package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearRepuestoLocal;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearRepuestosLocalUseCase extends UseCase<RequestCommand<CrearRepuestoLocal>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearRepuestoLocal> input) {
        var command = input.getCommand();

        var catalogoRepuestos = CatalogoRepuestos.from(command.getCatalogoRepuestosID(), retrieveEvents());

        catalogoRepuestos.crearRepuestosLocal(command.getRepuestoLocalID(),command.getCatalogoRepuestosID(), command.getRepuestosLocalAdicionales());

        emit().onResponse(new ResponseEvents(catalogoRepuestos.getUncommittedChanges()));
    }
}
