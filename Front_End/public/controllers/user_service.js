'use strict'
/*
 * service for User
 */
myApp.factory('UserService', ['$http', function ($http) {
    return {
        //add user to database
      add : function (user) {
          return $http.post('http://localhost:8080/user',user).then(function (res) {
              return res.data;
          })
      },
      //user validation for login function
      get: function (name, password) {
        return $http.get('http://localhost:8080/user'+'/'+name+'/'+password).then(function (res) {
              return res.data;
          }) 
      }
    }
}]);
