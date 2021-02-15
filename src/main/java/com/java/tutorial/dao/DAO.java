package com.java.tutorial.dao;

import com.java.tutorial.ConnectionBuilder;
import com.java.tutorial.exceptions.DAOException;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {

    protected Connection connection = ConnectionBuilder.getConnection();

    public abstract boolean update(T entity) throws DAOException;

    public abstract int insert(T entity) throws DAOException;

    public abstract void delete() throws DAOException;

    public abstract void deleteById(T entity) throws DAOException;

    public abstract T selectById(long id) throws DAOException;

    public abstract List<T> select() throws DAOException;

}
