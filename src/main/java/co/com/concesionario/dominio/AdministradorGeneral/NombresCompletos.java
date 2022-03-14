package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.valor.Nombres;
import co.com.concesionario.dominio.AdministradorGeneral.valor.NombresCompletosID;
import co.com.sofka.domain.generic.Entity;

public class NombresCompletos extends Entity<NombresCompletosID> {
    private Nombres nombres;

    public NombresCompletos(NombresCompletosID entityId, Nombres nombres) {
        super(entityId);
        this.nombres = nombres;
    }

    public Nombres nombres() {
        return nombres;
    }
}
