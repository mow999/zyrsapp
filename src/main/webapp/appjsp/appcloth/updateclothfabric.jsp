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
<script type="text/javascript" src="<%=path%>/appjs/appcloth/clothfabric.js"></script>
<script type="text/javascript" src="<%=path%>/appjs/appcloth/updateclothfabric.js"></script>
<script type="text/javascript" src="<%=path%>/appjs/appcloth/uploadclothfabricimage.js"></script>
<script type="text/javascript" src="<%=path%>/appjs/appcloth/uploadclothfabricfile.js"></script>
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
					<td class="lable" ><span>面料编码：</span></td>
					<td >
						<input type="text" required="required" id="fabriccode" name="fabriccode" readonly="readonly"/> 
						<label id="fabriccodeError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
			    <tr>
					<td class="lable" ><span>名称：</span></td>
					<td >
						<input type="text" required="required" id="fabricname" name="fabricname" readonly="readonly"/> 
						<label id="fabricnameError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable"><span>所属平台：</span></td>
					<td>
						<select id="clothfabricfiletools"  name="clothfabricfiletools" style="width: 200px">
						     <option value="请选择所属平台">请选择所属平台</option>
	                         <option value="PC">PC</option>
						     <option value="Android">Android</option>
						     <option value="IOS">IOS</option>
					    </select> 
					</td>
				</tr>
				<!--  
			    <tr>
					<td class="lable" ><span>服装面料模型名称：</span></td>
					<td >
						<input type="text" required="required" id="clothfabricfilename" name="clothfabricfilename"/> 
						<label id="clothfabricfilenameError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				-->
				
				<tr>
					<td class="lable" ><span>面料材质球：</span></td>
					<td >
						<input type="text" readonly="readonly" id=clothfabricfilename style="width: 400px" value=""/>
						<label class="up" for="fileToUpload2" style="width: 80px;">
							<input id="fileToUpload2" style="" class="bg" type="file" name="upfile2"> 
							<span style="float: left; margin-left: 5px" >上传模型</span>
						</label>
					</td>
				</tr>
				
				
				<tr>
					<td class="lable" ><span>面料材质球URL：</span></td>
					<td >
						<input type="text" required="required" id="clothfabricfileurl" name="clothfabricfileurl" readonly="readonly"/> 
						<label id="clothfabricfileurlError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable" ><span>面料材质球MD5：</span></td>
					<td >
						<input type="text" required="required" id="clothfabricfilemd5" name="clothfabricfilemd5" readonly="readonly"/> 
						<label id="clothfabricfilemd5Error" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<!-- 
				<tr>
					<td class="lable" ><span>适用平台：</span></td>
					<td >
						<input type="text" required="required" id="clothfabricfiletools" name="clothfabricfiletools"/> 
						<label id="clothfabricfiletoolsError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				 -->
				
				<!-- 
				 <tr>
					<td class="lable" ><span>服装面料模型图片名称：</span></td>
					<td >
						<input type="text" required="required" id="clothfabricimagename" name="clothfabricimagename"/> 
						<label id="clothfabricimagenameError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				 -->
				 <tr>
					<td class="lable" ><span>图片名称：</span></td>
					<td >
						<input type="text" readonly="readonly" id=clothfabricimagename style="width: 400px" value=""/>
						<label class="up" for="fileToUpload1" style="width: 80px;">
							<input id="fileToUpload1" style="" class="bg" type="file" name="upfile"> 
							<span style="float: left; margin-left: 5px">上传图片</span>
						</label>
					</td>
				</tr>
				<tr>
					<td class="lable" ><span>服装面料图片url：</span></td>
					<td >
						<input type="text" required="required" id="clothfabricimageurl" name="clothfabricimageurl" readonly="readonly"/> 
						<label id="clothfabricimageurlError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable" ><span>服装面料图片md5：</span></td>
					<td >
						<input type="text" required="required" id="clothfabricimagemd5" name="clothfabricimagemd5" readonly="readonly"/> 
						<label id="clothfabricimagemd5Error" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable" ><span>服装面料图片尺寸：</span></td>
					<td >
						<input type="text" required="required" id="clothfabricimagesize" name="clothfabricimagesize" readonly="readonly"/> 
						<label id="clothfabricimagesizeError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable" ><span>是否完成：</span></td>
					<td >
						<input type="text" required="required" id="clothfabriciscomplete" name="clothfabriciscomplete" readonly="readonly"/> 
						<label id="clothfabriciscompleteError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				
				<tbody id="tbody"></tbody>
			</table>

			<div align="center">
				<input type="button" onclick="updatesave()" value="修改面料" />
			</div>
	</div>

</body>
</html>