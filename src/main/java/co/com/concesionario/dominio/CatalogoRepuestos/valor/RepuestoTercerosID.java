package co.com.concesionario.dominio.CatalogoRepuestos.valor;

import co.com.sofka.domain.generic.Identity;

public class RepuestoTercerosID extends Identity {
    private RepuestoTercerosID(String valor){
        super(valor);
    }

    public RepuestoTercerosID(){}

    public static RepuestoTercerosID of(String valor) {
        return new RepuestoTercerosID(valor);
    }

}
