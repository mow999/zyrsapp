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



//保存服装款式
function save() {
    layer.confirm("确定新增服装款式？", function() {
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
			
			url : "clothstyle/addClothStyle",
			type : "post",
			dataType : "json",
			data : {
				"clothstylerank" : $("#clothstylerank").val(),
				"clothstylecnname" : $("#clothstylecnname").val(),
				"clothstyleengname" : $("#clothstyleengname").val(),
				"clothstylebyclothclass" : $("#clothstylebyclothclass").val(),
				"clothstylebyclothpart1" : $("#clothstylebyclothpart1").val(),
				"clothstylebyclothmodel" : $("#clothstylebyclothmodel").val(),
				"clothstylebyclothpart2" : $("#clothstylebyclothpart2").val(),
				"clothstylebymlmaterial" : $("#clothstylebymlmaterial").val(),
				"clothstyleistrue" : $("#clothstyleistrue").val(),
				"clothstyleimageurl" : $("#clothstyleimageurl").val(),
				"clothstyleimagename" : $("#clothstyleimagename").val(),
				"clothstyleimagemd5" : $("#clothstyleimagemd5").val(),
				"clothstyleplatform" : $("#clothstyleplatform").val()
			},
			async : false,
			success : function(data) {
				if (data.success) {
					layer.alert("新增服装款式成功!", {
						icon : 1
					});
				} else {
					layer.alert("新增服装款式失败!", {
					});
				}
				parent.location.reload();
			},
			error : function(data) {
			}
		});
	});
}

// 查询全部服装类型
function doSearch() {
	$.ajax({
			type : "post",
		    url : "../../clothfabric/getClothStoreFabric",
			data : {
				//"type" : "goods",
//				"fabricid" : fabricid
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
								var dssid = template.fabricid;
								
								tabhtml += "<tr>"
										+ "<td><input type='checkbox' name='check' value='"
										+ dssid
										+ "'/></td>"
										+ "<td>"
										+ template.fabriccode
										+ "</td>"
										+ "<td>"
										+ template.brandname
										+ "</td>"
										+ "<td>"
										+ template.fabricname
										+ "</td>"
//										+ "<td>"
//										+ template.brandid
//										+ "</td>"
//										+ "<td>"
//										+ template.categoryid
//										+ "</td>"
//										+ "<td>"
//										+ template.styleid
//										+ "</td>"

//										+ "<td>"
//										+ template.model
//										+ "</td>"
//										+ "<td>"
//										+ template.standard
//										+ "</td>"
//										+ "<td>"
//										+ template.color
//										+ "</td>"
//										+ "<td>"
//										+ template.composition
//										+ "</td>"
//										+ "<td>"
//										+ template.washingnotice
//										+ "</td>"
//										+ "<td>"
//										+ template.width
//										+ "</td>"
//										+ "<td>"
//										+ template.weight
//										+ "</td>"
//										+ "<td>"
//										+ template.yarn
//										+ "</td>"
//										+ "<td>"
//										+ template.unit
//										+ "</td>"
//										+ "<td>"
//										+ template.price
//										+ "</td>"
//										+ "<td>"
//										+ template.bomno
//										+ "</td>"
//										+ "<td>"
//										+ template.factoryid
//										+ "</td>"
//										+ "<td>"
//										+ template.channel
//										+ "</td>"
//										+ "<td>"
//										+ template.purchaseprice
//										+ "</td>"
//										+ "<td>"
//										+ template.isvalid
//										+ "</td>"
//										+ "<td>"
//										+ template.companyid
//										+ "</td>"
//										+ "<td>"
//										+ template.picture
//										+ "</td>"
//										+ "<td>"
//										+ template.version
//										+ "</td>"
//										+ "<td>"
//										+ template.isstorewarn
//										+ "</td>"
//										+ "<td>"
//										+ template.normal_image
//										+ "</td>"
//										+ "<td>"
//										+ template.big_image
//										+ "</td>"
//										+ "<td>"
//										+ template.small_image
//										+ "</td>"
//										+ "<td>"
//										+ template.creater
//										+ "</td>"
//										+ "<td>"
//										+ template.createdate
//										+ "</td>"
//										+ "<td>"
//										+ template.modifier
//										+ "</td>"
//										+ "<td>"
//										+ template.modifydate
//										+ "</td>"
//										+ "<td>"
//										+ template.padenable
//										+ "</td>"
										
										
										+ "<td>"
										+ template.clothfabricfilename
										+ "</td>"
//										+ "<td>"
//										+ template.clothfabricfileurl
//										+ "</td>"
//										+ "<td>"
//										+ template.clothfabricfilemd5
//										+ "</td>"
										+ "<td>"
										+ template.clothfabricfiletools
										+ "</td>"
										+ "<td>"
										+ template.clothfabricimagename
										+ "</td>"
//										+ "<td>"
//										+ template.clothfabricimageurl
//										+ "</td>"
//										+ "<td>"
//										+ template.clothfabricimagemd5
//										+ "</td>"
										+ "<td>"
										+ template.clothfabricimagesize
										+ "</td>"
										+ "<td>"
										+ template.clothfabriciscomplete
										+ "</td>"
										
										
										+ "<td>"
//										+ getInterceptedStr(template.salecode, 20)
										+""//暂时用不到的字段 设为空
										+ "</td>"
										+ "<td>"
//										+ "<div class='button-group'><a class='button border-red' onclick='del("
//										+ '"goods_'
//										+ dssid
//										+ '"'
//										+ ")'><span class='icon-trash-o'></span>删除</a></div>"
										+ "<div class='button-group'><a class='button border-red' onclick='updateclothfabric("
										+ '"tie_'
										+ dssid
										+ '"'
										+ ")'><span class='icon-trash-o'></span>修改</a></div>"
										+ "</td>" + 
										"</tr>"

							}
							tbody.append(tabhtml);
						}
					}
			   }
		});
}


//服装面料生成JSON文件
function clothStoreFabricToJson(a) {
	layer.confirm("确定要生成吗？", {
		btn : [ '确定', '取消' ],// 可以无限个按钮

	}, function() {
		// 生成JSON

		$.ajax({
//			url : "../../parts/styleToJson",
			url : "../../clothfabric/getClothStoreFabricToJson",
			type : "post",
			dataType : "json",
			data : {
//				"type" : "suit"
			},
			async : false,
			success : function(data) {
				if (data.success) {
					layer.alert("JSON文件生成成功！", {
						icon : 1
					});
				} else {
					layer.alert("JSON文件生成失败！", {
						icon : 2
					});
				}
			},
		});
	});
}



//修改服装面料
function updateclothfabric(id) {
	layer.open({
		type : 2,
		area : [ '1000px', '700px' ],
		title : "修改服装面料",
		shadeClose : false, // 点击遮罩关闭
		content : '../appcloth/updateclothfabric.jsp?id=' + id
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

//根据检索条件获取相应服装面料
function fabricSearchBy(){
	var fabriccode = document.getElementById("fabriccode").value;
	var brandname = document.getElementById("brandname").value;
	var clothfabriciscomplete = document.getElementById("clothfabriciscomplete").value;

	$.ajax({
		url : "../../clothfabric/getClothFabricBy",
		type : "post",
		dataType : "json",
	    data : {
			"fabriccode" : fabriccode,
			"brandname" : brandname,
			"clothfabriciscomplete" : clothfabriciscomplete
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
							var dssid = template.fabricid;
							
							tabhtml += "<tr>"
									+ "<td><input type='checkbox' name='check' value='"
									+ dssid
									+ "'/></td>"
									+ "<td>"
									+ template.fabriccode
									+ "</td>"
									+ "<td>"
									+ template.brandname
									+ "</td>"
									+ "<td>"
									+ template.fabricname
									+ "</td>"
//									+ "<td>"
//									+ template.brandid
//									+ "</td>"
//									+ "<td>"
//									+ template.categoryid
//									+ "</td>"
//									+ "<td>"
//									+ template.styleid
//									+ "</td>"

//									+ "<td>"
//									+ template.model
//									+ "</td>"
//									+ "<td>"
//									+ template.standard
//									+ "</td>"
//									+ "<td>"
//									+ template.color
//									+ "</td>"
//									+ "<td>"
//									+ template.composition
//									+ "</td>"
//									+ "<td>"
//									+ template.washingnotice
//									+ "</td>"
//									+ "<td>"
//									+ template.width
//									+ "</td>"
//									+ "<td>"
//									+ template.weight
//									+ "</td>"
//									+ "<td>"
//									+ template.yarn
//									+ "</td>"
//									+ "<td>"
//									+ template.unit
//									+ "</td>"
//									+ "<td>"
//									+ template.price
//									+ "</td>"
//									+ "<td>"
//									+ template.bomno
//									+ "</td>"
//									+ "<td>"
//									+ template.factoryid
//									+ "</td>"
//									+ "<td>"
//									+ template.channel
//									+ "</td>"
//									+ "<td>"
//									+ template.purchaseprice
//									+ "</td>"
//									+ "<td>"
//									+ template.isvalid
//									+ "</td>"
//									+ "<td>"
//									+ template.companyid
//									+ "</td>"
//									+ "<td>"
//									+ template.picture
//									+ "</td>"
//									+ "<td>"
//									+ template.version
//									+ "</td>"
//									+ "<td>"
//									+ template.isstorewarn
//									+ "</td>"
//									+ "<td>"
//									+ template.normal_image
//									+ "</td>"
//									+ "<td>"
//									+ template.big_image
//									+ "</td>"
//									+ "<td>"
//									+ template.small_image
//									+ "</td>"
//									+ "<td>"
//									+ template.creater
//									+ "</td>"
//									+ "<td>"
//									+ template.createdate
//									+ "</td>"
//									+ "<td>"
//									+ template.modifier
//									+ "</td>"
//									+ "<td>"
//									+ template.modifydate
//									+ "</td>"
//									+ "<td>"
//									+ template.padenable
//									+ "</td>"
									
									
									+ "<td>"
									+ template.clothfabricfilename
									+ "</td>"
//									+ "<td>"
//									+ template.clothfabricfileurl
//									+ "</td>"
//									+ "<td>"
//									+ template.clothfabricfilemd5
//									+ "</td>"
									+ "<td>"
									+ template.clothfabricfiletools
									+ "</td>"
									+ "<td>"
									+ template.clothfabricimagename
									+ "</td>"
//									+ "<td>"
//									+ template.clothfabricimageurl
//									+ "</td>"
//									+ "<td>"
//									+ template.clothfabricimagemd5
//									+ "</td>"
									+ "<td>"
									+ template.clothfabricimagesize
									+ "</td>"
									+ "<td>"
									+ template.clothfabriciscomplete
									+ "</td>"
									
									
									+ "<td>"
//									+ getInterceptedStr(template.salecode, 20)
									+""//暂时用不到的字段 设为空
									+ "</td>"
									+ "<td>"
//									+ "<div class='button-group'><a class='button border-red' onclick='del("
//									+ '"goods_'
//									+ dssid
//									+ '"'
//									+ ")'><span class='icon-trash-o'></span>删除</a></div>"
									+ "<div class='button-group'><a class='button border-red' onclick='updateclothfabric("
									+ '"tie_'
									+ dssid
									+ '"'
									+ ")'><span class='icon-trash-o'></span>修改</a></div>"
									+ "</td>" + 
									"</tr>"

						}
						tbody.append(tabhtml);
					}
				}
		   }
	});
}

//function selectSpare(ids) {
//
////--关闭 当前页面 开始-- 
//var index = parent.layer.getFrameIndex(window.name); 
//parent.layer.close(index); 
//alert("ddd");
//}