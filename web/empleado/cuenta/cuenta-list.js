app.controller("CuentaListController", ["$location","$scope", "$http", function CuentaListController($location,$scope, $http) {
        $scope.mostrarTablaCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/cuentas"
            }).success(function(data) {
                $scope.cuentas = data;
            }).error(function() {
                $location.url("/loginrequired");
            });
        };
        $scope.mostrarTablaCuenta();

    }]);

