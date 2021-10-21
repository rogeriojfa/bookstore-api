package com.rogerio.bookstore.resources;
import com.rogerio.bookstore.domain.Categoria;
import com.rogerio.bookstore.dto.CategoriaDto;
import com.rogerio.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria cat = service.findById(id);
        return ResponseEntity.ok().body(cat);
    }
    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll(){
        List<Categoria> list = service.findAll();
        List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj){
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDto> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDto objDto){
        Categoria newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new CategoriaDto(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
