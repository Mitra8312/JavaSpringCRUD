package com.example.daosism.Dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CRUD<T> implements CRUDao<T> {
    public List<Optional<T>> List = new ArrayList<>();
    @Override
    public void create(Optional<T> entity) {
        List.add(entity);
    }

    @Override
    public void update(Optional<T> updateable, Optional<T> updateT) {
        List.set(List.indexOf(updateable), updateT);
    }
    @Override
    public void delete(Optional<T> del) {
        List.remove(del);
    }
}
