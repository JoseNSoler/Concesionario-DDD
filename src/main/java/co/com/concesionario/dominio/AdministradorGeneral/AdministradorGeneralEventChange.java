package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.eventos.AdministradorGeneralArgumentosCreado;
import co.com.concesionario.dominio.AdministradorGeneral.eventos.AdministradorGeneralCreado;
import co.com.sofka.domain.generic.EventChange;

public class AdministradorGeneralEventChange extends EventChange {
    public AdministradorGeneralEventChange(AdministradorGeneral administradorGeneral){

        apply((AdministradorGeneralCreado event) -> {

        });

        apply((AdministradorGeneralArgumentosCreado event) -> {
            System.out.println(String.format("%s %s %s", event.usuarioID(),
                    event.pais().value(), event.nombres().value().primerosNombres()));
            administradorGeneral.usuario = new Usuario( event.usuarioID(), event.nombres(),
                                                        event.pais());
            administradorGeneral.dirrecionCompleta = new DirrecionCompleta(event.direccionCompletaID(), event.nomenclatura());
        });
    }
}
