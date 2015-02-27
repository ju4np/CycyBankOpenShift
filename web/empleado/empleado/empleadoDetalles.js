
app.controller("EmpleadoDetallesInsertController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.empleado = {
        };

        $scope.editar = false;
        $scope.insertar = true;

        $scope.insertarRegistro = function() {
            if (contenedor.$valid) {
                $http({
                    method: "POST",
                    url: contextPath + "/api/Empleado",
                    data: $scope.empleado
                }).success(function() {
                    window.location.assign("#/empleado/empleados");
                }).error(function(data, status) {
                    if (status === 406) {
                        $scope.errores = data;
                        $scope.mostrarErrores = true;
                    } else {
                        alert("No se pudo insertar el empleado");
                    }
                });
            }
        };

    }]);


app.controller("EmpleadoDetallesUpdateController", ["$scope", "$http", "$routeParams", function($scope, $http, $routeParams) {

        $scope.editar = true;
        $scope.insertar = false;

        $scope.buscarRegistro = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/Empleado/" + $routeParams.id
            }).success(function(data) {
                $scope.empleado = data;
            }).error(function(data, status) {
                if (status === 406) {
                    $scope.errores = data;
                    $scope.mostrarErrores = true;
                } else {
                    alert("No se encontro el cliente");
                }
            });
        };


        $scope.buscarRegistro($routeParams.id);

        $scope.modificarRegistro = function() {
            if (contenedor.$valid) {
                $http({
                    method: "PUT",
                    url: contextPath + "/api/Empleado/",
                    data: $scope.empleado
                }).success(function() {
                    window.location.assign("#/empleado/empleados");
                }).error(function(data, status) {
                    if (status === 406) {
                        $scope.errores = data;
                        $scope.mostrarErrores = true;
                    } else {
                        alert("No se pudo modificar el cliente");
                    }
                });
            }
        };

    }]);