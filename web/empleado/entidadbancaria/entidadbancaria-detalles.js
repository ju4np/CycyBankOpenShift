
app.controller("EntidadBancariaDetallesInsertController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.entidadBancaria = {
            idEntidadBancaria: "",
            nombre: "",
            codigoEntidad: ""
        };

        $scope.action = "insert";


        $scope.insertarRegistro = function () {

            $http({
                method: "POST",
                url: contextPath + "/api/EntidadBancaria/",
                data: $scope.entidadBancaria
            }).success(function () {
                window.location.assign("#/entidadbancaria/entidades");
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se pudo insertar el entidad");
                }
            });
        };

    }]);


app.controller("EntidadBancariaDetallesUpdateController", ["$scope", "$http", "$routeParams", function ($scope, $http, $routeParams) {

        $scope.action = "update";

        $scope.buscarRegistro = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/EntidadBancaria/" + $routeParams.id
            }).success(function (data) {
                $scope.entidadBancaria = data;
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se pudo modificar la entidad");
                }
            });
        };


        $scope.buscarRegistro($routeParams.id);

        $scope.modificarRegistro = function () {
            $http({
                method: "PUT",
                url: contextPath + "/api/EntidadBancaria/",
                data: $scope.entidadBancaria
            }).success(function () {
                window.location.assign("#/entidadbancaria/entidades");
            }).error(function (data,status) {
                if (status === 406) {
                    $scope.errores=data;
                    $scope.mostrarErrores=true;
                } else {
                    alert("No se ha podido modificar la entidad bancaria.");
                }
            });
        };

    }]);