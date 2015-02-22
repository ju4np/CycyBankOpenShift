app.controller("MovimientoBancarioDetailDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.action = "delete";
        $scope.get = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientoBancario/" + $routeParams.id
            }).success(function(data) {
                $scope.movimientoBancario = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No existe o no se puede encontrar");
                }
            });
        };
        $scope.get();

        $scope.deleteMovimiento = function(id) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/MovimientoBancario/" + id
            }).success(function() {
                window.location.assign("#/movimientobancario/MovimientoBancarios");
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No existe o no se puede borrar");
                }
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
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No existe o no se puede encontrar");
                }
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
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No existe o no se puede modificar");
                }
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
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se puede insertar el movimiento");
                }
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




