package co.com.concesionario.dominio.AdministradorGeneral;

import co.com.concesionario.dominio.AdministradorGeneral.valor.*;
import co.com.sofka.domain.generic.Entity;

public class Usuario extends Entity<UsuarioID> {
    private Nombres nombres;
    private Pais pais;


    public Usuario(UsuarioID entityId, Nombres nombres, Pais pais) {
        super(entityId);
        this.nombres = nombres;
        this.pais = pais;

    }

    public Nombres nombres() {
        return nombres;
    }

    public Pais pais() {
        return pais;
    }
}
