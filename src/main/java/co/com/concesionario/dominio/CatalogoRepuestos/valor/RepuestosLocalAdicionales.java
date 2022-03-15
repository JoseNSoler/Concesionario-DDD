package co.com.concesionario.dominio.CatalogoRepuestos.valor;

import co.com.concesionario.valorglobal.Adicionales;
import co.com.sofka.domain.generic.ValueObject;

public class RepuestosLocalAdicionales implements ValueObject<Adicionales> {
    private final Adicionales adicionales;

    public RepuestosLocalAdicionales(Adicionales adicionales) {
        this.adicionales = adicionales;
    }

    public static RepuestosLocalAdicionales of(Adicionales adicionales){
        return new RepuestosLocalAdicionales(adicionales);
    }

    @Override
    public Adicionales value(){
        return adicionales;
    }
    
}
