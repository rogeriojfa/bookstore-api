package com.rogerio.bookstore.service;

import com.rogerio.bookstore.repositories.LivroRepository;
import com.rogerio.bookstore.service.exceptions.DataIntegrityViolationException;
import com.rogerio.bookstore.service.exceptions.ObjectNotFoundException;
import com.rogerio.bookstore.domain.Categoria;
import com.rogerio.bookstore.domain.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService catService;

    public Livro findById(Integer id){
       Optional<Livro> obj = repository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + "Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_cat){
        catService.findById(id_cat);
        return repository.findAllByCategoria(id_cat);
    }

    public Livro create(Integer id_cat, Livro obj){
        obj.setId(null);
        Categoria cat = catService.findById(id_cat);
        obj.setCategoria(cat);
        return repository.save(obj);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj){
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "O Livro não pode ser deletado"
            );

        }

    }
}
