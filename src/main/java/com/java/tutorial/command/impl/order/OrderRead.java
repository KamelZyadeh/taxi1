package com.java.tutorial.command.impl.order;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;

public class OrderRead implements Command {

    private OrderService orderService;

    public OrderRead(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Order order = new Order();
        order.setStatus(OrderStatus.SUCCESSFUL);
        return null;
    }
}
