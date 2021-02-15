package com.java.tutorial.entities;

import java.util.Objects;

public class ClientOrders {
    private long id;
    private long orderId;
    private long clientId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientOrders that = (ClientOrders) o;
        return id == that.id &&
                orderId == that.orderId &&
                clientId == that.clientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, clientId);
    }

    @Override
    public String toString() {
        return "ClientOrders{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", clientId=" + clientId +
                '}';
    }
}
