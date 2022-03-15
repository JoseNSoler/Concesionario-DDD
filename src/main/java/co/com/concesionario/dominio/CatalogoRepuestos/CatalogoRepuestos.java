package co.com.concesionario.dominio.CatalogoRepuestos;

import co.com.concesionario.dominio.CatalogoRepuestos.eventos.*;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.*;
import co.com.concesionario.valorglobal.Referencia;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;

public class CatalogoRepuestos extends AggregateEvent<CatalogoRepuestosID> {
    protected RepuestosProveedor repuestosProveedor;
    protected RepuestosLocal repuestosLocal;
    

    public CatalogoRepuestos(CatalogoRepuestosID catalogoRepuestosID){
        super(catalogoRepuestosID);
        appendChange(new CatalogoRepuestosCreado(catalogoRepuestosID)).apply();
        subscribe(new CatalogoRepuestosEventChange(this));
    }

    public static CatalogoRepuestos from(CatalogoRepuestosID catalogoRepuestosID, List<DomainEvent> events){
        var catalogoRepuestos = new CatalogoRepuestos(catalogoRepuestosID);
        events.forEach(catalogoRepuestos::applyEvent);
        return catalogoRepuestos;
    }


    public void crearRepuestosProveedor(RepuestoProveedorID repuestoProveedorID, CatalogoRepuestosID catalogoRepuestosID,
                                        Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales){
        appendChange(new RepuestosProveedorCreado(repuestoProveedorID, catalogoRepuestosID,  repuestosProveedorAdicionales)).apply();
    }


    public void crearRepuestosLocal(RepuestoLocalID repuestolocalID, CatalogoRepuestosID catalogoRepuestosID,
                                    Map<Referencia, RepuestosLocalAdicionales> repuestosLocalAdicionales){
        appendChange(new RepuestoLocalCreado(repuestolocalID, catalogoRepuestosID,  repuestosLocalAdicionales)).apply();
    }




    public void agregarRepuestosProveedorAdicionales(CatalogoRepuestosID catalogoRepuestosID, RepuestosProveedorAdicionales repuestosProveedorAdicionales,
                                                     RepuestoProveedorID repuestoProveedorID, Referencia referencia){
        appendChange(new RepuestosProveedorAdicionalesAgregado(catalogoRepuestosID, repuestosProveedorAdicionales, repuestoProveedorID, referencia))
                .apply();
    }

    public void crearVariosRepuestosProveedorAdicionales(RepuestoProveedorID repuestoProveedorID, CatalogoRepuestosID catalogoRepuestosID,
                                                           Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales){
        appendChange(new VariosAdicionalesRepuestosProveedorCreados(repuestoProveedorID, catalogoRepuestosID, repuestosProveedorAdicionales))
                .apply();
    }

    public void modificarRepuestosProveedorAdicionalesPorReferencia(CatalogoRepuestosID catalogoRepuestosID, RepuestosProveedorAdicionales repuestosProveedorAdicionales,
                                                                    RepuestoProveedorID repuestoProveedorID, Referencia referencia){
        appendChange(new RepuestosProveedorAdicionalesPorReferenciaModificados(catalogoRepuestosID, repuestosProveedorAdicionales, repuestoProveedorID, referencia))
                .apply();
    }



    public RepuestosProveedor repuestosProveedor(){
        return repuestosProveedor;
    }
}
