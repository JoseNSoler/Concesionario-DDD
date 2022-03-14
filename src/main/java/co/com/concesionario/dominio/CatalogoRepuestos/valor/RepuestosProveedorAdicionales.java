package co.com.concesionario.dominio.CatalogoRepuestos.valor;

import co.com.concesionario.valorglobal.Adicionales;
import co.com.sofka.domain.generic.ValueObject;

public class RepuestosProveedorAdicionales implements ValueObject<Adicionales>{

    private final Adicionales adicionales;

    
    public RepuestosProveedorAdicionales(Adicionales adicionales) {
        this.adicionales = adicionales;
    }

    public static RepuestosProveedorAdicionales of(Adicionales adicionales){
        return new RepuestosProveedorAdicionales(adicionales);
    }

    @Override
    public Adicionales value(){
        return adicionales;
    }

}
