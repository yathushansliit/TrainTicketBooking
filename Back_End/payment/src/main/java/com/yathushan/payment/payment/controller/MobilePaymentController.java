package com.yathushan.payment.payment.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobilePaymentController {

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/verifyMobileNumber")
    public boolean verifyMobileNumber() {
        return true;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/verifyMobileCode")
    public boolean verifyMobileCode() {
        return true;
    }
}
