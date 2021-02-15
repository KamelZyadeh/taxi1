package com.java.tutorial.command.impl.order;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.Location;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderUpdate implements Command {

    private OrderService orderService;

    public OrderUpdate(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/admin_login", true);
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        Order order = orderService.readOrdersByTaxiId(account.getId());

//        order.setClientId(account.getId());
//        order.setDate(String.valueOf(LocalDate.now()));
//        order.setDestination(desId);
//        order.setSource(locId);
//        order.setPrice(Double.parseDouble(request.getParameter("price")));
//        order.setTaxiId(Long.parseLong(request.getParameter("taxiId")));
//        order.setTransactionId(Long.parseLong(request.getParameter("transactionId")));
        order.setStatus(OrderStatus.IN_PROGRESS);
        orderService.update(order);
        return page;
    }
}
