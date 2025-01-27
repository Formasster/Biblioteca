package es.educastur.biblioteca2025;

public class LibroNoDisponible extends Exception {
    public LibroNoDisponible(String cadena){
        super(cadena);
    }
}
