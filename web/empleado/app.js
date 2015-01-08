var app = angular.module("app", ['ngRoute']);

app.run(function($rootScope, $http) {
    $rootScope.logcheck = function() {
        $http({
            method: "GET",
            url: contextPath + "/api/session/empleado"
        }).success(function(data) {
            $rootScope.empleado = data;
        }).error(function() {
            $rootScope.empleado = null;
        });
    };
    $rootScope.logcheck();
    
    $rootScope.logout = function() {
        $http({
            method: "DELETE",
            url: contextPath + "/api/session/empleado"
        }).success(function() {
            $rootScope.empleado = null;
            window.location.assign("#/");
        }).error(function(status) {
            alert("Error: " + status);
        });
    };
});

