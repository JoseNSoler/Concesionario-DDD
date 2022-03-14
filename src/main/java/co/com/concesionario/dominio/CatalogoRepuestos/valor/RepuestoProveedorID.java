package co.com.concesionario.dominio.CatalogoRepuestos.valor;

import co.com.sofka.domain.generic.Identity;

public class RepuestoProveedorID extends Identity{

    private RepuestoProveedorID(String valor){
        super(valor);
    }

    public RepuestoProveedorID(){}

    public static RepuestoProveedorID of(String valor) {
        return new RepuestoProveedorID(valor);
    }
}
