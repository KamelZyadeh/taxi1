package com.java.tutorial.entities;

import java.util.Objects;

public class TaxiOrder {

    private long id;
    private long orderId;
    private long taxiId;

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

    public long getTaxiId() {
        return taxiId;
    }
    public void setTaxiId(long taxiId) {
        this.taxiId = taxiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxiOrder taxiOrder = (TaxiOrder) o;
        return id == taxiOrder.id &&
                orderId == taxiOrder.orderId &&
                taxiId == taxiOrder.taxiId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, taxiId);
    }

    @Override
    public String toString() {
        return "TaxiOrder{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", taxiId=" + taxiId +
                '}';
    }
}
