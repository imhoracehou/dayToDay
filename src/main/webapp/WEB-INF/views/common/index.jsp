<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/frame/bootstrap-3.3.7-dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<!-- 
<link rel="stylesheet" href="<%=request.getContextPath()%>/frame/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 -->
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/frame/bootstrap-3.3.7-dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/static/common/index.js"></script>

</head>
<body>
	<div class="container" style="padding-top: 20px;">
		<div class="row">
			<div class="col-md-2">
				<!-- .btn-block	这会创建块级的按钮，会横跨父元素的全部宽度。 -->
				<button type="button" class="btn btn-default btn-block" onclick="easyui()">Easyui</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default btn-block" onclick="pfLayoutUrl()">PrimeFaces Layout</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default btn-block" onclick="pfShowUrl()">PrimeFaces Show</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default btn-block" onclick="dataTableUrl()">DataTable</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default btn-block" onclick="eventUrl()">Event</button>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-default btn-block" onclick="springAjaxJsonUrl()">SpringMVC Ajax Json</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">.col-md-4</div>
			<div class="col-md-4">.col-md-4</div>
			<div class="col-md-4">.col-md-4</div>
		</div>
	</div>
</body>
</html>