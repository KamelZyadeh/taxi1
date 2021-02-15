package com.java.tutorial.service.impl;

import com.java.tutorial.dao.impl.LocationDAO;
import com.java.tutorial.entities.Location;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.CRUDService;

import java.sql.SQLException;
import java.util.List;

public class LocationService extends CRUDService<Location> {

    LocationDAO locationDAO = new LocationDAO();
    @Override
    public void create(Location entity) throws ServiceException {
        try {
            locationDAO.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant create location in service");
        }
    }

    @Override
    public Location readById(long id) throws ServiceException {
        try {
            return locationDAO.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant select location by id in service");
        }
    }

    @Override
    public List<Location> read() throws ServiceException {
        try {
            return locationDAO.select();
        } catch (DAOException e) {
            throw new ServiceException("cant select list of locations in service");
        }
    }

    @Override
    public void update(Location entity) throws ServiceException {
        try {
            locationDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update location from service");
        }
    }

    @Override
    public void delete() throws ServiceException {
        try {
            locationDAO.delete();
        } catch (DAOException e) {
            throw new ServiceException("cant delete locations from service");
        }
    }

    @Override
    public void deleteById(Location entity) throws ServiceException {
        try {
            locationDAO.deleteById(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete location by id in service");
        }
    }

    public long getLastId() throws ServiceException {
        try {
            return locationDAO.getLastId();
        } catch (DAOException e) {
            throw new ServiceException("cant find id in service");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Location getRandomLocation() throws ServiceException {
        try {
            return locationDAO.getRandomLocation();
        } catch (DAOException e) {
            throw new ServiceException("cant get random location in dao");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Location getLocationByTaxiId(long id) throws ServiceException {
        try {
            return locationDAO.getLocationFromTaxiId(id);
        } catch (DAOException e) {
            throw new ServiceException("cant get location by taxiId in service");
        }
    }
}
