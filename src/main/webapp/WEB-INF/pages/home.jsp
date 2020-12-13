<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>layout 后台大布局 - Layui</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resc/css/layui.css">
	
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resc/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resc/js/jquery-ext.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resc/js/layui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resc/js/laytpl.js"></script>

<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 后台布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） layui-nav-itemed -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item"><a class=""
						href="javascript:;">所有商品</a>
						<dl class="layui-nav-child">
							<dd>
								<a id="1">列表一</a>
							</dd>
							<dd>
								<a id="2">列表二</a>
							</dd>
							<dd>
								<a href="javascript:;">列表三</a>
							</dd>
							<dd>
								<a href="">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">解决方案</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">列表一</a>
							</dd>
							<dd>
								<a href="javascript:;">列表二</a>
							</dd>
							<dd>
								<a href="">超链接</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="">云市场</a></li>
					<li class="layui-nav-item"><a href="">发布商品</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">内容主体区域</div>
			<iframe style="width: 100%;height: 100%;" scrolling="no" src="change?name=topbar" ></iframe>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© layui.com - 底部固定区域
		</div>
	</div>
</body>
<script>
	function changPages (code){
		// 根据code 获取src 路径 ajax 请求
		code = code == "t1" ? "topbar": "topbar2";
		
		console.log("cc");
		var i = '<iframe  style="width: 100%;height: 100%;" scrolling="no" src="change?name='+code+'" ></iframe>';
		var s = $(".layui-body")[0].innerHTML = i;
		console.log(s);
	}




	//JavaScript代码区域
	layui.use('element', function() {
		var element = layui.element;
		console.log(element);

	});
	
	
	
	
	
	
	
	
	$(function() {
		console.log("初始化...");
		$id("1").click(function(){
			console.log('click1......');
			var code = "t1";
			changPages(code);
		})
		$id("2").click(function(){
			console.log('click2......');
			var code = "t2";
			changPages(code);
		})
	});
</script>
</html>