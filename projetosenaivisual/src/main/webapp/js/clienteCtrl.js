'use strict';

function ClienteController($scope, Cliente) {
    
    var limpar = function () {
        $scope.cliente = {};
    };
    
    $scope.gravar = function () {
        if ($scope.cliente.id) {
            $scope.cliente.update().then(function () {
                limpar();
                $scope.listar();
            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            $scope.cliente.type = "cliente";
            new Cliente($scope.cliente).create()
                    .then(function () {
                        limpar();
                        $scope.listar();
                    }, function (error) {
                        console.log('error', error);
                        alert(error.data);
                    });
        }
    };

    $scope.listar = function () {
        Cliente.query().then(function (data) {
            $scope.listCliente = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.editar = function (cliente) {
        $scope.cliente = angular.copy(cliente);
    };

    $scope.deletar = function (cliente) {
        cliente.remove().then(function () {
            $scope.listar();
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    limpar();
    $scope.listar();
}
function ClienteRoute($stateProvider) {
    $stateProvider.state('cliente', {
        url: '/cliente',
        templateUrl: 'views/cliente.html',
        controller: 'ClienteController'
    });
}
angular.module('visual')
        .config(ClienteRoute)
        .controller('ClienteController', ClienteController);