'use strict';

/* Services */
interviewSchedulerApp.service('vendorService', ['$http', '$q', function($http, $q){
	return {
		fetchAllVendors : function(){
			console.log('inside service.js vendors');
			return $http.get('http://localhost:8080/InterviewScheduler/vendors')
			.then(
					function(response){
						return response.data;
					},

					function(errResponse){
						console.error('Error while fetching vendors');
						return $q.reject(errResponse);
					}
			);
		}
	}

}]);