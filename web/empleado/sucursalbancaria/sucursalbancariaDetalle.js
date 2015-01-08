 app.controller("SucursalbancariaDetalleDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.getSucursal = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.id
            }).success(function(data) {
                $scope.sucursalBancaria = data;
            }).error(function(status) {
                alert("Error: " + status);
            });
        };
        $scope.getSucursal();

        $scope.deleteSucursal = function(id) {
            if (confirm("Desea borrar el registro con id: " + $routeParams.id)) {
                $http({
                    method: "DELETE",
                    url: contextPath + "/api/SucursalBancaria/" + id
                }).success(function() {
                    window.location.assign("#/sucursalbancaria/sucursalesbancarias");
                    }).error(function() {
                    alert("No se pudo borrar la sucursal bancaria.");
                });
            }
        };

    }]);

 app.controller("SucursalbancariaDetalleInsertController", ["$scope", "$http", function($scope, $http) {
        $scope.insertSucursal = function() {
            $http({
                method: "POST",
                data: $scope.sucursalBancaria,
                url: contextPath + "/api/SucursalBancaria/"
            }).success(function() {
                window.location.assign("#/sucursalbancaria/sucursalesbancarias");
                }).error(function() {
                alert("No se pudo insertar la sucursal bancaria.");
            });
        };
        $scope.action = "insert";
    }]);

 app.controller("SucursalbancariaDetalleUpdateController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.getSucursal = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.id
            }).success(function(data) {
                $scope.sucursalBancaria = data;
            }).error(function(status) {
                alert("Error: " + status);
            });
        };
        $scope.getSucursal();

        $scope.action = "update";

        $scope.updateSucursal = function() {
            $http({
                method: "PUT",
                data: $scope.sucursalBancaria,
                url: contextPath + "/api/SucursalBancaria/"
            }).success(function() {
                window.location.assign("#/sucursalbancaria/sucursalesbancarias");
                }).error(function() {
                alert("No se ha podido modificar la sucursal bancaria.");
            });
        };
    }]);

    