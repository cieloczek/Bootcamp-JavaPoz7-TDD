package com.sda.cinema;

import com.sda.cinema.com.sda.cinema.model.*;

public class Cinema {
    private final CinemaBookingService cinemaBookingService;
    private final CinemaNotifier cinemaNotifier;

    public Cinema(CinemaBookingService cinemaBookingService, CinemaNotifier cinemaNotifier) {
        this.cinemaBookingService = cinemaBookingService;
        this.cinemaNotifier = cinemaNotifier;
    }


    public CinemaBookingResponse bookMovie(CinemaMovie movie, int seating, CinemaUser user, CinemaChanel chanel){
        CinemaBookingStatus status = cinemaBookingService.bookingService(movie,seating);
        if(!status.isStatus()) {
            CinemaBookingResponse failureResponse = new CinemaBookingResponse();
            failureResponse.setStatus(false);
            switch (status.getStatusCode()) {
                case WRONG_STEAING_ID:
                    failureResponse.setMessage("Niepoprawny numer miejsca");
                    break;
                case INVALID_SEATING_TYPE:
                    failureResponse.setMessage("Niepoprawny rodzaj miejsca");
                    break;
                case SEATING_ALREADY_BOOKED:
                    failureResponse.setMessage("Miejsce juz zajete");
                    break;
            }
            return failureResponse;
        }
        cinemaNotifier.notifyUser(user,chanel, "Twój numer biletu to 000-abc-123");
        return new CinemaBookingResponse(true, "Miejsce zostało zarezerwowane");
    }




}
