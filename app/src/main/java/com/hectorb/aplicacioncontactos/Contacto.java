package com.hectorb.aplicacioncontactos;

public class Contacto {

    private String nombre;
    private String fechaNac;
    private String telefono;
    private String email;
    private String descripcion;
    public static String TAG_NOMBRE = "TAG_NOMBRE";
    public static String TAG_FECHA = "TAG_FECHA";
    public static String TAG_TELEFONO = "TAG_TELEFONO";
    public static String TAG_EMAIL = "TAG_EMAIL";
    public static String TAG_DESCRIPCION = "TAG_DESCRIPCION";



    public Contacto(String nombre, String fechaNac, String telefono, String email, String descripcion) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
