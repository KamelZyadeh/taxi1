package com.java.tutorial.command.impl.account;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.AccountService;

import javax.servlet.http.HttpServletRequest;

public class ReadAccount implements Command {

    private AccountService accountService;

    public ReadAccount(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return new Page();
    }
}
