/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarbaf.empresa;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author fernando
 */
public class EmpresaBean {

    private String nombre_empresa;
    private List<Object> telefono;
    private String direccion_empresa;
    private String correo_electronico;

    public EmpresaBean() {
        this.nombre_empresa = null;
        this.telefono = new ArrayList<Object>();
        this.direccion_empresa = null;
        this.correo_electronico = null;
    }

    /**
     * @return the nombre_empresa
     */
    public String getNombre_empresa() {
        return nombre_empresa;
    }

    /**
     * @param nombre_empresa the nombre_empresa to set
     */
    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    /**
     * @return the telefono
     */
    public List<Object> getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Object telefono) {
        this.telefono.add(telefono);
    }

    /**
     * @return the direccion_empresa
     */
    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    /**
     * @param direccion_empresa the direccion_empresa to set
     */
    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    /**
     * @return the correo_electronico
     */
    public String getCorreo_electronico() {
        return correo_electronico;
    }

    /**
     * @param correo_electronico the correo_electronico to set
     */
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
}
