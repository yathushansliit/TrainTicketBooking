'use strict'
/*
* ticket booking controller
* */
myApp.controller("ticketController", ['$scope', '$route', '$http', '$routeParams', 'ticketBooking','$location', function ($scope, $route, $http, $routeParams, ticketBooking,$location) {

    //for get ticket list
    function getTicketMenu() {
        ticketBooking.get().then(function (data) {
            $scope.tickets = data;
            $scope.places=['Anuradhapura','Batticallo','Colombo','Dematagoda','Ella','Gampaha','Hatton','Jaffna'];
        })
    }

    getTicketMenu();
    $scope.customer ={}
    $scope.creditCard={}
    $scope.selectItems = [];
    $scope.Qty = 1;
    $scope.total = 0;
    $scope.customer.ticketList = '';
    $scope.isDisabled = true;

    //add item to cart
    $scope.addItem = function (train_class, unitPrice, Qty,arrival,departure) {

        $scope.selectItems.push({
            Arr:arrival,
            Dep:departure,
            train_class: train_class,
            price: unitPrice,
            quantity: Qty


        });
        $scope.total = $scope.total + unitPrice * Qty;
        $scope.customer.totalAmount = $scope.total;
    }

    //remove item from cart
    $scope.removeItem = function (index) {

        var object = $scope.selectItems[index]
        $scope.total = $scope.total - (object.price * object.quantity)
        $scope.customer.totalAmount = $scope.total;
        $scope.selectItems.splice(index, 1);
    }

    // create string from ticket list
    function createStringByArray(array) {
        var output = '';
        angular.forEach(array, function (object) {
          output += '\n';
          output += 'Your depature place is '+ object.Arr+', ';
          output += 'your arrival place is '+ object.Dep+', '+'you reserved '+object.quantity+' tickets in '+ object.train_class;
          output += ' and price of one ticket is '+ object.price+', ';
          
          output += '\n';
        });
        return output;
    }

    //add cart tickets to order form
    $scope.addList = function () {

        var string = createStringByArray($scope.selectItems);
        $scope.customer.ticketList +=  string;
        $scope.selectItems = [];

        $scope.rows = $scope.selectItems.length;
    }


    //confirm mobile Number
    $scope.confirmMobileNumber = function (mobilepay) {

        $scope.isDisabled = !$scope.isDisabled;

        ticketBooking.mobileNumber(mobilepay).then(function (data) {
                if(data){
                    alert('successfully confirmed your number, proceed with 4 digit code sent to your mobile and pay')
                        
                }
                else
                {
                     alert("something wrong in system, try again later ");
                }
             })       

    }

    //add mobile pay orders
    $scope.addBookingForMobile = function (order,mobilepay) {

        ticketBooking.validateMobileCode(mobilepay).then(function (data) {

            if(data){
                ticketBooking.addMobileBooking(order).then(function (data) {
                    if(data){
                        alert('successfully Ordered please check your email')
                        $scope.customer ={}
                        $scope.creditCard={}
                        $scope.mobilepay ={}
                        $scope.total = 0;
                        $scope.customer.ticketList = '';
                    }
                    else
                    {
                        alert("something wrong in system, try again later ");
                    }
                })
            }
            else {
                alert("please enter valid Code")
            }
        })
    }


    //add credit card pay order
    $scope.addBookingForCreditCardUsers= function (order,creditCard) {
        ticketBooking.creditCard(creditCard).then(function (data) {

            if(data){
                ticketBooking.addCreditCardBooking(order).then(function (data) {
                    if(data){
                        alert('successfully Ordered please check your email')
                        $scope.customer ={}
                        $scope.creditCard={}
                        $scope.mobilepay ={}
                        $scope.total = 0;
                        $scope.customer.ticketList = '';
                    }
                    else
                    {
                        alert("something wrong in system, try again later ");
                    }
                })
            }
            else {
                alert("please enter valid credit card details")
            }
        })
    }
}
])
