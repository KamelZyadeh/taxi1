package com.java.tutorial.dao.impl;

import com.java.tutorial.dao.DAO;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.ClientOrders;
import com.java.tutorial.entities.UserType;
import com.java.tutorial.exceptions.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.java.tutorial.statics.data.ConstantHolder.*;

public class ClientOrderDAO extends DAO<ClientOrders> {

    @Override
    public boolean update(ClientOrders entity) throws DAOException {
        return false;
    }

    @Override
    public int insert(ClientOrders entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_ORDERS)){
            setting(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("inserting values in clientOrders failed");
        } return 0;
    }

    @Override
    public void delete() throws DAOException {

    }

    @Override
    public void deleteById(ClientOrders entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_ORDERS_BY_ID)){
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("deleting clientOrders by id in dao failed");
        }
    }

    @Override
    public ClientOrders selectById(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_ORDERS_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get clientOrder by id failed");
        }
    }

    public ClientOrders selectByClientId(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_ORDERS_BY_CLIENT_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get clientOrder by clientId failed");
        }
    }

    public ClientOrders selectByOrderId(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_ORDERS_BY_ORDER_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get clientOrder by orderId failed");
        }
    }

    @Override
    public List<ClientOrders> select() throws DAOException {
        return null;
    }

    public ClientOrders selection(ResultSet resultSet) throws SQLException {
        ClientOrders clientOrders = new ClientOrders();
        clientOrders.setId(resultSet.getLong("id"));
        clientOrders.setOrderId(resultSet.getLong("order_id"));
        clientOrders.setClientId(resultSet.getLong("client_id"));
        return clientOrders;
    }

    private void setting(ClientOrders clientOrders, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, clientOrders.getOrderId());
        preparedStatement.setLong(2, clientOrders.getClientId());
    }
}
