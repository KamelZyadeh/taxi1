package com.java.tutorial.dao.impl;

import com.java.tutorial.dao.DAO;
import com.java.tutorial.entities.ClientOrders;
import com.java.tutorial.entities.TaxiOrder;
import com.java.tutorial.exceptions.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.java.tutorial.statics.data.ConstantHolder.*;

public class TaxiOrderDAO extends DAO<TaxiOrder> {


    @Override
    public boolean update(TaxiOrder entity) throws DAOException {
        return false;
    }

    @Override
    public int insert(TaxiOrder entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TAXI_ORDERS)){
            setting(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("inserting values in taxiOrders failed");
        } return 0;
    }

    @Override
    public void delete() throws DAOException {

    }

    @Override
    public void deleteById(TaxiOrder entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TAXI_ORDERS_BY_ID)){
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("deleting taxiOrders by id in dao failed");
        }
    }

    @Override
    public TaxiOrder selectById(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAXI_ORDERS_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get taxiOrder by id failed");
        }
    }

    public TaxiOrder selectByTaxiId(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAXI_ORDERS_BY_TAXI_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get taxiOrder by TaxiId failed");
        }
    }

    public TaxiOrder selectByOrderId(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TAXI_ORDERS_BY_ORDER_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get taxiOrder by orderId failed");
        }
    }

    @Override
    public List<TaxiOrder> select() throws DAOException {
        return null;
    }

    public TaxiOrder selection(ResultSet resultSet) throws SQLException {
        TaxiOrder taxiOrder = new TaxiOrder();
        taxiOrder.setId(resultSet.getLong("id"));
        taxiOrder.setOrderId(resultSet.getLong("order_id"));
        taxiOrder.setTaxiId(resultSet.getLong("taxi_id"));
        return taxiOrder;
    }

    private void setting(TaxiOrder taxiOrder, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, taxiOrder.getOrderId());
        preparedStatement.setLong(2, taxiOrder.getTaxiId());
    }
}
