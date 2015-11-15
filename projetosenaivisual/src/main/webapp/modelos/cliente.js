'use strict';

angular.module('visual')
    .factory('Cliente', 
        function(railsResourceFactory, API_URL) {
        var Cliente = railsResourceFactory({
            url: API_URL + 'cliente'
        });

        return Cliente;
    });