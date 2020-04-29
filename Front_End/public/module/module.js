'use strict'
var myApp = angular.module('myApp', ["ngRoute", "ngStorage"]);

myApp.config(function ($routeProvider) {

    $routeProvider.when('/',{
        templateUrl: "./views/login.html"
    }).when('/register',{
        templateUrl: "./views/register.html"
    }).when('/ticket',{
        resolve: {

            'check': function ($location, $localStorage) {

                if (!$localStorage.loggedIn) {
                    $location.path('/');
                }


            }
        },
        templateUrl: "./views/ticket_booking.html"
    })
});

myApp.controller('loginCtrl', function ($scope, $location, $localStorage, UserService) {
    $scope.submit = function () {
        UserService.get($scope.username,$scope.password).then(function (data) {
            if(data.name != null){
                $localStorage.loggedIn = true;
                $location.path('/ticket');
            }
            else {
                alert('User Name or Password is Incorrect');
                $location.path('/');
            }
        })
    }
});

myApp.controller('logoutCtrl', function ($scope, $location, $localStorage) {

    $scope.logout = function () {
        $location.path('/');
        $localStorage.loggedIn = false;


    }
})