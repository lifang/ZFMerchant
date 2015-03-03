'user strict';

//系统设置模块
var cs_returninfoModule = angular.module("cs_returninfoModule",[]);

var cs_returninfoController = function ($scope,$location, $http, LoginService) {
	$scope.req={};
	$scope.req.id=$location.search()['infoId'];
    $scope.getInfo = function () {
    	$http.post("api/return/getReturnById", $scope.req).success(function (data) {  //绑定
            if (data.code==1) {
            	$scope.info=data.result;
            }
        }).error(function (data) {
            $("#serverErrorModal").modal({show: true});
        });
    };
    $scope.getInfo();

};

cs_returninfoModule.controller("cs_returninfoController", cs_returninfoController);