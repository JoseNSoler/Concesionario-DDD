package co.com.concesionario.dominio.CatalogoCarros.valor;

import co.com.concesionario.valorglobal.Adicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.concesionario.valorglobal.Tecnomecanicos;
import co.com.sofka.domain.generic.ValueObject;

public class FichaTecnicaCarroLocal implements ValueObject<FichaTecnicaCarroLocal.Props> {
    private final Adicionales adicionales;
    private final Tecnomecanicos tecnomecanicos;
    private final Referencia referencia;

    // Constructor
    public FichaTecnicaCarroLocal(Adicionales adicionales, Tecnomecanicos tecnomecanicos,
                                      Referencia referencia) {
        this.adicionales = adicionales;
        this.tecnomecanicos = tecnomecanicos;
        this.referencia = referencia;
    }

    public static FichaTecnicaCarroLocal of(Adicionales adicionales, Tecnomecanicos tecnomecanicos, Referencia referencia) {
        return new FichaTecnicaCarroLocal(adicionales, tecnomecanicos, referencia);
    }

    @Override
    public FichaTecnicaCarroLocal.Props value() {
        // TODO Auto-generated method stub
        return new FichaTecnicaCarroLocal.Props(){

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
