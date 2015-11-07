'use strict';

function UnidadeController($scope, Unidade) {
    
    $scope.gravar = function () {
        if ($scope.unidade.id) {
            $scope.unidade.update().then(function () {
                $scope.limpar();
                $scope.listar();
            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Unidade($scope.unidade).create()
                    .then(function () {
                        $scope.limpar();
                        $scope.listar();
                    }, function (error) {
                        console.log('error', error);
                        alert(error.data);
                    });
        }
    };
    
    limpar = function () {
        $scope.unidade = {};
    };

    $scope.listar = function () {
        Unidade.query().then(function (data) {
            $scope.listUnidades = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    

    $scope.editar = function (contato) {
        $scope.contato = angular.copy(contato);
    };

    $scope.deletar = function (contato) {
        contato.remove().then(function () {
            $scope.listar();
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.limpar();
    $scope.listar();
}
function UnidadeRoute($stateProvider) {
    $stateProvider.state('visual', {
        url: '/unidade',
        templateUrl: 'views/unidade_medida.html',
        controller: 'UnidadeController'
    });
}
angular.module('visual')
        .config(UnidadeRoute)
        .controller('UnidadeController', UnidadeController);