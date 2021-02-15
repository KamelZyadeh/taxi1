package com.java.tutorial.dao.impl;

import com.java.tutorial.dao.DAO;
import com.java.tutorial.entities.Location;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.java.tutorial.statics.data.ConstantHolder.*;
public class OrderDAO extends DAO<Order> {
    @Override
    public boolean update(Order entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ORDER_UPDATE)){
            setting(entity, preparedStatement);
            preparedStatement.setLong(9, entity.getId());
            int i = preparedStatement.executeUpdate();
            if (i==1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("updating order in dao failed");
        }
        return false;
    }

    @Override
    public int insert(Order entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ORDER_INSERT)){
            System.out.println("fuckkk");
            setting(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("cant insert order in dao");
        }
        return 0;
    }

    @Override
    public void delete() throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ORDER_DELETE_ALL)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("deleting orders in dao failed");
        }
    }

    @Override
    public void deleteById(Order entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ORDER_DELETE_BY_ID)){
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("deleting order by id in dao failed");
        }
    }

    @Override
    public Order selectById(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ORDER_SELECT_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("cant select order by id from dao");
        }
    }

    @Override
    public List<Order> select() throws DAOException {
        ArrayList<Order> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ORDER_SELECT)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = selection(resultSet);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new DAOException("cant select list of orders in dao");
        }
        return orders;
    }

    public List<Order> selectForTaxi(long id) throws DAOException {
        ArrayList<Order> orders = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_FOR_TAXI)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = selection(resultSet);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new DAOException("cant select waiting orders in dao");
        }
        return orders;
    }

    public Order selectTaxi(long id) throws DAOException {
        Order order = new Order();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_FOR_TAXI)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return order = selection(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException("cant select waiting orders in dao");
        } return null;
    }

    public Order selectUnfinishedOrders(long id, OrderStatus orderStatus) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_UNFINISHED_ORDERS)){
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, String.valueOf(orderStatus));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            } return null;
        } catch (SQLException e) {
            throw new DAOException("cant select unfinished orders in dao");
        }
    }

    public List<Order> selectFinishedOrders(OrderStatus orderStatus) throws DAOException {
        List<Order> orderList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINISHED_ORDERS)){
            preparedStatement.setString(1, String.valueOf(orderStatus));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = selection(resultSet);
                orderList.add(order);
            }
        } catch (SQLException e) {
            throw new DAOException("cant select finished orders in dao");
        }
        return orderList;
    }

    public long getLastId() throws DAOException, SQLException {
        try(Statement statement = connection.createStatement()) {
            String query=  String.format(LAST_INSERT, "order");
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getLong("currval");
            }
            throw new DAOException("no id has been found");
        } catch (SQLException e) {
            throw new DAOException("no id has been found");
        }
    }

    private Order selection(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        Location location = new Location();
        Location location1 = new Location();
        order.setId(resultSet.getLong("id"));
        order.setTaxiId(resultSet.getLong("taxi_id"));
        order.setClientId(resultSet.getLong("client_id"));

        location.setId(resultSet.getLong("source_id"));
        location1.setId(resultSet.getLong("destination_id"));

        order.setSource(location);
        order.setDestination(location1);
        order.setTransactionId(resultSet.getLong("transaction_id"));
        order.setPrice(resultSet.getDouble("price"));
        order.setDate(String.valueOf(resultSet.getDate("date")));
        order.setStatus(OrderStatus.valueOf(resultSet.getString("type")));
        return order;
    }

    private void setting(Order entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setLong(1, entity.getTaxiId());
        preparedStatement.setLong(2, entity.getClientId());
        preparedStatement.setLong(3, entity.getSource().getId());
        preparedStatement.setLong(4, entity.getDestination().getId());
        preparedStatement.setLong(5, entity.getTransactionId());
        preparedStatement.setDouble(6, entity.getPrice());
        preparedStatement.setDate(7, Date.valueOf(entity.getDate()));
        preparedStatement.setString(8, entity.getStatus().toString());
    }
}
