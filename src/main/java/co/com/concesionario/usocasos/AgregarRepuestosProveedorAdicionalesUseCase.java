package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.AgregarRepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearRepuestosProveedor;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarRepuestosProveedorAdicionalesUseCase extends UseCase<RequestCommand<AgregarRepuestosProveedorAdicionales>, ResponseEvents>{
    @Override
    public void executeUseCase(RequestCommand<AgregarRepuestosProveedorAdicionales> input) {
        var command = input.getCommand();

        var catalogoRepuestos = CatalogoRepuestos.from(command.getCatalogoRepuestosID(), retrieveEvents());

        catalogoRepuestos.agregarRepuestosProveedorAdicionales(
                command.getCatalogoRepuestosID(), command.getRepuestosProveedorAdicionales(),
                command.getRepuestoProveedorID(), command.getRepuestosProveedorReferencia());

        emit().onResponse(new ResponseEvents(catalogoRepuestos.getUncommittedChanges()));
    }
}

