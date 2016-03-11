interviewSchedulerApp.service('applicationUrlService', [ function(){
	return{
		getURL : function(){
			var link = "http://localhost:8080/InterviewScheduler";
			return link;
		}
	}
}]);
