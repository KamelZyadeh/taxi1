package com.java.tutorial.command.impl.transaction;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.TransactionService;

import javax.servlet.http.HttpServletRequest;

public class ReadTransaction implements Command {

    private TransactionService transactionService;

    public ReadTransaction(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return new Page();
    }
}
