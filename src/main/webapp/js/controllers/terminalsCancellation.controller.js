'user strict';

//系统设置模块
var terminalCancellationModule = angular.module("terminalCancellationModule",['loginServiceModule']);

var terminalCancellationController = function ($scope, $http,$location, LoginService) {
	$scope.$emit('topTitle',"华尔街金融平台-申请注销");
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
		//1 注销， 2 更新
		  $scope.types = 1;
      $http.post("api/terminal/getWebApplyDetails", {types:$scope.types,terminalsId:$scope.terminalId,customerId:$scope.customerId}).success(function (data) {  //绑定
          if (data != null && data != undefined) {
              //终端信息
              $scope.applyDetails = data.result.applyDetails;
              //注销模板
              $scope.ReModel = data.result.ReModel;
          }
      }).error(function (data) {
    	  alert("获取列表失败");
      });
  };
  
//提交注销申请
  $scope.subtruefalse = true;
	$scope.subRentalReturn = function(){
		$scope.array = [];
		 for(var i=0;i<$scope.ReModel.length;i++){
			 if($("#up_"+i).val() != null && $("#up_"+i).val() != ""){
				 $scope.subtruefalse = false;
				 $scope.array[i] = {
							"id":$("#upId_"+i).val()+"",
							"path":$("#up_"+i).val()+""
					};
			 }
		 }
		
		 $scope.map = {
 				terminalId : $scope.terminalId,
 				status : 1,
 				templeteInfoXml :JSON.stringify($scope.array),
 				type : 3,
 				customerId:$scope.customerId
 		 }
		 if($scope.subtruefalse == true){
			alert("请选择你要上传注销 资料！");
		 }else{
			 $http.post("api/terminal/subRentalReturn", $scope.map).success(function (data) {  //绑定
		          if (data != null && data != undefined) {
		        	  if(data.code == 1){
		        		  window.location.href ='#/terminalDetail?terminalId='+$scope.terminalId;
		        	  }else{
		        		alert("提交失败！");
		        	  }
		          }
		      }).error(function (data) {
		    	  alert("获取列表失败");
		      });
		 }
	}
  $scope.terminalDetail();
};


//改变上传按钮
function setSpanName(obj){
	//改变下载模板初始状态
	$(obj).parent("a").parent("form").attr("action","api/terminal/upload/tempCancellationFile/"+$("#terid").val());

	$(obj).parent("a").parent("form").ajaxSubmit({
		success : function(data) {
			if(data.code == -1){
				alert(data.message);
			}else if(data.code == 1){
				$(obj).siblings("span").parent("a").siblings("i").attr("class","on");
				$(obj).parent("a").children("span").html("重新上传");
				$(obj).siblings("input").val(data.result);
			}
		}
	});
}


terminalCancellationModule.$inject = ['$scope', '$http', '$cookieStore'];
terminalCancellationModule.controller("terminalCancellationController", terminalCancellationController);
