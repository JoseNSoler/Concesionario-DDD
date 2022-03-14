package co.com.concesionario.dominio.AdministradorGeneral.eventos;

import co.com.concesionario.dominio.AdministradorGeneral.valor.AdministradorGeneralID;
import co.com.sofka.domain.generic.DomainEvent;

public class AdministradorGeneralCreado extends DomainEvent {
    private final AdministradorGeneralID administradorGeneralID;

    public AdministradorGeneralCreado(AdministradorGeneralID administradorGeneralID){
        super("administradorgeneral.administradorgeneralcreado");
        this.administradorGeneralID = administradorGeneralID;
    }

    public AdministradorGeneralID getAdministradorGeneralID() {
        return administradorGeneralID;
    }
}
