'use strict';
interviewSchedulerApp.controller('consultantController', function($scope,$sce,consultantsData,consultantService) {
	$scope.selectedRows = [];
	//Needed Modals
	//Consultant Edit Modal
	$scope.showModal = false;
	$scope.toggleModal = function(){
		$scope.showModal = !$scope.showModal;
	};
	$scope.closeModal = function(){
		console.log('Modal Closed');
		$scope.showModal = false;
	};
	//Consultant resume Modal
	$scope.showResumeModal = false;
	$scope.toggleResumeModal = function(){
		$scope.showResumeModal = !$scope.showResumeModal;
	};
	$scope.closeResumeModal = function(){
		console.log('Modal Closed');
		$scope.showResumeModal = false;
	};
	//Sales Representative Modal
	$scope.showSalesRepModal = false;
	$scope.salesRepDtoModel = {};
	$scope.salesRepClick = function(salesRepDto) {
		console.log('inside the link click', salesRepDto);
		$scope.toggleSalesRepModal();
		$scope.salesRepDtoModel = salesRepDto;
	};

	$scope.toggleSalesRepModal = function(){
		$scope.showSalesRepModal = !$scope.showSalesRepModal;
	};
	//New Consultant Modal
	$scope.showNewConsultantModal = false;
	$scope.toggleNewConsultantModal = function(){
		$scope.showNewConsultantModal = !$scope.showNewConsultantModal;
	};
	//fetching clients and Sales reps.
	$scope.clientsandRepsList = function(){
		consultantService.fetchSalesReps().then(
				function(response){
					$scope.salesRepsData = response.data;
					$scope.toggleNewConsultantModal();
				}, function(errResponse){
					return $q.reject(errResponse);
				}
		);
		consultantService.fetchClients().then(
				function(response){
					$scope.clientsData = response.data;
				}, function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};

	//Creating a variable to add New Consultant Data
	$scope.consultant = {};
	$scope.closeNewConsultantModal = function(){
		consultantService.fetchClients();
		consultantService.fetchSalesReps();
		$scope.salesRepsData = consultantService.fetchSalesReps();
		console.log('new consultant Modal Closed');
		$scope.showNewConsultantModal = false;
		console.log('data for new consultant', $scope.consultant);
		consultantService.addConsultant($scope.consultant);
	};
	//Education Detail Modal
	$scope.showEducationModal = false;
	$scope.educationModal = [];
	$scope.educationClick = function(entity) {
		console.log('ed click entity',entity);
		$scope.toggleeducationModal (entity); 
	};
	$scope.toggleeducationModal = function(entity){
		var consultantId = entity.id;
		consultantService.fetchEducationDetail(consultantId).then(
				function(response) {
					$scope.educationModal = response;
				}, function(errResponse) {
					console.error('Error while fetching educationDetail');
					return $q.reject(errResponse);
				}
		);
		$scope.showEducationModal = !$scope.showEducationModal;
	};




	/* $scope.editConsultant=[];*/

	$scope.consultantsGrid = {
			enableSorting: true,
			columnDefs: [
			             { name:'Name', field:'name'},
			             { name:'DOB', field: 'dob' },
			             { name:'SSN', field: 'ssn'},
			             { name:'PHONE', field: 'phone'},
			             { name:'EMAIL', field: 'email'},
			             { name:'Experience', field: 'yearsExp'},
			             { 
			            	 name:'Education', 
			            	 field: 'educationName',
			            	 cellTemplate: '<a href ng-click="grid.appScope.educationClick(row.entity)">{{COL_FIELD}}</a>'
			             },
			             { 
			            	 name:'Sales Rep', 
			            	 field: 'salesRepDto.repName' ,
			            	 cellTemplate: '<a href ng-click="grid.appScope.salesRepClick(row.entity.salesRepDto)">{{COL_FIELD}}</a>'
			             },
			             { 	
			            	 name:'Resume', 
			            	 cellTemplate:'<a href ng-click="grid.appScope.fetchResume(row.entity.id)">View Resume</a>'
			             }
			             ],
			             data : consultantsData

	};
	$scope.fetchResume = function(id){
		consultantService.fetchResume(id).then(
				function(fileURL) {
					$scope.toggleResumeModal();
					$scope.content = $sce.trustAsResourceUrl(fileURL);

					console.log('from controller:',$scope.content);
				}, function(errResponse) {
					console.error('Error while fetching resume');
					return $q.reject(errResponse);
				}
		);

	};

	$scope.consultantsGrid.multiSelect = true;

	$scope.checkGridApi = function () {
		console.log('select: ', $scope.gridApi);	
	};

	$scope.consultantDeleteDisable = true;
	$scope.consultantEditDisable = true;

	$scope.consultantsGrid.onRegisterApi = function (gridApi) {
		$scope.gridApi = gridApi;


		gridApi.selection.on.rowSelectionChanged($scope, function (row) {
			console.log('ent: ', row.entity);
			var found = false;
			if ($scope.selectedRows.length > 0) {
				for(var i = 0; i < $scope.selectedRows.length; i++) {
					if ($scope.selectedRows[i].id === row.entity.id) {
						$scope.selectedRows.splice(i, 1);
						found = true;
						break;
					}
				}
				if (!found) {
					$scope.selectedRows.push(row.entity);
				} 
			} else {
				$scope.selectedRows.push(row.entity);
			}

		});
	};

	$scope.$watch('selectedRows', function() {
		console.log('watch ', $scope.selectedRows);
		if ($scope.selectedRows.length > 0) {
			if ($scope.selectedRows.length === 1) {
				$scope.consultantEditDisable = false;

			} else {
				$scope.consultantEditDisable = true;
			}
			$scope.consultantDeleteDisable = false;
		} else {
			$scope.consultantDeleteDisable = true;
			$scope.consultantEditDisable = true;
		}
	}, true);
	$scope.sendPost = function() {
		console.log('from sendpost');
		consultantService.editConsultant($scope.selectedRows[0]);

	}

	$scope.addNewConsultant = function () {
		$scope.consultantModalTitle = 'Add New Consultant';
	};

//	10/21
	/*
	 * change dto to fit the modal fields
	 * one modal for edit and add .. 
	 */

//	make http call for edit submit click.
//	on delete click .. pop up a window asking for confirmation
//	http call for delete
});