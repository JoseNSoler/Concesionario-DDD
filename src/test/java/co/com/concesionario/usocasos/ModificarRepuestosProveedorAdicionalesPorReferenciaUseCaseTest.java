package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.comandos.ModificarRepuestoProveedorAdicionalesPorReferencia;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.*;
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
class ModificarRepuestosProveedorAdicionalesPorReferenciaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarRepuestosProoveedor(){
        // Arrange

        var referencia1 = Referencia.of("2020");
        var referencia2 = Referencia.of("2022");
        var referencia3 = Referencia.of("2024");


        var catalogoRepuestosID = CatalogoRepuestosID.of("1Catalogo");
        var repuestosProveedorID = RepuestoProveedorID.of("1_1ProveedorRepuestoCC");

        var command = new ModificarRepuestoProveedorAdicionalesPorReferencia(catalogoRepuestosID,
                RepuestosProveedorAdicionales.of(Adicionales.of("estas sonsa as", "LLantasPrimeras")),
                repuestosProveedorID, referencia3);

        var usecase = new ModificarRepuestosProveedorAdicionalesPorReferenciaUseCase();


        Mockito.when(repository.getEventsBy("1Catalogo")).thenReturn(history());
        usecase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(catalogoRepuestosID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event0 = (CatalogoRepuestosCreado) events.get(0);
        var event = (RepuestosProveedorAdicionalesPorReferenciaModificados) events.get(1);




        Assertions.assertEquals("estas sonsa as", event.getRepuestosProveedorAdicionales().value().value().partesExternas());
                //event2.getMapRepuestosProveedorAdicionales().get(referencia3).value().value().partesExternas()


    }


    private List<DomainEvent> history() {
        Map<Referencia, RepuestosProveedorAdicionales> mapaRepuestosProveedorAdicional = new HashMap<Referencia, RepuestosProveedorAdicionales>();
        mapaRepuestosProveedorAdicional.put(Referencia.of("2020"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasPrimera", "LLantasPrimeras")) );
        mapaRepuestosProveedorAdicional.put(Referencia.of("2022"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasSeg", "LLantasSegundassss")) );
        mapaRepuestosProveedorAdicional.put(Referencia.of("2024"), RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasTerfcera", "LLantasTercera")) );

        return List.of(
                new CatalogoRepuestosCreado(CatalogoRepuestosID.of("1Catologo")),
                new RepuestosProveedorCreado(RepuestoProveedorID.of("1_1ProveedorRepuestoCC"), CatalogoRepuestosID.of("1Catalogo"), mapaRepuestosProveedorAdicional)
        );

    }
}