package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.eventos.AdministradorGeneralArgumentosCreado;
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
    protected Nombres nombres;
    protected Pais pais;


    protected DireccionCompletaID direccionCompletaID;
    protected DirrecionCompleta dirrecionCompleta;
    protected Nomenclatura nomenclatura;



    public AdministradorGeneral(AdministradorGeneralID entityId, UsuarioID usuarioID,
                                Nombres nombres, Pais pais,
                                DireccionCompletaID direccionCompletaID, Nomenclatura nomenclatura) {
        this(entityId);
        appendChange(new AdministradorGeneralArgumentosCreado(entityId, usuarioID, nombres, pais, direccionCompletaID, nomenclatura)).apply();
        subscribe(new AdministradorGeneralEventChange(this));
    }

    public AdministradorGeneral(AdministradorGeneralID entityId) {
        super(entityId);
        appendChange(new AdministradorGeneralCreado(entityId)).apply();
        subscribe(new AdministradorGeneralEventChange(this));
    }


    public static AdministradorGeneral from(AdministradorGeneralID entityId, List<DomainEvent> events){
        var administradorGeneral = new AdministradorGeneral(entityId);
        events.forEach(administradorGeneral::applyEvent);
        return administradorGeneral;
    }


    // Agregar

    public Usuario usuario() {
        return usuario;
    }
}
