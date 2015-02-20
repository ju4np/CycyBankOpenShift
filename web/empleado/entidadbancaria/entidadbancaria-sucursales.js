app.controller("EntidadBancariaSucursalController", ["$location","$scope", "$http","$routeParams", function($location,$scope, $http, $routeParams) {


        $scope.cargarEntidadBancaria = function() {

            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $routeParams.id
            }).success(function(data) {
                $scope.entidadBancaria = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                 $location.url("/loginrequired");
             }
            });

        };


       $scope.cargarEntidadBancaria();
       
       $scope.cargarSucursalesBancarias =function(){
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $routeParams.id+"/Sucursales"
            }).success(function(data) {
                $scope.sucursalesBancarias = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                 $location.url("/loginrequired");
             }
            });
       };
       $scope.cargarSucursalesBancarias();
       }]);