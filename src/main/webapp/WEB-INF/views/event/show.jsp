<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>iframe event test</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/frame/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#myIframeId").on(
				"load",
				function(e) {
					$("body", this.contentDocument).keydown(function(e) {
						var keyCode = e.keyCode || e.which || e.charCode;
						var ctrlKey = e.ctrlKey || e.metaKey;
						if (keyCode == 13) {
							alert("Enter Press");
						}
						if (ctrlKey && keyCode == 83) {//ctrl+s
							alert('save');
							//屏蔽浏览器快捷键
							e.preventDefault();
							window.event.returnValue = false;
						}
					});

					$("#iframeb", this.contentDocument).click(function(event) {
						alert("你倒是给点反应啊....");
					});

					$("#iframeText", this.contentDocument).on("keydown", null,
							"someParams", function(event) {
								//alert(event.data);
							});
				});

		$('#showText').on("keydown", null, "someParams", function(event) {
			alert(event.data);
		});

	});

	//屏蔽热键
	document.addEventListener('keydown', function(e) {
		var keycode = e.keyCode || e.which;
		if (e.ctrlKey && keycode == 83) { //Ctrl + S
			e.preventDefault();
			window.event.returnValue = false;
		}
		if (e.ctrlKey && keycode == 71) { //Ctrl + G
			e.preventDefault();
			window.event.returnValue = false;
		}
		if (e.ctrlKey && keycode == 72) { //Ctrl + H   
			e.preventDefault();
			window.event.returnValue = false;
		}
	});
</script>
</head>
<body>
	<div id="mainDiv">
		<h1>iframe event test</h1>
		<iframe id="myIframeId" frameborder="0" src="iframe.do" style="width: 100%; height: 100%; border: 1px solid black;"> </iframe>
		<textarea id="showText" rows="" cols=""></textarea>
	</div>
</body>
</html>