<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ele.me</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/frame/jquery-easyui-1.5.3/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/frame/jquery-easyui-1.5.3/themes/icon.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/frame/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/frame/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#datagrid1").datagrid({
			title : 'ele.me',
			idField : 'name',
			rownumbers : true,
			fitColumns : true,
			singleSelect : true,
			width : 600,
			pagination : true,
			columns : [ [ {
				title : 'name',
				field : 'name',
				width : 10,
				editor : {
					type : 'textbox',
					options : {}
				}
			}, {
				title : 'money',
				field : 'money',
				width : 10,
				editor : {
					type : 'numberbox',
					options : {
						prefix : '',
						precision : 2
					}
				}
			}, {
				title : 'cost',
				field : 'cost',
				width : 10
			} ] ],
			toolbar : "#ft",
			data : [ {
				'name' : 'Horace'
			}, {
				'name' : 'Tyler'
			}, {
				'name' : 'Miller'
			}, {
				'name' : 'Jane'
			} ],
			onClickRow : function(index, row) {
				$("#datagrid1").datagrid("beginEdit", index);
			}
		});

		var rows = $("#datagrid1").datagrid("getRows");
		for (i = 0; i < rows.length; i++) {
			$("#datagrid1").datagrid("beginEdit", i);
		}
	});

	function add() {
		$("#datagrid1").datagrid("appendRow", []);
		$("#datagrid1").datagrid("beginEdit",
				$("#datagrid1").datagrid("getRows").length - 1);
	}

	function calculate() {
		if ($("#sumCost").numberbox("getValue") == "") {
			$.messager.alert('Warning', '[ sum cost ] is required !');
			return;
		}
		var rows = $("#datagrid1").datagrid("getRows");
		var sumCost = parseFloat($("#sumCost").numberbox("getValue"));
		var sumMoney = 0;
		for (i = 0; i < rows.length; i++) {
			$("#datagrid1").datagrid("endEdit", i);
			if (rows[i].money == "") {
				rows[i].money = 0;
			}
			sumMoney += parseFloat(rows[i].money);
		}
		var rows = $("#datagrid1").datagrid("getRows");
		var ratio = 0;
		for (i = 0; i < rows.length; i++) {
			if (rows[i].money == undefined || rows[i].money == "") {
				rows[i].money = "0.00";
				rows[i].cost = "0.00";
			} else {
				ratio = parseFloat(rows[i].money) / sumMoney;
				rows[i].money = rows[i].money;
				rows[i].cost = (sumCost * ratio).toFixed(2);
			}
		}
		$("#datagrid1").datagrid("loadData", rows);
	}
</script>
</head>
<body>
	<table id="datagrid1"></table>
	<div id="ft" style="padding: 2px 5px;">
		<input id="sumCost" class="easyui-numberbox" prompt="sum cost" precision="2" required="true" />
		<a href="#" class="easyui-linkbutton" iconCls="icon-sum" plain="true" onclick="calculate()">Calculate</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">Add</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="history.go(0)">Reload</a>
	</div>
</body>
</html>