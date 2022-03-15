package co.com.concesionario.dominio.CatalogoCarros.valor;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.sofka.domain.generic.Identity;

public class CarrosLocalID extends Identity {

    private CarrosLocalID(String valor){
        super(valor);
    }

    public CarrosLocalID(){}

    public static CarrosLocalID of(String valor) {
        return new CarrosLocalID(valor);
    }
}
