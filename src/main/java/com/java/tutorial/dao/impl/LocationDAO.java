package com.java.tutorial.dao.impl;

import com.java.tutorial.dao.DAO;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.Location;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.java.tutorial.statics.data.ConstantHolder.*;
public class LocationDAO extends DAO<Location> {

    @Override
    public boolean update(Location entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_UPDATE)){
            setting(entity, preparedStatement);
            preparedStatement.setLong(4, entity.getId());
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("cant update location in dao");
        }
        return false;
    }

    @Override
    public int insert(Location entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_INSERT)){
            setting(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("cant insert location from dao");
        } return 0;
    }

    @Override
    public void delete() throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_DELETE_ALL)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("cant delete locations in dao");
        }
    }

    @Override
    public void deleteById(Location entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_DELETE_BY_ID)){
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("cant delete location by id in dao");
        }
    }

    @Override
    public Location selectById(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_SELECT_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("cant select by id in dao");
        }
    }

    @Override
    public List<Location> select() throws DAOException {
        ArrayList<Location> locations = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_SELECT)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location location = selection(resultSet);
                locations.add(location);
            }
        } catch (SQLException e) {
            throw new DAOException("cant select list of locations in dao");
        }
        return locations;
    }

    private Location selection(ResultSet resultSet) throws SQLException {
        Location location = new Location();
        location.setId(resultSet.getInt("id"));
        location.setLng(resultSet.getDouble("lng"));
        location.setLat(resultSet.getDouble("lat"));
        location.setAccount_id(resultSet.getLong("account_id"));
        return location;
    }

    private void setting(Location entity, PreparedStatement preparedStatement) throws SQLException {
        System.out.println("fuck1");
        preparedStatement.setBigDecimal(1, BigDecimal.valueOf(entity.getLng()));
        System.out.println("fuck2");
        preparedStatement.setBigDecimal(2, BigDecimal.valueOf(entity.getLat()));
        System.out.println("fuck3");
        preparedStatement.setLong(3, entity.getAccount_id());
        System.out.println("fuck4");
    }

    public long getLastId() throws DAOException, SQLException {
        try(Statement statement = connection.createStatement()) {
            String query=  String.format(LAST_INSERT, "location");
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getLong("currval");
            }
            throw new DAOException("no id has been found");
        } catch (SQLException e) {
            throw new DAOException("no id has been found");
        }
    }

    public Location getRandomLocation() throws SQLException, DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_GET_RANDOM)){
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            } return null;
        } catch (SQLException e) {
            throw new DAOException("cant get random location in dao");
        }
    }

    public Location getLocationFromTaxiId(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(LOCATION_SELECT_BY_TAXI_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            } return null;
        } catch (SQLException e) {
            throw new DAOException("cant get location by taxiId");
        }
    }
}
