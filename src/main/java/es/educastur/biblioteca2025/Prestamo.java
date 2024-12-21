
package es.educastur.biblioteca2025;

import java.time.LocalDate;

public class Prestamo {
    private Libro libroPrestamo;
    private Usuario usuarioPrest;
    private LocalDate fechaPrest;
    private LocalDate fechaDev;

    public Prestamo(Libro libroPrestamo, Usuario usuarioPrest, LocalDate fechaPrest, LocalDate fechaDev) {
        this.libroPrestamo = libroPrestamo;
        this.usuarioPrest = usuarioPrest;
        this.fechaPrest = fechaPrest;
        this.fechaDev = fechaDev;
    }

    public Libro getLibroPrestamo() {
        return libroPrestamo;
    }
    public Usuario getUsuarioPrest() {
        return usuarioPrest;
    }
    public LocalDate getFechaPrest() {
        return fechaPrest;
    }
    public LocalDate getFechaDev() {
        return fechaDev;
    }
    
    
    public void setLibroPrestamo(Libro libroPrestamo) {
        this.libroPrestamo = libroPrestamo;
    }
    public void setUsuarioPrest(Usuario usuarioPrest) {
        this.usuarioPrest = usuarioPrest;
    }
    public void setFechaPrest(LocalDate fechaPrest) {
        this.fechaPrest = fechaPrest;
    }
    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

    
    @Override
    public String toString() {
        return libroPrestamo + " - " + usuarioPrest + " - " + fechaPrest + " - " + fechaDev;
    }
    
    
}


