package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.sofka.domain.generic.Identity;

public class UsuarioID extends Identity {
    private UsuarioID(String valor){
        super(valor);
    }

    public UsuarioID(){}

    public static UsuarioID of (String valor) {
        return new UsuarioID(valor);
    }
}
