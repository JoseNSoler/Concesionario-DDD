package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.sofka.domain.generic.Entity;

public class Usuario extends Entity<UsuarioID> {
    private NombresCompletos nombresCompletos;
    private DirrecionCompleta direccionCompleta;

    public Usuario(UsuarioID entityId, DireccionCompletaID direccionCompletaID, Pais pais,
                    NombresCompletosID nombresCompletosID, Nombres nombre ) {
        super(entityId);
        this.direccionCompleta = new DirrecionCompleta(direccionCompletaID, pais);
        this.nombresCompletos = new NombresCompletos(nombresCompletosID, nombre);

    }

    public DirrecionCompleta direccionCompleta() {
        return direccionCompleta;
    }

    public NombresCompletos nombresCompletos() {
        return nombresCompletos;
    }
}
