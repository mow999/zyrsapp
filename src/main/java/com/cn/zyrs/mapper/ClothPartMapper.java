package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.AppClothPart;
/**
 * 创建标识：张祥
 * 创建时间：20171114
 */
public interface ClothPartMapper {
 
    //添加部位
    int insertAppClothPart(AppClothPart appClothPart);
    
    //删除部位
    int deleteAppClothPart(String clothPartlId);
    
    //修改服装部位
    int updateAppClothPart(AppClothPart appClothPart);
    
    //查询全部服装部位
    List<AppClothPart> getAppClothPart(AppClothPart appClothPart, String page, String di);
    
    //根据id查询服装部位
    List<AppClothPart> getAppClothPartById(@Param("clothpartid")String clothpartid);

}