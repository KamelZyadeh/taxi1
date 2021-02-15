package com.java.tutorial.statics.data;

import java.io.StringReader;

public class ConstantHolder {

    public static final String ACCOUNT_SELECT = "SELECT * FROM account";
    public static final String ACCOUNT_SELECT_BY_ID = "SELECT * FROM account a WHERE a.id = ?";
    public static final String ACCOUNT_INSERT = "INSERT INTO account (first_name, last_name, phone_number, user_name, " +
            "password, type) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String ACCOUNT_UPDATE = "UPDATE account SET first_name=?, last_name=?, phone_number=?, user_name=?," +
            "password=?, type=? WHERE id=?";
    public static final String ACCOUNT_DELETE_ALL = "DELETE FROM account";
    public static final String ACCOUNT_DELETE_BY_ID = "DELETE FROM account WHERE id=?";
    public static final String ACCOUNT_LOGIN = "SELECT * FROM account WHERE user_name=? AND password=?";


    public static final String LOCATION_SELECT = "SELECT * FROM location";
    public static final String LOCATION_SELECT_BY_ID = "SELECT * FROM location l WHERE l.id = ?";
    public static final String LOCATION_INSERT = "INSERT INTO location (lng, lat, account_id) VALUES (?, ?, ?)";
    public static final String LOCATION_UPDATE = "UPDATE location SET lng=?, lat=?, location_id=? WHERE id=?";
    public static final String LOCATION_DELETE_ALL = "DELETE FROM location";
    public static final String LOCATION_DELETE_BY_ID = "DELETE FROM location WHERE id=?";
    public static final String LOCATION_GET_RANDOM = "with getCount as (\n" +
            "select count(*) from location\n" +
            ")\n" +
            "select * from location offset floor(random() * (select count from getCount) ) limit 1;";
    public static final String LOCATION_SELECT_BY_TAXI_ID = "SELECT * FROM location l WHERE l.account_id = ?";

    public static final String TRANSACTION_SELECT = "SELECT * FROM transaction";
    public static final String TRANSACTION_SELECT_BY_ID = "SELECT * FROM transaction t WHERE t.id = ?";
    public static final String TRANSACTION_INSERT = "INSERT INTO transaction (date, type) VALUES (?, ?)";
    public static final String TRANSACTION_UPDATE = "UPDATE transaction SET date=?, type=? WHERE id=?";
    public static final String TRANSACTION_DELETE_ALL = "DELETE FROM transaction";
    public static final String TRANSACTION_DELETE_BY_ID = "DELETE FROM transaction WHERE id=?";

    public static final String ORDER_SELECT = "SELECT * FROM \"order\"";
    public static final String ORDER_SELECT_BY_ID = "SELECT * FROM \"order\" o WHERE o.id = ?";
    public static final String ORDER_INSERT = "INSERT INTO \"order\" (taxi_id, client_id, source_id, destination_id," +
            " transaction_id, price, date, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String ORDER_UPDATE = "UPDATE \"order\" SET taxi_id=?, client_id=?, source_id=?, destination_id=?, " +
            " transaction_id=?, price=?, date=?, type=? WHERE id=?";
    public static final String ORDER_DELETE_ALL = "DELETE FROM \"order\"";
    public static final String ORDER_DELETE_BY_ID = "DELETE FROM \"order\" WHERE id=?";
    public static final String SELECT_ORDER_FOR_TAXI = "SELECT * FROM \"order\" WHERE taxi_id=?";
    public static final String SELECT_UNFINISHED_ORDERS = "SELECT * FROM \"order\" WHERE client_id=? AND type=?";
    public static final String SELECT_FINISHED_ORDERS = "SELECT * FROM \"order\" WHERE type=?";

    public static final String INSERT_TAXI_ORDERS = "INSERT INTO taxi_orders (order_id, taxi_id) VALUES (?, ?)";
    public static final String SELECT_TAXI_ORDERS_BY_ID = "SELECT * FROM taxi_orders WHERE id=?";
    public static final String DELETE_TAXI_ORDERS_BY_ID = "DELETE FROM taxi_orders WHERE id=?";
    public static final String SELECT_TAXI_ORDERS_BY_TAXI_ID = "SELECT * FROM taxi_orders WHERE taxi_id=?";
    public static final String SELECT_TAXI_ORDERS_BY_ORDER_ID = "SELECT * FROM taxi_orders WHERE order_id=?";

    public static final String INSERT_CLIENT_ORDERS = "INSERT INTO client_orders (order_id, client_id) VALUES (?, ?)";
    public static final String SELECT_CLIENT_ORDERS_BY_ID = "SELECT * FROM client_orders WHERE id=?";
    public static final String DELETE_CLIENT_ORDERS_BY_ID = "DELETE FROM client_orders WHERE id=?";
    public static final String SELECT_CLIENT_ORDERS_BY_CLIENT_ID = "SELECT * FROM client_orders WHERE client_id=?";
    public static final String SELECT_CLIENT_ORDERS_BY_ORDER_ID = "SELECT * FROM client_orders WHERE order_id=?";

    public static final String LAST_INSERT = "SELECT currval(pg_get_serial_sequence('%s','id'))";


}
