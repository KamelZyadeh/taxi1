package com.java.tutorial.service;

import com.java.tutorial.exceptions.ServiceException;

import java.util.List;

public abstract class CRUDService<T> {

    public abstract void create(T entity) throws ServiceException;

    public abstract T readById(long id) throws ServiceException;

    public abstract List<T> read() throws ServiceException;

    public abstract void update(T entity) throws ServiceException;

    public abstract void delete() throws ServiceException;

    public abstract void deleteById(T entity) throws ServiceException;

}
