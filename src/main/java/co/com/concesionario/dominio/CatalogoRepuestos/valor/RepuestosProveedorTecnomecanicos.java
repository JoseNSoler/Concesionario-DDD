package co.com.concesionario.dominio.CatalogoRepuestos.valor;

import co.com.concesionario.valorglobal.Tecnomecanicos;
import co.com.sofka.domain.generic.ValueObject;

public class RepuestosProveedorTecnomecanicos implements ValueObject<RepuestosProveedorTecnomecanicos.Props>{
    private final Tecnomecanicos tecnomecanicos;
    private final String referencia;


    // Constructor
    public RepuestosProveedorTecnomecanicos(Tecnomecanicos tecnomecanicos, String referencia) {
        this.tecnomecanicos = tecnomecanicos;
        this.referencia = referencia;
    }


    // Implementacion para varios valores por medio de un objeto propiedades
    @Override
    public Props value() {
        // TODO Auto-generated method stub
        return new Props(){

            @Override
            public Tecnomecanicos tecnomecanicos() {
                return tecnomecanicos;
            }

            @Override
            public String referencia() {
                return referencia;
            }          
            
        };
    }

    public String getReferencia() {
        return referencia;
    }


    // Declaracion interfaz
    public interface Props{
        Tecnomecanicos tecnomecanicos();
        String referencia();
    }
    
}
