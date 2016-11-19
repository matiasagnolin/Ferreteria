(function(){
	angular
	.module('app', ['ui.route'])
	.config(function($stateProvider, $urlRouterProvider){
		$urlRouterProvider.otherwise('/');
		
		$stateProvider
		.state('app', {
			url: '/',
			templateUrl: pageContext + '/static/ventas.html',
			controller: 'PepeController'
		})
		console.log(error);

	});
})();