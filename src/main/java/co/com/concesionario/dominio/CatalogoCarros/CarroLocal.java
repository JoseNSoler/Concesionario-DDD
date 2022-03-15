package co.com.concesionario.dominio.CatalogoCarros;

import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosLocalID;
import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosProveedorID;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroLocal;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroProveedor;
import co.com.concesionario.valorglobal.Kilometraje;
import co.com.sofka.domain.generic.Entity;

public class CarroLocal extends Entity<CarrosLocalID> {
    FichaTecnicaCarroLocal fichaTecnicaCarroLocal;
    Kilometraje kilometraje;


    // Constructores
    public CarroLocal(CarrosLocalID entityId, FichaTecnicaCarroLocal fichaTecnicaCarroLocal,
                          Kilometraje kilometraje) {
        super(entityId);
        this.fichaTecnicaCarroLocal = fichaTecnicaCarroLocal;
        this.kilometraje = kilometraje;
    }

    public CarroLocal(CarrosLocalID entityId){
        super(entityId);
    }



    // "Getters" o exponer propiedades
    public FichaTecnicaCarroLocal fichaTecnicaCarroLocal() {
        return fichaTecnicaCarroLocal;
    }

    public Kilometraje kilometraje() {
        return kilometraje;
    }
}
