package com.java.tutorial.command.impl.order;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;

public class OrderDelete implements Command {

    private OrderService orderService;

    public OrderDelete(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        return new Page();
    }
}
