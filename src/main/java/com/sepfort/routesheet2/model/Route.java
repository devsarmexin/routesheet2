package com.sepfort.routesheet2.model;

import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route extends BaseEntity{
    @NonNull
    private String departurePoint;
    @NonNull
    private String destinationPoint;
    @NonNull
    private Short distance;

    public Route() {
    }

    public Route(String departurePoint, String destinationPoint, Short distance) {
        this.departurePoint = departurePoint;
        this.destinationPoint = destinationPoint;
        this.distance = distance;
    }

    //<editor-fold defaultstate="collapsed" desc="getters and setters">

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public Short getDistance() {
        return distance;
    }

    public void setDistance(Short distance) {
        this.distance = distance;
    }

    //</editor-fold>
}
