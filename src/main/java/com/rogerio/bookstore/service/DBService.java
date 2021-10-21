package com.rogerio.bookstore.service;

import com.rogerio.bookstore.repositories.LivroRepository;
import com.rogerio.bookstore.domain.Categoria;
import com.rogerio.bookstore.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rogerio.bookstore.repositories.CategoriaRepository;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){
        Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
        Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Teste de Livro", cat1);

        cat1.getLivros().addAll(Arrays.asList(livro1));

        categoriaRepository.saveAll(Arrays.asList(cat1));
        livroRepository.saveAll(Arrays.asList(livro1));

    }

    public void instanciaTestBaseDeDados(){
        Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
        Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Teste de Livro", cat1);

        cat1.getLivros().addAll(Arrays.asList(livro1));

        categoriaRepository.saveAll(Arrays.asList(cat1));
        livroRepository.saveAll(Arrays.asList(livro1));

    }
}

