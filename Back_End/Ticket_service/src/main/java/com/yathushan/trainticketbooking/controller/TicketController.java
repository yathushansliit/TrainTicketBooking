package com.yathushan.trainticketbooking.controller;


import com.yathushan.trainticketbooking.model.Ticket;
import com.yathushan.trainticketbooking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/services")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @RequestMapping(value = "/createTrain", method = RequestMethod.POST)
    public Ticket createTicket (@RequestBody Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    @RequestMapping(value = "findTrain/{id}")
    public Ticket findTicket(@PathVariable int id) {
        return ticketService.findTicket(id);
    }

    @RequestMapping(value = "/fetchAllUsers", method = RequestMethod.GET)
    public List<Ticket> fetchAllTrains() {
        return ticketService.fetchAllTickets();
    }
}
