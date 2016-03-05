/**
 * http://usejsdoc.org/
 */

(function(){
	
	var pmModule=angular.module('pm', ['ui.router']);
	
	pmModule.config(function($stateProvider,$urlRouterProvider) {
		
		$urlRouterProvider.otherwise('/');
		

		$stateProvider
		.state('home', {
			url : "/",
			templateUrl : 'templates/pm-home.html'
		}).state('all', {
			url : "/view-all",
			templateUrl : 'templates/pm-grid.html',
			controller : 'ViewController'
		}).state('new', {
			url : "/add-new",
			templateUrl : 'templates/pm-product-form.html',
			controller : 'SaveController'
		}).state('all.edit', {
			url : "/edit/:prodId",
			views:{
				readView:{
					templateUrl : 'templates/pm-product-view.html',
					controller : 'ViewAndEditController'
				},
				editView:{
					templateUrl : 'templates/pm-product-form.html',
					controller : 'ViewAndEditController'
				}
			}
		}).state('all.view', {
			url : "/view/:prodId",
			views:{
				readView:{
					templateUrl : 'templates/pm-product-view.html',
					controller : 'ViewAndEditController'
				}
			}
		});
		
		
	});
	
	
	pmModule.controller('ViewController', function($scope,pmService,$state) {
		
		pmService.loadAll()
		.then(function(items){
			$scope.products=items;
		});
		
		$scope.remove=function(id){
			pmService.remove(id)
			.then(function(){
				$state.reload();
			});
		};
		
	});
	
	pmModule.controller('SaveController', function($scope,pmService,$location) {
		$scope.product={};
		$scope.save=function(){
			pmService.save($scope.product)
			.then(function(item){
				$scope.product={};
				$scope.message=item.name+" saved ";
				$location.path('view-all');
			});
		};
	});
	
	pmModule.controller('ViewAndEditController', function($scope,pmService,$location,$stateParams) {
		
		if($stateParams.prodId){
			pmService.loadById($stateParams.prodId)
			.then(function(item){
				$scope.product=item;
			});
		}
		
		$scope.save=function(){
			pmService.update($scope.product)
			.then(function(item){
				$scope.product={};
				$scope.message=item.name+"updated ";
				$location.path('view-all');
			});
		};
	});
	

	
	// Angular REST - client
	pmModule.factory('pmService', function($q, $http) {
	
		var url = "http://localhost:8080/pm-rest-server-app/products";
		
		return {
			loadAll : function() {
				var defer = $q.defer();
				$http.get(url).then(function(result) {
					defer.resolve(result.data.product);
				});
				return defer.promise;
			},
			save : function(newProduct) {
				var defer = $q.defer();
				newProduct.notAvailable = false;
				newProduct.make = Date.now();
				$http.post(url, newProduct).then(function(result) {
					defer.resolve(result.data);
				});
				return defer.promise;
			},
			remove : function(id) {
				var defer = $q.defer();
				$http['delete'](url + "/" + id).then(function(result) {
					defer.resolve();
				});
				return defer.promise;
			},
			loadById : function(id) {
				var defer = $q.defer();
				$http.get(url + "/" + id).then(function(result) {
					defer.resolve(result.data);
				});
				return defer.promise;
			},
			update : function(product) {
				var defer = $q.defer();
				product.notAvailable = false;
				product.make = Date.now();
				$http.put(url + "/" + product.id, product).then(function(result) {
					defer.resolve(result.data);
				});
				return defer.promise;
	
			}
	
		};
	});
	
	
})();