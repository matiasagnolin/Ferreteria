(function(){
	angular
		.module('app')
		.controller('PepeController', function($scope, $http, $state, $stateParams){
			
			var id = $stateParams.id;
			
			$scope.DonPepe = {};
			
			if(id != null){
				$http.get(pageContext + '/api/ventas/' + id).then(function(response){
					$scope.DonPepe = response.data;
					//$scope.pet.birthdate = new Date(response.data.birthdate);
				});	
			}
			
//			$scope.save = function(){
//				
//				if(id == null){
//					addPet();
//				} else {
//					editPet();
//				}
//			};
//			
//			function editPet(){
//				var param = {
//						name: $scope.pet.name, 
//						birthdate: $scope.pet.birthdate
//				};
//				
//				$http.put(pageContext + '/api/ventas/' + id, param).then(function(){
//					$state.go('app');
//				});
//			}
			
			function addPet(){
				var param = {
						name: $scope.pet.name, 
						birthdate: $scope.pet.birthdate
				};
				
				$http.post(pageContext + '/api/ventas', param).then(function(){
					$state.go('app');
				}, function(error){
					
				});
			}
		});
})();