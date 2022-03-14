package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosProveedorID;
import co.com.sofka.domain.generic.Identity;

public class AdministradorGeneralID extends Identity {
    private AdministradorGeneralID(String valor){
        super(valor);
    }

    public AdministradorGeneralID(){}

    public static AdministradorGeneralID of (String valor) {
        return new AdministradorGeneralID(valor);
    }
}
