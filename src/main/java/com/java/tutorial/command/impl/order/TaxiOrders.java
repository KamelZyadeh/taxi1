package com.java.tutorial.command.impl.order;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.Account;
import com.java.tutorial.entities.Location;
import com.java.tutorial.entities.Order;
import com.java.tutorial.entities.TaxiOrder;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.LocationService;
import com.java.tutorial.service.impl.OrderService;
import com.java.tutorial.service.impl.TaxiOrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaxiOrders implements Command {

    private OrderService orderService;
    LocationService locationService = new LocationService();
    private TaxiOrderService taxiOrderService = new TaxiOrderService();

    public TaxiOrders(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/new_client_login.jsp", true);
        List<Order> orderList = new ArrayList<>();
        TaxiOrder taxiOrder = new TaxiOrder();

        HttpSession session = request.getSession();
        Account client = new Account();
        client = (Account) session.getAttribute("account");

        Location location = locationService.getRandomLocation();
        location.setAccount_id(client.getId());

        System.out.println(location.toString() + "checking location in TaxiOrders brought from DB");

        orderList.addAll(orderService.readWaitingOrders(-1));
        System.out.println(client + "account brought from session in TaxiOrder");


        session.setAttribute("orderList", orderList);
        return page;
    }
}
