package service;

import domain.Categoria;
import domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CategoriaRepository;
import repositories.LivroRepository;

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

        this.categoriaRepository.saveAll(Arrays.asList(cat1));
        this.livroRepository.saveAll(Arrays.asList(livro1));

    }
}

