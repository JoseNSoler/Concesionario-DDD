package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.eventos.AdministradorGeneralCreado;
import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestos;
import co.com.concesionario.dominio.CatalogoRepuestos.CatalogoRepuestosEventChange;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.CatalogoRepuestosID;
import co.com.concesionario.valorglobal.Adicionales;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class AdministradorGeneral extends AggregateEvent<AdministradorGeneralID> {

    protected Usuario usuario;
    protected UsuarioID usuarioID;
    protected DireccionCompletaID direccionCompletaID;
    protected Pais pais;
    protected NombresCompletosID nombresCompletosID;
    protected Nombres nombre;

    public AdministradorGeneral(AdministradorGeneralID entityId) {
        super(entityId);
        appendChange(new AdministradorGeneralCreado(entityId)).apply();
        subscribe(new AdministradorGeneralEventChange(this));
    }

    public AdministradorGeneral(AdministradorGeneralID entityId, Usuario usuario,
                                UsuarioID usuarioID, DireccionCompletaID direccionCompletaID,
                                Pais pais, Nombres nombre) {
        this(entityId);
        this.usuario = usuario;
        this.usuarioID = usuarioID;
        this.direccionCompletaID = direccionCompletaID;
        this.pais = pais;
        this.nombre = nombre;

    }



    public static AdministradorGeneral from(AdministradorGeneralID entityId, List<DomainEvent> events){
        var administradorGeneral = new AdministradorGeneral(entityId);
        events.forEach(administradorGeneral::applyEvent);
        return administradorGeneral;
    }







}
