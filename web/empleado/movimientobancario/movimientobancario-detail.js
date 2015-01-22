app.controller("MovimientoBancarioDetailDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.action = "delete";
        $scope.get = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $routeParams.id
            }).success(function(data) {
                $scope.movimientoBancario = data;
            }).error(function() {
                alert("No existe o no se pudo encontrar.");
            });
        };
        $scope.get();

        $scope.deleteMovimiento = function(id) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/MovimientoBancario/" + id
            }).success(function() {
                window.location.assign("#/movimientobancario/MovimientoBancarios");
            }).error(function() {
                alert("No existe o no se pudo borrar.");
            });
        };
    }]);

app.controller("MovimientoBancarioDetailModificarController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.action = "update";
        $scope.get = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $routeParams.id
            }).success(function(data) {
                $scope.movimientoBancario = data;
            }).error(function() {
                alert("No existe o no se pudo encontrar.");
            });

        };
        $scope.tiposMovimientosBancarios = [
            {
                id: "DEBE",
                titulo: 'Debe'
            }, {
                id: "HABER",
                titulo: 'Haber'
            }
        ];
        $scope.get();

        $scope.modificarMovimiento = function() {
            $http({
                method: "PUT",
                url: contextPath + "/api/MovimientoBancario/" + $routeParams.id,
                data: $scope.movimientoBancario
            }).success(function() {
                window.location.assign("#/movimientobancario/MovimientoBancarios");
            }).error(function() {
                alert("No se pudo modificar o no existe.");
            });
        };


    }]);

app.controller("MovimientoBancarioDetailInsertarController", ["$scope", "$http", function($scope, $http) {
        $scope.action = "insert";
        $scope.movimientoBancario={};
        $scope.insertarMovimiento = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/MovimientoBancario",
                data: $scope.movimientoBancario
            }).success(function() {
                window.location.assign("#/movimientobancario/MovimientoBancarios");
            }).error(function() {
                alert("No se pudo insertar el movimiento.");
            });
        };
        $scope.tiposMovimientosBancarios = [
            {
                id: "DEBE",
                titulo: 'Debe'
            }, {
                id: "HABER",
                titulo: 'Haber'
            }
        ];
    }]);




