package com.java.tutorial.command.impl.account;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccountLogout implements Command {

    private AccountService accountService;

    public AccountLogout(AccountService accountService) {
        this.accountService = accountService;
    }

    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/welcome_nav_bar.jsp", true);
        HttpSession session = request.getSession();
        session.getAttribute("account");
        session.removeAttribute("account");
        return page;
    }
}
