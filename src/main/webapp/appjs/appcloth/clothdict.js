$(function() {
	doSearch();
});

// 截取字符串显示
//function getInterceptedStr(sSource, iLen) {
//	if (sSource.replace(/[^x00-xff]/g, "xx").length <= iLen) {
//		return sSource;
//	}
//	var ELIDED = "...";
//
//	var str = "";
//	var l = 0;
//	var schar;
//	for (var i = 0; schar = sSource.charAt(i); i++) {
//		str += schar;
//		l += (schar.match(/[^x00-xff]/) != null ? 2 : 1);
//		if (l >= iLen - ELIDED.length) {
//			break;
//		}
//	}
//	str += ELIDED;
//
//	return str;
//}

// 查询全部数据字典
function doSearch() {
	
	$.ajax({
			type : "post",
		    url : "../../clothdict/getClothDict",
			data : {
				//"type" : "goods",
				//"enName" : "tie"
			},
			dataType : "json",
			async : false,
			success : function(data) {
					if (data.success) {
						var templateList = data.result;

						var tbody = $("#tbody");
						
						tbody.empty();
						if (templateList.length > 0) {
							var tabhtml = "";
							for (var i = 0; i < templateList.length; i++) {
								var template = templateList[i];
								var dssid = template.dictid;
								
								tabhtml += "<tr>"
										+ "<td><input type='checkbox' name='check' value='"
										+ dssid
										+ "'/></td>"
										+ "<td>"
										+ template.dictcode
										+ "</td>"
										+ "<td>"
										+ template.dictname
										+ "</td>"
										+ "<td>"
										+ "<div class='button-group'><a class='button border-red' onclick='del("
										+ '"goods_'
										+ dssid
										+ '"'
										+ ")'><span class='icon-trash-o'></span>删除字典</a></div>"
										+ "<div class='button-group'><a class='button border-red' onclick='update("
										+ '"tie_'
										+ dssid
										+ '"'
										+ ")'><span class='icon-trash-o'></span>修改字典</a></div>"
										+ "</td>" + 
										"</tr>"

							}
							tbody.append(tabhtml);
						}
					}
			   }
		});
}

//根据检索条件获取相应数据字典
function dictSearchBy(){
	var dictcode = document.getElementById("dictcode").value;
	var dictname = document.getElementById("dictname").value;
	
//	$.ajax({
//		url : "../../dicts/delClothDicts",
//		type : "post",
//		dataType : "json",
//		data : {
////			"type" : "goods",
//			"ids" : ids
//		},
	
	
	$.ajax({
		url : "../../clothdict/getClothDictBy",
		type : "post",
		dataType : "json",
	    data : {
			//"type" : "goods",
			//"enName" : "tie"
			"dictcode" : dictcode,
			"dictname" : dictname
		},
		
		async : false,
		success : function(data) {
				if (data.success) {
					var templateList = data.result;

					var tbody = $("#tbody");
					
					tbody.empty();
					if (templateList.length > 0) {
						var tabhtml = "";
						for (var i = 0; i < templateList.length; i++) {
							var template = templateList[i];
							var dssid = template.dictid;
							
							tabhtml += "<tr>"
									+ "<td><input type='checkbox' name='check' value='"
									+ dssid
									+ "'/></td>"
									+ "<td>"
									+ template.dictcode
									+ "</td>"
									+ "<td>"
									+ template.dictname
									+ "</td>"
									+ "<td>"
									+ "<div class='button-group'><a class='button border-red' onclick='del("
									+ '"goods_'
									+ dssid
									+ '"'
									+ ")'><span class='icon-trash-o'></span>删除字典</a></div>"
									+ "<div class='button-group'><a class='button border-red' onclick='update("
									+ '"tie_'
									+ dssid
									+ '"'
									+ ")'><span class='icon-trash-o'></span>修改字典</a></div>"
									+ "</td>" + 
									"</tr>"

						}
						tbody.append(tabhtml);
					}
				}
		   }
	});
}

// 删除字典模型
function del(ids) {
	// 获取选中的id号
	if (ids==null||ids==''){
		ids='';
		var length = $("input[name='check']:checked").length;
		if (length < 1) {
			layer.alert("请选择信息!", {
				icon : 2
			});
			return false;
		}
		 var el = document.getElementsByTagName('input');
		 var len = el.length;
		 for (var i = 0; i < len; i++) {
			 if ((el[i].type == "checkbox") && (el[i].name == 'check') && (el[i].checked)){
				 ids =ids + el[i].value+",";
			 }
		 }
	}else{
		ids=ids.split('_')[1];
	}
	layer.confirm("确定要删除吗？", {
		btn : [ '确定','取消' ],// 可以无限个按钮

	}, function() {
		deleteSpare(ids);
	});

}

//批量删除
function deleteSpare(ids) {
	 $.ajax({
		url : "../../clothdict/delClothDictById",
		type : "post",
		dataType : "json",
		data : {
			"ids" : ids
		},
		async : false,
		success : function(data) {
			if (data.success) {
				layer.alert("删除信息成功！", {
					icon : 1
				});
				window.location.reload();
			} else {
				layer. alert("删除信息失败！",{
					icon :2
				});
			}
		},
	});
}


// 新增
function add(enName) {
	layer.open({
		type : 2,
		area : [ '950px', '630px' ],
		title : "新增数据字典",
		shadeClose : false, // 点击遮罩关闭
		content : '../appcloth/addclothdict.jsp?enName=' + enName
	});
}


//保存
function save() {
	// 验证参数
	if ($("#dictcode").val() == "") {
		$("#dictcodeError").html("<font style='color:red'>请输入数据字典编码!</font>");
		$("#dictcode").focus();
		return false;
	}
	if ($("#dictname").val() == "") {
		$("#dictnameError").html("<font style='color:red'>请输入数据字典名称!</font>");
		$("#dictname").focus();
		return false;
	}

	
	if ($("#dictcodeError").html() != "") {
		$("#dictcode").focus();
		return false;
	}
	if ($("#dictnameError").html() != "") {
		$("#dictname").focus();
		return false;
	}

	
	layer.confirm("确定新增吗？", function() {
		var id = null;
		
//		//获取单选框的值
//		var issell=null;
//		var el = document.getElementsByTagName('input');
//		var len = el.length;
//		for (var i = 0; i < len; i++) {
//			if ((el[i].type == "radio") && (el[i].name == 'issell')
//					&& (el[i].checked)) {
//				issell = el[i].value;
//			}
//		}
		$.ajax({
			url : "clothdict/addClothDict",
			type : "post",
			dataType : "json",
			data : {
				"dictcode" : $("#dictcode").val(),
				"dictname" : $("#dictname").val()
			},
			async : false,
			success : function(data) {
				if (data.success) {
					layer.alert("新增信息成功!", {
						icon : 1
					});
				} else {
					layer.alert("新增信息失败!", {
					});
				}
				parent.location.reload();
			},
			error : function(data) {
			}
		});
	});
	
}

// 修改数据字典
function update(id) {
	layer.open({
		type : 2,
		area : [ '1000px', '700px' ],
		title : "修改数据字典1",
		shadeClose : false, // 点击遮罩关闭
		content : '../appcloth/updatedict.jsp?id=' + id
	});
}


//领带生成品牌JSON
//function goodsToJson(type){
//	layer.confirm("确定要生成吗？", {
//		btn : [ '确定', '取消' ],// 可以无限个按钮
//
//	}, function() {
//		// 生成JSON
//
//		$.ajax({
//			url : "../../json/goodsToJson",
//			type : "post",
//			dataType : "json",
//			data : {
//				"type" : type
//			},
//			async : false,
//			success : function(data) {
//				if (data.success) {
//					layer.alert("JSON文件生成成功！", {
//						icon : 1
//					});
//				} else {
//					layer.alert("JSON文件生成失败！", {
//						icon : 2
//					});
//				}
//			},
//		});
//	});
//}


//西服面料品牌详情生成JSON文件
//function goodsDetailToJson(type) {
//	// 查询面料品牌详情
//	$.ajax({
//		type : "post",
//		url : "../../json/detailToJson",
//		data : {
//			"type" : type,
//		},
//		dataType : "json",
//		async : false,
//		success : function(data) {
//			if (data.success) {
//				layer.alert("JSON文件生成成功！", {
//					icon : 1
//				});
//			} else {
//				layer.alert("JSON文件生成失败！", {
//					icon : 2
//				});
//			}
//		}
//	});
//}