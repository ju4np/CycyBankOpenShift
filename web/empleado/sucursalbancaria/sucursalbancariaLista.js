 app.controller("SucursalbancariaListaController", ["$location", "$scope", "$http", function ($location, $scope, $http) {
        $scope.sucursalesBancarias = {
            localizacion: "",
            codigoSucursal: "",
            entidadBancaria: "",
            nombreSucursal: ""
        };
     
        $scope.findAll = function () {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function (data) {
                $scope.sucursalesBancarias = data;
            }).error(function (data, status) {
                if (status === 406) {
                    $scope.errores = data;
                    $scope.mostrarErrores = true;
                } else {
                    $location.url("/loginrequired");
                }
            });
        };

        $scope.findAll();

        $scope.verCuentasDeSucursalBancaria = function (id) {
            location.href = "#/sucursalbancaria/" + id + "/cuentas";
        };


    }]);