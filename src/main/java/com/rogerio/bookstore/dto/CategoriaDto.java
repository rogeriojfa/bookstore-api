package com.rogerio.bookstore.dto;

import com.rogerio.bookstore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDto implements Serializable {
    private Integer id;

    @NotEmpty(message = "Campo NOME requerido")
    @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo DESCRIÇÃO requerido")
    @Length(min = 3, max = 100, message = "O campo DESCRIÇÃO deve ter entre 3 e 100 caracteres")
    private String descricao;

    public CategoriaDto() {
        super();
    }

    public CategoriaDto(Categoria cat) {
        this.id = cat.getId();
        this.nome = cat.getNome();
        this.descricao = cat.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
