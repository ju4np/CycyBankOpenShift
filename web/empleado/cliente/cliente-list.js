app.controller("ClienteListController", ["$location","$scope", "$http", function ClientesListController($location,$scope, $http) {

    $scope.mostrarTablaCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Clientes/"
            }).success(function(data) {
                $scope.clientes = data;
                for(i=0; i<$scope.clientes.length;i++){
                    $scope.clientes[i].fechaNacimiento=new Date($scope.clientes[i].fechaNacimiento);
                }

            }).error(function() {
                $location.url("/loginrequired");
            });
        };
        $scope.mostrarTablaCliente();

}]);