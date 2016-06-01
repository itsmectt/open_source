package com.ctt.json;

import java.util.ArrayList;
import java.util.List;
import com.ctt.entity.Products;

public class JsonService {
	public JsonService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Products> getlistProduct() {
		List<Products> list=new ArrayList<>();
		Products products1=new Products("ITEM000001", "可口可乐", "瓶", "饮料", "碳酸饮料", 3.00);
		Products products2=new Products("ITEM000002", "篮球", "个", "体育用品", "球类", 98.00);
		Products products3=new Products("ITEM000003", "羽毛球", "个", "体育用品", "球类", 1.00);
		Products products4=new Products("ITEM000004", "苹果", "斤", "食品", "水果", 5.50);
		list.add(products1);
		list.add(products2);
		list.add(products3);
		list.add(products4);
		return list;
		// TODO Auto-generated method stub

	}
}
