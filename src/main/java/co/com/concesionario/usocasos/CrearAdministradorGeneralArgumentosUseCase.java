package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.AdministradorGeneral.AdministradorGeneral;
import co.com.concesionario.dominio.AdministradorGeneral.comandos.CrearAdministradoGeneralArgumentos;
import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearAdministradorGeneralArgumentosUseCase extends UseCase<RequestCommand<CrearAdministradoGeneralArgumentos>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearAdministradoGeneralArgumentos> input) {
        var command = input.getCommand();

        var administradorGeneral= new AdministradorGeneral(command.getAdministradorGeneralID(), command.getUsuario(),
                command.getUsuarioID(), command.getDireccionCompletaID(), command.getPais(), command.getNombre());

        emit().onResponse(new ResponseEvents(administradorGeneral.getUncommittedChanges()));
    }
}
