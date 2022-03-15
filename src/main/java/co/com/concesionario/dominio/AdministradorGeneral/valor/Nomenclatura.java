package co.com.concesionario.dominio.AdministradorGeneral.valor;

import co.com.sofka.domain.generic.ValueObject;

public class Nomenclatura implements ValueObject<String> {
    private String nomenclaturaFisica;

    public Nomenclatura(String nomenclaturaFisica) {
        this.nomenclaturaFisica = nomenclaturaFisica;
    }

    public static Nomenclatura of(String nomenclaturaFisica){
        return new Nomenclatura(nomenclaturaFisica);
    }

    @Override
    public String value() {
        return nomenclaturaFisica;
    }
}
