/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.DAPP02Practica02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author JMRes
 */
@Entity
@Table(name = "empleadotemporal")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "empleadotemporal_id_seq")
    @SequenceGenerator(name = "empleadotemporal_id_seq",
            sequenceName = "empleadotemporal_id_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private Long clave;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    /**
     * @return the clave
     */
    public Long getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(Long clave) {
        this.clave = clave;
    }

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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
