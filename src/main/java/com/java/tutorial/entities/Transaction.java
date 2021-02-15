package com.java.tutorial.entities;

import java.util.Date;
import java.util.Objects;

public class Transaction {

    private long id;
    private String date;
    private TransactionType type;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }
    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return  id == transaction.id &&
                Objects.equals(date, transaction.date) &&
                Objects.equals(type, transaction.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, type);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                "date='" + date + '\'' +
                "type='" + type + '\'' +
                '}';
    }
}
