'use strict';

angular.module('visual', [
    'ui.router',
    'ui.bootstrap',
    'rails'
]).config(function ($urlRouterProvider, RailsResourceProvider, railsSerializerProvider) {
    $urlRouterProvider.when('', '/');
    $urlRouterProvider.otherwise('/error?code=404');
    RailsResourceProvider.rootWrapping(false);
    railsSerializerProvider.underscore(angular.identity).camelize(angular.identity);
}).constant('API_URL', 'api/');