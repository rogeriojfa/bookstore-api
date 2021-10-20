package dto;
import domain.Livro;

import java.io.Serializable;

public class LivroDto implements Serializable {
    private Integer id;
    private String titulo;

    public LivroDto() {
        super();
    }

    public LivroDto(Livro obj) {
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}