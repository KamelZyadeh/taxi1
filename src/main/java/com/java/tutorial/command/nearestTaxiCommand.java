package com.java.tutorial.command;

import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.OrderStatus;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class nearestTaxiCommand implements Command{

    private OrderService orderService;
    List<Order> orderList = new ArrayList<>();

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/client_orders.jsp", true);
        orderList = orderService.readFinishedOrders(OrderStatus.IN_PROGRESS);
        return page;
    }
}
