'use strict';

function VendaController($scope, Venda, Produto, Cliente) {

    $scope.item ={};
    var itemVenda = [];
    itemVenda.push({produto:null, valorItem:null});
    $scope.venda = itemVenda;
    
    $scope.addRow = function(){
     $scope.venda.itemVenda.push({produto:null, valorItem:null});     
    };
    
    $scope.deleteRow = function(item){
      $scope.venda.itemVenda.pop($scope.venda.itemVenda.indexOf(item));      
    };

    var limpar = function () {
        $scope.venda = {};
        $scope.venda.itemVenda = [{}];
    };

    $scope.gravar = function () {
        if ($scope.venda.id) {
            $scope.venda.update().then(function () {
                limpar();
                $scope.listar();
            }, function (error) {
                console.log('error', error);
                alert(error.data);
            });
        } else {
            new Venda($scope.venda).create()
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
        Venda.query().then(function (data) {
            $scope.listVendas = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.listarProdutos = function () {
        Produto.query().then(function (data) {
            $scope.listProdutos = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    var listarClientes = function () {
        Cliente.query().then(function (data) {
            $scope.listClientes = data;
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };

    $scope.editar = function (venda) {
        $scope.venda = angular.copy(venda);
    };

    $scope.deletar = function (produto) {
        produto.remove().then(function () {
            $scope.listar();
        }, function (error) {
            console.log('error', error);
            alert(error.data);
        });
    };
    
    $scope.open = function(itemVenda){
        if ($scope.isOpen(itemVenda)){
            $scope.opened = undefined;
        } else {
            $scope.opened = itemVenda;
        }        
    };
    
    $scope.isOpen = function(item){
        return $scope.opened === item;
    };
    
    $scope.anyItemOpen = function() {
        return $scope.opened !== undefined;
    };
    
    $scope.close = function() {
        $scope.opened = undefined;
    };
    
    limpar();
    listarClientes();
    $scope.listar();
    $scope.listarProdutos();
}
function VendaRoute($stateProvider) {
    $stateProvider.state('venda', {
        url: '/venda',
        templateUrl: 'views/venda.html',
        controller: 'VendaController'
    });
}
angular.module('visual')
        .config(VendaRoute)
        .controller('VendaController', VendaController);