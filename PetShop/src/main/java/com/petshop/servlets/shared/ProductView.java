package com.petshop.servlets.shared;

import java.util.ArrayList;
import java.util.List;

import com.petshop.hibernate.entities.ProductDescription;

public class ProductView {
	private int id;
	private String name;
	private int price;
	private String imageLink;
	private String code;
	private List<ProductDescription> listProductDescriptions = new ArrayList<ProductDescription>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public List<ProductDescription> getListProductDescriptions() {
		return listProductDescriptions;
	}

	public void setListProductDescriptions(List<ProductDescription> listProductDescriptions) {
		this.listProductDescriptions = listProductDescriptions;
	}

	public ProductView(int id, String name, int price, String imageLink,
			List<ProductDescription> listProductDescriptions) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.imageLink = imageLink;
		this.listProductDescriptions = listProductDescriptions;
	}

	public ProductView() {
	}
}
