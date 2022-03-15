package co.com.concesionario.dominio.AdministradorGeneral.eventos;

import co.com.concesionario.dominio.AdministradorGeneral.Usuario;
import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.sofka.domain.generic.DomainEvent;

public class AdministradorGeneralArgumentosCreado extends DomainEvent {
    private final AdministradorGeneralID administradorGeneralID;

    private final UsuarioID usuarioID;
    private final Nombres nombres;
    private final Pais pais;


    private final DireccionCompletaID direccionCompletaID;
    private final Nomenclatura nomenclatura;



    public AdministradorGeneralArgumentosCreado(AdministradorGeneralID administradorGeneralID, UsuarioID usuarioID,
                                                Nombres nombres, Pais pais,
                                                DireccionCompletaID direccionCompletaID, Nomenclatura nomenclatura){
        super("administradorgeneral.administradorgeneralargumentoscreado");
        this.administradorGeneralID = administradorGeneralID;
        this.usuarioID = usuarioID;
        this.nombres = nombres;
        this.pais = pais;

        this.direccionCompletaID = direccionCompletaID;
        this.nomenclatura = nomenclatura;
    }

    public UsuarioID usuarioID() {
        return usuarioID;
    }

    public AdministradorGeneralID administradorGeneralID() {
        return administradorGeneralID;
    }


    public Pais pais() {
        return pais;
    }

    public Nombres nombres() {
        return nombres;
    }

    public Nomenclatura nomenclatura() {
        return nomenclatura;
    }

    public DireccionCompletaID direccionCompletaID() {
        return direccionCompletaID;
    }
}
