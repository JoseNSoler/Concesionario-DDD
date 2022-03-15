package co.com.concesionario.dominio.CatalogoCarros;

import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosLocalID;
import co.com.concesionario.dominio.CatalogoCarros.valor.CarrosTercerosID;
import co.com.concesionario.dominio.CatalogoCarros.valor.FichaTecnicaCarroLocal;
import co.com.concesionario.valorglobal.Kilometraje;
import co.com.sofka.domain.generic.Entity;

public class CarroTerceros extends Entity<CarrosTercerosID> {
    FichaTecnicaCarroLocal fichaTecnicaCarroLocal;
    Kilometraje kilometraje;


    // Constructores
    public CarroTerceros(CarrosTercerosID entityId, FichaTecnicaCarroLocal fichaTecnicaCarroLocal,
                      Kilometraje kilometraje) {
        super(entityId);
        this.fichaTecnicaCarroLocal = fichaTecnicaCarroLocal;
        this.kilometraje = kilometraje;
    }

    public CarroTerceros(CarrosTercerosID entityId){
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

