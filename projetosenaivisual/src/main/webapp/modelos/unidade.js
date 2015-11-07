'use strict';

angular.module('visual')
    .factory('Unidade', 
        function(railsResourceFactory, API_URL) {
        var Unidade = railsResourceFactory({
            url: API_URL + 'unidade'
        });

        return Unidade;
    });