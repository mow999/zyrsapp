package com.cn.zyrs.service;


import java.util.List;

import com.cn.zyrs.domain.AppClothButton;

public interface AppClothButtonService {
	//添加按钮
	int addAppClothButton(AppClothButton clothButton);
	
	//删除按钮
//	int delAppClothButton(String buttonId);
	
	//修改按钮
//	int upAppClothButton(AppClothButton clothButton);
	
	//查询所有按钮
	List<AppClothButton> getAllAppClothButton(AppClothButton clothButton,String page,String di);
}
