package co.com.concesionario.dominio.CatalogoRepuestos.valor;

import co.com.sofka.domain.generic.ValueObject;

public class RepuestosProveedorReferencia implements ValueObject<String> {
    private final String repuestoProveedorReferencia;

    public RepuestosProveedorReferencia(String repuestoProveedorReferencia) {
        this.repuestoProveedorReferencia = repuestoProveedorReferencia;
    }

    public static RepuestosProveedorReferencia of(String valor) {
        return new RepuestosProveedorReferencia(valor);
    }

    @Override
    public String value() {
        return repuestoProveedorReferencia;
    }


}
