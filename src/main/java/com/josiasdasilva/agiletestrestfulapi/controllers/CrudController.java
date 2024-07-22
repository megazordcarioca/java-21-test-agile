package com.josiasdasilva.agiletestrestfulapi.controllers;

import com.josiasdasilva.agiletestrestfulapi.services.CrudService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/api")
public abstract class CrudController <T, ID extends Serializable> {
    public abstract CrudService<T, ID> getService();

    @GetMapping
    public Page<T> findAll(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size) {
        return getService().findAll(page,size);
    }

    @PostMapping
    public ResponseEntity<T> save( @Valid @RequestBody T entity) {
        ResponseEntity.ok(getService().save(entity));
        return ResponseEntity.ok(entity);
    }

    @GetMapping("{id}")
    public ResponseEntity<T> findById(@PathVariable ID id) {
        return getService().findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable ID id, @Valid @RequestBody T entity) {
        T updatedEntity = getService().update(id, entity);
        if(updatedEntity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEntity);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@RequestBody ID id){
        return getService().findById(id).map(hasEntity -> {
            getService().delete(id);
            return ResponseEntity.ok(getService().findById(id));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
