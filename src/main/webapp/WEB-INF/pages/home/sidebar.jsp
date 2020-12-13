<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>sidebar</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resc/js/jquery-3.3.1.js"></script>
</head>
<body>
	<div>
		<ul class="layui-nav layui-nav-tree layui-nav-side">
			<!-- 侧边导航: <ul class="layui-nav layui-nav-tree" lay-filter="test"> -->
			<li class="layui-nav-item layui-nav-itemed">
				<a style="margin-left: 25px;">幼儿园管理平台</a>
			</li>
			<li class="layui-nav-item layui-nav-itemed">
				<a href="javascript:;">默认展开</a>
				<dl class="layui-nav-child">
					<dd>
						<a href="javascript:;">选项1</a>
					</dd>
					<dd>
						<a href="javascript:;">选项2</a>
					</dd>
					<dd>
						<a href="">跳转</a>
					</dd>
				</dl>
			</li>
			<li class="layui-nav-item">
				<a href="javascript:;">解决方案</a>
				<dl class="layui-nav-child">
					<dd>
						<a href="">移动模块</a>
					</dd>
					<dd>
						<a href="">后台模版</a>
					</dd>
					<dd>
						<a href="">电商平台</a>
					</dd>
				</dl>
			</li>
			<li class="layui-nav-item">
				<a href="">产品</a>
			</li>
			<li class="layui-nav-item">
				<a href="">大数据</a>
			</li>
		</ul>
	</div>
</body>

<script type="text/javascript">







	$(function() {
		$(".layui-nav-item").click(function(){
			//
			$(this).addClass("layui-nav-itemed");
			$(this).siblings().removeClass("layui-nav-itemed");
			
		});
	});
</script>

</html>