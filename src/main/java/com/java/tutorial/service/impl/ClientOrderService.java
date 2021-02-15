package com.java.tutorial.service.impl;

import com.java.tutorial.dao.impl.ClientOrderDAO;
import com.java.tutorial.entities.ClientOrders;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.CRUDService;

import java.util.List;

public class ClientOrderService extends CRUDService<ClientOrders> {
    ClientOrderDAO clientOrderDAO = new ClientOrderDAO();

    @Override
    public void create(ClientOrders entity) throws ServiceException {
        try {
            clientOrderDAO.insert(entity);
        } catch (DAOException e) {
            throw   new ServiceException("cant insert clientOrder");
        }
    }

    @Override
    public ClientOrders readById(long id) throws ServiceException {
        try {
            return clientOrderDAO.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read clientOrder by id");
        }
    }

    public ClientOrders readByClientId(long id) throws ServiceException {
        try {
            return clientOrderDAO.selectByClientId(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read clientOrder by clientId");
        }
    }

    public ClientOrders readByOrderId(long id) throws ServiceException {
        try {
            return clientOrderDAO.selectByOrderId(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read clientOrder by orderId");
        }
    }

    @Override
    public List<ClientOrders> read() throws ServiceException {
        return null;
    }

    @Override
    public void update(ClientOrders entity) throws ServiceException {

    }

    @Override
    public void delete() throws ServiceException {

    }

    @Override
    public void deleteById(ClientOrders entity) throws ServiceException {
        try {
            clientOrderDAO.deleteById(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete by id in service");
        }
    }
}
