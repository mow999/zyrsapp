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
<script type="text/javascript" src="<%=path%>/appjs/appcloth/addclothmainmodel.js"></script>
<script type="text/javascript" src="<%=path%>/appjs/appcloth/uploadclothmainmodel.js"></script>
<script type="text/javascript" src="<%=path%>/appjsp/appcommon/selectclothclass.js"></script>
<script type="text/javascript" src="<%=basePath%>js/layer/layer.js"></script>
<script type="text/javascript" src="<%=path%>/appjsp/appcommon/storage.js"></script>
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
					<td class="lable" ><span>中文名：</span></td>
					<td >
						<input type="text" required="required" id="clothmainmodelcnname" name="clothmainmodelcnname"/> 
						<label id="clothmainmodelcnnameError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable"><span>英文名：</span></td>
					<td >
						<input type="text" required="required" id="clothmainmodelengname"	name="clothmainmodelengname"/> 
						<label id="clothmainmodelengnameError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable"><span>所属服装类型：</span></td>
					<td >
						<input type="text" required="required" id="cmmbyclothclass"	name="cmmbyclothclass"/> 
						<label id="cmmbyclothclassError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><span>服装部位：</span></td>
					<td >
						<input type="text" required="required" id="cmmbodystyle"	name="cmmbodystyle"/> 
						<label id="cmmbodystyleError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><span>所属平台：</span></td>
					<!-- 
					<td >
						<input type="text" required="required" id="cmmplatform"	name="cmmplatform"/> 
						<label id="cmmplatformError" style="width: 200px; text-align: left;"></label>
					</td>
					 -->
					<td>
						<select id="cmmplatform"  name="cmmplatform" style="width: 200px">
						     <option value="请选择所属平台">请选择所属平台</option>
	                         <option value="PC">PC</option>
						     <option value="Android">Android</option>
						     <option value="IOS">IOS</option>
					    </select> 
					</td>
				</tr>
				<tr>
					<td class="lable" ><span>主模型（附件）：</span></td>
					<td >
						<input type="text" readonly="readonly" id=clothmainmodelname style="width: 400px" value=""/>
						<label class="up" for="fileToUpload2" style="width: 80px;">
							<input id="fileToUpload2" style="" class="bg" type="file" name="upfile2"> 
							<span style="float: left; margin-left: 5px" >上传模型</span>
						</label>
					</td>
				</tr>
				
				<tr>
					<td class="lable" ><span>主模型模型url：</span></td>
					<td >
						<input type="text" required="required" id="clothmainmodelurl" name="clothmainmodelurl" readonly="readonly"/> 
						<label id="clothmainmodelurlError" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable"><span>主模型模型md5：</span></td>
					<td >
						<input type="text" required="required" id="clothmainmodelmd5"	name="clothmainmodelmd5"  readonly="readonly"> 
						<label id="clothmainmodelmd5Error" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable" ><span>主模型图片（附件）：</span></td>
					<td >
						<input type="text" readonly="readonly" id=cmmimagename style="width: 400px" value=""/>
						<label class="up" for="fileToUpload1" style="width: 80px;">
							<input id="fileToUpload1" style="" class="bg" type="file" name="upfile"> 
							<span style="float: left; margin-left: 5px">上传图片</span>
						</label>
					</td>
				</tr>
				<tr>
					<td class="lable"><span>主模型图片url：</span></td>
					<td >
						<input type="text" required="required" id="cmmimageurl"	name="cmmimageurl"/> 
						<label id="cmmimageurlError" style="width: 200px; text-align: left;"></label></td>
				</tr>
				<tr>
					<td class="lable"><span>主模型图片md5：</span></td>
					<td >
						<input type="text" required="required" id="cmmimagemd5"	name="cmmimagemd5"/> 
						<label id="cmmimagemd5Error" style="width: 200px; text-align: left;"></label>
					</td>
				</tr>
				<tr>
					<td class="lable"><span>主模型是否可用：</span></td>
					<!-- 
					<td >
						<input type="text" required="required" id="cmmistrue"	name="cmmistrue"/> 
						<label id="cmmistrueError" style="width: 200px; text-align: left;"></label>
					</td>
					 -->
					<td>
						<select id="cmmistrue"  name="cmmistrue" style="width: 200px">
						     <option value="请选择">请选择</option>
	                         <option value="是">是</option>
						     <option value="否">否</option>
					    </select> 
					</td>
                </tr>
			</table>

			<div align="center">
				<input type="button" onclick="save()" value="保存" />
			</div>
	</div>

</body>
</html>