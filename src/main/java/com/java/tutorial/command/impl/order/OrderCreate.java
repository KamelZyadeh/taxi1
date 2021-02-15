package com.java.tutorial.command.impl.order;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.Location;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.LocationService;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderCreate implements Command {

    private OrderService orderService;

    public OrderCreate(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/admin_login.jsp", true);
//        Order order = new Order();
//        HttpSession session = request.getSession();
//        long locId = (long) session.getAttribute("locId");
//        long desId = (long) session.getAttribute("desId");
//        Account account = (Account) session.getAttribute("account");

//        order.setClientId(account.getId());
//        order.setDate(String.valueOf(LocalDate.now()));
//        order.setDestination(desId);
//        order.setSource(locId);
//        order.setPrice(0);
//        order.setTaxiId(-1);
//        order.setTransactionId(-1);
//        order.setStatus(OrderStatus.WAITING);
//        orderService.create(order);
        return page;
    }
}
