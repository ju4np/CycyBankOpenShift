app.controller("SucursalBancariaCuentaController", ["$location","$scope", "$http","$routeParams", function($location,$scope, $http, $routeParams) {

        $scope.cargarSucursalBancaria = function() {

            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.id
            }).success(function(data) {
                $scope.sucursalBancaria = data;
            }).error(function() {
                 $location.url("/loginrequired");
            });

        };


       $scope.cargarSucursalBancaria();
       
       $scope.cargarCuentasBancarias =function(){
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria/" + $routeParams.id+"/Cuentas"
            }).success(function(data) {
                $scope.cuentas = data;
            }).error(function() {
                 $location.url("/loginrequired");
            });
       };
       
       $scope.cargarCuentasBancarias();
       
       }]);