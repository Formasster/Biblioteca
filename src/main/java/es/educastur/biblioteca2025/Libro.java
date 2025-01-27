package es.educastur.biblioteca2025;

import org.springframework.web.context.annotation.ApplicationScope;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int ejemplares;
    

    @Override
    public String toString() {
        return isbn + " - " + titulo + " - " + autor + " - " + genero + " - " + ejemplares;
    }
}
    
   