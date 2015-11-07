'use strict';

function UnidadeController($scope, Unidade) {
    
    var limpar = function () {
        $scope.unidade = {};
    };
    
    $scope.gravar = function () {
        if ($scope.unidade.id) {
            $scope.unidade.update().then(function () {
                limpar();
                $scope.listar();
            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Unidade($scope.unidade).create()
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
        Unidade.query().then(function (data) {
            $scope.listUnidades = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.editar = function (unidade) {
        $scope.unidade = angular.copy(unidade);
    };

    $scope.deletar = function (unidade) {
        unidade.remove().then(function () {
            $scope.listar();
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    limpar();
    $scope.listar();
}
function UnidadeRoute($stateProvider) {
    $stateProvider.state('unidade', {
        url: '/unidade',
        templateUrl: 'views/unidade_medida.html',
        controller: 'UnidadeController'
    });
}
angular.module('visual')
        .config(UnidadeRoute)
        .controller('UnidadeController', UnidadeController);