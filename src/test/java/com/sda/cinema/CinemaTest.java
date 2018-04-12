package com.sda.cinema;

import com.sda.cinema.com.sda.cinema.model.CinemaBookingResponse;
import com.sda.cinema.com.sda.cinema.model.CinemaBookingStatus;
import com.sda.cinema.com.sda.cinema.model.CinemaBookingStatusCode;
import com.sun.javafx.tools.packager.CreateBSSParams;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CinemaTest {
    @Test
    public void userCanReserveMovieAndReciveNotificationWithTicker() {
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookingService(Mockito.any(), Mockito.anyInt())).then(e -> new CinemaBookingStatus(true, null));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 10, null, null);

        //then
        Assert.assertEquals("Miejsce zostało zarezerwowane", response.getMessage());
        Assert.assertTrue(response.isStatus());

    }

    @Test
    public void userCannotReserveMovieBecaiuseSelectedSeatingIsInvalid() {
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookingService(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.INVALID_SEATING_TYPE));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);
        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse response = cinema.bookMovie(null, 10, null, null);

        //then
        Assert.assertEquals("Niepoprawny rodzaj miejsca", response.getMessage());
        Assert.assertFalse(response.isStatus());
    }

    @Test
    public void userCannotReserveMovieBecauseSeatingIsAlreadyTaken() {
        //given
        CinemaBookingService cinemaBookingService = Mockito.mock(CinemaBookingService.class);
        Mockito.when(cinemaBookingService.bookingService(Mockito.any(), Mockito.anyInt()))
                .then(e -> new CinemaBookingStatus(false, CinemaBookingStatusCode.SEATING_ALREADY_BOOKED));
        CinemaNotifier cinemaNotifier = Mockito.mock(CinemaNotifier.class);

        Cinema cinema = new Cinema(cinemaBookingService, cinemaNotifier);

        //when
        CinemaBookingResponse resp = cinema.bookMovie(null, 10, null, null);

        //then
        Assert.assertEquals("Miejsce juz zajete", resp.getMessage());
        // to check : Mockito.verify
    }
}

