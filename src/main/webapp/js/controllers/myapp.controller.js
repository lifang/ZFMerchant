'user strict';

//我的掌富
var myappModule = angular.module("myappModule",[]);

var myappController = function ($scope, $http, LoginService) {
	$scope.$emit('topTitle',"华尔街金融平台-我的掌富");
	$scope.my_message_list = function(){
		$scope.req={customer_id:LoginService.userid,rows:8};
		$http.post("api/message/receiver/getAll", $scope.req).success(function (data) {   
            if (data != null && data != undefined) {
                $scope.my_list = data.result.content;
            }
        }).error(function (data) {
            $("#serverErrorModal").modal({show: true});
        });
	};
	$scope.web_message_list = function(){
		$scope.req={rows:8};
		$http.post("api/web/message/getAll", $scope.req).success(function (data) {  
			if (data != null && data != undefined) {
				$scope.web_list = data.result.content;
			}
		}).error(function (data) {
			$("#serverErrorModal").modal({show: true});
		});
	};
	//业务处理
	$scope.web_yw_list = function(){
		$scope.req={customer_id:LoginService.userid};
		$http.post("api/cs/repair/wxlist", $scope.req).success(function (data) {  
			if (data != null && data != undefined) {
				$scope.cp_list = data.result;
			}
		}).error(function (data) {
			$("#serverErrorModal").modal({show: true});
		});
	};
	
	$scope.trade_list = function(){
		$scope.req={customer_id:LoginService.userid};
		$http.post("api/trade/record/getSevenDynamic", $scope.req).success(function (data) {   
			if (data != null && data != undefined && data.code == 1) {
				$scope.trade = data.result;
				if(data.result!=null && data.result.daylist != undefined){
					$scope.t_list = data.result.daylist;
					var myobj=eval($scope.t_list);
					var data_sum =  new Array();
					for(var i=0;i<myobj.length;i++){
						var s = myobj[i].tread_sum;
						data_sum[i]=s/100;
					} 
			         
			         var barChartData = {
			             labels : ["1","2","3","4","5","6","7"],
			             datasets : [
			                 {
			                     fillColor : "rgba(151,187,205,0.5)",
			                     strokeColor : "rgba(151,187,205,0.8)",
			                     highlightFill : "rgba(151,187,205,0.75)",
			                     highlightStroke : "rgba(151,187,205,1)",
			                     data : data_sum
			                 }
			             ]		
			         }
			         var globalGraphSettings = {
			             responsive : true,
			             barStrokeWidth : 1,
			             barValueSpacing : 10,
			         };
			         function showBarChart(){
			             var ctx = document.getElementById("myChart").getContext("2d");
			             new Chart(ctx).Bar(barChartData,globalGraphSettings);
			         };
			         
			         $(function(){
			             showBarChart();
			         });
				}else{
					var randomScalingFactor = function(){ return 0};
					var barChartData = {
				             labels : ["1","2","3","4","5","6","7"],
				             datasets : [
				                 {
				                     fillColor : "rgba(151,187,205,0.5)",
				                     strokeColor : "rgba(151,187,205,0.8)",
				                     highlightFill : "rgba(151,187,205,0.75)",
				                     highlightStroke : "rgba(151,187,205,1)",
				                     data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
				                 }
				             ]		
				         }
				         var globalGraphSettings = {
				             responsive : true,
				             barStrokeWidth : 1,
				             barValueSpacing : 10,
				         };
				         function showBarChart(){
				             var ctx = document.getElementById("myChart").getContext("2d");
				             new Chart(ctx).Bar(barChartData,globalGraphSettings);
				         };
				         
				         $(function(){
				             showBarChart();
				         });
				}
			}
		}).error(function (data) {
			$("#serverErrorModal").modal({show: true});
		});
	};
	
	$scope.my_message_list();
	$scope.web_message_list();
	$scope.trade_list();
	$scope.web_yw_list();
};

myappModule.$inject = ['$scope', '$http', '$cookieStore'];
myappModule.controller("myappController", myappController);

