var app = angular.module("app", ['ngRoute','ui.date']);

app.constant('uiDateConfig',{
	dateFormat: "dd/mm/yy",
	firstDay: 1
});

app.filter('FiltroNumeros', function () {
        return function (n, len) {
            var num = parseInt(n, 10);
            len = parseInt(len, 10);
            if (isNaN(num) || isNaN(len)) {
                return n;
            }
            num = ''+num;
            while (num.length < len) {
                num = '0'+num;
            }
            return num;
        };
    });

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



