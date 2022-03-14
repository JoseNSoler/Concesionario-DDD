package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoCarros.CatalogoCarros;
import co.com.concesionario.dominio.CatalogoCarros.comandos.CrearCatalogoCarros;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosCreado;
import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;

import co.com.concesionario.dominio.CatalogoRepuestos.eventos.CatalogoRepuestosCreado;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCatalogoCarrosUseCaseTest {

    @Test
    void crearCatalogoCarros() {

        // Arrange
        CatalogoCarrosID catalogoCarrosID = CatalogoCarrosID.of("CatalogoCarros");


        var command = new CrearCatalogoCarros(catalogoCarrosID);

        var usecase = new CrearCatalogoCarrosUseCase();

        // Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        // Assert

        var event = (CatalogoCarrosCreado) events
                ;
        Assertions.assertEquals("catalogocarros.catalogocarroscreado", event.type);

        Assertions.assertEquals("CatalogoCarros", event.getCatalogoCarrosID().value());
    }
}