package junit.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.cn.zyrs.service.AppWsClothDictService;
import com.cn.zyrs.serviceimpl.AppWsClothDictServiceImpl;

@WebService
public class wstest {
	public static void main(String args[]) {
		AppWsClothDictService appws = new AppWsClothDictServiceImpl();
		appws.getAppClothDictByCode("aaa");
		Endpoint.publish("http://192.168.1.199:6666/getClothDictByCode", appws);
	}
}
