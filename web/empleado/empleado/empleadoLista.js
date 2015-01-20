app.controller("EmpleadoListaController", ["$location","$scope", "$http", function($location,$scope, $http) {


        $scope.cargarEntidadesBancarias = function() {

            $http({
                method: "GET",
                url: contextPath + "/api/Empleado"
            }).success(function(data) {
                $scope.empleados = data;
            }).error(function() {
                 $location.url("/loginrequired");
            });

        };


        $scope.cargarEntidadesBancarias();


        $scope.editar = function(id) {
            location.href = "#/empleado/detalles/" + id;
        };


        $scope.borrarRegistro = function(id) {

            if (confirm('¿Está seguro de que quiere borrar el empleado ' + id + '?')) {
                $http({
                    method: "DELETE",
                    url: contextPath + "/api/Empleado/" + id
                }).success(function() {
                    $scope.cargarEntidadesBancarias();
                }).error(function() {
                    alert("Error: " + status);
                });
            }
        };


    }]);