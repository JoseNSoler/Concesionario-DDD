package co.com.concesionario.dominio.CatalogoCarros.valor;

import co.com.sofka.domain.generic.Identity;

public class CarrosTercerosID extends Identity {
    private CarrosTercerosID(String valor){
        super(valor);
    }

    public CarrosTercerosID(){}

    public static CarrosTercerosID of(String valor) {
        return new CarrosTercerosID(valor);
    }
}
