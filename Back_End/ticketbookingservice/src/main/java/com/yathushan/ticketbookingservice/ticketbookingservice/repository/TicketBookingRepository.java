package com.yathushan.ticketbookingservice.ticketbookingservice.repository;

import com.yathushan.ticketbookingservice.ticketbookingservice.model.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking,Integer>{
}
