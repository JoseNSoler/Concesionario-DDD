package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearCatalogoRepuestos;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCatalogoRepuestosUseCase extends UseCase<RequestCommand<CrearCatalogoRepuestos>, ResponseEvents>{

    @Override
    public void executeUseCase(RequestCommand<CrearCatalogoRepuestos> input) {
        // TODO Auto-generated method stub
        var command = input.getCommand();

        var catalogoRepuestos = new CatalogoRepuestos(command.getCatalogoRepuestosID());
        emit().onResponse(new ResponseEvents(catalogoRepuestos.getUncommittedChanges()));
    }
    
}
