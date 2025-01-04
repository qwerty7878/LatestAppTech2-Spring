package com.example.testgeneric;

public interface Repository <T>{
    void save(T item);

    T findByid(int id);
}
