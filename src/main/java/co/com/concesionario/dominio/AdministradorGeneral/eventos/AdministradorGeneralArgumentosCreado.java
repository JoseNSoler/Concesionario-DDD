package co.com.concesionario.dominio.AdministradorGeneral.eventos;

import co.com.concesionario.dominio.AdministradorGeneral.Usuario;
import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.sofka.domain.generic.DomainEvent;

public class AdministradorGeneralArgumentosCreado extends DomainEvent {
    private final AdministradorGeneralID administradorGeneralID;
    protected Usuario usuario;
    protected UsuarioID usuarioID;
    protected DireccionCompletaID direccionCompletaID;
    protected Pais pais;


    public AdministradorGeneralArgumentosCreado(AdministradorGeneralID administradorGeneralID, Usuario usuario,
                                                UsuarioID usuarioID, DireccionCompletaID direccionCompletaID, Pais pais
                                                ){
        super("administradorgeneral.administradorgeneralcreado");
        this.administradorGeneralID = administradorGeneralID;
        this.usuario = usuario;
        this.usuarioID = usuarioID;
        this.direccionCompletaID = direccionCompletaID;
        this.pais = pais;

    }


    public AdministradorGeneralID getAdministradorGeneralID() {
        return administradorGeneralID;
    }

    public Pais getPais() {
        return pais;
    }

    public DireccionCompletaID getDireccionCompletaID() {
        return direccionCompletaID;
    }



    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }
}
