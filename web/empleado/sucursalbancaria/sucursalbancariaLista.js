 app.controller("SucursalbancariaListaController", ["$location","$scope", "$http", function($location,$scope, $http){
        $scope.findAll = function() {
            $http({
                method: "GET",
                url: contextPath + "/api/SucursalBancaria"
            }).success(function(data) {
                $scope.sucursalesBancarias = data;
                }).error(function() {
                 $location.url("/loginrequired");
            });
        };
        
        $scope.findAll();
    }]);