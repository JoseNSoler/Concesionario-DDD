package co.com.concesionario.dominio.CatalogoCarros.valor;

import co.com.sofka.domain.generic.Identity;

public class CarrosProveedorID extends Identity {
    private CarrosProveedorID(String valor){
        super(valor);
    }

    public CarrosProveedorID(){}

    public static CarrosProveedorID of (String valor) {
        return new CarrosProveedorID(valor);
    }
}
