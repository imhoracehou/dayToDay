//模拟键盘回车事件
function demo1() {
	var e = jQuery.Event("keydown"); // 模拟一个键盘事件
	e.keyCode = 13; // keyCode=13是回车
	$("#id").trigger(e); // 绑定执行
}

// 重新加载当前页面
function demo2() {
	location.reload();
}