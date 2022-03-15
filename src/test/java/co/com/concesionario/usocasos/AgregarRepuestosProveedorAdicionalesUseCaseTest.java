package co.com.concesionario.usocasos;

import co.com.concesionario.dominio.CatalogoRepuestos.comandos.AgregarRepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.CatalogoRepuestosCreado;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.RepuestosProveedorAdicionalesAgregado;
import co.com.concesionario.dominio.CatalogoRepuestos.eventos.RepuestosProveedorCreado;
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

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AgregarRepuestosProveedorAdicionalesUseCaseTest {
/*
    @Mock
    private DomainEventRepository repository;

    @Test
    void crearRepuestosProoveedor(){
        // Arrange
        var catalogoRepuestosID = CatalogoRepuestosID.of("1Catalogo");
        var repuestosProveedorID = RepuestoProveedorID.of("1_1ProveedorRepuestoCC");
        var adicionales = Adicionales.of("partesExternasPrimera", "LLantasPrimeras");
        var repuestosProveedorReferencia = Referencia.of("2115");
        var repuestosProveedorAdicionales = RepuestosProveedorAdicionales.of(adicionales);


        var command = new AgregarRepuestosProveedorAdicionales(
                catalogoRepuestosID,
                repuestosProveedorAdicionales,
                repuestosProveedorID,
                repuestosProveedorReferencia);

        var usecase = new AgregarRepuestosProveedorAdicionalesUseCase();

        Mockito.when(repository.getEventsBy("1Catalogo")).thenReturn(history());
        usecase.addRepository(repository);

        // Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(catalogoRepuestosID.value())
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        // Assert

        var event = (RepuestosProveedorAdicionalesAgregado) events.get(1);



        Assertions.assertEquals("catalogorepuestos.repuestosproveedoradicionalesagregado", event.type);

        Assertions.assertEquals("partesExternasPrimera", event.getRepuestosProveedorAdicionales().value().value().partesExternas() );

        Assertions.assertEquals("LLantasPrimeras", event.getRepuestosProveedorAdicionales().value().value().llantasModificadas() );


        Assertions.assertEquals("1Catalogo", event.getCatalogoRepuestosID().value());
        Assertions.assertEquals("1_1ProveedorRepuestoCC", event.getRepuestoProveedorID().value());






    }


    private List<DomainEvent> history() {
        return List.of(
                new CatalogoRepuestosCreado(CatalogoRepuestosID.of("1Catologo")),
                new RepuestosProveedorCreado(RepuestoProveedorID.of("1_1ProveedorRepuestoCC"), CatalogoRepuestosID.of("1Catologoz")),
                new RepuestosProveedorAdicionalesAgregado(
                        CatalogoRepuestosID.of("1Catologoz"),
                        RepuestosProveedorAdicionales.of(Adicionales.of("partesExternasPrimera", "LLantasPrimeras")),
                        RepuestoProveedorID.of("1_1ProveedorRepuestoCC"),
                        Referencia.of("2115"))

        );
    }
    */
}