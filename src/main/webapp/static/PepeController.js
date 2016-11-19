(function(){
	angular
		.module('app')
		.controller('PepeController', function($scope, $http, $state){
			$scope.text = 'bienvenido';
			
//			$scope.remove = function(pet){
//				$http.delete(pageContext + '/api/ventas/' + pet.id).then(function(response){
//					loadPets();
//				}, function(){
//					alert('Error!!!');
//				});
//			}
//			
//			$scope.edit = function(pet){
//				$state.go('newPet', {id: pet.id});
//			}
			
			function loadVentas(){
				$http.get(pageContext + '/api/ventas').then(function(response){
					// Exito
					$scope.ventas = response.data;
				}, function(error){
					//Error
					console.log(error);
				});	
			};
			
			loadVentas();
		});
})();