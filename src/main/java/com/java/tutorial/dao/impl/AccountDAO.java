package com.java.tutorial.dao.impl;

import com.java.tutorial.dao.DAO;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.UserType;
import com.java.tutorial.exceptions.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.java.tutorial.statics.data.ConstantHolder.*;
public class AccountDAO extends DAO<Account> {
    @Override
    public boolean update(Account entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT_UPDATE)){
            setting(entity, preparedStatement);
            preparedStatement.setLong(7, entity.getId());
            int i = preparedStatement.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            throw new DAOException("updating account failed");
        }
        return false;
    }

    @Override
    public int insert(Account entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT_INSERT)){
            setting(entity, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("inserting values in account failed");
        } return 0;
    }

    @Override
    public void delete() throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT_DELETE_ALL)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("deleting accounts in dao failed");
        }
    }

    @Override
    public void deleteById(Account entity) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT_DELETE_BY_ID)) {
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("deleting accounts by id in dao failed");
        }
    }

    @Override
    public Account selectById(long id) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT_SELECT_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return selection(resultSet);
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("get account by id failed");
        }
    }

    @Override
    public List<Account> select() throws DAOException {
        ArrayList<Account> accounts = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT_SELECT)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = selection(resultSet);
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new DAOException("selecting a list of accounts failed");
        }
        return accounts;
    }

    public Account selection(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setFirstName(resultSet.getString("first_name"));
        account.setLastName(resultSet.getString("last_name"));
        account.setPhoneNumber(resultSet.getString("phone_number"));
        account.setUserName(resultSet.getString("user_name"));
        account.setPassword(resultSet.getString("password"));
        account.setType(UserType.valueOf(resultSet.getString("type")));
        return account;
    }

    private void setting(Account entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getFirstName());
        preparedStatement.setString(2, entity.getLastName());
        preparedStatement.setString(3, entity.getPhoneNumber());
        preparedStatement.setString(4, entity.getUserName());
        preparedStatement.setString(5, entity.getPassword());
        preparedStatement.setString(6, entity.getType().toString());
    }

    public Account login(String userName, String passWord) throws DAOException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ACCOUNT_LOGIN)){
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getAccount(resultSet);
        } catch (SQLException e) {
            throw new DAOException("cant select account by username and password in dao");
        }
    }

    private Account getAccount(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return selection(resultSet);
        }
        return null;
    }

}
