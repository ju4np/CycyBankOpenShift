app.controller("CuentaDetailDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        
        $scope.action = "delete";
        $scope.buscarCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/cuenta/" + $routeParams.id
            }).success(function(data) {
                $scope.cuenta = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No existe o no de puede encontrar la cuenta");
                }
            });
        };
        $scope.buscarCuenta();

        $scope.deleteCuenta = function(id) {
            alert(id);
            $http({
                method: "DELETE",
                url: contextPath + "/api/cuenta/" + id
            }).success(function() {
                window.location.assign("#/cuenta/cuentas");
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se puede borrar la cuenta");
                }
            });
        };
    }]);


app.controller("CuentaDetailModificarController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.action = "update";
        $scope.buscarCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/cuenta/" + $routeParams.id
            }).success(function(data) {
                $scope.cuenta = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No existe o no de puede encontrar la cuenta");
                }
            });

        };
        $scope.buscarCuenta();

        $scope.modificarCuenta = function() {
            $http({
                method: "PUT",
                url: contextPath + "/api/cuenta",
                data: $scope.cuenta
            }).success(function() {
                window.location.assign("#/cuenta/cuentas");
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se puede modificar la cuenta");
                }
            });
        };


    }]);

app.controller("CuentaDetailInsertarController", ["$scope", "$http", function($scope, $http) {
        $scope.action = "insert";
        $scope.insertarCuenta = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/cuenta/",
                data: $scope.cuenta
            }).success(function() {
                window.location.assign("#/cuenta/cuentas");
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se puede insertar la cuenta");
                }
            });
        };
    }]);

