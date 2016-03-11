'use strict';
interviewSchedulerApp.controller('userController', function($scope, userService) {
	$scope.selectedRows = [];

	$scope.showModal = false;
	$scope.userRoleOptions = [];
	$scope.toggleUserModal = function(){
		userService.fetchRole().then(
				function(response){
					console.log('role data', response);
					$scope.userRoleOptions = response;
				},

				function(errResponse){
					console.error('Error while fetching roles');
					return $q.reject(errResponse);
				}
		);
		console.log('user role data',$scope.userRoleOptions);
		$scope.showModal = !$scope.showModal;
	};
	$scope.signUpNewUser = function(){
		if(validatePassword()===true){
			$scope.showModal = false;
			//make a post request calling user service fx.
			var signUpNewUserData = {
					name: $scope.registerUser.name, 
					password: $scope.registerUser.password, 
					role: $scope.registerUser.role
			}
			userService.signUpNewUser(signUpNewUserData);
		} else {
			$scope.registerUser.alertUser.invalidPwd = 'Passwords donot match. Please re-enter.';
			$scope.registerUser.password = '';
			$scope.registerUser.password1 = '';
		}

	};

	var validatePassword = function () {
		var match = false;
		if ($scope.registerUser.password != '') {
			if($scope.registerUser.password===$scope.registerUser.password1){
				match = true;
			}
		}
		return match;
	}

	//Password must contain one alphanumeric character .. greater than 8 characters... must contain at least one lower case and one Uppercase 
	var characterCheck = function () {

	}

	$scope.registerUser = {
			name: '', 
			password: '',
			password1: '',
			alertUser: {
				invalidPwd: ''
			},
			role: ''
	};

});