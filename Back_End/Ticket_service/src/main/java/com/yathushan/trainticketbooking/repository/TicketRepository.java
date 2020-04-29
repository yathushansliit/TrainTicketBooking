package com.yathushan.trainticketbooking.repository;

import com.yathushan.trainticketbooking.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
