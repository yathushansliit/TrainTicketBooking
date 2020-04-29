package com.yathushan.trainticketbooking.service;

import com.yathushan.trainticketbooking.model.Ticket;
import com.yathushan.trainticketbooking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket findTicket(int id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);

        if(ticket.isPresent()) {
            return ticket.get();
        }
        return null;
    }

    @Override
    public List<Ticket> fetchAllTickets() {
        List<Ticket> users = ticketRepository.findAll();

        if(users.isEmpty()){
            return null;
        }
        return  users;
    }
}
