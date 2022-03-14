package co.com.concesionario.valorglobal;

import co.com.sofka.domain.generic.ValueObject;

public class Referencia implements ValueObject<String> {
    private final String repuestoProveedorReferencia;

    public Referencia(String repuestoProveedorReferencia) {
        this.repuestoProveedorReferencia = repuestoProveedorReferencia;
    }

    public static Referencia of(String valor) {
        return new Referencia(valor);
    }

    @Override
    public String value() {
        return repuestoProveedorReferencia;
    }


}
