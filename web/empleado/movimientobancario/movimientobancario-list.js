app.controller("MovimientoBancarioListController", ["$location","$scope", "$http", function MovimientoBancarioListController($location,$scope, $http) {
        $scope.getMovimientos = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/MovimientosBancarios/"
            }).success(function(data, status, headers, config) {
                $scope.movimientosBancarios = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    $location.url("/loginrequired");
                }
            });
        };
        $scope.getMovimientos();

    }]);

