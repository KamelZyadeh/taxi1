package com.java.tutorial.command;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class nearestTaxiCommand implements Command{

    public nearestTaxiCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    private OrderService orderService;
    LocationService locationService = new LocationService();
    List<Order> orderList = new ArrayList<>();

    @Override
    public Page execute(HttpServletRequest request) throws ServiceException {
        Page page = new Page("/pages/client_orders.jsp", true);
        Account client = new Account();
        Order order = new Order();
        Location location = new Location();
        HttpSession session = request.getSession();
        client = (Account) session.getAttribute("account");
        System.out.println("testing client from session" + client);

        orderList = orderService.readUnfinishedOrders(client.getId() ,OrderStatus.IN_PROGRESS);
        System.out.println("orderList" + orderList.toString());
        order = orderList.get(0);
        System.out.println("check if first order is correct" + order);
        location = order.getSource();
        location = locationService.readById(location.getId());
        System.out.println("check for sourceLocation" + location);

        nearestTaxiSorting(location, orderList);
        return page;
    }

    public void nearestTaxiSorting(Location s, List<Order> ll) throws ServiceException {
        System.out.println("in nearestTaxiSorting");
        double clientLoc = s.getLat() + s.getLng();
        System.out.println("check the value of clientLoc" + clientLoc);
        Order[] orderArray = new Order[ll.size()];
        ll.toArray(orderArray);
//        System.out.println("orderArray" + Arrays.toString(orderArray));
//        System.out.println(orderArray.length);
//        System.out.println("checking size" + ll.size());
//        double temp = 0;
//        double total;

        System.out.println("before loop");
//        for (int i = 0; i < ll.size(); i++) {
//
//        }
        for (int i = 0; i < orderList.size(); i++){
            System.out.println("in loop");
            System.out.println("fuck");
            Order order = orderArray[i];
            System.out.println("check if order in zero index" + orderArray[i]);
            Location location = locationService.getLocationByTaxiId(order.getTaxiId());
            System.out.println("check location by taxi id" + location);
            double taxiLoc = location.getLat() + location.getLng();
            System.out.println("check the value of taxiLoc" + taxiLoc);


//            orderList.sort(Comparator.comparing());
//
//            total = clientLoc - taxiLoc;
//            if (temp == 0) {
//                temp = total;
//            }
//            if (temp != total) {
//                if (temp > total) {
//                    temp = total;
//                } else {
//                    orderArray[orderArray.length - 1] = order;
//                }
//            }
        }
        orderList = Arrays.asList(orderArray);
    }
}
