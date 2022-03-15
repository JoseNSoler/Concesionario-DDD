package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Adicionales;
import co.com.sofka.domain.generic.ValueObject;

public class Nombres implements ValueObject<Nombres.Props> {
    private String primerosNombres;
    private String apellidos;

    public Nombres(String primerosNombres, String apellidos) {
        this.primerosNombres = primerosNombres;
        this.apellidos = apellidos;
    }

    public static Nombres of(String primerosNombres, String apellidos){
        return new Nombres(primerosNombres, apellidos);
    }

    @Override
    public Props value(){
        return new Props(){

            @Override
            public String primerosNombres() {
                return primerosNombres;
            }

            @Override
            public String apellidos() {
                return apellidos;
            }
        };
    }

    public interface Props{
        String primerosNombres();
        String apellidos();
    }
}
