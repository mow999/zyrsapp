package junit.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.zyrs.domain.AppClothButton;
import com.cn.zyrs.domain.AppClothClass;
import com.cn.zyrs.domain.AppClothDict;
import com.cn.zyrs.domain.AppClothMainModel;
import com.cn.zyrs.domain.AppClothModel;
import com.cn.zyrs.domain.AppClothPart;
import com.cn.zyrs.domain.AppClothQuantityBodySize;
import com.cn.zyrs.domain.AppClothStoreFabric;
import com.cn.zyrs.domain.AppClothStyle;
import com.cn.zyrs.domain.AppDepartMent;
import com.cn.zyrs.domain.AppTerrace;
import com.cn.zyrs.service.AppClothButtonService;
import com.cn.zyrs.service.AppClothClassService;
import com.cn.zyrs.service.AppClothDictService;
import com.cn.zyrs.service.AppClothMainService;
import com.cn.zyrs.service.AppClothModelService;
import com.cn.zyrs.service.AppClothPartService;
import com.cn.zyrs.service.AppClothQuantityBodySizeService;
import com.cn.zyrs.service.AppClothStoreFabricService;
import com.cn.zyrs.service.AppClothStyleService;
import com.cn.zyrs.service.AppDeptLoginService;
import com.cn.zyrs.service.AppTerraceService;
import com.cn.zyrs.utils.DynamicDataSource;

import junit.test.SpringTestCase;

/**
 * 创建标识：张祥
 * 创建时间：20171114
 */
public class ModelServiceTest extends SpringTestCase {
	Logger logger = Logger.getLogger(ModelServiceTest.class);
	
	@Resource(name = "clothModelService")
	private AppClothModelService clothModelService;
	
	@Resource(name = "terraceService")
	private AppTerraceService terraceService;
	
	@Resource(name = "clothClassService")
	private AppClothClassService clothClassService;
	
	@Resource(name = "clothPartService")
	private AppClothPartService clothPartService;
	
	@Resource(name = "deptLoginService")
	private AppDeptLoginService deptLoginService;
	
	@Resource(name = "clothDictService")
	private AppClothDictService clothDictService;
	
	@Resource(name = "clothStyleService")
	private AppClothStyleService clothStyleService;
	
	@Resource(name = "clothMainModelService")
	private AppClothMainService clothMainModelService;
	
	@Resource(name = "clothButtonService")
	private AppClothButtonService clothButtonService;
	
	@Resource(name = "clothStoreFabricService")
	private AppClothStoreFabricService clothStoreFabricService;
	
	@Resource(name = "clothQuantityBodySizeService")
	private AppClothQuantityBodySizeService clothQuantityBodySizeService;
	
	//添加量体信息
//	@Test
	public void addQuantityBodySizeTest() {
		AppClothQuantityBodySize BodySize = new AppClothQuantityBodySize();
//		BodySize.setLtxxid("111");
		BodySize.setChinesename("aaa");
		BodySize.setEnglishname("dddd");
		BodySize.setBodystyle("ddd");
		BodySize.setSex("111");
		clothQuantityBodySizeService.addAppClothQuantityBodySize(BodySize);
		
	}
	
	
	//根据id查询数据字典d
//	@Test
	public void getClothClothByIdTest() {
		AppClothDict clothDict = new AppClothDict();
		clothDict.setDictid("B59D9CEC-4B1E-416C-9FC5-D9E5DB723A59");
		List<AppClothDict> list = clothDictService.getAllAppClothDict("B59D9CEC-4B1E-416C-9FC5-D9E5DB723A59", null, null, null, null);
		System.out.println(list.get(0));
	}
	
	//查询全部服装面料
//	@Test
	public void getClothMainModelTest() {
		AppClothStoreFabric clothStoreFabric = new AppClothStoreFabric();
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_2);
		List<AppClothStoreFabric> list = clothStoreFabricService.getAllAppClothStoreFabric(null, null);
		System.out.println(list.get(0));
	}
	
	//修改全部服装面料
//	@Test
	public void upClothMainModelTest() {
		AppClothStoreFabric clothStoreFabric = new AppClothStoreFabric();
		clothStoreFabric.setFabricid("001683a8-5466-49d2-8223-9de101e2e8c2");
		clothStoreFabric.setClothfabricfilename("文件名");
		clothStoreFabric.setClothfabricfileurl("111111111111");
		clothStoreFabric.setClothfabricfilemd5("111111111111");
		clothStoreFabric.setClothfabricfiletools("111111111111");
		clothStoreFabric.setClothfabricimagename("111111111111");
		clothStoreFabric.setClothfabricimageurl("111111111111");
		clothStoreFabric.setClothfabricimagemd5("111111111111");
		clothStoreFabric.setClothfabricimagesize("6666");
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_2);
		clothStoreFabricService.upAppClothStoreFabric(clothStoreFabric);
	}
	
	//根据条件查找面料
//	@Test
	public void upClothTest() {
		AppClothStoreFabric clothStoreFabric = new AppClothStoreFabric();
	
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_2);
		List list = clothStoreFabricService.getAllAppClothStoreFabricBy(null, null, "T");
		System.out.println(list.get(0));
	
	}
    
    
	//添加模型
//	@Test  
	public void addClothModelTest() {
		AppClothModel colthModel = new AppClothModel();
		colthModel.setClothmodelcnname("11");
		colthModel.setClothmodelengname("aaa");
		colthModel.setClothmodelbyclothclass("aaa");
		colthModel.setClothmodelbyclothpart("aaa");
		colthModel.setClothmodelbyplatform("aaa");
		colthModel.setClothmodelname("aaa");
		colthModel.setClothmodelfilename("aaa");
		colthModel.setClothmodelurl("aaa");
		colthModel.setClothmodelistrue("aaa");
		colthModel.setClothmodeldifferentedpart("aaa");
		colthModel.setClothmodeldifferentspart("aaa");
		colthModel.setClothmodelmd5("aaa");
		colthModel.setClothmodelimagename("aaa");
		colthModel.setClothmodelimageurl("aaa");
		colthModel.setClothmodelauthor("aaa");
		colthModel.setClothmodeluploadname("aaa");
		colthModel.setClothmodelversion("aaa");
		
		
		 clothModelService.addAppClothModel(colthModel);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	   
		//查询全部主模型部
//		@Test
		public void getClothMainTest() {
			AppClothMainModel clothMainModel = new AppClothMainModel();
			List<AppClothMainModel> list = clothMainModelService.getAllAppClothMainModel(clothMainModel, null, null);
			System.out.println(list.get(0));
		}
	
	//删除模型
//	@Test  
	public void delClothModelTest() {
		clothModelService.delAppClothModel("4170E005-BE23-438D-88DB-41A0329AD610");
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	//根据id查询模型
//	@Test  
	public void getClothModelTest() {
		clothModelService.getAllAppClothModelById("13364A83-B6C6-49AC-8593-EB3F4316361B");
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	//修改模型
//	@Test
//	public void upClothModelTest() {
//		AppClothModel colthModel = new AppClothModel();
//		colthModel.setModelid("D67673C0-0376-428C-8ED0-6A000706060B");
//		colthModel.setChinesename("1");
//		 colthModel.setEnglishname("1");
//		 colthModel.setClothclass("1");
//		 colthModel.setClothpart("1");
//		 colthModel.setUrl("1");
//		 colthModel.setIstrue("1");
//		 colthModel.setLimitsize("1");
//		
//		clothModelService.upAppClothModel(colthModel);
//		 logger.debug("查找结果" + "111");
//		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//	}
	
	//查询全部服装模型
//	@Test
//	public void getAllClothModelTest() {
//		AppClothModel colthModel = new AppClothModel();
//		colthModel.setModelid("D67673C0-0376-428C-8ED0-6A000706060B");
//		colthModel.setChinesename("1");
//		 colthModel.setEnglishname("1");
//		 colthModel.setClothclass("1");
//		 colthModel.setClothpart("1");
//		 colthModel.setUrl("1");
//		 colthModel.setIstrue("1");
//		 colthModel.setLimitsize("1");
//		
//		List<AppClothModel> list = clothModelService.getAllAppClothModel(colthModel,null,null);
//		for(AppClothModel aaa:list) {
//			String englistname = aaa.getEnglishname();
//			System.out.println(englistname);
//		}
//		System.out.println(list.size());
//		 logger.debug("查找结果" + "111");
//		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//	}
	
	//----------------------------------------------------------------------------
	//添加模型
//	@Test  
	public void addTerraceTest() {
		AppTerrace terrace = new AppTerrace();
		terrace.setTerraceid("aaa");
		terrace.setCnterracename("安卓");
		terrace.setEngterracename("android");
		terraceService.addAppTerrace(terrace);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	
	//添加类型
//	@Test  
	public void addClassTest() {
		AppClothClass clothClass = new AppClothClass();
		clothClass.setClothclassengname("111");
		clothClass.setClothclasscnname("aaa");
		clothClass.setClothclasssex("男");
		clothClassService.addAppClothClass(clothClass);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	
	//类型生成json
//	@Test  
	public void addClassToJsonTest() throws IOException {
		AppClothClass clothClass = new AppClothClass();
		
		List<AppClothClass> colthClassList = this.clothClassService.getAllAppClothClass(clothClass, null, null);
		File directory = new File("c:\\toclothjson"); 
		//拼接文件完整路径
        String fullPath = directory + File.separator + "ClothClass" + ".json";
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
	         for(AppClothClass appcc : colthClassList){
	             JSONObject jo = new JSONObject();
	             jo.put("clothclassid", appcc.getClothclassid());
	             jo.put("clothclasscnname", appcc.getClothclasscnname());
	             jo.put("clothclassengname", appcc.getClothclassengname());
	             jo.put("clothclasssex", appcc.getClothclasssex());
	             jo.put("clothclassistrue", appcc.getClothclassistrue());
	             jo.put("clothclasscode", appcc.getClothclasscode());
	             
	            
	             appccjson.add(jo);
//	             rd.write(jo.toString());
	            
	         }
	         rd.write(appccjson.toString());
			 rd.close();
             out.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
    }
	
	
	//更新类型
//	@Test  
	public void upClassTest() {
		AppClothClass clothClass = new AppClothClass();
		clothClass.setClothclassid("5EFDFDEA-4473-409C-8733-1DE48156FE3A");
		clothClass.setClothclassengname("111");
		clothClass.setClothclasscnname("aaa");
		clothClass.setClothclasssex("男");
		clothClass.setClothclassistrue("1111");
		clothClass.setClothclasscode("dddd");
		clothClassService.upAppClothClass(clothClass);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	//添加部位
//	@Test  
	public void addPartTest() {
		AppClothPart clothPart = new AppClothPart();
		clothPart.setClothpartengname("aaa");
		clothPart.setClothpartcnname("tttt");
		clothPart.setClothpartstyle("11");
		clothPart.setClothpartoccasion("111");
		clothPart.setClothpartclass("111");
		clothPart.setClothpartcode("aaa");
		clothPartService.addAppClothPart(clothPart);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	//删除部位
//		@Test  
		public void delPartTest() {
			
			clothPartService.delAppClothPart("0ED549D7-2B7C-4995-A662-CED0637B9C10");
			 logger.debug("查找结果" + "111");
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		
		
		//根据id查询部位
		@Test  
		public void getPartTest() {
			
			List<AppClothPart> list = clothPartService.getAllAppClothPartById("0363EACA-D7FF-4B70-A2D7-5147D597E596");
			System.out.println(list.get(0)+"ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
			 logger.debug("查找结果" + "111");
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		
	
	//登录测试
//	@Test  
	public void deptLoginTest() {
		AppDepartMent departMent = new AppDepartMent();
		departMent.setDeptname("jingdong");
		departMent.setDeptcode("123");
		
		AppDepartMent dept = deptLoginService.getDeptLogin("jingdong", "123");
		String deptname = dept.getDeptname();
		System.out.println(deptname+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	//添加数据字典
//	@Test  
	public void addDictTest() {
		AppClothDict clothDict = new AppClothDict();
		clothDict.setDictcode("aaaa");
		clothDict.setDictname("男");
	
		clothDictService.addAppClothDict(clothDict);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	//添加数据字典
//	@Test  
	public void addClothStyleTest() {
		AppClothStyle clothStyle = new AppClothStyle();
		clothStyle.setClothstylerank("DDDD"); 
		clothStyle.setClothstylecnname("D22");
		clothStyle.setClothstyleengname("DDD"); 
		clothStyle.setClothstylebyclothclass("7777");
		clothStyle.setClothstylebyclothpart1("7777");
		clothStyle.setClothstylebyclothmodel("7777");
		clothStyle.setClothstylebyclothpart2("7777");
		clothStyle.setClothstylebymlmaterial("7777");
		clothStyle.setClothstyleistrue("7777");
		clothStyle.setClothstyleimageurl("7777");
		clothStyle.setClothstyleimagename("7777");
		clothStyle.setClothstyleimagemd5("7777");
		clothStyle.setClothstyleplatform("7777");
	
		clothStyleService.addAppClothStyle(clothStyle);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	//根据条件查询相应数据字典
//	@Test
	public void queryDictByTest() {
		AppClothDict clothDict = new AppClothDict();
		clothDict.setDictcode("2");
//		clothDict.setDictname("男");
	
//		clothDictService.getAllAppClothDict(clothDict, page, di);
		 List<AppClothDict> colthDictList = this.clothDictService.getAllAppClothDict("757A231A-251B-4DDD-9D3F-A956B4C4B6E4","","",null,null);
		 logger.debug("查找结果" + "111");
		 System.out.println(colthDictList.get(0).getDictcode()+"ffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		 System.out.println(colthDictList.get(0).getDictname()+"ffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	//数据字典修改保存
//	@Test
	public void updateDictByTest() {
		AppClothDict clothDict = new AppClothDict();
		clothDict.setDictid("757A231A-251B-4DDD-9D3F-A956B4C4B6E4");
		clothDict.setDictcode("1");
		clothDict.setDictname("1");
//		clothDict.setDictname("男");
	
//		clothDictService.getAllAppClothDict(clothDict, page, di);
//		 int reg = this.clothDictService.upAppClothDict("111","111","757A231A-251B-4DDD-9D3F-A956B4C4B6E4");
		 int reg = this.clothDictService.upAppClothDict(clothDict);
		 logger.debug("查找结果" + "111");
		 System.out.println("ffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		
	}
	
	
	//查询全部服装模型
//	@Test
//	public void getAllClothClassTest() {
//		AppClothClass colthclass = new AppClothClass();
////		colthModel.setModelid("D67673C0-0376-428C-8ED0-6A000706060B");
////		colthModel.setChinesename("1");
////		 colthModel.setEnglishname("1");
////		 colthModel.setClothclass("1");
////		 colthModel.setClothpart("1");
////		 colthModel.setUrl("1");
////		 colthModel.setIstrue("1");
////		 colthModel.setLimitsize("1");
//		
//		List<AppClothClass> list = clothClassService.getAllAppClothClass(colthclass,null,null);
//		for(AppClothClass aaa:list) {
//			String englistname = aaa.getClothclasscnname();
//			System.out.println(englistname);
//		}
//		System.out.println(list.size());
//		 logger.debug("查找结果" + "111");
//		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//	}
	
	//添加服装类型
//	@Test  
	public void addClothClassTest() {
		AppClothClass clothclass = new AppClothClass();
		clothclass.setClothclasscnname("11");
		clothclass.setClothclassengname("11");
		clothclass.setClothclasssex("1");
		clothclass.setClothclassistrue("111");
		clothclass.setClothclasscode("aaa");
	
		clothClassService.addAppClothClass(clothclass);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	//删除服装类型
//	@Test  
	public void delClothClassTest() {
		AppClothClass clothclass = new AppClothClass();
		clothclass.setClothclasscnname("11");
		clothclass.setClothclassengname("11");
		clothclass.setClothclasssex("1");
		clothclass.setClothclassistrue("111");
		clothclass.setClothclasscode("aaa");
	
		clothClassService.delAppClothClass("32963464-EFF6-4739-AAC4-C72D2D737C2E");
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	
	//添加服装按钮
//	@Test  
	public void addClothButtonTest() {
		AppClothButton clothbutton = new AppClothButton();
		clothbutton.setClothbuttoncnname("dddd");
		
		clothbutton.setClothbuttonengname("dddd");
		clothbutton.setClothbuttonbyclothclass("dddd");
		clothbutton.setClothbuttoncnpartname("dddd");
		clothbutton.setClothbuttonbyclothpart("dddd");
		clothbutton.setClothbuttonname("dddd");
		clothbutton.setClothbuttonmorg("dddd");
		clothbutton.setClothbuttonistrue("dddd");
		clothbutton.setClothbuttonimagename("dddd");
		clothbutton.setClothbuttonimageurl("dddd");
		clothbutton.setClothbuttonimagemd5("dddd");
		clothbutton.setClothbuttonplatform("dddd");
		clothbutton.setClothbuttonscreenresolution("dddd");
		
//		clothbutton.setClothclassengname("11");
//		clothbutton.setClothclasssex("1");
//		clothbutton.setClothclassistrue("111");
//		clothbutton.setClothclasscode("aaa");
	
		clothButtonService.addAppClothButton(clothbutton);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	 //添加主模型
//	@Test 
	public void addClothMainTest() {
		AppClothMainModel colthMainModel = new AppClothMainModel();
		colthMainModel.setClothmainmodelcnname("111");
		colthMainModel.setClothmainmodelengname("111");
		colthMainModel.setCmmbyclothclass("yyy");
		colthMainModel.setCmmplatform("111");
		colthMainModel.setClothmainmodelname("111");
		colthMainModel.setClothmainmodelurl("111");
		colthMainModel.setClothmainmodelmd5("111");
		colthMainModel.setCmmimagename("111");
		colthMainModel.setCmmimageurl("111");
		colthMainModel.setCmmimagemd5("111");
		colthMainModel.setCmmistrue("111");
		
		clothMainModelService.addAppClothMainModel(colthMainModel);
		 logger.debug("查找结果" + "111");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
}
