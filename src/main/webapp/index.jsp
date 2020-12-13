<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>幼儿园管理系统</title>

<link rel="stylesheet" type='text/css'
	href="${pageContext.request.contextPath}/resc/css/layui.css" />
<link rel='stylesheet' type='text/css'
	href="${pageContext.request.contextPath}/resc/css/loginStyle.css" />

</head>
<!-- <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> -->
<!-- 远程的jquery插件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resc/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resc/js/jquery-ext.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resc/js/layui.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resc/js/laytpl.js"></script>

<body>
	<h1>幼儿园管理系统</h1>
	<div class="w3ls-login box">
		<img src="resc/images/logo.png" alt="logo_img" />
		<div id="loginORegist"></div>
	</div>
	<div class="copy-wthree">
		<p>Copyright &copy; 2018.Company name All rights reserved</p>
	</div>
</body>

<script type="text/javascript">
	layui.use('layer', function() {
	});
	// ------------ ajax 请求 -----------

	// 登录
	function doLogin() {
		var phoneNo = $("#phoneNo").val();
		var password = $("#password").val();
		//
		if (phoneNo == null || phoneNo == "") {
			layer.msg('账号不可为空', {
				icon : 5
			});
			return;
		}
		if (password == null || password == "") {
			layer.msg('密码不可为空！', {
				icon : 5
			});
			return;
		}
		var userInfo = {};
		userInfo.phoneNo = phoneNo;
		userInfo.pswd = password;
		userInfo = JSON.stringify(userInfo);
		$.ajax({
			type : "post",
			url : "api/user/login/do",
			data : userInfo,
			contentType : 'application/json;charset=UTF-8',
			headers : {
				"Content-Type" : "application/json;charset=UTF-8"
			},
			dataType : "json",
			async : false,
			success : function(result) {
				if (result.type == "info") {
					// 跳转后台管理界面
					location.href = result.data;
				} else {
					layer.msg(result.message);
				}
			}
		});
	}
	// 注册
	function doRegist() {
		var phoneNo = $("#phoneNo").val();
		var nickName = $("#nickName").val();
		var password = $("#password").val();
		var confirmPswd = $("#confirmPswd").val();
		//
		if (phoneNo == null || phoneNo == "") {
			layer.msg('账号不可为空', {
				icon : 5
			});
			return;
		}
		if (password == null || password == "") {
			layer.msg('密码不可为空！', {
				icon : 5
			});
			return;
		}
		if (confirmPswd == null || confirmPswd == "") {
			layer.msg('确认密码不可为空！', {
				icon : 5
			});
			return;
		}
		if (password != confirmPswd) {
			layer.msg('两次输入的密码不一致！', {
				icon : 5
			});
			return;
		}
		//
		var userInfo = {};
		userInfo.phoneNo = phoneNo;
		userInfo.name = nickName;
		userInfo.pswd = password;
		//
		userInfo = JSON.stringify(userInfo);
		$.ajax({
			type : "post",
			url : "api/user/regist/do",
			data : userInfo,
			contentType : 'application/json;charset=UTF-8',
			headers : {
				"Content-Type" : "application/json;charset=UTF-8"
			},
			dataType : "json",
			success : function(result) {
				if (result.type == "info") {
					// 加载登录界面
					var user = result.data;
					readTpl("loginTpl", "loginORegist", {});
				} else {
					layer.msg(result.message);
				}
			}
		});

	}

	// --------------------------- 业务处理 --------------------------

	function toRegistTp() { // 注册
		readTpl("registTpl", "loginORegist", {});
	}
	function toLogionTpl() { // 返回登录
		readTpl("loginTpl", "loginORegist", {});
	}

	function readTpl(tplId, dataId, data) {
		var tpl = $id(tplId)[0].innerHTML;
		// 异步渲染
		// laytpl(tpl).render(data, function(render){
		// 	$(dataId).innerHTML = render;
		// });
		// 同步渲染
		var render = laytpl(tpl).render(data);
		$id(dataId)[0].innerHTML = render;
	}

	$(function() {
		// 初始化
		readTpl("loginTpl", "loginORegist", {});
	});
</script>

</html>
<script type="text/html" id="loginTpl">
	<div class="login-box">
		<div class="agile-field-txt">
			<input type="email" name="phone" placeholder="账号" id="phoneNo"/>
		</div>
		<div class="agile-field-txt">
			<input type="password" name="password" placeholder="密码" id="password" />
			<div class="agile_label">
				<label class="check" for="check3">忘记密码</label>
				<label class="check" for="check3" style="padding-left: 230px;" onClick="toRegistTp()">注册账号</label>
			</div>
		</div>
		<div class="w3ls-bot">
			<input type="submit" onClick="doLogin()" value="登    陆">
		</div>
	</div>
</script>

<script type="text/html" id="registTpl">
	<div class="login-box">
		<div class="agile-field-txt">
			<input type="email" name="email" placeholder="账号" id="phoneNo" />
		</div>
		<div class="agile-field-txt">
			<input type="email" name="phone" placeholder="昵称" id="nickName"/>
		</div>
		<div class="agile-field-txt">
			<input type="password" name="password" placeholder="密码" id="password" />
		</div>
		<div class="agile-field-txt">
			<input type="password" name="password" placeholder="确认密码" id="confirmPswd" />
			<div class="agile_label">
				<label class="check" for="check3"  onClick="toLogionTpl()">已有账号，立即登陆！</label>
			</div>
		</div>
		<div class="w3ls-bot">
			<input type="submit" onClick="doRegist()" value="注    册">
		</div>
	</div>
</script>

