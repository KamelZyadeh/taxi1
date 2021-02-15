package com.java.tutorial.command.impl.account;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Account;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AccountByLogin implements Command {

    private AccountService accountService;

    public AccountByLogin(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/admin_login.jsp", true);
        Account account = new Account();
        account.setUserName(request.getParameter("userName"));
        account.setPassword(request.getParameter("password"));
        account = accountService.login(account);
        System.out.println("sout for account in AccountByLogin.. "+account);
        HttpSession session = request.getSession();
        session.setAttribute("account", account);

//        page.setUrl("/taxi?command=command_taxi_order");

//        List<Order> orderList = new ArrayList<>();
//        try {
//            orderList = checkOutput(account.getId(), OrderStatus.WAITING);
//        } catch (DAOException e) {
//            e.getMessage();
//        }
//
//        if (account.getType() == UserType.TAXI) {
//            HttpSession session = request.getSession();
//            session.setAttribute("taxi", account);
//        }
//
//        if (orderList.isEmpty()) {
//            HttpSession session = request.getSession();
//            session.setAttribute("client", account);
//            page.setUrl("/taxi?command=command_taxi_order");
//        } else {
//            HttpSession session = request.getSession();
//            session.setAttribute("orderList", orderList);
//            return new Page("/pages/new_client_login.jsp", true);
//        }

        return page;
    }

//    public List<Order> checkOutput(long id, OrderStatus orderStatus) throws DAOException, ServiceException {
//        List<Order> orderList = new ArrayList<>();
//        OrderService orderService = new OrderService();
//        orderList = orderService.readUnfinishedOrders(id, orderStatus);
//        return orderList;
//    }
}
