package com.cn.zyrs.service;
import java.util.List;
import javax.jws.WebService;
import com.cn.zyrs.domain.AppClothDict;

@WebService
public interface AppWsClothDictService {
    // 根据字典编码获取对应字典
	List<AppClothDict> getAppClothDictByCode(String dictcode);
}
