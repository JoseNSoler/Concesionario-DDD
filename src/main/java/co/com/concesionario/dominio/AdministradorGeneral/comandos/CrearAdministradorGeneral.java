package co.com.concesionario.dominio.AdministradorGeneral.comandos;

import co.com.concesionario.dominio.AdministradorGeneral.valor.AdministradorGeneralID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.sofka.domain.generic.Command;

public class CrearAdministradorGeneral extends Command {
    private final AdministradorGeneralID administradorGeneralID;

    public CrearAdministradorGeneral(AdministradorGeneralID administradorGeneralID){
        this.administradorGeneralID = administradorGeneralID;
    }

    public AdministradorGeneralID getAdministradorGeneralID() {
        return administradorGeneralID;
    }
}
