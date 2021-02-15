package com.java.tutorial.entities;

import java.util.Objects;

public class Location {

    private long id;
    private double lng;
    private double lat;
    private long account_id;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getAccount_id() {
        return account_id;
    }
    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id &&
                Double.compare(location.lng, lng) == 0 &&
                Double.compare(location.lat, lat) == 0 &&
                account_id == location.account_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lng, lat, account_id);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", lng=" + lng +
                ", lat=" + lat +
                ", account_id=" + account_id +
                '}';
    }
}
