package com.rogerio.bookstore.service;

import com.rogerio.bookstore.domain.Categoria;
import com.rogerio.bookstore.dto.CategoriaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rogerio.bookstore.repositories.CategoriaRepository;
import com.rogerio.bookstore.service.exceptions.DataIntegrityViolationException;
import com.rogerio.bookstore.service.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
       Optional<Categoria> obj = repository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + "Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDto objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(
                    "A Categoria não pode ser deletada, por possuir livros associados."
            );
        }
    }
}
