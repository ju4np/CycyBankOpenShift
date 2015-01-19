
app.config(['$routeProvider', function($routeProvider) {


        $routeProvider.when('/entidadbancaria/entidades', {
            templateUrl: "entidadbancaria/entidadbancaria-lista.html",
            controller: "EntidadBancariaListaController"
        });

        $routeProvider.when('/entidadbancaria/detalles', {//INSERT
            templateUrl: "entidadbancaria/entidadbancaria-detalles.html",
            controller: "EntidadBancariaDetallesInsertController"
        });

        $routeProvider.when('/entidadbancaria/detalles/:id', {//UPDATE
            templateUrl: "entidadbancaria/entidadbancaria-detalles.html",
            controller: "EntidadBancariaDetallesUpdateController"
        });

        $routeProvider.when('/entidadbancaria/:id/sucursales', {
            templateUrl: "entidadbancaria/entidadbancaria-sucursales.html",
            controller: "EntidadBancariaSucursalController"
        });

    }]);

