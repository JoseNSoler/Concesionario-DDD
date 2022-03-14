package co.com.concesionario.valorglobal;

import co.com.sofka.domain.generic.ValueObject;

public class Tecnomecanicos implements ValueObject<Tecnomecanicos.Props>{
    private final String llantas;
    private final String suspension;
    private final String transmision;
    private final String motor;


    // Constructor
    public Tecnomecanicos(String llantas, String suspension, String transmision, String motor) {
        this.llantas = llantas;
        this.suspension = suspension;
        this.transmision = transmision;
        this.motor = motor;
    }


    // Implementacion para varios valores por medio de un objeto propiedades
    @Override
    public Props value() {
        // TODO Auto-generated method stub
        return new Props(){

            @Override
            public String llantas() {
                return llantas;
            }

            @Override
            public String suspension() {
                return suspension;
            }

            @Override
            public String transmision() {
                return transmision;
            }
            @Override
            public String motor() {
                return motor;
            }
            
            
        };
    }


    // Declaracion interfaz
    public interface Props{
        String llantas();
        String suspension();
        String transmision();
        String motor();
    }
}
