package com.sha.transaction.model.service;

import java.util.List;

public interface EntityService<E, I>
{
    List<E> findAll();

    E save(E entity);

    void deleteByID(I id);
}
