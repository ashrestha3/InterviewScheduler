var interviewSchedulerApp = angular.module('interviewSchedulerApp', ['ngSanitize','ui.router', 'ngTouch', 'ui.grid','ui.grid.selection','ui.bootstrap', 'interviewSchedulerApp.directives']);
 

interviewSchedulerApp.config(function($stateProvider, $urlRouterProvider) {

	console.log('inside app.js');

	$urlRouterProvider.otherwise('/home');

	$stateProvider

	// HOME STATES AND NESTED VIEWS ========================================
	.state('home', {
		url: '/home',
		templateUrl: 'resources/html/home/home.html'
	})

	// ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
	.state('about', {
		url: '/about',
		templateUrl: 'resources/html/about/about.html'   
	})

	.state('contact', {
		url: '/contact',
		templateUrl: 'resources/html/contact/contact.html'

	})
	.state('consultants', {
		url: '/consultants',
		templateUrl: 'resources/html/consultant/consultant.html',
		controller: 'consultantController',
		resolve: {
			/*message: function(consultantService){
				var message = consultantService.getMessage();
				console.log('state :', message);
				return message;
			}
			message : function() {
				console.log('inside state');
				return {value : 'Hello!'};
			}*/
			consultantsData : ['consultantService', function(consultantService){
				console.log('inside app.js consultants');
				consultantService.fetchAllConsultants
				return consultantService.fetchAllConsultants();

			}]

		}

	})
	.state('vendors',{
		url: '/vendors',
		templateUrl: 'resources/html/vendor/vendor.html',
		controller: 'vendorController',
		resolve: {
			vendorsData : ['vendorService', function(vendorService){
				console.log('inside app.js vendors', vendorService);
				return vendorService.fetchAllVendors();
			}]

		}	

	})

	.state('login',{
		url: '/login',
		templateUrl: 'resources/html/user/user.html',
		controller: 'userController'

	})

	.state('interviews',{
		url:'/interviews',
		views: {
			'':{
				templateUrl:'resources/html/interview/interviews.html'
			},
			'calendar@interviews':{
			templateUrl:'resources/html/interview/calendar.html',
			controller: 'calendarController'
			},
			'consultantList@interviews':{
				templateUrl:'resources/html/interview/consultantList.html',
				controller: 'interviewConsultantListController'	
			},
			'selectedDayInterviews@interviews': {
				
			}
		}
	})
}
);
