'user strict';

//系统设置模块
var terminalReturnGoodModule = angular.module("terminalReturnGoodModule",['loginServiceModule']);

var terminalReturnGoodController = function ($scope, $http,$location, LoginService) {
	$scope.$emit('topTitle',"华尔街金融平台-申请退货");
	$scope.terminalId=Math.ceil($location.search()['terminalId']);
	$scope.customerId = LoginService.userid;
	//查看终端详情
	$scope.terminalDetail = function () {
		if(LoginService.userid == 0){
			window.location.href = '#/login';
		}else{
			//显示用户登录部分
			$scope.$emit('changeshow',false);
		}
		//1 注销，2 更新
		  $scope.types = 1;
      $http.post("api/terminal/getWebApplyDetails", {types:$scope.types,terminalsId:$scope.terminalId,customerId:$scope.customerId}).success(function (data) {  //绑定
          if (data != null && data != undefined) {
              //终端信息
              $scope.applyDetails = data.result.applyDetails;
              //下载模板
              $scope.ReModel = data.result.ReModel;
          }
      }).error(function (data) {
    	  alert("获取列表失败");
      });
  };
//提交
	$scope.subReturn = function () {
		$scope.array = [];
		 for(var i=0;i<$scope.ReModel.length;i++){
			 if($("#up_"+i).val() != null && $("#up_"+i).val() != ""){
				 $scope.array[i] = {
							id:$("#upId_"+i).val(),
							path:$("#up_"+i).val()
					};
			 }
		 }
		
		$scope.message = {
				reason:$scope.reason,
				person:$scope.person,
				phone:$scope.phone,
				terminalsId:Math.ceil($scope.terminalId),
				customerId:Math.ceil($scope.customerId),
				returnPrice:$scope.returnPrice,
				status:1,
				templeteInfoXml :JSON.stringify($scope.array),
				type : 3,
				modelStatus:$("#modelStatus").val()
				};
		if($scope.reason == undefined || $scope.reason == ''){
			alert("请填写退货原因！");
		}else if($scope.person == undefined || $scope.person == ''){
			alert("请填写联系人！");
		}else if($scope.phone == undefined || $scope.phone ==''){
			alert("请填写联系电话！");
		}else{
			  $http.post("api/terminal/subReturn", $scope.message).success(function (data) {  //绑定
	        if (data != null && data != undefined) {
	        	if(data.code == 1){
	        		alert("操作成功！");
	        		window.location.href ='#/terminalDetail?terminalId='+$scope.terminalId;
	        	}else{
	        		alert("操作失败！");
	        	}
	        }
	    }).error(function (data) {
	  	  alert("操作失败");
	    });
		}
};

  $scope.terminalDetail();
};

//改变上传按钮
function setSpanName(obj){
	//改变下载模板初始状态
	
	$(obj).parent("a").parent("form").attr("action","api/terminal/upload/tempReturnFile/"+$("#terid").val());
	$(obj).parent("a").parent("form").ajaxSubmit({
		success : function(data) {
			if(data.code == -1){
				alert(data.message);
			}else if(data.code == 1){
				$("#modelStatus").val(1);
				$(obj).parent("a").children("span").html("重新上传");
				$(obj).siblings("span").parent("a").siblings("i").attr("class","on");
				$(obj).siblings("input").val(data.result);
			}
		}
	});
}



terminalReturnGoodModule.$inject = ['$scope', '$http', '$cookieStore'];
terminalReturnGoodModule.controller("terminalReturnGoodController", terminalReturnGoodController);
