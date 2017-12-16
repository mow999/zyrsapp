<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String basePath = request.getContextPath();
	String path = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + basePath;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=path%>/css/pintuer.css">
<link rel="stylesheet" href="<%=path%>/css/admin.css">
<script type="text/javascript" src="<%=path%>/js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/pintuer.js"></script>
<script type="text/javascript" src="<%=path%>/appjsp/appcommon/selectclothclass.js"></script>
<script type="text/javascript" src="<%=path%>/appjsp/appcommon/storage.js"></script>
<script type="text/javascript" src="<%=path%>/js/layer/layer.js"></script>
</head>
<body>		
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 基础数据&nbsp;●&nbsp;请选择服装类型</strong>
			</div>
			
			<table class="table table-hover text-center">
				<tr>
					<th width="120">ID</th>
					<th>服装类型中文名</th>
					<th>服装类型英文名</th>
					<th>服装类型性别</th>
					<th>服装类型是否有效</th>
					<th>服装类型编码</th>
				</tr>

				<tbody id="tbody"></tbody>
				<tr>
					<td colspan="13"><div class="pagelist">
							<a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
								href="">3</a><a href="">下一页</a><a href="">尾页</a>
						</div></td>
				</tr>
			</table>
		</div>
</body>
</html>