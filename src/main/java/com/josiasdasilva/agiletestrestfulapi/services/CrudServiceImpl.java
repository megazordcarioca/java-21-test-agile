package com.josiasdasilva.agiletestrestfulapi.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public abstract class CrudServiceImpl <T, ID extends Serializable>
        implements CrudService<T,ID>{
    protected abstract JpaRepository<T, ID> getRepository();

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        return getRepository().findById(id).map(existingEntity -> {
            BeanUtils.copyProperties(entity, existingEntity, "id");
            return getRepository().save(entity);
        }).orElseThrow(()-> new EntityNotFoundException("Entity not Found"+entity));

    }

    @Override
    public void delete(ID id) {
        getRepository().deleteById(id);
    }

    @Override
    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public Page<T> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return getRepository().findAll(pageable);
    }

}
