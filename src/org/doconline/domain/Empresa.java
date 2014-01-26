/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doconline.domain;

import java.sql.Date;

/**
 *
 * @author Administrador
 */
public class Empresa {
    private int cuit;
    private String razon_social;
    private Date fecha_inicio_actividades;
    private String jefe;
    private String noticia;

    /**
     * @return the cuit
     */
    public int getCuit() {
        return cuit;
    }

    /**
     * @param cuit the cuit to set
     */
    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the fecha_inicio_actividades
     */
    public Date getFecha_inicio_actividades() {
        return fecha_inicio_actividades;
    }

    /**
     * @param fecha_inicio_actividades the fecha_inicio_actividades to set
     */
    public void setFecha_inicio_actividades(Date fecha_inicio_actividades) {
        this.fecha_inicio_actividades = fecha_inicio_actividades;
    }

    /**
     * @return the jefe
     */
    public String getJefe() {
        return jefe;
    }

    /**
     * @param jefe the jefe to set
     */
    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    /**
     * @return the noticia
     */
    public String getNoticia() {
        return noticia;
    }

    /**
     * @param noticia the noticia to set
     */
    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }
}
