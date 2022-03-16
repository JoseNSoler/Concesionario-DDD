package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoCarros.CatalogoCarros;
import co.com.concesionario.dominio.CatalogoCarros.comandos.CrearCatalogoCarrosConCarrosProveedor;
import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.concesionario.valorglobal.Kilometraje;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.generic.Command;

import java.util.Map;

public class CrearCatalogoCarrosConCarrosProveedorUseCase extends UseCase<RequestCommand<CrearCatalogoCarrosConCarrosProveedor>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CrearCatalogoCarrosConCarrosProveedor> input) {
        var command = input.getCommand();

        var catalogoCarros = new CatalogoCarros(command.catalogoCarrosID(), command.listaArgsCarroProveedor());

        emit().onResponse(new ResponseEvents(catalogoCarros.getUncommittedChanges()));

    }
}
