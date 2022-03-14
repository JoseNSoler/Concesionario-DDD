package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Adicionales;
import co.com.sofka.domain.generic.ValueObject;

public class Nombres implements ValueObject<Nombres.Props> {
    private String primerosNombres;
    private String apellidos;

    public Nombres(String primerosNombres, String apellido) {
        this.primerosNombres = primerosNombres;
        this.apellidos = apellidos;
    }

    public static Nombres of(String primerosNombres, String apellido){
        return new Nombres(primerosNombres, apellido);
    }

    @Override
    public Props value(){
        return new Props(){

            @Override
            public String primerosNombres() {
                return null;
            }

            @Override
            public String apellidos() {
                return null;
            }
        };
    }

    public interface Props{
        String primerosNombres();
        String apellidos();
    }
}
