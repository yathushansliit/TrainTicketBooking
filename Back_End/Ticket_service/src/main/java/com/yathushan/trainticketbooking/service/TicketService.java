package com.yathushan.trainticketbooking.service;

import com.yathushan.trainticketbooking.model.Ticket;

import java.util.List;

public interface TicketService {

    public Ticket createTicket(Ticket ticket);
    public Ticket findTicket(int id);
    public List<Ticket> fetchAllTickets();
}
