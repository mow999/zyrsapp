<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/zhome.css" />
<link rel="stylesheet" href="<%=basePath%>css/zpop.css" />
<link rel="stylesheet" href="<%=basePath%>css/table.css" />
<link rel="stylesheet" href="<%=basePath%>css/style.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="<%=basePath%>js/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=basePath%>js/action/addModels.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<style type="text/css">
.up {
	background-image: url("images/button_small.png");
	height: 28px;
	border: 1px;
	color: white;
	padding-top: 5px;
	cursor: pointer;
	display: block;
}

.bg {
	loat: left;
	width: 80px;
	height: 28px;
	z-index: 2999;
	top: 150px;
	left: 570px;
	background-color: #FFF;
	filter: alpha(opacity = 0);
	-moz-opacity: 0.0;
	-khtml-opacity: 0.0;
	opacity: 0.0;
	position: absolute;
	cursor: pointer;
	background-color: #FFF;
	cursor: pointer;
}

.bodyPop label {
	width: 110px;
}

</style>
</head>

<body>
	<div class="bodyPop">
			<table class="table">
				<tr>
					<td class="lable" ><span>服装模型英文名：</span></td>
					<td >
						<input type="text" required="required" id="englishname" name="englishname"/> 
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable"><span>服装模型中文名：</span></td>
					<td >
						<input type="text" required="required" id="chinesename"	name="chinesename"/> 
						<label id="brandNameCNError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable" ><span>模型类型：</span></td>
					<td >
						<select id="clothclass" name="clothclass" onclick="changeModelClass()">  
						   <!-- 
						     <option value="1">1</option>  
						    <option value="0">1</option> 
						    --> 
						    <!--<input type="text" id="val"><input type="button" value="设置" onclick="fun()">  -->
						</select>  
						<label id="brandNameENError" style="width: 100px; text-align: left;"></label> 
					</td>
					<!-- 
					<td>
					<seclect >
					    <logic:notEmpty name="catalog">   
					        <logic:iterate id="li" name="catalog">   
					               <option><bean:write name="li" property="name"/></option> 
					        </logic:iterate>   
					    </logic:notEmpty>  
					</seclect></td>
					 -->
				</tr>
				
				
				<tr>
					<td class="lable" ><span>服装模型类型：</span></td>
					<td >
						<input type="text" required="required" id="brandNameEN" name="brandNameEN" onblur="changeModelClass();"/> 
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				
				
				<tr>
					<td class="lable" ><span>模型部位：</span></td>
					<td >
					    <select id="clothpart" name="clothpart">  
						    <option value="1">1</option>  
						    <option value="0">1</option>  
						</select> 
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<!-- 
				<tr>
					<td class="lable" ><span>url：</span></td>
					<td >
						<input type="text" required="required" id="url" name="url" type="hidden"/> 
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				 -->
				<tr>
					<td class="lable"><span>是否可用：</span></td>
					<td >
						<input type="text" required="required" id="istrue" name="istrue" />
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<!-- 
				<tr>
					<td class="lable"><span>大小限制：</span></td>
					<td >
						<input type="text" required="required" id="limitsize" name="limitsize" type="hidden"/>
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				 -->
				<tr>
					<td class="lable" ><span>服装模型文件名：</span></td>
					<td >
						<input type="text" required="required" id="clothmodelfilename" name="clothmodelfilename" /> 
						<label id="brandNameENError"	style="width: 200px; text-align: left;"></label></td>
				</tr>
				<!--
				<tr>
					<td class="lable" ><span>模型md5：</span></td>
					<td >
						<input type="text" required="required" id="md5file" name="md5file" /> 
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				-->
				<tr>
					<td class="lable" ><span>模型影响部位：</span></td>
					<td >
						<input type="text" required="required" id="holdpart" name="holdpart" /> 
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><span>模型受影响部位：</span></td>
					<td >
						<input type="text" required="required" id="byholdpart" name="byholdpart" />
						<label id="brandNameENError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable"><span>服装模型性别：</span></td>
					<td >
						<select id="clothmodelsex" name="clothmodelsex">  
						    <option value="1">男</option>  
						    <option value="0">女</option>  
						</select>  
						<!--<input type="text" required="required" id="clothmodelsex" name="clothmodelsex" />  -->
						<label id="brandNameENError" style="width: 20px; text-align: left;"></label>
					</td>
				</tr>
			</table>

			<div align="center">
				<input type="button" onclick="save()" value="保存" />
			</div>
	</div>

</body>
</html>