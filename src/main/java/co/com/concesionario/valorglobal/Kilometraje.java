package co.com.concesionario.valorglobal;

import co.com.sofka.domain.generic.ValueObject;

public class Kilometraje implements ValueObject<Double> {
    private final Double valorKilometraje;

    public Kilometraje(Double valorKilometraje) {
        this.valorKilometraje = valorKilometraje;
    }

    public static Kilometraje of(Double valor) {
        return new Kilometraje(valor);
    }

    @Override
    public Double value() {
        return valorKilometraje;
    }

}
