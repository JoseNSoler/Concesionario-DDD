package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.RepuestosProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearCatalogoRepuestos;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.CatalogoRepuestosCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearCatalogoRepuestosUseCaseTest {


    @Test
    void crearCatalogoRepuestos(){
        // Arrange
        CatalogoRepuestosID catalogoRepuestosID = CatalogoRepuestosID.of("1Catologo");


        var command = new CrearCatalogoRepuestos(catalogoRepuestosID);

        var usecase = new CrearCatalogoRepuestosUseCase();

        // Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        // Assert

        var event = (CatalogoRepuestosCreado) events.get(0);
        Assertions.assertEquals("catalogorepuestos.catalogorepuestoscreado", event.type);

        Assertions.assertEquals("1Catologo", event.getCatalogoRepuestosID().value());
    }

}