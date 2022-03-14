package co.com.concesionario.valorglobal;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.sofka.domain.generic.ValueObject;

public class Adicionales implements ValueObject<Adicionales.Props>{

    private final String partesExternas;
    private final String llantasModificadas;


    // Constructor
    public Adicionales(String partesExternas, String llantasModificadas) {
        this.partesExternas = partesExternas;
        this.llantasModificadas = llantasModificadas;
    }

    public static Adicionales of(String partesExternas, String llantasModificadas) {
        return new Adicionales(partesExternas, llantasModificadas);
    }

    // Implementacion para varios valores por medio de un objeto propiedades
    @Override
    public Props value() {
        // TODO Auto-generated method stub
        return new Props(){

            @Override
            public String partesExternas() {
                return partesExternas;
            }

            @Override
            public String llantasModificadas() {
                return llantasModificadas;
            }
            
        };
    }

    // Declaracion interfaz
    public interface Props{
        String partesExternas();
        String llantasModificadas();
    }
}
