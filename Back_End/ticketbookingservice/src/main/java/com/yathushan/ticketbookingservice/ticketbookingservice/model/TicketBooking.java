package com.yathushan.ticketbookingservice.ticketbookingservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class TicketBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private String name;
    private int phoneNumber;
    private String email;

    private String ticketList;
    private double totalAmount;

    Random rand = new Random();
    private int OrderId = rand.nextInt();

    public TicketBooking() {
    }

    public TicketBooking(String name, int phoneNumber, String email, String ticketList, double totalAmount) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.ticketList = ticketList;
        this.totalAmount = totalAmount;
    }


    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTicketList() {
        return ticketList;
    }

    public void setTicketList(String ticketList) {
        this.ticketList = ticketList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }
}
