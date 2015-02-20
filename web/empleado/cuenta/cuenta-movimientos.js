app.controller("CuentaMovimientoController", ["$location","$scope", "$http","$routeParams", function($location,$scope, $http, $routeParams) {
        $scope.cargarCuenta = function(){
            $http({
                method: "GET",
                url: contextPath + "/api/cuenta/"+ $routeParams.id
            }).success(function(data){
                $scope.cuenta = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {               
                    $location.url("loginrequired");
                }
            });
        };
        $scope.cargarCuenta();
        
        $scope.cargarMovimientos = function(){
            $http({
                method: "GET",
                url:contextPath+"/api/cuenta/"+$routeParams.id+"/movimientos"
            }).success(function(data){
                $scope.movimientosBancarios = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No existe o no de puede encontrar el movimiento");
                }
            });
        };
        
        $scope.cargarMovimientos();
}]);