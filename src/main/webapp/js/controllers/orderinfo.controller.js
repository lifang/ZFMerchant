'user strict';

//系统设置模块
var orderinfoModule = angular.module("orderinfoModule",[]);

var orderinfoController = function ($scope,$location, $http, LoginService) {
//	$("#leftRoute").show();
	$scope.$emit('topTitle',"华尔街金融平台-订单详情");
	if(LoginService.userid == 0){
		window.location.href = '#/login';
	}else{
		//显示用户登录部分
		$scope.$emit('changeshow',false);
	}
	$scope.req={};
	$scope.req.id=$location.search()['orderId'];
    $scope.getOrderInfo = function () {
    	$http.post("api/order/getMyOrderById", $scope.req).success(function (data) {  //绑定
            if (data.code==1) {
            	$scope.orderInfo=data.result;
            }
        }).error(function (data) {
            $("#serverErrorModal").modal({show: true});
        });
    };
    //取消
    $scope.cancelApply = function(id){
    	if(window.confirm('你确定要取消吗？')){
    		$scope.req={id:id};
    		$http.post("api/order/cancelMyOrder", $scope.req).success(function (data) {  //绑定
    			if (data != null && data != undefined) {
    				$scope.getOrderInfo();
    			}
    		}).error(function (data) {
    			$("#serverErrorModal").modal({show: true});
    		});
	         
            return true;
         }else{
            return false;
        }
    	
	};
    
    $scope.topay = function(o) {
    	window.open("#/pay?id="+o.order_id) ; 
//    	var g_name = $("#g_name").val();
//    	window.open("alipayapi.jsp?WIDtotal_fee="+o.order_totalPrice/100+"&WIDsubject="+g_name+"&WIDout_trade_no="+o.order_number);  
	};
	
	$scope.close_wlxx = function() {
		$("#od_ter_div").css('display', 'none');
	};
	$scope.close_pj = function() {
		$("#od_pj_div").css('display', 'none');
	};
 
    $scope.t_comment = function (g) {
    	$("#order_g_t_v").html(g.terminals_web);
	    $("#od_ter_div").css('display','block');
    };
    
    $scope.s_comment = function (g) {
    	$("#com_good_id").val(g.good_id);
    	$("#od_pj_div").css('display','block');
    };
    
    $scope.saveContent= function () {
//    	var goodid = $("#com_good_id").val();
//    	$scope.req.content = $scope.content;
//    	$scope.req.good_id = goodid;
//    	var score = $("#com_score").val();
//    	if(score == ""){
//    		score = 3;
//    	}
//    	$scope.req.score = score*10;
//    	$scope.req.customer_id = LoginService.userid;
//    	
//    	$http.post("api/order/saveComment", $scope.req).success(function (data) {  
//    		if (data.code==1) {
////    			 $(".tab").css('display','none');
//    			 $("#od_pj_div").css('display','none');
//    		}
//    	}).error(function (data) {
//    		$("#serverErrorModal").modal({show: true});
//    	});
    };
    
    $scope.getOrderInfo();

};

orderinfoModule.controller("orderinfoController", orderinfoController);
