package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.sofka.domain.generic.Identity;

public class NombresCompletosID extends Identity {
    private NombresCompletosID(String valor){
        super(valor);
    }

    public NombresCompletosID(){}

    public static NombresCompletosID of (String valor) {
        return new NombresCompletosID(valor);
    }
}
