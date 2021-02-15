package com.java.tutorial.dao.impl;

import com.java.tutorial.dao.DAO;
import com.java.tutorial.entities.Transaction;
import com.java.tutorial.entities.TransactionType;
import com.java.tutorial.exceptions.DAOException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.java.tutorial.statics.data.ConstantHolder.*;
public class TransactionDAO extends DAO<Transaction> {
    @Override
    public boolean update(Transaction entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(TRANSACTION_UPDATE)) {
            setting(entity, preparedStatement);
            preparedStatement.setLong(3, entity.getId());
            int i = preparedStatement.executeUpdate();
            if (i==1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("updating transaction in dao failed");
        }
        return false;
    }

    @Override
    public int insert(Transaction entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(TRANSACTION_INSERT)){
            setting(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("inserting transaction in dao failed");
        }
        return 0;
    }

    @Override
    public void delete() throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(TRANSACTION_DELETE_ALL)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("deleting all transaction in dao failed");
        }
    }

    @Override
    public void deleteById(Transaction entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(TRANSACTION_DELETE_BY_ID)){
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("deleting transaction by id in dao failed");
        }
    }

    @Override
    public Transaction selectById(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(TRANSACTION_SELECT_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("cant select transaction by id in dao");
        }
    }

    @Override
    public List<Transaction> select() throws DAOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(TRANSACTION_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transaction transaction = selection(resultSet);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            throw new DAOException("cant select list of transaction in dao");
        }
        return transactions;
    }

    private Transaction selection(ResultSet resultSet) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setId(resultSet.getInt("id"));
        transaction.setDate(String.valueOf(resultSet.getDate("date")));
        transaction.setType(TransactionType.valueOf(resultSet.getString("type")));
        return transaction;
    }

    private void setting(Transaction entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setDate(1, Date.valueOf(entity.getDate()));
        preparedStatement.setString(2, entity.getType().toString());
    }
}
