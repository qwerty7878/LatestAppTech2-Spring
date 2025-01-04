package com.example.testgeneric;

public interface JpaRepository <T,ID>{
    T findByid(ID id);

    void save(T entity);

    void delete(T entity);
}
