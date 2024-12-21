package es.educastur.biblioteca2025;

import java.time.LocalDate;


public class Usuario {
    private String dni;
    private String nombre;
    private String email;
    private String telefono;
    private LocalDate fechaNac;

    public Usuario(String dni, String nombre, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    

    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefono() {
        return telefono;
    }
    public LocalDate getFechaNac() {
        return fechaNac;
    }
    

    public void setDni(String dni) {
        this.dni = dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return dni + " - " + nombre + " - " + email + " - " + telefono + " - " + fechaNac;
    }
    
    
}
