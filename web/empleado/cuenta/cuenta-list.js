app.controller("CuentaListController", ["$location","$scope", "$http", function CuentaListController($location,$scope, $http) {
        $scope.mostrarTablaCuenta = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/cuentas"
            }).success(function(data) {
                $scope.cuentas = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                $location.url("/loginrequired");
            }
            });
        };
        $scope.mostrarTablaCuenta();

         $scope.verMovimientos = function(idCuenta) {
            location.href = "#/cuenta/"+idCuenta+"/movimientos" ;
        };
    }]);

