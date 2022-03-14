package co.com.concesionario.dominio.CatalogoRepuestos.valor;

import co.com.sofka.domain.generic.Identity;

public class CatalogoRepuestosID extends Identity{

    private CatalogoRepuestosID(String valor){
        super(valor);
    }

    public CatalogoRepuestosID(){}

    public static CatalogoRepuestosID of(String valor) {
        return new CatalogoRepuestosID(valor);
    }


}
