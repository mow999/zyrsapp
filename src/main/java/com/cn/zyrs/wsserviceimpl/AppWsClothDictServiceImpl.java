package com.cn.zyrs.wsserviceimpl;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.cn.zyrs.domain.AppClothDict;
import com.cn.zyrs.mapper.ClothDictMapper;
import com.cn.zyrs.wsservice.AppWsClothDictService;

@Service("clothDictService")
//@WebService(endpointInterface="com.cn.zyrs.wsservice.AppWsClothDictService.java",serviceName="AppWsClothDictService")
@WebService(endpointInterface="com.cn.zyrs.wsservice.AppWsClothDictService",serviceName="AppWsClothDictService")
public class AppWsClothDictServiceImpl implements AppWsClothDictService {
	
	@Resource(name = "clothDictMapper")
	private ClothDictMapper clothDictMapper;
	
	//查询所有服装类型
	public List<AppClothDict> getAllAppClothDict(@Param("dictid")String dictid,@Param("dictcode")String dictcode, @Param("dictname")String dictname, String page, String di) {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//		return null;
		
		System.out.println(dictid);
		
		return this.clothDictMapper.getAppClothDict(dictid,dictcode,dictname,page,di);
	}
}
