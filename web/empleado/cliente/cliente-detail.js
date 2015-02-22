app.controller("ClienteDetailDeleteController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.action='delete';
        $scope.buscarCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $routeParams.id
            }).success(function(data, status, headers, config) {
                $scope.cliente = data; 
}).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se existe o no se puede encontrar el cliente");
                }
            });

        };
            $scope.buscarCliente();

        $scope.deleteCliente = function(idCliente) {
            $http({
                method: "DELETE",
                url: contextPath + "/api/Cliente/" +idCliente
            }).success(function(data, status, headers, config) {
                window.location.assign("#/cliente/clientes");
}).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se pudo borrar el cliente");
                }
            });
        };
    }]);







app.controller("ClienteDetailModificarController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {
        $scope.action='update';
        $scope.buscarCliente = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Cliente/" + $routeParams.id

            }).success(function(data, status, headers, config) {
                $scope.cliente = data;
                $scope.cliente.fechaNacimiento=new Date($scope.cliente.fechaNacimiento);
}).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No existe o no se puede encontrar el cliente");
                }
            });

        };
            $scope.buscarCliente();

        $scope.modificarCliente = function() {
            $http({
                method: "PUT",
                url: contextPath + "/api/Cliente",
                data: $scope.cliente
            }).success(function(data, status, headers, config) {     
                window.location.assign("#/cliente/clientes");
}).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se puede modificar el cliente");
                }
            });
        };
        
        
}]);

app.controller("ClienteDetailInsertController", ["$scope", "$http", function($scope, $http) {
        $scope.action='insert';
        $scope.insertarCliente = function() {
            $http({
                method: "POST",
                url: contextPath + "/api/Cliente/",
                data: $scope.cliente
            }).success(function(data, status, headers, config) {
                window.location.assign("#/cliente/clientes");
}).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No puede insertar el cliente");
                }
            });
        };
        
    }]);





