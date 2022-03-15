package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearRepuestosProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.CatalogoRepuestosCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.RepuestosProveedorCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
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

@ExtendWith(MockitoExtension.class)
class CrearRepuestosProveedorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearRepuestosProoveedor(){
        // Arrange
        Referencia ref1 = Referencia.of("2020");
        Referencia ref2 = Referencia.of("2022");
        Referencia ref3 = Referencia.of("2024");


        Map<Referencia, RepuestosProveedorAdicionales> mapaRepuestosProveedorAdicional = new HashMap<Referencia, RepuestosProveedorAdicionales>();
        mapaRepuestosProveedorAdicional.put(ref1, RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasPrimera", "LLantasPrimeras")) );
        mapaRepuestosProveedorAdicional.put(ref2, RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasSeg", "LLantasSegundassss")) );
        mapaRepuestosProveedorAdicional.put(ref3, RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasTerfcera", "LLantasTercera")) );



        var catalogoRepuestosID = CatalogoRepuestosID.of("1Catalogo");
        var repuestosProveedorID = RepuestoProveedorID.of("1_1ProveedorRepuestoCC");


        var command = new CrearRepuestosProveedor(repuestosProveedorID, catalogoRepuestosID, mapaRepuestosProveedorAdicional);

        var usecase = new CrearRepuestosProveedorUseCase();

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

        Assertions.assertEquals("partesExternasPrimera",event.repuestosProveedorAdicionales().get(ref1).value().value().partesExternas());
        Assertions.assertEquals("LLantasTercera",event.repuestosProveedorAdicionales().get(ref3).value().value().llantasModificadas());


    }


    private List<DomainEvent> history() {
        Map<Referencia, RepuestosProveedorAdicionales> mapaRepuestosProveedorAdicional = new HashMap<Referencia, RepuestosProveedorAdicionales>();
        mapaRepuestosProveedorAdicional.put(Referencia.of("2020"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasPrimera", "LLantasPrimeras")) );
        mapaRepuestosProveedorAdicional.put(Referencia.of("2022"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasSeg", "LLantasSegundassss")) );
        mapaRepuestosProveedorAdicional.put(Referencia.of("2024"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasTerfcera", "LLantasTercera")) );


        return List.of(
                new CatalogoRepuestosCreado(CatalogoRepuestosID.of("1Catologo")),
                new RepuestosProveedorCreado(RepuestoProveedorID.of("1_1ProveedorRepuestoCC"), CatalogoRepuestosID.of("1Catologoz"), mapaRepuestosProveedorAdicional)
        );
    }
}