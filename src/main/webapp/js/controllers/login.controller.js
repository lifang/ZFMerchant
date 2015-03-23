'use strict';

// 主页面路由模块，用于控制主页面的菜单导航(注入了登陆服务LoginService)
//var indexModule = angular.module("indexModule", [ 'loginServiceModule', 'loginrouteModule', 'ngRoute' ]);

var indexController = function($scope, $location, $http, LoginService,$cookieStore) {
	$scope.loginUserName=LoginService.loginUserName;
	$scope.city_name = $cookieStore.get("city_name")==null?"上海市":$cookieStore.get("city_name");
	$scope.ngshow=true;
	$scope.ngshow2=false;
	$scope.shopcount=0;
	$scope.shopcartcount=function () {
    	if(LoginService.userid>0){
    		$http.post("api/cart/total", {customerId:LoginService.userid}).success(function (data) {  //绑定
                if (data.code==1) {
                	$scope.shopcount= data.result;
                }
            });
    	}
    };
    $scope.$on('$locationChangeStart', function (scope, next, current) {                          		
		//alert(strs[0]);
		if(LoginService.userid == 0){
			$scope.loginshow=false;
			$scope.ngshow=true;
			$scope.ngshow2=false;
		}else{
			$scope.loginshow=true;
			var strs= new Array(); //定义一数组
			strs=next.split("/#/"); //字符分割
			if(strs.length==2){
				strs=strs[1].split("?")
				if(check(strs[0])){
					$scope.ngshow=false;
					$scope.ngshow2=true;
				}else{
					$scope.ngshow=true;
					$scope.ngshow2=false;
				}
			}else{
				$scope.ngshow=true;
				$scope.ngshow2=false;
			}
		}
		//$scope.searchview=true;
    });
	
	var check=function(str){
		var arry=["myapp","webmessageinfo",
		          "order","orderinfo","merchantAdd",
		          "terminalRepair","terminalExchangeGoods","terminalToUpdate",
		          "terminalCancellation","terminalReturnGood",
		          "terminal","terminalOpening","terminalDetail",
		          "cs_cencel","cs_return","cs_change","cs_repair","cs_update","cs_lease",
		          "cs_cencelinfo","cs_returninfo","cs_changeinfo","cs_repairinfo","cs_updateinfo","cs_leaseinfo",
		          "traderecord","tradeinfo",
		          "myinfobase","myinfoupdatepassword","myinfoAddresses","myinfointegral",
		          "merchantList","merchantOne",
		          "message","messageinfo"];
		for (var i = 0; i < arry.length; i++) {
			if(str==arry[i]){
				return true;
			}
		}
		return false;
	}
	
	
	//退出页面(清除$cookieStore)
	$scope.escLogin = function(){
		$cookieStore.put("loginUserName",null);
    	$cookieStore.put("loginUserId",0);
    	$scope.password1 = "";
    	$scope.code = "";
    	location.reload();
    	window.location.href = '#/';
    	
	}
	
	
	$scope.shopcount=0;
	$scope.$on('shopcartcountchange', function() {
		$scope.shopcartcount();
	});
	$scope.shopcartcount=function () {
    	if(LoginService.userid>0){
    		$http.post("api/cart/total", {customerId:LoginService.userid}).success(function (data) {  //绑定
                if (data.code==1) {
                	$scope.shopcount= data.result;
                }
            });
    	}
    };
    $scope.shopcartcount();
    
    
    
//	$scope.$on('changeshow', function(d,data) {
//		$scope.ngshow=data;
//	});
	$scope.$on('changesearchview', function(d,data) {
		$scope.searchview=data;
	});
	
	$scope.index=function() {
		window.location.href = '#/';
	};
	
};

var headerController = function($scope, $location, $http, LoginService,$cookieStore) {
	$scope.loginUserName=LoginService.loginUserName;
	$scope.city_name = $cookieStore.get("city_name")==null?"上海市":$cookieStore.get("city_name");
	 
	$scope.index=function() {
		window.location.href = '#/';
	};
	
	$scope.city_list = function(){
		$http.post("api/index/getCity").success(function (data) {   
			if (data != null && data != undefined) {
				$scope.city_list = data.result;
			}
		});
	};
	
	$scope.submit_city = function(){
		//alert($scope.selected_city.id);
		$cookieStore.put("city_name", $scope.selected_city.name);
		$cookieStore.put("city_id", $scope.selected_city.id);
		$scope.city_name = $scope.selected_city.name;
	};
	
	$scope.city_list();
};

var searchController = function($scope, LoginService) {
	$scope.searchShop=function() {
		LoginService.keys=$scope.haha;
		window.location.href = '#/shop';
	};
};


var loginController=function($scope, $location, $http, LoginService){
	//隐藏中间搜索
	$scope.$emit('changesearchview',false);
	$scope.RememberPass = false;
	//普通用户代理商登陆
	$scope.loginAngShow = true;
	//登陆
	$scope.login = function() {
		//移除样式
	/*	$("link[href='style/global.css']").remove();*/
		LoginService.login($scope,$http);
	};
	
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	$scope.loginUserName = LoginService.loginUserName;
	//勾选协议
	$scope.ridel_xy = false;
	
	//登陆页面文本框得到光标的时候失去错误提示信息
	$scope.RememberPass = false;

	$scope.password1 = "";
	$scope.password2 = "";
	$scope.codeNumber = "";
	$scope.code = "";//图片验证
	
	$scope.jsons = {
		username : $scope.username,
		password : $scope.password
	};

	/*//退出页面(清除$cookieStore)
	$scope.escLogin = function(){
		$cookieStore.put("loginUserName",null);
    	$cookieStore.put("loginUserId",0);
    	
    	$scope.password1 = "";
    	$scope.code = "";
    	LoginService.hideAll();
		//登陆前首页
		$('#maintop').show();
		$('#mainindex').show();
	}*/

	// 初始化图片验证码
	$scope.reGetRandCodeImg = function() {
		$(".loginRandCodeImg").attr("src", "api/user/getRandCodeImg?id=" + Math.random());
	};
	

	$scope.reGetRandCodeImg();
	

	// 动态加载css样式
//	$scope.dynamicLoadingCss = function(path) {
//		if (!path || path.length == 0) {
//			throw new Error('argument "path" is required !');
//		}
//		var head = document.getElementsByTagName('head')[0];
//		var link = document.createElement('link');
//		link.href = path;
//		link.rel = 'stylesheet';
//		link.type = 'text/css';
//		head.appendChild(link);
//	};
};

var registerController=function($scope, $location, $http, LoginService){
	$scope.usernameLocal=$location.search()['sendusername'];
	$scope.sendStatus=Math.ceil($location.search()['sendStatus']);
	//检验邮箱格式
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	//手机格式
	var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
	var intervalOne;// 
	clearInterval(intervalOne);
	//邮箱激活链接判断
	if($scope.sendStatus == -1){
		$scope.show = false;
		$http.post("api/user/activationEmail", {
			username : $scope.usernameLocal
		}).success(function(data) {
			if(data.code == 1){
				$scope.sendEmailShow = false;
				$scope.miao = 5;
				intervalOne = window.setInterval(function(){
				    	if($scope.miao == 0){
				    		$scope.sendStatus = null;
				    		$scope.usernameLocal = null;
				    		clearInterval(intervalOne);
				    		window.location.href = '#/login';
				    	}else{
				    		$(".winSkip").html("账号激活成功！<span>"+$scope.miao+"秒</span>后跳转至登录页！");
				    	    $scope.miao--;
				    	}
				    }, 1000);
				intervalOne;
			}else{
				alert("激活失败！");
			}
		})
	}else{
		//手机邮箱注册显示
		$scope.show = true;
		//发送邮件状态
		$scope.sendEmailShow = true;
	}
	
	//勾选协议
	$scope.ridel_xy = false;
	//邮箱注册显示状态
	$scope.successEmailShow = false;
	
	// 初始化图片验证码
	$scope.reGetRandCodeImg = function() {
		$(".loginRandCodeImg").attr("src", "api/user/getRandCodeImg?id=" + Math.random());
	};
	
	$scope.init= function() {
		//移除样式
		$("link[href='style/global.css']").remove();
		//隐藏中间搜索
		$scope.$emit('changesearchview',false);
		//获得省级
		$scope.getShengcit();
	};
	
	// 跳转手机注册
	$scope.register = function() {
		$scope.emailname = null;
		$scope.name = null;
		$scope.password1 = null;
		$scope.password2 = null;
		$scope.codeBei = null;
		$scope.show = true;
		//倒计时
		clearInterval(intervalOne);
		//获得省级
		$scope.getShengcit();
		/*$http.post("api/terminal/getCities").success(function(data) {
			if (data.code == 1) {
				$scope.cities = data.result;
			} else {
				alert("城市加载失败！");
			}
		})*/
	};
	
	// 跳转邮箱注册用户
	$scope.gotoEmailRetrieve = function() {
		$scope.rename = null;
		$scope.codeNumber = null;
		$scope.name = null;
		$scope.password1 = null;
		$scope.password2 = null;
		$scope.codeBei = null;
		$scope.show = false;
		$scope.sendEmailShow = true;
		$scope.successEmailShow = false;
		//倒计时
		clearInterval(intervalOne);
		
	}
	//获取验证码后动态显示倒计时
	$scope.registreTime = true;
	// 获取手机验证码
	$scope.getRegisterCode = function() {
		if(!reg.test($scope.rename)){
			alert("请输入合法手机号！");
		}else if($scope.registreTime == true){
			$scope.registreTime = false;
			$http.post("api/user/sendPhoneVerificationCodeReg", {
				codeNumber : $scope.rename
			}).success(function(data) {
				if(data.code == 1){
					$scope.code = data.result;
					/*//倒计时
					$scope.intDiff = 120;*/
					$scope.rountTime();
				}else{
					$scope.registreTime = true
					alert(data.message);
				}
			})
		}
	};
	$scope.deleteShiId = function(){
		$scope.shiId= "";
	}
	// 手机校验图片验证码
	$scope.getImgCode = function() {
		if($scope.selected == undefined || $scope.phoneShiList == undefined){
			alert("请选择城市！");
		}else if(!reg.test($scope.rename)){
			alert("请输入合法手机号！");
		}else if($scope.codeNumber == undefined){
			alert("请输入验证码！");
		}else if($scope.code == $scope.codeNumber){
			if($scope.password1==''||$scope.password1==null||$scope.password2==''||$scope.password2==null){
				alert("密码不能为空！");
			}else if ($scope.password1.length<6||$scope.password1.length>20||$scope.password2.length<6||$scope.password2.length>20) {
				alert("密码由6-20位，英文字符组成！");
			}  
			else if($scope.password1 == $scope.password2){
				$http.post("api/user/sizeUpImgCode", {
				imgnum : $scope.codeBei
			}).success(function(data) {
				if (data.code == 1) {
					if($scope.ridel_xy != true){//勾选协议
						$scope.addUser();
					}
				} else if (data.code == -1) {
					alert(data.message);
				}
			})
		}else{
			alert("密码不一致！");
		}
		}else{
			alert("验证码错误!");
		}
	};
	
	// 注册用户
	$scope.addUser = function() {
		$http.post("api/user/userWebRegistration", {
			username : $scope.rename,
			accountType : false,
			code : $scope.codeNumber,
			cityId : Math.ceil($scope.phoneShiList.id),
			password : $scope.password1
		}).success(function(data) {
			if (data.code == 1) {
				$scope.ridel_xy = false;
				$scope.password1 = "";
				$scope.password2 = "";
				$scope.codeNumber = "";
				$scope.code = "";
				$scope.codeBei = "";
				window.location.href = '#/login';
			} else if (data.code == -1) {
				alert(data.message);
			}
		})
	};
	// 校验图片验证码
	$scope.getImgEmailCode = function() {
		if ($scope.selected == undefined || $scope.emailShiList == undefined) {
			alert("请选择城市！");
		} else if (!myreg.test($scope.emailname)) {
			alert("请输入合法邮箱！");
		} else if ($scope.password1 == '' || $scope.password1 == null
				|| $scope.password2 == '' || $scope.password2 == null) {
			alert("密码不能为空！");
		} else if ($scope.password1.length < 6 || $scope.password1.length > 20
				|| $scope.password2.length < 6 || $scope.password2.length > 20) {
			alert("密码由6-20位，英文字符组成！");
		} else if ($scope.password1 == $scope.password2) {
			$http.post("api/user/sizeUpImgCode", {
				imgnum : $scope.codeBei
			}).success(function(data) {
				if (data.code == 1) {// 图片验证
					if ($scope.ridel_xy != true) {// 勾选协议
						$http.post("api/user/jusEmail", {
							username : $scope.emailname
						}).success(function(data) {
							if (data.code == 1) {// 检验用户是否存在
								$scope.addUserEmail();
							} else {
								alert(data.message);
							}
						})
					}
				} else if (data.code == -1) {
					alert(data.message);
				}
			})
		} else {
			alert("密码不一致！");
		}
	};
	
	// 邮箱注册用户
	$scope.addUserEmail = function() {
		$http.post("api/user/userWebRegistration", {
			username : $scope.emailname,
			accountType : true,
			cityId : Math.ceil($scope.emailShiList.id),
			password : $scope.password1
		}).success(function(data) {
			if (data.code == 1) {
				$scope.ridel_xy = false;
				$scope.password1 = "";
				$scope.password2 = "";
				$scope.codeBei = "";
				$scope.successEmailShow = true;
			} else if (data.code == -1) {
				alert(data.code);
			}
		})
	};
	
	//获得省级
	$scope.getShengcit= function(){
		$http.post("api/index/getCity").success(function(data) {
			if (data.code == 1) {
				$scope.cities = data.result;
			} else {
				alert("城市加载失败！");
			}
		})
	};
	
	//倒计时
	
	$scope.rountTime=function() {
		$scope.intDiff = 120;
	    window.setInterval(function(){
	    	if($scope.intDiff == 0){
	    		$('#time_show').html("获取验证码！");
	    		$scope.registreTime = true;
	    	}else{
	    		$('#time_show').html("重新发送（"+$scope.intDiff+"秒）");
	    	    $scope.intDiff--;
	    	}
	    }, 1000);
	};
	
	
/*	//获得市级
	$scope.getShicit = function(parentId){
		$http.post("api/terminal/getShiCities", {
			parentId : parentId
		}).success(function(data) {
			$scope.getShi = data.result;
		})
	};*/
	
/*	//获得市ID
	$scope.getsShiId = function(siId){
		$scope.siId = siId;
	};*/
	
	$scope.toIndex = function(){
    	window.location.href = '#/';
    	location.reload();
	};

	$scope.reGetRandCodeImg();
	$scope.init();
};
	
var findpassController=function($scope, $location, $http, LoginService,$timeout){
	$scope.usernameLocal=$location.search()['sendusername'];
	$scope.sendStatus=Math.ceil($location.search()['sendStatus']);
	//检验邮箱格式
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	//手机格式
	var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
	//隐藏想邮箱发送邮件状态
	$scope.songToEmail = false;
	// 初始化图片验证码
	$scope.reGetRandCodeImg = function() {
		$(".loginRandCodeImg").attr("src", "api/user/getRandCodeImg?id=" + Math.random());
	};
	
	$scope.init=function() {
		//隐藏中间搜索
		$scope.$emit('changesearchview',false);
		if($scope.sendStatus == -1){
			$scope.phone_email = $scope.usernameLocal;
			$scope.threestep();
		}else{
			$scope.onestep();
		}
	};
	
	
	$scope.onestep=function() {
		$scope.one=true;
		$scope.two=false;
		$scope.three=false;
	};
	$scope.twostep=function() {
		$scope.one=false;
		$scope.two=true;
		$scope.three=false;	
	};
	$scope.threestep=function() {
		$scope.one=false;
		$scope.two=false;
		$scope.three=true;
	};
	//从新获得验证码
	$scope.codeStatus = false;
	$scope.newCode = function(){
		if($scope.codeStatus == true){
			$http.post("api/user/sendPhoneVerificationCodeFind", {
				codeNumber : $scope.phone_email,
			}).success(function(data) {
				if (data.code == 1) {
					alert(data.result);
					$scope.code = data.result;
					$scope.codeNumber = "";
					$scope.twostep();
					//倒计时
					/*$scope.intDiff = 120;*/
					$scope.rountTime();
				} else {
					alert("发送手机验证码失败！");
				}
			})
		}
	}
	
	//倒计时
	
	$scope.rountTime=function() {
		$scope.intDiff = 120;
	    window.setInterval(function(){
	    	if($scope.intDiff == 0){
	    		$('#day_show').html("点击获得验证码！");
	    		$scope.codeStatus = true;
	    	}else{
	    		$('#day_show').html("重新发送验证码（"+$scope.intDiff+"秒）");
	    	    $scope.intDiff--;
	    	}
	    }, 1000);
	};
	
	
	
	//移除样式
	$("link[href='style/global.css']").remove();
	
	// 找回密码第一步
	$scope.findPassOnes = function() {
		if(!reg.test($scope.phone_email)&&!myreg.test($scope.phone_email)){
			alert("请输入正确的手机/邮箱号码！");
		}else{
			$http.post("api/user/getFindUser", {
				username : $scope.phone_email
			}).success(function(data) {
				if (data.code == -1) {//检验账号存在
					alert(data.message);
				} else {
					$http.post("api/user/sizeUpImgCode", {
						imgnum : $scope.code
					}).success(function(data) {
						if (data.code == -1) {
							alert(data.message);
						} else {
							// 下一步
							if (myreg.test($scope.phone_email)) {
								// 向邮箱发送密码重置邮件！
								$http.post("api/user/sendEmailVerificationCode", {
									codeNumber : $scope.phone_email,
								}).success(function(data) {
									if (data.code == 1) {
										$scope.songToEmail = true;
										$scope.twostep();
									} else {
										alert("重置密码邮件发送失败！");
									}
								})
							} else {
								$http.post("api/user/sendPhoneVerificationCodeFind", {
									codeNumber : $scope.phone_email,
								}).success(function(data) {
									if (data.code == 1) {
										$scope.code = data.result;
										$scope.codeNumber = "";
										$scope.twostep();
										/*//倒计时
										$scope.intDiff = 120;*/
										$scope.rountTime();
									} else {
										alert(data.message);
									}
								})
							}
						}
					})
				}
			})
		}
	};
	
	// 找回密码第三步
	$scope.findPassThree = function() {
		if($scope.code == $scope.codeNumber){
			$http.post("api/user/webFicationCode", {
			code : $scope.codeNumber,
			username : $scope.phone_email
			}).success(function(data) {
			if (data.code == 1) {
				$scope.threestep();
			} else if (data.code == -1) {
				alert(data.message);
			}
			})
		}else{
			alert("验证码错误！");
		}
	};
	
	// 开始找回
	$scope.findPassEnd = function() {
		if($scope.password1==''||$scope.password1==null||$scope.password2==''||$scope.password2==null){
			alert("密码不能为空！");
		}else if ($scope.password1.length<6||$scope.password1.length>20||$scope.password2.length<6||$scope.password2.length>20) {
			alert("密码由6-20位，英文字符组成！");
		}else if ($scope.password1 != $scope.password2) {
			alert("密码不一致！");
		} else {
			$http.post("api/user/webUpdatePass", {
				password : $scope.password1,
				username : $scope.phone_email
			}).success(function(data) {
				if (data.code == 1) {
					$('#login').show();
					 window.location.href = '#/login';
				} else if (data.code == -1) {
					alert(data.message);
				}
			})
		}
	};
	
	$scope.reGetRandCodeImg();
	$scope.init();
};

indexModule.controller("indexController", indexController);
indexModule.controller("headerController", headerController);
indexModule.controller("loginController", loginController);
indexModule.controller("registerController", registerController);
indexModule.controller("findpassController", findpassController);
