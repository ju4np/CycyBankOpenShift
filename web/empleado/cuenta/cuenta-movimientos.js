app.controller("CuentaMovimientoController", ["$location","$scope", "$http","$routeParams", function($location,$scope, $http, $routeParams) {
        $scope.cargarCuenta = function(){
            $http({
                method: "GET",
                url: contextPath + "/api/cuenta/"+ $routeParams.id
            }).success(function(data){
                $scope.cuenta = data;
            }).error(function(){
                $location.url("loginrequired");
            });
        };
        $scope.cargarCuenta();
        
        $scope.cargarMovimientos = function(){
            $http({
                method: "GET",
                url:contextPath+"/api/cuenta/"+$routeParams.id+"/movimientos"
            }).success(function(data){
                $scope.movimientosBancarios = data;
            }).error(function(status){
                
            });
        };
        
        $scope.cargarMovimientos();
}]);