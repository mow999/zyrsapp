var queryStr = location.href.substring(location.href.indexOf("?") + 1);
var parameters = queryStr.split("=");
var type = parameters[1].split("_")[0];
var id = parameters[1].split("_")[1];
var url = null;

$(function() {
	if(type=="tie"){
		url = "tie_commodity/";
	}else if(type=="cravat"){
		url = "cravat_commodity/";
	}else if(type=="shirtbutton"){
		url = "shirtbutton_commodity/";
	}else if(type=="suitbutton"){
		url = "suitbutton_commodity/";
	}else if(type=="trousersbutton"){
		url = "trousersbutton_commodity/";
	}else if(type=="vestbutton"){
		url = "vestbutton_commodity/";
	}
	doSearch();
});

//获取要修改的数据字典ID
function doSearch() {
	$.ajax({
		type : "post",
		url : "clothdict/getAllClothDictById",
		data : {
			"id" : id,
		},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.success) {
				var res = data.result[0];
				var tbody = $("#tbody");
				tbody.empty();
				var tabhtml = "";
					$("#dictid").val(res.dictid);
					$("#dictcode").val(res.dictcode);
					$("#dictname").val(res.dictname);
		        tbody.append(tabhtml);
			}
		}
	});
}

//数据字典修改保存
function updatesave() {
	// 验证参数
	if ($("#dictcode").val() == "") {
		$("#dictcodeError").html("<font style='color:red'>请输入数据字典编码!</font>");
		$("#dictcode").focus();
		return false;
	}
	if ($("#dictname").val() == "") {
		$("#dictnameError").html("<font style='color:red'>请输入数据字典名称!</font>");
		$("#dictcode").focus();
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
	
	layer.confirm("确定修改吗？", function() {
		$.ajax({
			url : "clothdict/updateDict",
			type : "post",
			dataType : "json",
			data : {
				"id" : id,
				"dictcode" : $("#dictcode").val(),
				"dictname" : $("#dictname").val(),
			},
			async : false,
			success : function(data) {
				if (data.success) {
					layer.alert("修改信息成功!", {
						icon : 1
					});
				} else {
					layer.alert("修改信息失败!", {
						icon : 2
					});
				}
				parent.location.reload();
			},
			error : function(data) {
			}
		});
	});
}


