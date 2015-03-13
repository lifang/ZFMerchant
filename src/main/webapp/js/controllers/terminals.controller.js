'user strict';

//系统设置模块
var terminalModule = angular.module("terminalModule",['loginServiceModule']);

var terminalController = function ($scope, $http, LoginService) {
	  initSystemPage($scope);// 初始化分页参数
	  $scope.customersId = LoginService.userid;
	  $scope.total = 0;
	  //付款筛选状态
	  $scope.frontStatus = null;
	  //根据终端号筛选
	  $scope.serialNum = null;
	  
	  //付款状态集
	  $scope.frontPayStatus = [];
	  
	  //辨别获取付款状态
	  $scope.boolean = true;

	
	//获得终端列表
	$scope.getInfo = function () {
		
		if(LoginService.userid == 0){
			window.location.href = '#/login';
		}else{
			//显示用户登录部分
			$scope.$emit('changeshow',false);
		} 
      $scope.req={
    		  customersId:$scope.customersId,
    		  page:$scope.indexPage,
    		  rows:$scope.rows,
    		  frontStatus:$scope.frontStatus,
    		  serialNum:$scope.serialNum
    		  };
      
      $http.post("api/terminal/getApplyList", $scope.req).success(function (data) {  //绑定
          if (data != null && data != undefined) {
              $scope.list = data.result.list;
              $scope.total = data.result.total;
              //所有通道
              $scope.channels = data.result.channels;
              if($scope.boolean){
            	  $scope.frontPayStatus = data.result.frontPayStatus;
              }
          }
          $scope.pages = [];
          calcSystemPage($scope, $scope.total);// 计算分页
      }).error(function (data) {
    	  alert("获取列表失败");
      });
	}  
	
	//添加終端是通道Id
	$scope.channelId = function(chanId){
		$scope.payChannelId = Math.ceil(chanId);
	}
	//添加終端$scope.channels
	$scope.addChannel = function(){
		 $scope.addChan={
				  customerId:$scope.customersId,
	    		  title:$scope.title,
	    		  payChannelId:$scope.payChannelId,
	    		  serialNum:$scope.serialNum
	    		  };
		
		$http.post("api/terminal/addTerminal", $scope.addChan).success(function (data) {  //绑定
	          if (data != null && data != undefined) {
	        	  if(data.code == 1){
	        		  $("#closeWin").css('display','none');
	        		  $(".mask").css('display','none');
	        		  
	        		  $scope.serialNum = null;
	        		  $scope.getInfo();
	        	  }else{
	        		  alert(data.result);
	        	  }
	          }
	      }).error(function (data) {
	    	  alert("获取列表失败");
	      });
	}
	
	//筛选状态
	$scope.screening = function(obj){
		//再一次初始化分页
		initSystemPage($scope);
		if(obj == 0){
			$scope.frontStatus = null;
		}else{
			$scope.frontStatus = Math.ceil(obj);
		}
		$scope.boolean = false;
		//取消终端号的筛选
		$scope.serialNum = null;
		$scope.getInfo();
	}
	
	//筛选终端号
	$scope.screeningSerialNum = function(){
		 $scope.indexPage = 1;
		//取消终端状态的筛选
		$scope.frontStatus = null;
		$scope.boolean = true;
		$scope.getInfo();
	}

	//go to page
	$scope.tiaoPage = 1;
	$scope.getPage = function(){
		$scope.indexPage = Math.ceil($scope.tiaoPage);
		$scope.getInfo();
	};

	//下一页
  $scope.next = function () {
      if ($scope.indexPage < $scope.totalPage) {
          $scope.indexPage++;
          $scope.getInfo();
      }
  };

  //上一页
  $scope.prev = function () {
      if ($scope.indexPage > 1) {
          $scope.indexPage--;
          $scope.getInfo();
      }
  };

  $scope.loadPage = function (page) {
      $scope.indexPage = page;
      $scope.getInfo();
  };
  
  
  $scope.getInfo();

};

terminalModule.$inject = ['$scope', '$http', '$cookieStore'];
terminalModule.controller("terminalController", terminalController);
