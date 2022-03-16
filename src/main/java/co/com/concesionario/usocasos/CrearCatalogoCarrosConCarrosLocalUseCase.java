package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoCarros.CatalogoCarros;
import co.com.concesionario.dominio.CatalogoCarros.comandos.CrearCatalogoCarrosConCarrosLocal;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearCatalogoCarrosConCarrosLocalUseCase extends UseCase<RequestCommand<CrearCatalogoCarrosConCarrosLocal>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCatalogoCarrosConCarrosLocal> input) {
        var command = input.getCommand();

        var catalogoCarros = new CatalogoCarros(command.catalogoCarrosID(), command.listaArgsCarroLocal(), "g");

        emit().onResponse(new ResponseEvents(catalogoCarros.getUncommittedChanges()));
    }
}
