package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoCarros.CatalogoCarros;
import co.com.concesionario.dominio.CatalogoCarros.comandos.CrearCatalogoCarros;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCatalogoCarrosUseCase extends UseCase<RequestCommand<CrearCatalogoCarros>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearCatalogoCarros> input) {

        var command = input.getCommand();

        var catalogoCarros = new CatalogoCarros(command.getCatalogoCarrosID());
        emit().onResponse(new ResponseEvents(catalogoCarros.getUncommittedChanges()));
    }
}
