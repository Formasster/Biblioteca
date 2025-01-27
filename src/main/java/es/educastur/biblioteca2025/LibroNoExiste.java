package es.educastur.biblioteca2025;

public class LibroNoExiste extends Exception {
    public LibroNoExiste(String cadena){
        super(cadena);
    }
}
