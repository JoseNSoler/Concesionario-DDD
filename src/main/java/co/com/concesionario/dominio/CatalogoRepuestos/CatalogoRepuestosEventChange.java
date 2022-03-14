package co.com.concesionario.dominio.CatalogoRepuestos;

import co.com.concesionario.dominio.CatalogoRepuestos.eventos.*;
import co.com.sofka.domain.generic.EventChange;

public class CatalogoRepuestosEventChange extends EventChange{
    public CatalogoRepuestosEventChange(CatalogoRepuestos catalogoRepuestos){

        apply((CatalogoRepuestosCreado event) -> {

        });

        apply((VariosAdicionalesRepuestosProveedorCreados event) -> {
            catalogoRepuestos.repuestosProveedor = new RepuestosProveedor(event.getRepuestoProveedorID(), event.getMapRepuestosProveedorAdicionales());

        });

        apply((RepuestosProveedorAdicionalesPorReferenciaModificados event) -> {
            catalogoRepuestos.repuestosProveedor.modificarRepuestosProveedorAdicionalesPorReferencia(event.getRepuestosProveedorAdicionales(), event.getRepuestosProveedorReferencia());
        });


        apply((RepuestosProveedorCreado event) -> {
            catalogoRepuestos.repuestosProveedor = new RepuestosProveedor(event.getRepuestoProveedorID());
        });

        apply((RepuestosProveedorAdicionalesAgregado event) -> {
            catalogoRepuestos.repuestosProveedor.agregarRepuestosProveedorAdicionales(event.getRepuestosProveedorAdicionales(), event.getRepuestosProveedorReferencia());
        });




    }
}
