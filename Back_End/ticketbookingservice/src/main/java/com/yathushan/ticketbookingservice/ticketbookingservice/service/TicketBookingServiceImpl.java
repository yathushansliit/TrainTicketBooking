package com.yathushan.ticketbookingservice.ticketbookingservice.service;

import com.yathushan.ticketbookingservice.ticketbookingservice.model.TicketBooking;
import com.yathushan.ticketbookingservice.ticketbookingservice.repository.TicketBookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TicketBookingRepository ticketBookingRepository;

    @Override
    public TicketBooking createBooking(TicketBooking ticketBooking) {
        return ticketBookingRepository.save(ticketBooking);
    }

    @Override
    public TicketBooking findBooking(int id) {
        Optional<TicketBooking> ticketBooking = ticketBookingRepository.findById(id);

        if(ticketBooking.isPresent()) {
            return ticketBooking.get();
        }
        return null;
    }

    @Override
    public List<TicketBooking> fetchAllBooking() {
        List<TicketBooking> users = ticketBookingRepository.findAll();

        if(users.isEmpty()){
            return null;
        }
        return  users;
    }
}
