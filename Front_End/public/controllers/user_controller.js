'use strict'
/*
 * This controller for User
 */
myApp.controller('userController', ['$scope', '$route', '$http', '$location', 'UserService',  function ($scope, $route, $http, $location, UserService) {

    //add user
    $scope.addUser = function (customer) {

        UserService.add(customer).then(function (data) {
            if(data){
                alert("Successfully Registered to System");
                $location.path('/')
            }
            else{
                alert("something wrong in system, try again later ");
            }
        }) 

    }
}
])