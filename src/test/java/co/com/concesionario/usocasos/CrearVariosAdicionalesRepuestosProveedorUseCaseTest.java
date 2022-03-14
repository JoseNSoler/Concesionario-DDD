package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.comandos.CrearVariosAdicionalesRepuestosProveedor;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.CatalogoRepuestosCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.VariosAdicionalesRepuestosProveedorCreados;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.concesionario.valorglobal.Adicionales;
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
class CrearVariosAdicionalesRepuestosProveedorUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    void crearVariosRepuestosProoveedor(){
        // Arrange

        // Creacion mapa personalizado con RepuestosProoveedor adicionales
        var referencia1 = Referencia.of("2020");
        var referencia2 = Referencia.of("2022");
        var referencia3 = Referencia.of("2024");
        HashMap<Referencia, RepuestosProveedorAdicionales> mapaRepuestosProveedorAdicional = new HashMap<Referencia, RepuestosProveedorAdicionales>();
        mapaRepuestosProveedorAdicional.put(referencia1, RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasPrimera", "LLantasPrimeras")) );
        mapaRepuestosProveedorAdicional.put(referencia2, RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasSeg", "LLantasSegu")) );
        mapaRepuestosProveedorAdicional.put(referencia3, RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasTerfcera", "LLantasTercera")) );


        var catalogoRepuestosID = CatalogoRepuestosID.of("1Catalogo");
        var repuestosProveedorID = RepuestoProveedorID.of("1_1ProveedorRepuestoCC");


        var command = new CrearVariosAdicionalesRepuestosProveedor(repuestosProveedorID, catalogoRepuestosID, mapaRepuestosProveedorAdicional);

        var usecase = new CrearVariosRepuestosProveedorAdicionalesUseCase();

        Mockito.when(repository.getEventsBy("1Catalogo")).thenReturn(history());
        usecase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(catalogoRepuestosID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert

        var event = (VariosAdicionalesRepuestosProveedorCreados) events.get(1);

        Assertions.assertEquals("catalogorepuestos.variosrepuestosproveedoradicionalesagregados", event.type);

        Assertions.assertEquals("1Catalogo", event.getCatalogoRepuestosID().value());
        Assertions.assertEquals("1_1ProveedorRepuestoCC", event.getRepuestoProveedorID().value());


        Assertions.assertEquals("LLantasTercera", event.getMapRepuestosProveedorAdicionales().get(referencia3).value().value().llantasModificadas());

        Assertions.assertEquals("partesExternasPrimera", event.getMapRepuestosProveedorAdicionales().get(referencia1).value().value().partesExternas());

    }


    private List<DomainEvent> history() {
        Map<Referencia, RepuestosProveedorAdicionales> mapaRepuestosProveedorAdicional = new HashMap<Referencia, RepuestosProveedorAdicionales>();
        mapaRepuestosProveedorAdicional.put(Referencia.of("2020"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasPrimera", "LLantasPrimeras")) );
        mapaRepuestosProveedorAdicional.put(Referencia.of("2020"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasSeg", "LLantasSegu")) );
        mapaRepuestosProveedorAdicional.put(Referencia.of("2020"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasTerfcera", "LLantasTercera")) );

        return List.of(
                new CatalogoRepuestosCreado(CatalogoRepuestosID.of("1Catologo")),
                new VariosAdicionalesRepuestosProveedorCreados(RepuestoProveedorID.of("1_1ProveedorRepuestoCC"), CatalogoRepuestosID.of("1Catologo"),
                        new HashMap<Referencia, RepuestosProveedorAdicionales>(mapaRepuestosProveedorAdicional) )

        );
    }
}