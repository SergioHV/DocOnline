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
public class Empleado {
    private String nombre;
    private String apellido;
    private int dni;
    private Date fecha_nacimiento;
    private String cargo;
    private String email;
    private int empresa_cuit;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the fecha_nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * @param fecha_nacimiento the fecha_nacimiento to set
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the empresa_cuit
     */
    public int getEmpresa_cuit() {
        return empresa_cuit;
    }

    /**
     * @param empresa_cuit the empresa_cuit to set
     */
    public void setEmpresa_cuit(int empresa_cuit) {
        this.empresa_cuit = empresa_cuit;
    }
    
}
