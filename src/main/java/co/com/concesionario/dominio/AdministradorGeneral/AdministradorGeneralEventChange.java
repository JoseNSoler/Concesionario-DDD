package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.eventos.AdministradorGeneralCreado;
import co.com.sofka.domain.generic.EventChange;

public class AdministradorGeneralEventChange extends EventChange {
    public AdministradorGeneralEventChange(AdministradorGeneral administradorGeneral){

        apply((AdministradorGeneralCreado event) -> {

        });
    }
}
