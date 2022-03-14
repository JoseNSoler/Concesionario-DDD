package co.com.concesionario.dominio.CatalogoCarros.valor;

import co.com.sofka.domain.generic.Identity;

public class CatalogoCarrosID extends Identity {
    private CatalogoCarrosID(String valor){
        super(valor);
    }

    public CatalogoCarrosID(){}

    public static CatalogoCarrosID of (String valor) {
        return new CatalogoCarrosID(valor);
    }
}
