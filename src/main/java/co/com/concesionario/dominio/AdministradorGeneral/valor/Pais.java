package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Adicionales;
import co.com.sofka.domain.generic.ValueObject;

public class Pais implements ValueObject<String> {
    private final String pais;


    public Pais(String pais) {
        this.pais = pais;
    }

    public static Pais of(String pais){
        return new Pais(pais);
    }

    @Override
    public String value(){
        return pais;
    }
}
