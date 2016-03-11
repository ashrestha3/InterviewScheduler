'use strict';
interviewSchedulerApp.controller('vendorController', function($scope,vendorsData) {
	$scope.selectedRows = [];

	$scope.showModal = false;
	$scope.toggleModal = function(){
		console.log('togMod', $scope.selectedRows);
		$scope.showModal = !$scope.showModal;
	};

	$scope.gridOptions = {
			enableSorting: true,
			columnDefs: [
			             { name:'Name', field:'vendorName'},
			             { name:'Location', field: 'location' },

			             ],
			             data : vendorsData
	};
	$scope.gridOptions.multiSelect = true;

	$scope.checkGridApi = function () {
		console.log('select: ', $scope.gridApi);
	};	
		$scope.vendorDeleteDisable = true;
		$scope.vendorEditDisable = true;

		$scope.gridOptions.onRegisterApi = function (gridApi) {
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
					$scope.vendorEditDisable = false;
				} else {
					$scope.vendorEditDisable = true;
				}
				$scope.vendorDeleteDisable = false;
			} else {
				$scope.vendorDeleteDisable = true;
				$scope.vendorEditDisable = true;
			}
		}, true);
	});