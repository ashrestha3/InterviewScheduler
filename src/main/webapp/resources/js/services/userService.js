'use strict';

/* Services */
interviewSchedulerApp.service('userService', ['$http', '$q', function($http, $q){
	return {
		fetchRole : function(){
			console.log('inside fetching role');
			return $http.get('http://localhost:8080/InterviewScheduler/fetchRole')
			.then(
					function(response){
						console.log('role data', response.data);
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching roles');
						return $q.reject(errResponse);
					}
			);
		},
		 signUpNewUser: function(signUpNewUserData){
			console.log('User service : ' , signUpNewUserData);
			$http.post('http://localhost:8080/InterviewScheduler/signUpNewUser', signUpNewUserData)
			.success(function(signUpNewUserData, status, headers, config){
				console.log('post servie hit'+signUpNewUserData);

			}).error(function(signUpNewUserData, status, headers, config) {
				alert("failure");
			}
			);	

		}

	}

}]);
