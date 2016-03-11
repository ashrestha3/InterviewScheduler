interviewSchedulerApp.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
     console.log('inside upload service.');
        $http.post(uploadUrl, fd, {
           transformRequest: angular.identity,
           headers: {'Content-Type': undefined}
        })
     
        .success(function(){
        })
     
        .error(function(){
        });
     }
  }]);