package com.yathushan.payment.payment.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardPaymentController {
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/verifyCreditCard")
    public boolean verifyCreditCards() {
        return true;
    }
}
