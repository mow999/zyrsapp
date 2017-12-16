package com.cn.zyrs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.cn.zyrs.domain.AppClothModel;
import com.cn.zyrs.domain.AppClothStoreFabric;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.ftp.FtpUtil;
import com.cn.zyrs.service.AppClothModelService;
import com.cn.zyrs.utils.DynamicDataSource;
/**
 * 创建标识：张祥
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/clothmodel")
public class AppClothModelController {

	Logger log = Logger.getLogger(AppClothModelController.class);
	@Resource(name = "clothModelService")
	private AppClothModelService clothModelService;
    
	//增加新的服装模型
	@ResponseBody
	@RequestMapping("/addClothModel")
	public ResultJsonBean addColthModel(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		AppClothModel clothModel = new AppClothModel();
        ResultJsonBean rjb = null;
    
        
        // 入参
		String clothmodelcnname = request.getParameter("clothmodelcnname");
	    String clothmodelengname = request.getParameter("clothmodelengname");
		String clothmodelbyclothclass = request.getParameter("clothmodelbyclothclass");
		String clothmodelbyclothpart = request.getParameter("clothmodelbyclothpart");
		String clothmodelbyplatform = request.getParameter("clothmodelbyplatform");
		String clothmodelname = request.getParameter("clothmodelname");
		String clothmodelfilename = request.getParameter("clothmodelfilename");
		String clothmodelurl = request.getParameter("clothmodelurl");
		String clothmodelistrue = request.getParameter("clothmodelistrue");
		String clothmodeldifferentedpart = request.getParameter("clothmodeldifferentedpart");
		String clothmodeldifferentspart = request.getParameter("clothmodeldifferentspart");
		String clothmodelmd5 = request.getParameter("clothmodelmd5");
		String clothmodelimagename = request.getParameter("clothmodelimagename");
		String clothmodelimageurl = request.getParameter("clothmodelimageurl");
		String clothmodelimagemd5 = request.getParameter("clothmodelimagemd5");
		String clothmodelauthor = request.getParameter("clothmodelauthor");
		String clothmodeluploadname = request.getParameter("clothmodeluploadname");
		String clothmodelversion = request.getParameter("clothmodelversion");
		
		clothModel.setClothmodelcnname(clothmodelcnname);
		clothModel.setClothmodelengname(clothmodelengname);
		clothModel.setClothmodelbyclothclass(clothmodelbyclothclass);
		clothModel.setClothmodelbyclothpart(clothmodelbyclothpart);
		clothModel.setClothmodelbyplatform(clothmodelbyplatform);
		clothModel.setClothmodelname(clothmodelname);
		clothModel.setClothmodelfilename(clothmodelfilename);
		clothModel.setClothmodelurl(clothmodelurl);
		clothModel.setClothmodelistrue(clothmodelistrue);
		clothModel.setClothmodeldifferentedpart(clothmodeldifferentedpart);
		clothModel.setClothmodeldifferentspart(clothmodeldifferentspart);
		clothModel.setClothmodelmd5(clothmodelmd5);
		clothModel.setClothmodelimagename(clothmodelimagename);
		clothModel.setClothmodelimageurl(clothmodelimageurl);
		clothModel.setClothmodelimagemd5(clothmodelimagemd5);
		clothModel.setClothmodelauthor(clothmodelauthor);
		clothModel.setClothmodeluploadname(clothmodeluploadname);
		clothModel.setClothmodelversion(clothmodelversion);

//		int res = -1;
//		res = this.clothModelService.addAppClothModel(clothModel);
//
//		if (res == 1) {
//			log.info("新增服装模型成功！");
//			rjb = new ResultJsonBean(true, res, "1", "新增服装模型成功！");
//		} else {
//			log.error("新增服装模型失败！");
//			rjb = new ResultJsonBean(false, res, "-1", "新增服装模型失败！");
//		}
//		return rjb;
		
		int res = -1;
		res = this.clothModelService.addAppClothModel(clothModel);
		//所属平台属于pc
		if(clothmodelbyplatform.equals("PC")) {
//			System.out.println(fromurl+"\\"+clothmainmodelname);
//			System.out.println(topcurl+"\\"+clothmainmodelname);
			//模型移动
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+clothmainmodelname, topcurl+"\\"+clothmainmodelname);
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+cmmimagename, topcurl+"\\"+cmmimagename);
			FileInputStream inmodel=new FileInputStream(new File("C:\\APP_Server\\"+clothmodelfilename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/PC", clothmodelfilename, inmodel);
			
			//图片移动
			FileInputStream inimage=new FileInputStream(new File("C:\\APP_Server\\"+clothmodelimagename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/PC", clothmodelimagename, inimage);
        }
		//所属平台属于Android
		if(clothmodelbyplatform.equals("Android")) {
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+clothmainmodelname, toandroidurl+"\\"+clothmainmodelname);
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+cmmimagename, toandroidurl+"\\"+cmmimagename);
			//模型移动
			FileInputStream inmodel=new FileInputStream(new File("C:\\APP_Server\\"+clothmodelfilename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/Android", clothmodelfilename, inmodel);
			//图片移动
			FileInputStream inimage=new FileInputStream(new File("C:\\APP_Server\\"+clothmodelimagename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/Android", clothmodelimagename, inimage);
        }
		//所属平台属于IOS
		if(clothmodelbyplatform.equals("IOS")) {
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+clothmainmodelname, toiosurl+"\\"+clothmainmodelname);
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+cmmimagename, toiosurl+"\\"+cmmimagename);
			//模型移动
			FileInputStream inmodel=new FileInputStream(new File("C:\\APP_Server\\"+clothmodelfilename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/IOS", clothmodelfilename, inmodel);
			//图片移动
			FileInputStream inimage=new FileInputStream(new File("C:\\APP_Server\\"+clothmodelimagename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/IOS", clothmodelimagename, inimage);
        }
		if (res == 1) {
			log.info("新增数据成功！");
			rjb = new ResultJsonBean(true, res, "1", "新增数据成功！");
		} else {
			log.error("新增数据失败！");
			rjb = new ResultJsonBean(false, res, "-1", "新增数据失败！");
		}
		
		//所属平台属于PC
//		if(cmmplatform.equals("PC")) {
//			//moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "ftp://114.55.138.73/APP_Server/PC", "Suit.assetbundle", in);
//		}
	return rjb;
	}

    
	//查询所有服装模型
	@ResponseBody
	@RequestMapping("/getClothModel")
	public ResultJsonBean getClothModel(HttpServletRequest request,HttpServletResponse response) {
		ResultJsonBean rjb = null;
		AppClothModel colthModel = new AppClothModel();
        List<AppClothModel> colthModelList = this.clothModelService.getAllAppClothModel(colthModel,null,null);
		rjb = new ResultJsonBean(true, colthModelList, "1", "服装模型查询成功！");
		return rjb;
    }
	
	//删除所选服装模型
	@ResponseBody
	@RequestMapping("/delClothModel")
	public ResultJsonBean delClothModel(HttpServletRequest request,HttpServletResponse response) {
		String modelId = request.getParameter("ids");
		ResultJsonBean rjb = null;
        int res1 = this.clothModelService.delAppClothModel(modelId);
		if(res1==1){
			log.info("服装模型删除成功！");
			rjb = new ResultJsonBean(true, res1, "1", "服装模型删除成功！");
			return rjb;
		}else{
			log.error("服装模型删除失败！");
			rjb = new ResultJsonBean(false, res1, "-1", "服装模型删除失败！");
			return rjb;
		}
    }
	
	
	//根据ID查询服装模型
	@ResponseBody
	@RequestMapping("/getAllClothModelById")
	public ResultJsonBean getAllClothModelById(HttpServletRequest request,HttpServletResponse response) {
		ResultJsonBean rjb = null;
		String clothmodelid = request.getParameter("id");
        List<AppClothModel> colthClassList = this.clothModelService.getAllAppClothModelById(clothmodelid);
		rjb = new ResultJsonBean(true, colthClassList, "1", "服装面料查询成功！");
		return rjb;
    }
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@ResponseBody
	@RequestMapping("/uploadmodel")
	//上传模型
	public void uploadmodel(HttpServletRequest request, HttpServletResponse response)throws IOException {
		response.setContentType("textml");
		response.setCharacterEncoding("utf-8");

//		String type = request.getParameter("type");
		//声明上传路径
		//String rootPath = request.getSession().getServletContext().getRealPath("/")+ "Dress/data/Commodity/" + type + "_commodity";
		String rootPath = "C:/APP_Server";
//		String name = UUID.randomUUID().toString() + ".assetbundle";
//		String name = UUID.randomUUID().toString() + ".jpg";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("upfile2");
		String fName = multipartFile.getOriginalFilename();
		File file = new File(rootPath, fName);
		
		
//		if(file.exists()){
//			file.delete();
//		}
		FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
		String filesize = multipartFile.getSize() / 1024L + "k";
		
		//对文件件进行md5密
		String md5 = DigestUtils.md5Hex(new FileInputStream(file));

		JSONObject res = new JSONObject();
//		res.put("path", rootPath);
		res.put("path", "APP_Server");
		res.put("exName", fName);
//		res.put("name", name);
		res.put("name", fName);
		res.put("filesize", filesize);
		//获取模型url存放地址
		res.put("clothmodelurl", rootPath);
		//获取模型md5
		res.put("clothmodelmd5", md5);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(res.toJSONString());

		log.info(fName + "模型上传成功！");
	}
	
	
	@ResponseBody
	@RequestMapping("/uploadclothimage")
//	上传模型图片
	public void uploadimage(HttpServletRequest request, HttpServletResponse response)throws IOException {
		response.setContentType("textml");
		response.setCharacterEncoding("utf-8");

//		String type = request.getParameter("type");
		//声明上传路径
//		String rootPath = request.getSession().getServletContext().getRealPath("/")+ "Dress/data/MainModel/" + type + "_mainmodel";
		String rootPath ="C:/APP_Server";
//		String rootPath = "D:/JAVA/apache-tomcat-7.0.65/webapps/zyrsback/APP_Server/toclothjson";
//		String name = UUID.randomUUID().toString() + ".jpg";

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("upfile");
		String fName = multipartFile.getOriginalFilename();
		File file = new File(rootPath, fName);
		
//		if(file.exists()){
//			file.delete();
//		}
		FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
		//对模型图片件进行md5
		String md5 = DigestUtils.md5Hex(new FileInputStream(file));
		String filesize = multipartFile.getSize() / 1024L + "k";

		JSONObject res = new JSONObject();
		res.put("path", "APP_Server");
		res.put("exName", fName);
//		res.put("name", name);
		res.put("name", fName);
		res.put("filesize", filesize);
		//获取模型图片url存放地址
		res.put("clothmodelimageurl", rootPath);
		//获取模型图片md5
		res.put("clothmodelimagemd5", md5);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(res.toJSONString());

		log.info(fName + "上传成功！");
	}
}
