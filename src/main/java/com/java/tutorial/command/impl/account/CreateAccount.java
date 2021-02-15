package com.java.tutorial.command.impl.account;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.UserType;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.AccountService;

import javax.servlet.http.HttpServletRequest;

public class CreateAccount implements Command {

    private AccountService accountService;

    public CreateAccount(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/register.jsp", true);
        Account account = new Account();
        account.setFirstName(request.getParameter("firstName"));
        account.setLastName(request.getParameter("lastName"));
        account.setPhoneNumber(request.getParameter("phoneNumber"));
        account.setUserName(request.getParameter("userName"));
        account.setPassword(request.getParameter("password"));
        String s = request.getParameter("typeOfAccount");
        System.out.println(s);
        account.setType(UserType.valueOf(request.getParameter("typeOfAccount")));
        accountService.create(account);
        return page;
    }
}
