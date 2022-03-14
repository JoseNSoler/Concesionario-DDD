package co.com.concesionario.dominio.AdministradorGeneral.comandos;

import co.com.concesionario.dominio.AdministradorGeneral.Usuario;
import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.sofka.domain.generic.Command;

public class CrearAdministradoGeneralArgumentos extends Command {

    private final AdministradorGeneralID administradorGeneralID;
    protected Usuario usuario;
    protected UsuarioID usuarioID;
    protected DireccionCompletaID direccionCompletaID;
    protected Pais pais;
    protected NombresCompletosID nombresCompletosID;
    protected Nombres nombre;


    public CrearAdministradoGeneralArgumentos(AdministradorGeneralID administradorGeneralID, Usuario usuario,
                                              UsuarioID usuarioID, DireccionCompletaID direccionCompletaID, Pais pais,
                                              NombresCompletosID nombresCompletosID, Nombres nombre) {

        this.administradorGeneralID = administradorGeneralID;
        this.usuario = usuario;
        this.usuarioID = usuarioID;
        this.direccionCompletaID = direccionCompletaID;
        this.pais = pais;
        this.nombresCompletosID = nombresCompletosID;
        this.nombre = nombre;
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

    public Nombres getNombre() {
        return nombre;
    }

    public NombresCompletosID getNombresCompletosID() {
        return nombresCompletosID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }


}
