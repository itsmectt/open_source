package com.ctt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PurchaseNote {
	public PurchaseNote() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Map<String, String>> proInfo(String mString) throws Exception{
		String msg=mString.substring(4, mString.length()-1);
		JSONArray array=JSONArray.fromObject(msg);
		List<Map<String, String>> rsList = new ArrayList<Map<String, String>>();
		for (int i = 0; i < array.size(); i++) {
			JSONObject object=array.getJSONObject(i);
			Map<String, String> map=new HashMap<>();
			Iterator<?> iterator=object.keys();
			while(iterator.hasNext()){
				String key=(String) iterator.next();
				String value=object.get(key).toString();
				map.put(key, value);
			}
			rsList.add(map);
		}
		return rsList;
		
	}
	
	public void print(List<Map<String, String>> list,Map<String,Integer> nuMap){
		System.out.println("*<没钱赚商店>购物清单*");
		int total=0;
		for (int i = 0; i < list.size(); i++) {
			//System.out.println(list.get(i).get("price"));
			//double danjia=Integer.parseInt(list.get(i).get("price"));	
			double danjia=Double.parseDouble(list.get(i).get("price"));
			double sum=nuMap.get(list.get(i).get("name"))*danjia;
			total+=sum;
			if (sum>=100) {
				System.out.print("名称："+list.get(i).get("name")+",");
				System.out.print("数量："+nuMap.get(list.get(i).get("name"))+list.get(i).get("unit")+",");
				System.out.print("单价："+list.get(i).get("price")+"(元)"+",");
				System.out.print("小计："+(sum-10*(Math.floor(sum/100)))+",");
				System.out.print("优惠："+10*(Math.floor(sum/100))+" ");
				System.out.println();
				
				
			}else {
				System.out.print("名称："+list.get(i).get("name")+",");
				System.out.print("数量："+nuMap.get(list.get(i).get("name"))+list.get(i).get("unit")+",");
				System.out.print("单价："+list.get(i).get("price")+"(元)"+",");
				System.out.print("小计："+sum+",");
				System.out.println();
				
			}	
			
		}	
		
		int discount=0;
		for (int i = 0; i < list.size(); i++) {
			double danjia=Double.parseDouble(list.get(i).get("price"));
			//double danjia=Integer.parseInt(list.get(i).get("price"));
			double sum=nuMap.get(list.get(i).get("name"))*danjia;
			if (sum>=100) {			
				discount+=10*(Math.floor(sum/100));
				System.out.print("单品满100减10块商品："+list.get(i).get("name")+",");
				System.out.print("原价："+sum+",");
				System.out.print("优惠："+10*(Math.floor(sum/100))+" ");
				System.out.println();			
			}
		}
		System.out.print("总计："+(total-discount)+"(元)"+" ");
		System.out.print("节省："+discount+"(元)");
	}
}
