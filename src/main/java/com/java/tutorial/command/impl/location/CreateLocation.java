package com.java.tutorial.command.impl.location;

import com.java.tutorial.command.Command;
import com.java.tutorial.devObjs.Page;
import com.java.tutorial.entities.*;
import com.java.tutorial.exceptions.ServiceException;
import com.java.tutorial.service.impl.ClientOrderService;
import com.java.tutorial.service.impl.LocationService;
import com.java.tutorial.service.impl.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.time.LocalDate;

public class CreateLocation implements Command {

    private LocationService locationService;
    private ClientOrderService clientOrderService = new ClientOrderService();

    public CreateLocation(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/admin_login.jsp", true);
        HttpSession session = request.getSession();
        Account client = (Account) session.getAttribute("account");
        Order order = new Order();
        System.out.println("getting account from session in CreateLocation.." + client);
        ClientOrders clientOrders = new ClientOrders();

        Location loc = new Location();
        Location loc1 = new Location();
        loc.setLat(Double.parseDouble(request.getParameter("l-lat")));
        loc.setLng(Double.parseDouble(request.getParameter("l-lng")));
        loc.setAccount_id(client.getId());
        locationService.create(loc);
        loc.setId(locationService.getLastId());

        loc1.setLat(Double.parseDouble(request.getParameter("d-lat")));
        loc1.setLng(Double.parseDouble(request.getParameter("d-lng")));
        loc1.setAccount_id(client.getId());
        locationService.create(loc1);
        loc1.setId(locationService.getLastId());

        System.out.println("CreateLocation first Location "+loc.toString());
        System.out.println("CreateLocation second Location "+loc.toString());

        locationService.create(loc1);
        System.out.println("printing source again in CreateLocation for checkup "+ order.toString());

        locationService.create(loc1);
        System.out.println("printing destination again in CreateLocation for checkup "+ order.toString());

        session.setAttribute("location", loc);
//        session.setAttribute("destination", location1);
//        session.setAttribute("clientId", client.getId());

        order = setOrder(client, loc, loc1);
        clientOrders.setClientId(client.getId());
        System.out.println(client.getId() + "check clientOrder client id");
        clientOrders.setOrderId(order.getId());
        System.out.println(order.getId() + "check clientId orderId");
        System.out.println(order.getId());
        clientOrderService.create(clientOrders);
        return page;
    }

    public Order setOrder(Account account, Location location, Location location1) throws ServiceException {
        Order order = new Order();
        OrderService orderService = new OrderService();

        order.setSource(location);
        order.setDestination(location1);
        order.setClientId(account.getId());
        order.setDate(String.valueOf(LocalDate.now()));
        order.setTaxiId(-1);
        order.setPrice(0);
        order.setTransactionId(-1);
        order.setStatus(OrderStatus.WAITING);
        orderService.create(order);
        order.setId(orderService.getLastId());
        System.out.println("printing initial order in CreateLocation for checkUp " + order);
        return order;
    }
}
