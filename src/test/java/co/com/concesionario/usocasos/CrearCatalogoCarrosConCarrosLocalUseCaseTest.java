package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoCarros.comandos.CrearCatalogoCarrosConCarrosLocal;
import co.com.concesionario.dominio.CatalogoCarros.comandos.CrearCatalogoCarrosConCarrosProveedor;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosConCarrosLocalCreado;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosConCarrosProveedorCreado;
import co.com.concesionario.dominio.CatalogoCarros.valor.*;
import co.com.concesionario.valorglobal.Adicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.concesionario.valorglobal.Tecnomecanicos;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CrearCatalogoCarrosConCarrosLocalUseCaseTest {
    @Test
    void crearCatalogoCarrosConCarrosLocalUseCaseTest(){

        // Creacion varios carros encapsulados en un mapa
        var carroLocalID1 = CarrosLocalID.of("1CARRO LOCAL 1");
        var carroLocalID2 = CarrosLocalID.of("2CARRO LOCAL 2");
        var carroLocalID3 = CarrosLocalID.of("3CARRO LOCAL 3");

        Map<CarrosLocalID, FichaTecnicaCarroLocal> mapaArgumentosCarro = new HashMap<>();

        mapaArgumentosCarro.put(
                carroLocalID1, FichaTecnicaCarroLocal.of(
                        Adicionales.of("11ExternasCarro", "1LlantasAdicionales"),
                        Tecnomecanicos.of("11LLantas-", "11Suspension--", "11Transmision---", "11Motor----"),
                        Referencia.of("Local Modelo 2021")
                )
        );
        mapaArgumentosCarro.put(
                carroLocalID2, FichaTecnicaCarroLocal.of(
                        Adicionales.of("22ExternasCarro", "2LlantasAdicionales"),
                        Tecnomecanicos.of("22LLantas-", "22Suspension--", "22Transmision---", "22Motor----"),
                        Referencia.of("Local Modelo 2022")
                )
        );

        mapaArgumentosCarro.put(
                carroLocalID3, FichaTecnicaCarroLocal.of(
                        Adicionales.of("33ExternasCarro", "33LlantasAdicionales"),
                        Tecnomecanicos.of("33LLantas-", "33Suspension--", "33Transmision---", "33Motor----"),
                        Referencia.of("Local Modelo 2033")
                )
        );




        // Arrange
        CatalogoCarrosID catalogoCarrosID = CatalogoCarrosID.of("CatalogoCarros");

        var command = new CrearCatalogoCarrosConCarrosLocal(catalogoCarrosID, mapaArgumentosCarro);

        var usecase = new CrearCatalogoCarrosConCarrosLocalUseCase();

        // Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        // Assert

        var event = (CatalogoCarrosConCarrosLocalCreado) events.get(0);

        Assertions.assertEquals("11ExternasCarro", event.listaArgsCarroLocal().get(carroLocalID1).value().adicionales().value().partesExternas());

        Assertions.assertEquals("Local Modelo 2033", event.listaArgsCarroLocal().get(carroLocalID3).value().referencia().value());

    }
}