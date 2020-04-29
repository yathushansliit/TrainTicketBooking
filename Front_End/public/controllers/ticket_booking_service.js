'use strict'
/*
* ticket booking service
* */
myApp.factory('ticketBooking', ['$http', function ($http) {
    return {
        //get ticket list from backend server
        get:function () {
            return $http.get('http://localhost:8080/ticket').then(function (res) {
                return res.data;
            });
        },
  
        //validate Mobile number from mobile payment gateway
        mobileNumber:function (mobilepay) {
            return $http.get('http://localhost:8080/verifyMobileNumber').then(function (res) {
                return res.data;
            })
        },
  
        //add mobile pay bboking tickets to database
        addMobileBooking:function (order) {
            return $http.post('http://localhost:8080/ticketbooking/mobile',order).then(function (res) {
                return res.data;
            })
        },
  
        //validate mobile code
        validateMobileCode:function (mobilepay) {
            return $http.get('http://localhost:8080/verifyMobileCode').then(function (res) {
                return res.data;
            })
        },
  
        //validate credit card from credit card payment gateway
        creditCard:function (creditCard) {
            return $http.get('http://localhost:8080/verifyCreditCard').then(function (res) {
                return res.data;
            })
        },
  
        //add credit card pay food orders to database
        addCreditCardBooking:function (order) {
            return $http.post('http://localhost:8080/ticketbooking/creditCard',order).then(function (res) {
                return res.data;
            })
        }
    }
}]);
