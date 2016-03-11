'use strict';
/* Services */
interviewSchedulerApp.service('consultantService', ['$http', '$q', 'applicationUrlService', function($http, $q, urlService){
	var url =  urlService.getURL();
	return {
		fetchClients:function(){
			return $http.get(url+'/getClients')
			.then(function(response){
				return response.data;
			},
			function(errResponse){
				console.log("couldnot Fetch clients");
			}
			)

		},
		fetchSalesReps:function(){
			return $http.get(url+'/allSalesRep')
			.then(function(response){
				return response.data;
			},
			function(errResponse){
				console.log("couldnot Fetch SalesRepresentatives");
			}
			)

		},
		addConsultant : function(consultantData){
			console.log('data for adding consultant', consultantData);
			return $http.post(url+'/addConsultant',consultantData)
			.success(function(consultantData){
				console.log('put servie for adding consultant hit',consultantData);

			})
			.error(function(consultantData) {
				alert("failure adding Consultant");
			})
		},
		fetchAllConsultants : function(){
			return $http.get(url+ '/consultants')
			.then(
					function(response){
						console.log('response: ', response);
						return response.data;
					},

					function(errResponse){
						console.error('Error while fetching users');
						return $q.reject(errResponse);
					}
			);
		},

		fetchResume : function(consultantId){
			console.log('Resume For Consultant No' , consultantId);
			return $http.post(url+'/getResume', consultantId,{responseType:'arraybuffer'})
			.success(function(response){

			})
			.error(function(file) {
				console.log(file);
				alert("failure");
			}).then(
					function(response){

						console.log("resolved promise for resume",response);
						var file = new Blob([response.data], {type: 'application/pdf'});
						var fileURL = URL.createObjectURL(file);
						return fileURL;
					},
					function(errResponse){
						console.error('Error while fetching Education Detail');
						return $q.reject(errResponse);
					}
			);
		},

		fetchEducationDetail : function(consultantId){
			console.log('Education Detail : ' , consultantId);
			return $http.post(url+'/getEducationDetail', consultantId)
			.success(function(consultantId){
				console.log('post servie hit',consultantId);

			})
			.error(function(consultantId) {
				alert("failure");
			})
			.then(
					function(response){
						console.log('response: ', response);
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching Education Detail');
						return $q.reject(errResponse);
					}
			);	

		}

	}

}]);


