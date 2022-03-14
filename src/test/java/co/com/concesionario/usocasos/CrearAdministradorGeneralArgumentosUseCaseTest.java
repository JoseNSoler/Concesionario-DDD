package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.AdministradorGeneral.NombresCompletos;
import co.com.concesionario.dominio.AdministradorGeneral.Usuario;
import co.com.concesionario.dominio.AdministradorGeneral.comandos.CrearAdministradorGeneral;
import co.com.concesionario.dominio.AdministradorGeneral.eventos.AdministradorGeneralCreado;
import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearAdministradorGeneralArgumentosUseCaseTest {

    @Test
    void crearAdministradorGeneralArgumentos(){
        // Arrange
        UsuarioID usuarioID = UsuarioID.of("11Usuario");
        Nombres nombres = Nombres.of("larry", "di");
        AdministradorGeneralID administradorGeneralID = AdministradorGeneralID.of("AdministradorGeneral1");
        DireccionCompletaID direccionCompletaID = DireccionCompletaID.of("DIRECCION ID 1111");
        Pais pais = Pais.of("Colombia");
        NombresCompletosID nombresCompletosID = NombresCompletosID.of("nombreUSUARIO111");

        Usuario usuario = new Usuario(usuarioID, direccionCompletaID, pais, nombresCompletosID, nombres);


        var command = new CrearAdministradorGeneral(administradorGeneralID);

        var usecase = new CrearAdministradorGeneralUseCase();


        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(administradorGeneralID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert

        var event = (AdministradorGeneralCreado) events.get(0);

        Assertions.assertEquals("administradorgeneral.administradorgeneralcreado", event.type);

        Assertions.assertEquals("AdministradorGeneral1", event.getAdministradorGeneralID().value());

        Assertions.assertEquals("", event.);
    }
}