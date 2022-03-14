package co.com.concesionario.dominio.CatalogoRepuestos;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestoProveedorID;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorAdicionales;
import co.com.concesionario.valorglobal.Referencia;
import co.com.concesionario.dominio.CatalogoRepuestos.valor.RepuestosProveedorTecnomecanicos;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.domain.generic.Entity;

public class RepuestosProveedor extends Entity<RepuestoProveedorID>{
    private Referencia referencia;
    private Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales;
    private List<RepuestosProveedorTecnomecanicos> repuestosProveedorTecnomecanicos;


    public RepuestosProveedor(RepuestoProveedorID entityId, Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales) {
        super(entityId);
        //TODO Auto-generated constructor stub

        this.repuestosProveedorAdicionales = repuestosProveedorAdicionales;
        this.repuestosProveedorTecnomecanicos = new ArrayList<>();
    }


    public RepuestosProveedor(RepuestoProveedorID entityId) {
        super(entityId);
        //TODO Auto-generated constructor stub

        this.repuestosProveedorAdicionales = new HashMap<Referencia, RepuestosProveedorAdicionales>();
        this.repuestosProveedorTecnomecanicos = new ArrayList<>();
    }



    public void modificarRepuestosProveedorAdicionalesPorReferencia(RepuestosProveedorAdicionales repuestosProveedorAdicionales,
                                                                    Referencia referencia){
        try {
            boolean switcher = false;
            boolean condicion = this.repuestosProveedorAdicionales.containsKey(referencia.value());
            for(Referencia unidad : this.repuestosProveedorAdicionales.keySet()){
                System.out.println(this.repuestosProveedorAdicionales.get(unidad).value().value().partesExternas());
                if(unidad.value().equals(referencia.value())) switcher = true;
            }
            if (switcher){
                this.repuestosProveedorAdicionales.put(referencia, repuestosProveedorAdicionales);
            } else throw new Exception();

        } catch (Exception e){

            throw new BusinessException("",String.format("No existe Referencia en proveedores, con la referencia indicada == -%s-", referencia.value()));
        }

    }


    public void agregarRepuestosProveedorAdicionales(RepuestosProveedorAdicionales repuestosProveedorAdicionales, Referencia referencia){
        this.repuestosProveedorAdicionales.put(referencia, repuestosProveedorAdicionales);
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





    public Map<Referencia, RepuestosProveedorAdicionales> repuestosProveedorAdicionales() {
        return repuestosProveedorAdicionales;
    }



    public List<RepuestosProveedorTecnomecanicos> repuestosProveedorTecnomecanicos() {
        return repuestosProveedorTecnomecanicos;
    }

     
}
