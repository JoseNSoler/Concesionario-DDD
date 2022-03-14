package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.comandos.AgregarRepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.comandos.ModificarRepuestoProveedorAdicionalesPorReferencia;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.CatalogoRepuestosCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.RepuestosProveedorAdicionalesAgregado;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.RepuestosProveedorAdicionalesPorReferenciaModificados;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.RepuestosProveedorCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorReferencia;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ModificarRepuestosProveedorAdicionalesPorReferenciaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarRepuestosProoveedor(){
        // Arrange
        var catalogoRepuestosID = CatalogoRepuestosID.of("1Catalogo");
        var repuestosProveedorID = RepuestoProveedorID.of("1_1ProveedorRepuestoCC");
        var adicionales = Adicionales.of("partesExternasModificada", "LLantasSegundas");
        var repuestosProveedorReferencia = RepuestosProveedorReferencia.of("2115");
        var repuestosProveedorAdicionales = RepuestosProveedorAdicionales.of(adicionales);


        var command = new ModificarRepuestoProveedorAdicionalesPorReferencia(
                catalogoRepuestosID,
                repuestosProveedorAdicionales,
                repuestosProveedorID,
                repuestosProveedorReferencia);

        var usecase = new ModificarRepuestosProveedorAdicionalesPorReferenciaUseCase();

        Mockito.when(repository.getEventsBy("1Catalogo")).thenReturn(history());
        usecase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(catalogoRepuestosID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert

        var eventoo = (RepuestosProveedorAdicionalesAgregado) events.get(0);

        var event = (RepuestosProveedorAdicionalesPorReferenciaModificados) events.get(2);





        assertEquals("catalogorepuestos.repuestosproveedoradicionalesporreferenciamodificados", event.type);

        Assertions.assertEquals("partesExternasModificada", event.getRepuestosProveedorAdicionales().value().value().partesExternas() );

        Assertions.assertEquals("LLantasSegundas", event.getRepuestosProveedorAdicionales().value().value().llantasModificadas() );




        /*
        Assertions.assertEquals("1Catalogo", event.getCatalogoRepuestosID().value());
        Assertions.assertEquals("1_1ProveedorRepuestoCC", event.getRepuestoProveedorID().value());
        */

    }


    private List<DomainEvent> history() {
        return List.of(
                // crear catalogo principal repuestos
                new CatalogoRepuestosCreado(CatalogoRepuestosID.of("1Catologo")),
                // crear categoria repuestos prooveedor
                new RepuestosProveedorCreado(RepuestoProveedorID.of("1_1ProveedorRepuestoCC"), CatalogoRepuestosID.of("1Catologoz")),
                // agregar atributos, a los adicionales a la categoria de prooveedor
                new RepuestosProveedorAdicionalesAgregado(
                        CatalogoRepuestosID.of("1Catologoz"),
                        RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasPrimera", "LLantasPrimeras")),
                        RepuestoProveedorID.of("1_1ProveedorRepuestoCC"),
                        RepuestosProveedorReferencia.of("2115")),
                // modificar atributos, a los adicionales a la categoria de prooveedor por referencia
                new RepuestosProveedorAdicionalesPorReferenciaModificados(CatalogoRepuestosID.of("1Catologoz"),
                        RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasModificada", "LLantasSegundas")),
                        RepuestoProveedorID.of("1_1ProveedorRepuestoCC"),
                        RepuestosProveedorReferencia.of("2115"))
        );
    }
}