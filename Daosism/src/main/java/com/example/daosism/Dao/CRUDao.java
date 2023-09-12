package com.example.daosism.Dao;

import java.util.List;
import java.util.Optional;

public interface CRUDao<T> {
    void create(Optional<T> entity);
    void update(Optional<T> updateable, Optional<T> updateT);
    void delete(Optional<T>  del);
}