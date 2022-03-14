package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.concesionario.valorglobal.Adicionales;
import co.com.sofka.domain.generic.AggregateEvent;

public class AdministradorGeneral extends AggregateEvent<AdministradorGeneralID> {

    protected Usuario usuario;
    protected UsuarioID usuarioID;
    protected DireccionCompletaID direccionCompletaID;
    protected Pais pais;
    protected NombresCompletosID nombresCompletosID;
    protected Nombres nombre;


    public AdministradorGeneral(AdministradorGeneralID entityId, Usuario usuario,
                                UsuarioID usuarioID, DireccionCompletaID direccionCompletaID,
                                Pais pais, Nombres nombre) {
        super(entityId);
        this.usuario = usuario;
        this.usuarioID = usuarioID;
        this.direccionCompletaID = direccionCompletaID;
        this.pais = pais;
        this.nombre = nombre;

    }

    public AdministradorGeneral(AdministradorGeneralID entityId) {
        super(entityId);

    }
}
