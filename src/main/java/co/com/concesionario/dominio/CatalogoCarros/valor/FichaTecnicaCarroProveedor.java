package co.com.concesionario.dominio.CatalogoCarros.valor;

import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorTecnomecanicos;
import co.com.concesionario.valorglobal.Adicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.concesionario.valorglobal.Tecnomecanicos;
import co.com.sofka.domain.generic.ValueObject;

public class FichaTecnicaCarroProveedor implements ValueObject<FichaTecnicaCarroProveedor.Props> {

    private final Adicionales adicionales;
    private final Tecnomecanicos tecnomecanicos;
    private final Referencia referencia;

    // Constructor
    public FichaTecnicaCarroProveedor(Adicionales adicionales, Tecnomecanicos tecnomecanicos,
                                      Referencia referencia) {
        this.adicionales = adicionales;
        this.tecnomecanicos = tecnomecanicos;
        this.referencia = referencia;
    }

    public static FichaTecnicaCarroProveedor of(Adicionales adicionales, Tecnomecanicos tecnomecanicos, Referencia referencia) {
        return new FichaTecnicaCarroProveedor(adicionales, tecnomecanicos, referencia);
    }

    @Override
    public Props value() {
        // TODO Auto-generated method stub
        return new Props(){

            @Override
            public Adicionales adicionales() {
                return adicionales;
            }

            @Override
            public Tecnomecanicos tecnomecanicos() {
                return tecnomecanicos;
            }

            @Override
            public Referencia referencia() {
                return referencia;
            }

        };
    }

    // Declaracion interfaz
    public interface Props{
        Adicionales adicionales();
        Tecnomecanicos tecnomecanicos();
        Referencia referencia();
    }
}
