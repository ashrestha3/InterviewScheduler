interviewSchedulerApp.controller('interviewConsultantListController', function($scope) {
	console.log('inside interviewConsultantListController');
	$scope.consultantsList = {
			enableSorting: true,
			columnDefs: [
			             { name:'Inteview Candidates For Today', field:'name'}
			            ],
			            data : [
			            	 {name: "Nirish Pyakurel"}
			            ]

	};
});