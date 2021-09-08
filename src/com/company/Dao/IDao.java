package com.company.Dao;

import java.util.List;

public interface IDao<T> {
    public T guardar(T t);
    public List<T> listar();
    public void mostrarDatos();
}
