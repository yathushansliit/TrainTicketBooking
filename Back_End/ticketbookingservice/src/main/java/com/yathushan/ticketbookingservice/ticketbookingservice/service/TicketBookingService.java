package com.yathushan.ticketbookingservice.ticketbookingservice.service;

import com.yathushan.ticketbookingservice.ticketbookingservice.model.TicketBooking;


import java.util.List;

public interface TicketBookingService {
    TicketBooking createBooking(TicketBooking ticketBooking);

    TicketBooking findBooking(int id);

    List<TicketBooking> fetchAllBooking();
}
