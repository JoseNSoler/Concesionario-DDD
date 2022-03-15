package co.com.concesionario.dominio.AdministradorGeneral.comandos;

import co.com.concesionario.dominio.AdministradorGeneral.Usuario;
import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.sofka.domain.generic.Command;

public class CrearAdministradoGeneralArgumentos extends Command {

    private final AdministradorGeneralID administradorGeneralID;

    private final UsuarioID usuarioID;
    private final Nombres nombres;
    private final Pais pais;

    private final DireccionCompletaID direccionCompletaID;
    private final Nomenclatura nomenclatura;

    public CrearAdministradoGeneralArgumentos(AdministradorGeneralID administradorGeneralID, UsuarioID usuarioID,
                                              Nombres nombres, Pais pais,
                                              DireccionCompletaID direccionCompletaID, Nomenclatura nomenclatura) {
        this.administradorGeneralID = administradorGeneralID;
        this.usuarioID = usuarioID;
        this.nombres = nombres;
        this.pais = pais;

        this.direccionCompletaID = direccionCompletaID;
        this.nomenclatura = nomenclatura;

    }

    public AdministradorGeneralID administradorGeneralID() {
        return administradorGeneralID;
    }

    public UsuarioID usuarioID() {
        return usuarioID;
    }

    public Nombres nombres() {
        return nombres;
    }

    public Pais pais() {
        return pais;
    }

    public Nomenclatura nomenclatura() {
        return nomenclatura;
    }

    public DireccionCompletaID direccionCompletaID() {
        return direccionCompletaID;
    }

}
