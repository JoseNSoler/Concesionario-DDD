package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.valor.Nombres;
import co.com.concesionario.dominio.AdministradorGeneral.valor.NombresCompletosID;
import co.com.sofka.domain.generic.Entity;

public class InformacionLocal extends Entity<NombresCompletosID> {
    private Nombres nombres;

    public InformacionLocal(NombresCompletosID entityId, Nombres nombres) {
        super(entityId);
        this.nombres = nombres;
    }

    public Nombres nombres() {
        return nombres;
    }
}
