'use strict';

angular.module('visual')
    .factory('Venda', 
        function(railsResourceFactory, API_URL) {
        var Venda = railsResourceFactory({
            url: API_URL + 'venda'
        });
        
        return Venda;
    });