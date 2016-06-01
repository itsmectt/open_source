package com.ctt.entity;

public class Products {
	private String barcode;
	private String name;
	private String unit;
	private String category;
	private String subcategory;
	private double price;
	
	public Products(){}
	public Products(String barcode,String name,String unit,String category
			,String subcategory,double price){
		super();
		this.barcode=barcode;
		this.name=name;
		this.unit=unit;
		this.category=category;
		this.subcategory=subcategory;
		this.price=price;		
	}
	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "product [barcode=" + barcode + ", name=" + name + ", unit=" + unit
			    + ",category="+category+",subcategory="+subcategory+",price="+price+"]";
	}
}
