'use strict';

angular.module('visual')
    .factory('Produto', 
        function(railsResourceFactory, API_URL) {
        var Produto = railsResourceFactory({
            url: API_URL + 'produto'
        });

        return Produto;
    });