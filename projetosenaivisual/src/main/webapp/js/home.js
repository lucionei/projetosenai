'use strict';

function HomeController($scope) {}

function HomeRoute($stateProvider) {
    $stateProvider.state('home', {
        url: '/',
        templateUrl: 'views/home.html',
        controller: 'HomeController'
    });
}
angular.module('visual')
        .config(HomeRoute)
        .controller('HomeController', HomeController);