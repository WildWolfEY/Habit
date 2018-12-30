package ru.myhabit.data.dao;


import java.util.List;

public interface GeneralDao<T> {

    public List<T> getAll();
    public T getById(Long id);
    public T update(T object);
    public void delete(T object);

}
