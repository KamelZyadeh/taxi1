package com.java.tutorial.service.impl;

import com.java.tutorial.dao.impl.AccountDAO;
import com.java.tutorial.dao.impl.LocationDAO;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.UserType;
import com.java.tutorial.exceptions.DAOException;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.CRUDService;

import java.util.ArrayList;
import java.util.List;

public class AccountService extends CRUDService<Account> {

    AccountDAO accountDAO = new AccountDAO();

    @Override
    public void create(Account entity) throws ServiceException {
        try {
            accountDAO.insert(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant insert this account");
        }
    }

    @Override
    public Account readById(long id) throws ServiceException {
        try {
            return accountDAO.selectById(id);
        } catch (DAOException e) {
            throw new ServiceException("cant read account by id");
        }
    }

    @Override
    public List<Account> read() throws ServiceException {
        try {
            return accountDAO.select();
        } catch (DAOException e) {
            throw new ServiceException("cant read all accounts in service");
        }
    }

    @Override
    public void update(Account entity) throws ServiceException {
        try {
            accountDAO.update(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant update account in service");
        }
    }

    @Override
    public void delete() throws ServiceException {
        try {
            accountDAO.delete();
        } catch (DAOException e) {
            throw new ServiceException("cant delete account in service");
        }
    }

    @Override
    public void deleteById(Account entity) throws ServiceException {
        try {
            accountDAO.deleteById(entity);
        } catch (DAOException e) {
            throw new ServiceException("cant delete by id in service");
        }
    }

    public Account login(Account entity) throws ServiceException {
        try {
            return accountDAO.login(entity.getUserName(), entity.getPassword());
        } catch (DAOException e) {
            throw new ServiceException("cant find account by login in service");
        }
    }

//    public List<Account> accountSorting(Account account) throws ServiceException {
//        List<Account> accountList;
//        try {
//            accountList = accountDAO.select();
//            List<Account> accounts;
//            if (account.getType() == UserType.ADMIN) {
//                accounts = taxiList(accountList);
//            } else {
//                accounts = clientList(accountList);
//            }
//            return accounts;
//        } catch (DAOException e) {
//            throw new ServiceException("cant sort list of accounts");
//        }
//    }
//
//    public List<Account> taxiList(List<Account> accountList) {
//        List<Account> accounts = new ArrayList<>();
//        for (Account account : accountList) {
//            if (account.getType() == UserType.TAXI) accounts.add(account);
//        }
//        return accounts;
//    }
//
//    public List<Account> clientList(List<Account> accountList) {
//        List<Account> accounts = new ArrayList<>();
//        for (Account account : accountList) {
//            if (account.getType() == UserType.CLIENT) accounts.add(account);
//        }
//        return accounts;
//    }

}
