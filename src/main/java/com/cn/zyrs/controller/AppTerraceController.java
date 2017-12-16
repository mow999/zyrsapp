package com.cn.zyrs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.AppTerrace;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.service.AppTerraceService;
/**
 * 创建标识：张祥
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/terraces")
public class AppTerraceController {

	Logger log = Logger.getLogger(AppTerraceController.class);
	@Resource(name = "terraceService")
	private AppTerraceService terraceService;

	@ResponseBody
	@RequestMapping("/addTerraces")
	public ResultJsonBean addTerrace(HttpServletRequest request, HttpServletResponse response) {
		AppTerrace terrace = new AppTerrace();
		

		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		terrace.setTerraceid("12");
		terrace.setCnterracename("333");
		terrace.setEngterracename("555");;
		

		ResultJsonBean rjb = null;

		// 入参
		//
		// String chinesename = request.getParameter("chinesename");
		// String englistname = request.getParameter("englistname");
		// String clothclass = request.getParameter("clothclass");
		// String clothpart = request.getParameter("clothpart");
		// String url = request.getParameter("url");
		// String istrue = request.getParameter("istrue");
		// String limitsize = request.getParameter("limitsize");
		//
		// colthModel.setChinesename(chinesename);
		// colthModel.setEnglistname(englistname);
		// colthModel.setClothclass(clothclass);
		// colthModel.setClothpart(clothpart);
		// colthModel.setUrl(url);
		// colthModel.setIstrue(istrue);
		// colthModel.setLimitsize(limitsize);
		terraceService.addAppTerrace(terrace);
		return null;
	}
}
