'use strict';

function ProdutoController($scope, Produto, Unidade) {
    
    var limpar = function () {
        $scope.produto = {};
    };
    
    $scope.gravar = function () {
        if ($scope.produto.id) {
            $scope.produto.update().then(function () {
                limpar();
                $scope.listar();
            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Produto($scope.produto).create()
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
        Produto.query().then(function (data) {
            $scope.listProdutos = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
    
    $scope.listarUnidades = function () {
        Unidade.query().then(function (data) {
            $scope.listUnidades = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.editar = function (produto) {
        $scope.produto = angular.copy(produto);       
    };

    $scope.deletar = function (produto) {
        produto.remove().then(function () {
            $scope.listar();
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    limpar();
    $scope.listar();
    $scope.listarUnidades();
}
function ProdutoRoute($stateProvider) {
    $stateProvider.state('produto', {
        url: '/produto',
        templateUrl: 'views/produto.html',
        controller: 'ProdutoController'
    });
}
angular.module('visual')
        .config(ProdutoRoute)
        .controller('ProdutoController', ProdutoController);