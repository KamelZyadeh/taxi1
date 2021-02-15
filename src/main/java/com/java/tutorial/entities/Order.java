package com.java.tutorial.entities;

import java.util.Objects;

public class Order {

    private long id;
    private long clientId;
    private long taxiId;
    private long transactionId;
    private double price;
    private Location source;
    private Location destination;
    private String date;
    private OrderStatus status;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }
    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getTaxiId() {
        return taxiId;
    }
    public void setTaxiId(long taxiId) {
        this.taxiId = taxiId;
    }

    public Location getSource() {
        return source;
    }
    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }
    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(long transactionId) {this.transactionId = transactionId;}

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                clientId == order.clientId &&
                taxiId == order.taxiId &&
                transactionId == order.transactionId &&
                Double.compare(order.price, price) == 0 &&
                Objects.equals(source, order.source) &&
                Objects.equals(destination, order.destination) &&
                Objects.equals(date, order.date) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, taxiId, transactionId, price, source, destination, date, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", taxiId=" + taxiId +
                ", transactionId=" + transactionId +
                ", price=" + price +
                ", source=" + source +
                ", destination=" + destination +
                ", date='" + date + '\'' +
                ", status=" + status +
                '}';
    }
}
