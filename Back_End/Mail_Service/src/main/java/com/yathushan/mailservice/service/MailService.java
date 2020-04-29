package com.yathushan.mailservice.service;


import com.yathushan.ticketbookingservice.ticketbookingservice.model.TicketBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MailService  {
    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    JavaMailSender getEmail(){
        return new JavaMailSenderImpl();
    }


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JavaMailSender jms;

    @Autowired
    public void MailSevice(JavaMailSender jms) {
        this.jms = jms;
    }

    //send mail about ticket reservation
    public void sendMailAboutTicketBooking(TicketBooking ticketBooking) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(ticketBooking.getEmail());
        sm.setFrom("trainticketbooking96@gmail.com");
        sm.setSubject("Train Ticket Reservation");
        sm.setText("Dear customer,\n\n Your Train Ticket Reservation is successfully confirmed \n\n" + "Your train ticket list below \n" + ticketBooking.getTicketList()
                + '\n' + "your total amount is " + ticketBooking.getTotalAmount()+'\n'+" your order id is "+ticketBooking.getOrderId());

        jms.send(sm);
    }



}
