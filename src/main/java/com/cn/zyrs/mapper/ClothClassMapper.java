package com.cn.zyrs.mapper;

import java.util.List;

import com.cn.zyrs.domain.AppClothClass;
/**
 * 创建标识：张祥
 * 创建时间：20171114
 */
public interface ClothClassMapper {
 
    //添加类型
    int insertAppClothClass(AppClothClass appClothClass);
    
    //删除类型
    int deleteAppClothClass(String clothClassId);
    
    //修改服装类型
    int updateAppClothClass(AppClothClass appClothClass);
    
    //查询全部服装类型
    List<AppClothClass> getAppClothClass(AppClothClass appClothClass, String page, String di);
    
    //根据id查询服装类型
    List<AppClothClass> getAppClothClassById(String classId);
}