package com.ctt.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctt.dao.PurchaseNote;
import com.ctt.entity.Products;

public class Test {
//	public Test() {
//		// TODO Auto-generated constructor stub
//	}
	public static void main(String[] args) throws Exception {		
		JsonService service=new JsonService();
		List<Products> list=service.getlistProduct();
		String mString=JsonTools.createJsonString("",list);
		//把mstring当作参数传入实现业务逻辑模块
		//System.out.println(mString);		
		Map<String, Integer> nuMap=new HashMap<>();
		nuMap.put("篮球", 2);
		nuMap.put("可口可乐",3);
		nuMap.put("苹果", 2);
		nuMap.put("羽毛球",5);
		PurchaseNote pNote=new PurchaseNote();
		pNote.print(pNote.proInfo(mString), nuMap);
	}
}
