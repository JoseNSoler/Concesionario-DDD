package co.com.concesionario.dominio.CatalogoRepuestos.valor;

import co.com.sofka.domain.generic.Identity;

public class RepuestoLocalID extends Identity{
    private RepuestoLocalID(String valor){
        super(valor);
    }

    public RepuestoLocalID(){}

    public static RepuestoLocalID of(String valor) {
        return new RepuestoLocalID(valor);
    }
}
