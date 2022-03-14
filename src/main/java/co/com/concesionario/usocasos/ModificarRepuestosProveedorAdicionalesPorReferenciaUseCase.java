package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.concesionario.dominio.CatalogoRepuestos.RepuestosProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.ModificarRepuestoProveedorAdicionalesPorReferencia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ModificarRepuestosProveedorAdicionalesPorReferenciaUseCase extends UseCase<RequestCommand<ModificarRepuestoProveedorAdicionalesPorReferencia>,
        ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarRepuestoProveedorAdicionalesPorReferencia> input) {
        var command = input.getCommand();

        var catalogoRepuestos = CatalogoRepuestos.from(command.getCatalogoRepuestosID(), retrieveEvents());

        catalogoRepuestos.modificarRepuestosProveedorAdicionalesPorReferencia(
                command.getCatalogoRepuestosID(), command.getRepuestosProveedorAdicionales(),
                command.getRepuestoProveedorID(), command.getRepuestosProveedorReferencia()
        );

        emit().onResponse(new ResponseEvents(catalogoRepuestos.getUncommittedChanges()));

    }
}
