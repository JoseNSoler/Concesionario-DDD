package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Nombres implements ValueObject<Nombres.Props> {
    private String primerosNombres;
    private String apellidos;

    public Nombres(String primerosNombres, String Apellido) {
        this.primerosNombres = primerosNombres;
        this.apellidos = apellidos;
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
