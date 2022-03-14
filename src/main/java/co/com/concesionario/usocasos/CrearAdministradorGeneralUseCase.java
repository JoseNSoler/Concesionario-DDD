package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.AdministradorGeneral.AdministradorGeneral;
import co.com.concesionario.dominio.AdministradorGeneral.comandos.CrearAdministradorGeneral;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;

import co.com.sofka.business.support.ResponseEvents;

public class CrearAdministradorGeneralUseCase extends UseCase<RequestCommand<CrearAdministradorGeneral>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearAdministradorGeneral> input) {

        var command = input.getCommand();

        var administradorGeneral = new AdministradorGeneral(command.getAdministradorGeneralID()
        );

        emit().onResponse(new ResponseEvents(administradorGeneral.getUncommittedChanges()));

    }
}
