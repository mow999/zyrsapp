package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.cn.zyrs.domain.AppClothModel;
import com.cn.zyrs.mapper.ClothModelMapper;
import com.cn.zyrs.service.AppClothModelService;
/**
 * 创建标识：张祥
 * 创建时间：20171114
 */
@Service("clothModelService")
public class AppClothModelImpl implements AppClothModelService {
	
	@Resource(name = "clothModelMapper")
	private ClothModelMapper clothModelMapper;
	
	//添加服装模型
    @Override
	public int addAppClothModel(AppClothModel appClothModel) {
		return this.clothModelMapper.insertAppClothModel(appClothModel);

	}

    //删除服装模型
	@Override
	public int delAppClothModel(String clothModelId) {
		return this.clothModelMapper.deleteAppClothModel(clothModelId);
	}
	
	//修改服装服装模型
	@Override
	public int upAppClothModel(AppClothModel appClothModel) {
		return this.clothModelMapper.updateAppClothModel(appClothModel);
	}

	//查询所有服装模型
	@Override
	public List<AppClothModel> getAllAppClothModel(AppClothModel appClothModel, String page, String di) {
		return this.clothModelMapper.getAppClothModel(appClothModel,page,di);
	}
	
	//根据id查询要修改的模型
	@Override
	public List<AppClothModel> getAllAppClothModelById(@Param("clothmodelid")String clothmodelid) {
		return this.clothModelMapper.getAppClothModelById(clothmodelid);
	}
}
