package com.java.tutorial.service.impl;

import com.java.tutorial.dao.impl.TaxiOrderDAO;
import com.java.tutorial.entities.TaxiOrder;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.CRUDService;

import java.util.List;

public class TaxiOrderService extends CRUDService<TaxiOrder> {
    TaxiOrderDAO taxiOrderDAO = new TaxiOrderDAO();

    @Override
    public void create(TaxiOrder entity) throws ServiceException {
        try {
            taxiOrderDAO.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant insert taxiOrder");
        }
    }

    @Override
    public TaxiOrder readById(long id) throws ServiceException {
        try {
            return taxiOrderDAO.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read taxiOrder by id");
        }
    }

    @Override
    public List<TaxiOrder> read() throws ServiceException {
        return null;
    }

    @Override
    public void update(TaxiOrder entity) throws ServiceException {

    }

    @Override
    public void delete() throws ServiceException {

    }

    @Override
    public void deleteById(TaxiOrder entity) throws ServiceException {
        try {
            taxiOrderDAO.deleteById(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete by id in service");
        }
    }
}
