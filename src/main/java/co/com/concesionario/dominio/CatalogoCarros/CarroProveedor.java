package co.com.concesionario.dominio.CatalogoCarros;

import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosProveedorID;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroProveedor;
import co.com.concesionario.valorglobal.Kilometraje;
import co.com.sofka.domain.generic.Entity;

import java.util.List;

public class CarroProveedor extends Entity<CarrosProveedorID> {
    FichaTecnicaCarroProveedor fichaTecnicaCarroProveedor;
    Kilometraje kilometraje;


    // Constructores
    public CarroProveedor(CarrosProveedorID entityId, FichaTecnicaCarroProveedor fichaTecnicaCarroProveedor,
                          Kilometraje kilometraje) {
        super(entityId);
        this.fichaTecnicaCarroProveedor = fichaTecnicaCarroProveedor;
        this.kilometraje = kilometraje;
    }

    public CarroProveedor(CarrosProveedorID entityId){
        super(entityId);
    }



    // "Getters" o exponer propiedades
    public FichaTecnicaCarroProveedor fichaTecnicaCarroProveedor() {
        return fichaTecnicaCarroProveedor;
    }

    public Kilometraje kilometraje() {
        return kilometraje;
    }
}
