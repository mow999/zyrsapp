package com.cn.zyrs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.AppClothDict;
import com.cn.zyrs.domain.GoodsParts;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.service.AppClothDictService;
import com.cn.zyrs.utils.DynamicDataSource;

@Controller
@RequestMapping("/dicts")
public class AppClothDictController {

	Logger log = Logger.getLogger(AppClothDictController.class);
	@Resource(name = "clothDictService")
	private AppClothDictService clothDictService;
    
	//增加新的数据字典
	@ResponseBody
	@RequestMapping("/addDicts")
	public ResultJsonBean addColthModel(HttpServletRequest request, HttpServletResponse response) {
		AppClothDict clothDict = new AppClothDict();
        ResultJsonBean rjb = null;
	        // 入参
			String dictcode = request.getParameter("dictcode");
			String dictname = request.getParameter("dictname");
			
			clothDict.setDictcode(dictcode);
			clothDict.setDictname(dictname);
			int res = -1;
			res = this.clothDictService.addAppClothDict(clothDict);

			if (res == 1) {
				log.info("新增数据字典成功！");
				rjb = new ResultJsonBean(true, res, "1", "新增数据字典成功！");
			} else {
				log.error("新增数据字典失败！");
				rjb = new ResultJsonBean(false, res, "-1", "新增数据字典失败！");
			}
			
		return rjb;
	}
    
	//查询所有数据字典
	@ResponseBody
	@RequestMapping("/getClothDicts")
	public ResultJsonBean getAllClothDict(HttpServletRequest request,HttpServletResponse response) {
		String dictid = request.getParameter("id");
		String dictcode = request.getParameter("dictcode");
		String dictname = request.getParameter("dictname");
		ResultJsonBean rjb = null;
//		AppClothDict clothDict = new AppClothDict();
        List<AppClothDict> colthDictList = this.clothDictService.getAllAppClothDict(dictid,dictcode,dictname,null,null);
		rjb = new ResultJsonBean(true, colthDictList, "1", "数据字典查询成功！");
		return rjb;
    }
	
	//根据检索条件查询对应字典
	@ResponseBody
	@RequestMapping("/getClothDictsBy")
	public ResultJsonBean getAllClothDictBy(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		 // 入参
//		String dictId = request.getParameter("ids");
		String dictid = request.getParameter("dictid");
		String dictcode = request.getParameter("dictcode");
		String dictname = request.getParameter("dictname");
		System.out.println(dictcode+"yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
		ResultJsonBean rjb = null;
		AppClothDict clothDict = new AppClothDict();
		clothDict.setDictcode(dictcode);
		clothDict.setDictname(dictname);
        List<AppClothDict> colthDictList = this.clothDictService.getAllAppClothDict(dictid,dictcode, dictname,null,null);
		rjb = new ResultJsonBean(true, colthDictList, "1", "数据字典查询成功！");
		return rjb;
    }
	
	//删除所选数据字典
	@ResponseBody
	@RequestMapping("/delClothDicts")
	public ResultJsonBean delClothModel(HttpServletRequest request,HttpServletResponse response) {
		String dictId = request.getParameter("ids");
		ResultJsonBean rjb = null;
        int res1 = this.clothDictService.delAppClothDict(dictId);
		if(res1==1){
			log.info("数据字典删除成功！");
			rjb = new ResultJsonBean(true, res1, "1", "数据字典删除成功！");
			return rjb;
		}else{
			log.error("数据字典删除失败！");
			rjb = new ResultJsonBean(false, res1, "-1", "数据字典删除失败！");
			return rjb;
		}
    }
	
//	//获取需要修改的数据
//	@ResponseBody
//	@RequestMapping("/getDicts")
//	public ResultJsonBean getGoods(HttpServletRequest request,HttpServletResponse response) {
//		ResultJsonBean rjb = null;
//
//		String id = request.getParameter("id");
////		String style = request.getParameter("enName");
//
//		GoodsParts gp = new GoodsParts();
//
//		gp.setId(id);
//		gp.setStyle(style);
//
////		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//		List<GoodsParts> gpl = this.partsService.getGoodsParts(gp);
//
//		if (gpl != null && gpl.size() > 0) {
//			rjb = new ResultJsonBean(true, gpl, "1", "查询配件信息成功！");
//			log.info("查询配件信息成功！");
//		} else if (gpl != null && gpl.size() == 0) {
//			rjb = new ResultJsonBean(false, gpl, "-1", "查询不到匹配信息！");
//			log.error("查询不到匹配信息！");
//		}
//
//		return rjb;
//
//	}
	
	
	//修改保存数据字典
	@ResponseBody
	@RequestMapping("/updateDicts")
	public ResultJsonBean updateDicts(HttpServletRequest request,HttpServletResponse response) {
		ResultJsonBean rjb = null;
        String id = request.getParameter("id");
        String dictcode = request.getParameter("dictcode");
		String dictname = request.getParameter("dictname");
		AppClothDict dict = new AppClothDict();
		
		System.out.println(id);
		System.out.println(dictcode);
		System.out.println(dictname);

		dict.setDictid(id);
		dict.setDictcode(dictcode);
		dict.setDictname(dictname);

		int res = -1;
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		res = this.clothDictService.upAppClothDict(dict);

		if (res == 1) {
			log.info("修改数据字典成功！");
			rjb = new ResultJsonBean(true, res, "1", "修改数据字典成功！");
		} else {
			log.error("修改数据字典失败！");
			rjb = new ResultJsonBean(false, res, "-1", "修改数据字典失败！");
		}
		return rjb;
    }
}
