package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.RepuestosLocal;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearRepuestoLocal;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearRepuestosProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.CatalogoRepuestosCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.RepuestoLocalCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.RepuestosProveedorCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.*;
import co.com.concesionario.valorglobal.Adicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CrearRepuestosLocalUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void crearRepuestosProoveedor(){
        // Arrange
        Referencia ref1 = Referencia.of("1010");
        Referencia ref2 = Referencia.of("1012");
        Referencia ref3 = Referencia.of("1014");


        Map<Referencia, RepuestosLocalAdicionales> mapaRepuestosLocalAdicional = new HashMap<Referencia, RepuestosLocalAdicionales>();
        mapaRepuestosLocalAdicional.put(ref1, RepuestosLocalAdicionales.of(Adicionales.of("LOCAL partes externas prim", "LOCAL LLantasPrimeras")) );
        mapaRepuestosLocalAdicional.put(ref2, RepuestosLocalAdicionales.of(Adicionales.of("LOCAL partes externas segund", "LOCAL LLantasSegundassss")) );
        mapaRepuestosLocalAdicional.put(ref3, RepuestosLocalAdicionales.of(Adicionales.of("LOCAL partes externas ter", "LOCAL LLantasTercera")) );



        var catalogoRepuestosID = CatalogoRepuestosID.of("1Catalogo");
        var repuestosLocalID = RepuestoLocalID.of("1_1LocalRepuestoCC");


        var command = new CrearRepuestoLocal(repuestosLocalID, catalogoRepuestosID, mapaRepuestosLocalAdicional);

        var usecase = new CrearRepuestosLocalUseCase();

        Mockito.when(repository.getEventsBy("1Catalogo")).thenReturn(history());
        usecase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(catalogoRepuestosID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert

        var event = (RepuestosProveedorCreado) events.get(1);

        Assertions.assertEquals("catalogorepuestos.repuestosproveedorcreado", event.type);

        Assertions.assertEquals("1Catalogo", event.catalogoRepuestosID().value());
        Assertions.assertEquals("1_1ProveedorRepuestoCC", event.repuestoProveedorID().value());


        Assertions.assertEquals(3, event.repuestosProveedorAdicionales().size());

        Assertions.assertEquals("partesExternasPrimera",event.repuestosProveedorAdicionales());
        Assertions.assertEquals("LLantasTercera",event.repuestosProveedorAdicionales().get(ref3).value().value().llantasModificadas());


    }


    private List<DomainEvent> history() {
        Map<Referencia, RepuestosLocalAdicionales> mapaRepuestosLocalAdicional = new HashMap<Referencia, RepuestosLocalAdicionales>();
        mapaRepuestosLocalAdicional.put(Referencia.of("2020"), RepuestosLocalAdicionales.of(Adicionales.of("LOCAL partes externas prim", "LOCAL LLantasPrimeras")) );
        mapaRepuestosLocalAdicional.put(Referencia.of("2022"), RepuestosLocalAdicionales.of(Adicionales.of("LOCAL partes externas segund", "LOCAL LLantasSegundassss")) );
        mapaRepuestosLocalAdicional.put(Referencia.of("2024"), RepuestosLocalAdicionales.of(Adicionales.of("LOCAL partes externas ter", "LOCAL LLantasTercera")) );


        return List.of(
                new CatalogoRepuestosCreado(CatalogoRepuestosID.of("1Catologo")),
                new RepuestoLocalCreado(RepuestoLocalID.of("1_1LocalRepuestoCC"), CatalogoRepuestosID.of("1Catologo"), mapaRepuestosLocalAdicional)
        );
    }
}