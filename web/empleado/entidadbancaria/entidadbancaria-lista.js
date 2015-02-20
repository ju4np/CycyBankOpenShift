app.controller("EntidadBancariaListaController", ["$location","$scope", "$http", function($location,$scope, $http) {


        $scope.cargarEntidadesBancarias = function() {

            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria"
            }).success(function(data) {
                $scope.entidadesBancarias = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {

                 $location.url("/loginrequired");
             }
            });

        };


       $scope.cargarEntidadesBancarias();


        $scope.editarEntidadBancaria = function(id) {
            location.href = "#/entidadbancaria/detalles/" + id;
        };
        
 $scope.verSucursalesDeEntidadBancaria = function(id) {
            location.href = "#/entidadbancaria/"+id+"/sucursales" ;
        };

        $scope.borrarEntidadBancaria = function(id) {

            if (confirm('¿Está seguro de que quiere borrar la entidad bancaria ' + id + '?')) {

                $http({
                    method: "DELETE",
                    url: contextPath + "/api/EntidadBancaria/" + id
                }).success(function() {
                    $scope.cargarEntidadesBancarias();
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("Error: " + status);
                }
                });

            }
        };


    }]);