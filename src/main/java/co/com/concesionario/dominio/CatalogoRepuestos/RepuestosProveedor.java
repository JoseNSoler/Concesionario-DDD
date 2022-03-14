package co.com.concesionario.dominio.CatalogoRepuestos;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorReferencia;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorTecnomecanicos;
import co.com.concesionario.valorglobal.Tecnomecanicos;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.domain.generic.Entity;

public class RepuestosProveedor extends Entity<RepuestoProveedorID>{
    RepuestosProveedorReferencia repuestosProveedorReferencia;
    Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales;
    List<RepuestosProveedorTecnomecanicos> repuestosProveedorTecnomecanicos;


    public RepuestosProveedor(RepuestoProveedorID entityId, Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales) {
        super(entityId);
        //TODO Auto-generated constructor stub

        this.repuestosProveedorAdicionales = repuestosProveedorAdicionales;
        this.repuestosProveedorTecnomecanicos = new ArrayList<>();
    }


    public RepuestosProveedor(RepuestoProveedorID entityId) {
        super(entityId);
        //TODO Auto-generated constructor stub

        this.repuestosProveedorAdicionales = new HashMap<RepuestosProveedorReferencia, RepuestosProveedorAdicionales>();
        this.repuestosProveedorTecnomecanicos = new ArrayList<>();
    }



    public void modificarRepuestosProveedorAdicionalesPorReferencia(RepuestosProveedorAdicionales repuestosProveedorAdicionales, RepuestosProveedorReferencia repuestosProveedorReferencia){
        try {
            boolean condicion = this.repuestosProveedorAdicionales.containsKey(repuestosProveedorReferencia.value());
            if(!condicion) {
                throw new Exception();
            } else{
                this.repuestosProveedorAdicionales.put(repuestosProveedorReferencia, repuestosProveedorAdicionales);
            }

        } catch (Exception e){

            throw new BusinessException("",String.format("No existe Referencia en proveedores, con la referencia indicada == %s", repuestosProveedorReferencia.value()));
        }

    }


    public void agregarRepuestosProveedorAdicionales(RepuestosProveedorAdicionales repuestosProveedorAdicionales, RepuestosProveedorReferencia repuestosProveedorReferencia){
        this.repuestosProveedorAdicionales.put(repuestosProveedorReferencia, repuestosProveedorAdicionales);
    }


    public void agregarRepuestosProveedorTecnomecanicos(RepuestosProveedorTecnomecanicos repuestosProveedorTecnomecanicos){
        this.repuestosProveedorTecnomecanicos.add(repuestosProveedorTecnomecanicos);
    }

/*
    public void modificarRepuestoProveedorTecnomecanicoPorReferencia(String referencia,Tecnomecanicos repuestosProveedorTecnomecanicos){

        this.repuestosProveedorTecnomecanicos.stream().forEach(repuesto -> {
            if(repuesto.getReferencia() == referencia){
                repuesto = new RepuestosProveedorTecnomecanicos(repuestosProveedorTecnomecanicos, referencia);
            }
        });
    }*/





    public Map<RepuestosProveedorReferencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }



    public List<RepuestosProveedorTecnomecanicos> repuestosProveedorTecnomecanicos() {
        return repuestosProveedorTecnomecanicos;
    }

     
}
