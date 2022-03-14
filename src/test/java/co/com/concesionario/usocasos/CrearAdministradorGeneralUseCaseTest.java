package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.AdministradorGeneral.comandos.CrearAdministradorGeneral;
import co.com.concesionario.dominio.AdministradorGeneral.eventos.AdministradorGeneralCreado;
import co.com.concesionario.dominio.AdministradorGeneral.valor.AdministradorGeneralID;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearAdministradorGeneralUseCaseTest {

    @Test
    void crearAdministradorGeneral(){
        // Arrange

        AdministradorGeneralID administradorGeneralID = AdministradorGeneralID.of("AdministradorGeneral1");

        var command = new CrearAdministradorGeneral(administradorGeneralID);

        var usecase = new CrearAdministradorGeneralUseCase();


        // Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert

        var event = (AdministradorGeneralCreado) events.get(0);

        Assertions.assertEquals("administradorgeneral.administradorgeneralcreado", event.type);

        Assertions.assertEquals("AdministradorGeneral1", event.getAdministradorGeneralID());

    }

}