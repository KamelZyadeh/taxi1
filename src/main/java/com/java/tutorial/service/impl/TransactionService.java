package com.java.tutorial.service.impl;

import com.java.tutorial.dao.impl.LocationDAO;
import com.java.tutorial.dao.impl.TransactionDAO;
import com.java.tutorial.entities.Transaction;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.CRUDService;

import java.util.List;

public class TransactionService extends CRUDService<Transaction> {
    TransactionDAO transactionDAO = new TransactionDAO();

    @Override
    public void create(Transaction entity) throws ServiceException {
        try {
            transactionDAO.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("inserting transaction in service failed");
        }
    }

    @Override
    public Transaction readById(long id) throws ServiceException {
        try {
            return transactionDAO.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant select transaction by id in service");
        }
    }

    @Override
    public List<Transaction> read() throws ServiceException {
        try {
            return transactionDAO.select();
        } catch (DAOException e) {
            throw new ServiceException("cant select list of transaction in service");
        }
    }

    @Override
    public void update(Transaction entity) throws ServiceException {
        try {
            transactionDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("updating transaction in service failed");
        }
    }

    @Override
    public void delete() throws ServiceException {
        try {
            transactionDAO.delete();
        } catch (DAOException e) {
            throw new ServiceException("deleting all transaction in service failed");
        }
    }

    @Override
    public void deleteById(Transaction entity) throws ServiceException {
        try {
            transactionDAO.deleteById(entity);
        } catch (DAOException e) {
            throw new ServiceException("deleting transaction by id in service failed");
        }
    }
}
