package com.cn.zyrs.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.UUID;

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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.zyrs.domain.AppClothMainModel;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.ftp.FtpUtil;
import com.cn.zyrs.service.AppClothMainService;
import com.cn.zyrs.utils.DynamicDataSource;
/**
 * 创建标识：张祥
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/clothmainmodel")
public class AppClothMainModelController {

	Logger log = Logger.getLogger(AppClothMainModelController.class);
	@Resource(name = "clothMainModelService")
	private AppClothMainService clothMainService;
	
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//	@ResponseBody
//	@RequestMapping("/uploadimage")
	//上传主模型图片
//	public void uploadimage(HttpServletRequest request, HttpServletResponse response)throws IOException {
//		response.setContentType("textml");
//		response.setCharacterEncoding("utf-8");
//
//		String type = request.getParameter("type");
//		//声明上传路径
//		String rootPath = request.getSession().getServletContext().getRealPath("/")+ "Dress/data/MainModel/" + type + "_mainmodel";
//		String name = UUID.randomUUID().toString() + ".jpg";
//
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		MultipartFile multipartFile = multipartRequest.getFile("upfile");
//		String fName = multipartFile.getOriginalFilename();
//		File file = new File(rootPath, fName);
//		
////		if(file.exists()){
////			file.delete();
////		}
//		FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
//		//对模型图片件进行md5
//		String md5 = DigestUtils.md5Hex(new FileInputStream(file));
//		String filesize = multipartFile.getSize() / 1024L + "k";
//
//		JSONObject res = new JSONObject();
//		res.put("path", rootPath);
//		res.put("exName", fName);
////		res.put("name", name);
//		res.put("name", fName);
//		res.put("filesize", filesize);
//		//获取模型图片url存放地址
//		res.put("cmmimageurl", rootPath);
//		//获取模型图片md5
//		res.put("cmmimagemd5", md5);
//		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().write(res.toJSONString());
//
//		log.info(fName + "上传成功！");
//	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	

	@ResponseBody
	@RequestMapping("/uploadimage")
//	上传主模型图片
	public void uploadimage(HttpServletRequest request, HttpServletResponse response)throws IOException {
		response.setContentType("textml");
		response.setCharacterEncoding("utf-8");
//		String type = request.getParameter("type");
		//声明上传路径
		String rootPath = "C:\\APP_Server";
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
		res.put("path", rootPath);
		res.put("exName", fName);
//		res.put("name", name);
		res.put("name", fName);
		res.put("filesize", filesize);
		//获取模型图片url存放地址
		res.put("cmmimageurl", rootPath);
		//获取模型图片md5
		res.put("cmmimagemd5", md5);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(res.toJSONString());

		log.info(fName + "上传成功！");
	}

	
	
	@ResponseBody
	@RequestMapping("/uploadmainmodel")
	//上传主模型
	public void uploadmainmodel(HttpServletRequest request, HttpServletResponse response)throws IOException {
		response.setContentType("textml");
		response.setCharacterEncoding("utf-8");

//		String type = request.getParameter("type");
		//声明上传路径
		//String rootPath = request.getSession().getServletContext().getRealPath("/")+ "Dress/data/Commodity/" + type + "_commodity";
		String rootPath = "C:\\APP_Server";
		String name = UUID.randomUUID().toString() + ".assetbundle";
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
		res.put("path", rootPath);
		res.put("exName", fName);
//		res.put("name", name);
		res.put("name", fName);
		res.put("filesize", filesize);
		//获取模型url存放地址
		res.put("clothmainmodelurl", rootPath);
		//获取模型md5
		res.put("clothmainmodelmd5", md5);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(res.toJSONString());

		log.info(fName + "主模型上传成功！");
	}
	
	//查询所有服装主模型
	@ResponseBody
	@RequestMapping("/getClothMainModel")
	public ResultJsonBean getClothMainModel(HttpServletRequest request,HttpServletResponse response) {
		
		ResultJsonBean rjb = null;
		AppClothMainModel colthMainModel = new AppClothMainModel();
        List<AppClothMainModel> colthMainModelist = this.clothMainService.getAllAppClothMainModel(colthMainModel, null, null);
		rjb = new ResultJsonBean(true, colthMainModelist, "1", "服装主模型查询成功！");
		return rjb;
    }
    
	//增加新的主模型
	@ResponseBody
	@RequestMapping("/addClothMainModel")
	public ResultJsonBean addClothMainModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResultJsonBean rjb = null;
		AppClothMainModel colthMainModel = new AppClothMainModel();
		//模型或图片源存放路径径
		String fromurl = "C:\\APP_Server";
		//PC文件路径
		String topcurl = "C:\\APP_Server\\PC";
		//安卓文件路径
		String toandroidurl = "C:\\APP_Server\\Android";
		//IOS文件路径
		String toiosurl = "C:\\APP_Server\\IOS";
		
        // 入参
		String clothmainmodelcnname = request.getParameter("clothmainmodelcnname");
		String clothmainmodelengname = request.getParameter("clothmainmodelengname");
		String cmmbyclothclass = request.getParameter("cmmbyclothclass");
		String cmmbodystyle = request.getParameter("cmmbodystyle");
		String cmmplatform = request.getParameter("cmmplatform");
		String clothmainmodelname = request.getParameter("clothmainmodelname");
        String clothmainmodelurl = request.getParameter("clothmainmodelurl");
        String clothmainmodelmd5 = request.getParameter("clothmainmodelmd5");
		String cmmimagename = request.getParameter("cmmimagename");
		String cmmimageurl = request.getParameter("cmmimageurl");
		String cmmimagemd5 = request.getParameter("cmmimagemd5");
		String cmmistrue = request.getParameter("cmmistrue");
		
        colthMainModel.setClothmainmodelcnname(clothmainmodelcnname);
		colthMainModel.setClothmainmodelengname(clothmainmodelengname);
		colthMainModel.setCmmbyclothclass(cmmbyclothclass);
		colthMainModel.setCmmbodystyle(cmmbodystyle);
		colthMainModel.setCmmplatform(cmmplatform);
		colthMainModel.setClothmainmodelname(clothmainmodelname);
		//主模型urll
		colthMainModel.setClothmainmodelurl(clothmainmodelurl+"/"+cmmplatform+"/"+clothmainmodelname);
		colthMainModel.setClothmainmodelmd5(clothmainmodelmd5);
		colthMainModel.setCmmimagename(cmmimagename);
		//主模型图片url
		colthMainModel.setCmmimageurl(cmmimageurl+"/"+cmmplatform+"/"+cmmimagename);
		colthMainModel.setCmmimagemd5(cmmimagemd5);
		colthMainModel.setCmmistrue(cmmistrue);
		int res = -1;
		res = this.clothMainService.addAppClothMainModel(colthMainModel);
		//所属平台属于pc
		if(cmmplatform.equals("PC")) {
			//模型移动
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+clothmainmodelname, topcurl+"\\"+clothmainmodelname);
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+cmmimagename, topcurl+"\\"+cmmimagename);
			FileInputStream inmodel=new FileInputStream(new File("C:\\APP_Server\\"+clothmainmodelname));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/PC", clothmainmodelname, inmodel);
			
			//图片移动
			FileInputStream inimage=new FileInputStream(new File("C:\\APP_Server\\"+cmmimagename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/PC", cmmimagename, inimage);
        }
		//所属平台属于Android
		if(cmmplatform.equals("Android")) {
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+clothmainmodelname, toandroidurl+"\\"+clothmainmodelname);
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+cmmimagename, toandroidurl+"\\"+cmmimagename);
			//模型移动
			FileInputStream inmodel=new FileInputStream(new File("C:\\APP_Server\\"+clothmainmodelname));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/Android", clothmainmodelname, inmodel);
			//图片移动
			FileInputStream inimage=new FileInputStream(new File("C:\\APP_Server\\"+cmmimagename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/Android", cmmimagename, inimage);
        }
		//所属平台属于IOS
		if(cmmplatform.equals("IOS")) {
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+clothmainmodelname, toiosurl+"\\"+clothmainmodelname);
//			FileUrlAdmin.CopySingleFile(fromurl+"\\"+cmmimagename, toiosurl+"\\"+cmmimagename);
			//模型移动
			FileInputStream inmodel=new FileInputStream(new File("C:\\APP_Server\\"+clothmainmodelname));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/IOS", clothmainmodelname, inmodel);
			//图片移动
			FileInputStream inimage=new FileInputStream(new File("C:\\APP_Server\\"+cmmimagename));
			FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/IOS", cmmimagename, inimage);
        }
		if (res == 1) {
			log.info("新增数据成功！");
			rjb = new ResultJsonBean(true, res, "1", "新增数据成功！");
		} else {
			log.error("新增数据失败！");
			rjb = new ResultJsonBean(false, res, "-1", "新增数据失败！");
		}
		
		//所属平台属于PC
		if(cmmplatform.equals("PC")) {
			 
//			 moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "ftp://114.55.138.73/APP_Server/PC", "Suit.assetbundle", in);
			 
		}
	return rjb;
	}
    
	
	
	//删除主模型
	@ResponseBody
	@RequestMapping("/delClothMainModel")
	public ResultJsonBean delClothMainModel(HttpServletRequest request,HttpServletResponse response) {
		
		String clothMainId = request.getParameter("ids");
		ResultJsonBean rjb = null;
        int res1 = this.clothMainService.delAppClothMainModel(clothMainId);
		if(res1==1){
			log.info("删除成功！");
			rjb = new ResultJsonBean(true, res1, "1", "删除成功！");
			return rjb;
		}else{
			log.error("删除失败！");
			rjb = new ResultJsonBean(false, res1, "-1", "删除失败！");
			return rjb;
		}
    }




    //生成服装主模型json文件
	@ResponseBody
	@RequestMapping("/getClothMainModelToJson")
	public ResultJsonBean getClothMainModelToJson(HttpServletRequest request,HttpServletResponse response) throws IOException {
		ResultJsonBean rjb = null;
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		AppClothMainModel colthMainModel = new AppClothMainModel();
        List<AppClothMainModel> colthMainModelist = this.clothMainService.getAllAppClothMainModel(colthMainModel, null, null);
//		rjb = new ResultJsonBean(true, colthMainModelist, "1", "服装主模型查询成功！");
//		File directory = new File("c:\\toclothjson"); 
        File directory = new File("C:\\APP_Server"); 
		//拼接文件完整路径
        String fullPath = directory + File.separator + "ModelMain" + ".json";
        File file=new File(fullPath);
        //如果父目录不存在，创建父目录
		if (!file.getParentFile().exists()) { 
		    file.getParentFile().mkdirs();
		}
		//如果已存在,删除旧文件
		if (file.exists()) { 
		    file.delete();
		}
		file.createNewFile();
        OutputStream out=null;
        BufferedWriter rd=null;

      
		try {
			out = new FileOutputStream(file);
			 rd = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
			 JSONArray appccjson = new JSONArray();
	         for(AppClothMainModel appcc : colthMainModelist){
	             JSONObject jo = new JSONObject();
	             jo.put("clothmainmodelid", appcc.getClothmainmodelid());                
	             jo.put("ChineseName", appcc.getClothmainmodelcnname());       //ChineseName 服装主模型中文名
	             jo.put("EnglishName", appcc.getClothmainmodelengname());      //EnglishName 服装主模型英文名
	             jo.put("ClothClass", appcc.getCmmbyclothclass());             //ClothClass  服装主模型所属服装类型
	             jo.put("BodyStyle", appcc.getCmmbodystyle());                   //BodyStyle   服装部位
	             jo.put("Platform", appcc.getCmmplatform());                     //Platform    服装主模型所属平台
	             jo.put("ModeMainName", appcc.getClothmainmodelname());         //ModeMainName 服装主模型名称
	             jo.put("ModelMainUrl", appcc.getClothmainmodelurl());          //ModelMainUrl 服装主模型URL
	             jo.put("ModelMainMD5", appcc.getClothmainmodelmd5());          //ModelMainMD5  服装主模型MD5
	             jo.put("ImageName", appcc.getCmmimagename());                   //ImageName    图片名称
	             jo.put("ImageUrl", appcc.getCmmimageurl());                     //ImageUrl     图片url
	             jo.put("ImageMD5", appcc.getCmmimagemd5());                     //ImageMD5          图片md5
	             jo.put("isTrue", appcc.getCmmistrue());                         //isTrue       是否有效 
	            
	             appccjson.add(jo);
//		         rd.write(jo.toString());
	         }
	         rd.write(appccjson.toString());
			 rd.close();
           out.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//json文件移动
		FileInputStream injson=new FileInputStream(new File("C:\\APP_Server\\ModelMain.json"));
		FtpUtil.moveFile("114.55.138.73", 21, "administrator", "ZYRScrljsyc060822", "APP_Server/toclothjson", "ModelMain.json", injson);
		
		rjb = new ResultJsonBean(true, colthMainModelist, "1", "服装主模型生成成功！");
		return rjb;
	}
}	