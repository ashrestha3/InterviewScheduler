interviewSchedulerApp.controller('uploadCtrl', ['$scope', 'fileUpload', function($scope, fileUpload){
    $scope.uploadFile = function(){
        var file = $scope.myFile;
        
        console.log('file is ' );
        console.dir(file);
        
        var uploadUrl = "http://localhost:8080/InterviewScheduler/fileUpload";
        fileUpload.uploadFileToUrl(file, uploadUrl);
     };
  }]);