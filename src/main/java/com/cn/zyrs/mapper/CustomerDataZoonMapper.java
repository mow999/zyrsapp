package com.cn.zyrs.mapper;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.CustomerDataZoon;
/**
 * 创建标识：张祥
 * 创建时间：20171114
 */
public interface CustomerDataZoonMapper {
    int deleteByPrimaryKey(String detailcode);

    int insert(CustomerDataZoon record);

    int insertSelective(@Param("customerdatazoon") CustomerDataZoon customerdatazoon);

    CustomerDataZoon selectByPrimaryKey(String detailcode);

    int updateByPrimaryKeySelective(CustomerDataZoon record);

    int updateByPrimaryKey(CustomerDataZoon record);
}