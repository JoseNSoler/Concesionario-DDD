package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.AdministradorGeneral.comandos.CrearAdministradoGeneralArgumentos;
import co.com.concesionario.dominio.AdministradorGeneral.eventos.AdministradorGeneralArgumentosCreado;
import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearAdministradorGeneralArgumentosUseCaseTest {

    @Test
    void crearAdministradorGeneralconvariosArgumentos(){
        // Arrange
        AdministradorGeneralID administradorGeneralID = AdministradorGeneralID.of("AdministradorGeneral1");
        UsuarioID usuarioID = UsuarioID.of("11Usuario");


        Nombres nombres = Nombres.of("larry", "di");
        Pais pais = Pais.of("Colombia");


        DireccionCompletaID direccionCompletaID = DireccionCompletaID.of("Direccion ABC");
        Nomenclatura nomenclatura = Nomenclatura.of("Carrera 90 numero 30");


        var command = new CrearAdministradoGeneralArgumentos(administradorGeneralID, usuarioID,
                nombres, pais, direccionCompletaID, nomenclatura);

        var usecase = new CrearAdministradorGeneralArgumentosUseCase();


        // Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert

        var event = (AdministradorGeneralArgumentosCreado) events.get(1);

        Assertions.assertEquals("administradorgeneral.administradorgeneralargumentoscreado", event.type);

        Assertions.assertEquals("AdministradorGeneral1", event.administradorGeneralID().value());
        Assertions.assertEquals("11Usuario", event.usuarioID().value());

        Assertions.assertEquals("larry", event.nombres().value().primerosNombres());
        Assertions.assertEquals("di", event.nombres().value().apellidos());


        Assertions.assertEquals("Direccion ABC", event.direccionCompletaID().value());
        Assertions.assertEquals(direccionCompletaID, event.direccionCompletaID());
        Assertions.assertEquals("Carrera 90 numero 30", event.nomenclatura().value());


    }
}