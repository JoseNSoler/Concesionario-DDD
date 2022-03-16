package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoCarros.comandos.CrearCatalogoCarros;
import co.com.concesionario.dominio.CatalogoCarros.comandos.CrearCatalogoCarrosConCarrosProveedor;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosConCarrosProveedorCreado;
import co.com.concesionario.dominio.CatalogoCarros.eventos.CatalogoCarrosCreado;
import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosProveedorID;
import co.com.concesionario.dominio.CatalogoCarros.valor.CatalogoCarrosID;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
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

class CrearCatalogoCarrosConCarrosProveedorUseCaseTest {
    @Test
    void crearCatalogoCarros() {

        // Creacion varios carros encapsulados en un mapa
        var carroProveedorID1 = CarrosProveedorID.of("1CARRO PROV 1");
        var carroProveedorID2 = CarrosProveedorID.of("2CARRO PROV 2");
        var carroProveedorID3 = CarrosProveedorID.of("3CARRO PROV 3");

        Map<CarrosProveedorID, FichaTecnicaCarroProveedor> mapaArgumentosCarro = new HashMap<>();

        mapaArgumentosCarro.put(
                carroProveedorID1, FichaTecnicaCarroProveedor.of(
                        Adicionales.of("11ExternasCarro", "1LlantasAdicionales"),
                        Tecnomecanicos.of("11LLantas-", "11Suspension--", "11Transmision---", "11Motor----"),
                        Referencia.of("Modelo 2021")
                )
        );
        mapaArgumentosCarro.put(
                carroProveedorID2, FichaTecnicaCarroProveedor.of(
                        Adicionales.of("22ExternasCarro", "2LlantasAdicionales"),
                        Tecnomecanicos.of("22LLantas-", "22Suspension--", "22Transmision---", "22Motor----"),
                        Referencia.of("Modelo 2022")
                )
        );

        mapaArgumentosCarro.put(
                carroProveedorID3, FichaTecnicaCarroProveedor.of(
                        Adicionales.of("33ExternasCarro", "33LlantasAdicionales"),
                        Tecnomecanicos.of("33LLantas-", "33Suspension--", "33Transmision---", "33Motor----"),
                        Referencia.of("Modelo 2033")
                )
        );




        // Arrange
        CatalogoCarrosID catalogoCarrosID = CatalogoCarrosID.of("CatalogoCarros");

        var command = new CrearCatalogoCarrosConCarrosProveedor(catalogoCarrosID, mapaArgumentosCarro);

        var usecase = new CrearCatalogoCarrosConCarrosProveedorUseCase();

        // Act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        // Assert

        var event = (CatalogoCarrosConCarrosProveedorCreado) events.get(1);

        Assertions.assertEquals("11ExternasCarro", event.listaArgsCarroProveedor().get(carroProveedorID1).value().adicionales().value().partesExternas());

        Assertions.assertEquals("Modelo 2033", event.listaArgsCarroProveedor().get(carroProveedorID3).value().referencia().value());

    }
}