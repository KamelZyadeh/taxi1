package com.java.tutorial.command;

import com.java.tutorial.command.impl.account.AccountByLogin;
import com.java.tutorial.command.impl.account.AccountLogout;
import com.java.tutorial.command.impl.account.CreateAccount;
import com.java.tutorial.command.impl.location.CreateLocation;
import com.java.tutorial.command.impl.order.OrderCreate;
import com.java.tutorial.command.impl.order.TaxiOrderAcceptance;
import com.java.tutorial.command.impl.order.TaxiOrders;
import com.java.tutorial.service.impl.AccountService;
import com.java.tutorial.service.impl.LocationService;
import com.java.tutorial.service.impl.OrderService;

public class CommandFactory {

    public static Command getCommand(String commandType) {
        switch (commandType) {
            case "command_register":
                return new CreateAccount(new AccountService());

            case "command_login":
                System.out.println("AccountByLogin");
                return new AccountByLogin(new AccountService());

            case "command_create_order":
                System.out.println("OrderCreate");
                return new OrderCreate(new OrderService());

            case "command_create_location":
                System.out.println("CreateLocation");
                return new CreateLocation(new LocationService());

            case "command_taxi_order":
                System.out.println("TaxiOrders");
                return new TaxiOrders(new OrderService());

            case "taxi_order_acceptance":
                System.out.println("TaxiOrderAcceptance");
                return new TaxiOrderAcceptance(new OrderService());

            case "logout":
                System.out.println("logout");
                return new AccountLogout(new AccountService());
            default:return null;
        }
    }
}
