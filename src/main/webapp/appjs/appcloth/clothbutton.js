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

//新增服装按钮
function add(enName) {
	
	layer.open({
		type : 2,
		area : [ '950px', '630px' ],
		title : "新增服装按钮",
		shadeClose : false, // 点击遮罩关闭
		content : '../appcloth/addclothbutton.jsp?enName=' + enName
	});
}

//保存服装按钮
function save() {
    layer.confirm("确定新增服装按钮？", function() {
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
			url : "clothbutton/addClothButton",
			type : "post",
			dataType : "json",
			data : {
				"clothbuttoncnname" : $("#clothbuttoncnname").val(),
				"clothbuttonengname" : $("#clothbuttonengname").val(),
				"clothbuttonbyclothclass" : $("#clothbuttonbyclothclass").val(),
				"clothbuttoncnpartname" : $("#clothbuttoncnpartname").val(),
				"clothbuttonbyclothpart" : $("#clothbuttonbyclothpart").val(),
				"clothbuttonname" : $("#clothbuttonname").val(),
				"clothbuttonmorg" : $("#clothbuttonmorg").val(),
				"clothbuttonistrue" : $("#clothbuttonistrue").val(),
				"clothbuttonimagename" : $("#clothbuttonimagename").val(),
				"clothbuttonimageurl" : $("#clothbuttonimageurl").val(),
				"clothbuttonimagemd5" : $("#clothbuttonimagemd5").val(),
				"clothbuttonplatform" : $("#clothbuttonplatform").val(),
				"clothbuttonscreenresolution" : $("#clothbuttonscreenresolution").val()
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

// 查询全部服装按钮
function doSearch() {
	$.ajax({
			type : "post",
		    url : "../../clothbutton/getClothButton",
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
								var dssid = template.clothbuttonid;
								
								tabhtml += "<tr>"
										+ "<td><input type='checkbox' name='check' value='"
										+ dssid
										+ "'/></td>"
										+ "<td>"
										+ template.clothbuttoncnname
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonengname
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonbyclothclass
										+ "</td>"
										+ "<td>"
										+ template.clothbuttoncnpartname
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonbyclothpart
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonname
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonmorg
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonistrue
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonimagename
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonimageurl
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonimagemd5
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonplatform
										+ "</td>"
										+ "<td>"
										+ template.clothbuttonscreenresolution
										+ "</td>"
										+ "<td>"
//										+ getInterceptedStr(template.salecode, 20)
										+""//暂时用不到的字段 设为空
										+ "</td>"
										+ "<td>"
										+ "<div class='button-group'><a class='button border-red' onclick='del("
										+ '"goods_'
										+ dssid
										+ '"'
										+ ")'><span class='icon-trash-o'></span>删除部位</a></div>"
										+ "<div class='button-group'><a class='button border-red' onclick='update("
										+ '"tie_'
										+ dssid
										+ '"'
										+ ")'><span class='icon-trash-o'></span>修改部位</a></div>"
										+ "</td>" + 
										"</tr>"

							}
							tbody.append(tabhtml);
						}
					}
			   }
		});
}

// 删除服装部位
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

//批量删除服装部位
function deleteSpare(ids) {
	 $.ajax({
		url : "../../clothpart/delClothPart",
		type : "post",
		dataType : "json",
		data : {
//			"ids" : "ids",
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
				layer.alert("删除信息失败！",{
					icon :2
				});
			}
		},
	});
}




// 修改服装部位
function update(id) {
	layer.open({
		type : 2,
		area : [ '1000px', '700px' ],
		title : "修改服装部位",
		shadeClose : false, // 点击遮罩关闭
		content : '../action/updateGoods.jsp?id=' + id
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

//选择服装类型
function changeClothClass(){
    parent.layer.open({
		type : 2,
		area : [ '1000px', '500px' ],
		title : "选择服装类型",
		shadeClose : false, // 点击遮罩关闭
        content : '../appcommon/selectclothclass.jsp',
        
        async : false,
		success : function(data) {
			if (data.success) {
				layer.alert("删除信息成功！", {
					icon : 1
				});
				document.getElementById("clothpartclass").value = "2222222222222222222222";
				window.location.reload();
			} else {
//				layer. alert("删除信息失败！",{
//					icon :2
//				});
				document.getElementById("clothpartclass").value = "5555555555555";
				var aa = window.LS.get("ids");
				
				document.getElementById("clothpartclass").value = aa;
//				document.getElementById("clothpartclass").value = ids;
			}
		},
    });
   
}

//function selectSpare(ids) {
//
////--关闭 当前页面 开始-- 
//var index = parent.layer.getFrameIndex(window.name); 
//parent.layer.close(index); 
//alert("ddd");
//}