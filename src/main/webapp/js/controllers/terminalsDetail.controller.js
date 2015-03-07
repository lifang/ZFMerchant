'user strict';

//系统设置模块
var terminalDetailModule = angular.module("terminalDetailModule",[]);

var terminalDetailController = function ($scope, $http,$location, LoginService) {
	$scope.terminalId=$location.search()['terminalId'];
	$(".leaseExplain_tab").hide();
	$("#pass").hide();
	//查看终端详情
	$scope.terminalDetail = function () {
      alert($scope.terminalId);
      $http.post("api/terminal/getApplyDetails", {terminalsId:$scope.terminalId}).success(function (data) {  //绑定
          if (data != null && data != undefined) {
              //终端信息
              $scope.applyDetails = data.result.applyDetails;
              //交易
              $scope.rateList = data.result.rates;
              //租赁
              $scope.tenancy  = data.result.tenancy;
              //追踪记录
              $scope.trackRecord = data.result.trackRecord;
              //资料
              $scope.openingDetails = data.result.openingDetails;
          }
      }).error(function (data) {
    	  alert("获取列表失败");
          /*$("#serverErrorModal").modal({show: true});*/
      });
  };
  
//弹出层
  $scope.popup = function(t,b){
	  $(".mask").show();
	  $(".leaseExplain_tab").show();
  }
  
  //关闭弹出框
  $scope.closeDocument = function(obj){
	  $("#"+obj).hide();
	  $(".mask").hide ();
  }
  //找回POS机密码
  $scope.findPassword = function(){
	  $http.post("api/terminal/Encryption", {terminalid:$scope.terminalId}).success(function (data) {  //绑定
          if (data != null && data != undefined) {
        	  $scope.pass = data.result;
        	  $(".mask").show();
        	  $("#pass").show();
          }
      }).error(function (data) {
    	  alert("获取列表失败");
      });
  }
  
  $scope.terminalDetail();

};



terminalDetailModule.$inject = ['$scope', '$http', '$cookieStore'];
terminalDetailModule.controller("terminalDetailController", terminalDetailController);
