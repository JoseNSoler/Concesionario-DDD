package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.sofka.domain.generic.Identity;

public class DireccionCompletaID extends Identity {
    private DireccionCompletaID(String valor){
        super(valor);
    }

    public DireccionCompletaID(){}

    public static DireccionCompletaID of (String valor) {
        return new DireccionCompletaID(valor);
    }
}
