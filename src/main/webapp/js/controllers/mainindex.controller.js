'user strict';

//系统设置模块
var mainindexModule = angular.module("shopModule",[]);

var mainindexController = function ($scope, $http) {
	
	$scope.req={};
	
	$scope.addBuy= function(){
		$http.post("api/paychannel/intention/add", $scope.req).success(function (data) {  //绑定
            if (data.code==1) {
            	$('.buyIntention_tab').hide();
            	$('.mask').hide();
            }
        });
	}
	
	$scope.searchhh= function(){
		$scope.req.id=80;
		$http.post("api/terminal/openStatus", $scope.req).success(function (data) {  //绑定
            if (data.code==1) {
            	$('.tab').show();
            	alert(0);
            	$('#qwert').show();
            }
        });
	}
    
	//公告
	$scope.web_message_list = function(){
		$scope.req={rows:7};
		$http.post("api/web/message/getAll", $scope.req).success(function (data) {  
			if (data != null && data != undefined) {
				$scope.web_list = data.result.content;
			}
		});
	};
	//热卖POS
	$scope.web_pos_list = function(){
		$scope.req={rows:6};
		$http.post("api/index/pos_list", $scope.req).success(function (data) {  
			if (data != null && data != undefined) {
				$scope.pos_list = data.result;
			}
		});
	};
	//收单机构
	$scope.factory_list = function(){
		$http.post("api/index/factory_list", $scope.req).success(function (data) {  
			if (data != null && data != undefined) {
				$scope.factory_list = data.result;
			}
		});
	};
	
	//轮播图
	$scope.pic_list = function(){
		$http.post("api/index/sysshufflingfigure/getList", $scope.req).success(function (data) {  
			if (data != null && data != undefined) {
				$scope.pic_list = data.result;
			}
		});
	};
	$scope.init = function(){
		$scope.web_message_list();
		$scope.factory_list();
		$scope.web_pos_list();
		$scope.pic_list();
	};
	$scope.init();
};



mainindexModule.controller("mainindexController", mainindexController);
