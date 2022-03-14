package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.valor.DireccionCompletaID;
import co.com.concesionario.dominio.AdministradorGeneral.valor.Pais;
import co.com.sofka.domain.generic.Entity;

public class DirrecionCompleta extends Entity<DireccionCompletaID> {
    private Pais pais;
    public DirrecionCompleta(DireccionCompletaID entityId, Pais pais ) {
        super(entityId);
        this.pais = pais;
    }

    public Pais pais() {
        return pais;
    }
}
