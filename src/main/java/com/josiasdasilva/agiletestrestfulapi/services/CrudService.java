package com.josiasdasilva.agiletestrestfulapi.services;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.Optional;

public interface CrudService <T, ID extends Serializable> {
    Page<T> findAll(int page, int size);
    Optional<T> findById(ID id);
    T save(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}
