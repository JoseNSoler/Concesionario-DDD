package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.valor.DireccionCompletaID;
import co.com.concesionario.dominio.AdministradorGeneral.valor.Nomenclatura;
import co.com.concesionario.dominio.AdministradorGeneral.valor.Pais;
import co.com.sofka.domain.generic.Entity;

public class DirrecionCompleta extends Entity<DireccionCompletaID> {
    private Nomenclatura nomenclatura;

    public DirrecionCompleta(DireccionCompletaID entityId, Nomenclatura nomenclatura ) {
        this(entityId);
        this.nomenclatura = nomenclatura;
    }

    public DirrecionCompleta(DireccionCompletaID entityId){
        super(entityId);
    }



    public Nomenclatura nomenclatura() {
        return nomenclatura;
    }
}
