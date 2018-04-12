package com.sda.cinema.com.sda.cinema.model;

import com.sda.cinema.com.sda.cinema.model.CinemaBookingStatusCode;

public class CinemaBookingStatus {
    private boolean status;
    private CinemaBookingStatusCode statusCode;

    public CinemaBookingStatus(boolean status, CinemaBookingStatusCode statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public CinemaBookingStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(CinemaBookingStatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
