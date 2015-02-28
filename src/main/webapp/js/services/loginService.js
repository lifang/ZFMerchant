'use strict';

//登陆服务模块
var loginServiceModule = angular.module("loginServiceModule", []);

//登陆服务
var loginService = function ($scope){
	 $scope.username = "";
	 $scope.login = function(){
		 alert($scope.username);
	 }
}
var loginServices = function ($http, $rootScope, $cookieStore) {
    return {
        //定义当前用户是否被授权
        //isAuthorized: typeof($cookieStore.get("loginInfo")) == 'undefined' ? false : true,
    	isAuthorized:true,
    	//当前登陆的用户名
        //loginUserName: typeof($cookieStore.get("loginInfo")) == 'undefined' ? "" : $cookieStore.get("loginInfo"),
        fullName: "123",
        userPower : "11",
        userLogo: "123",
        userLogo:"123",
        city:1,
        //用户登陆功能
        login: function ($scope) {
        	alert("login");
            var self = this;
            $http.post("api/user/studentLogin", $scope).success(function (data) {
            	if (data.code != 10) {
//                    self.mobile = user.mobile;
//                    self.isAuthorized = true;
//                    self.userCD = data.userinfo.userCD;
//                    self.fullName = data.userinfo.fullName;
//                    self.userLogo = data.userinfo.picurl;
//                    $cookieStore.put("loginInfo", user.mobile);
//                    $cookieStore.put("loginUserName", self.fullName);
//                    $cookieStore.put("shopLogo", self.userLogo);
//                    $("#loginModal").modal('hide'); //登陆成功，则隐藏登陆窗口，并且显示主页面
//                    $("#userPwd").val("");
                    $("#indexDiv").show();
                    $rootScope.$broadcast('Login.Success', self.mobile);
                } else {
                    $("#resetPwd-success-msg").hide();
                    $("#login-danger-msg").show();
                }
        }).error(function (data) {
            console.log("Login error!");
        });
        },

        //用户登出功能
        logout: function () {
            $cookieStore.remove("loginInfo");
            $cookieStore.remove("loginUserName");
            $cookieStore.remove("loginSmsPauseFlag");
            $cookieStore.remove("shopLogo");
            $cookieStore.remove("shopName");
            $cookieStore.remove("userCoverPicCD");
            this.isAuthorized = false;
            $("#loginModal").modal({keyboard:false,backdrop:'static'}); //登出之后，则显示登陆界面，并隐藏主页面
            $("#resetPwd-success-msg").hide();
            $("#indexDiv").hide();
        },

        //检验当前是否为已登录状态，或Cookie中仍存在登陆记录
        checkAuthorization: function () {
            var self = this;
            //必须从Cookie中校验(Cookie)
            this.isAuthorized = typeof($cookieStore.get("loginInfo")) == 'undefined' ? false : true,
                //根据是否已登录，设置登陆窗口和主页面的显示与否
                $("#loginModal").modal(this.isAuthorized == true ? 'hide' : {keyboard:false,backdrop:'static'});
            if (this.isAuthorized == true) {
                self.mobile = $cookieStore.get("loginInfo");
                self.fullName = $cookieStore.get("loginUserName");
               // self.loginSmsPauseFlag = $cookieStore.get("loginSmsPauseFlag");
                self.shopLogo = $cookieStore.get("shopLogo");
               // self.shopName = $cookieStore.get("shopName");
                //self.userCoverPicCD = $cookieStore.get("userCoverPicCD");
                $("#indexDiv").show();
            } else {
                $("#indexDiv").hide();
            }
        },
        //检查用户权限
        check : function(idStr,state) {
        	var id= new Array(); //定义一数组
        	if(idStr!=null&&idStr!=""){
        		id=idStr.split(","); //字符分割 
        		for(var i=0;i<id.length;i++){
        			if(this.userPower.indexOf(id[i])>-1){
    	    			if(state==0){
    	    				$("#"+id).remove();//移除
    	    			}else if(state==1){
    	    				 $("#"+id).hide();//隐藏
    	    			}else if(state==2){
    	    				 $("#"+id).attr("disabled", true);//不可用
    	    			}
    		    	}
        		}
        	}
	    	
	    }
    };
};

loginServiceModule.$inject = ['$http', '$rootScope', '$cookieStore'];
loginServiceModule.service("LoginService", loginService);