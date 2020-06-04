package com.hzb.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class Food {
	
	public Food() {
		
	}
	
	
	
	public Food(Integer id, Integer category_id, String name, String detail, String main_image, String sub_image,
			BigDecimal price, Integer stock, Date create_time) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.name = name;
		this.detail = detail;
		this.main_image = main_image;
		this.sub_image = sub_image;
		this.price = price;
		this.stock = stock;
		this.create_time = create_time;
	}



	private Integer id;
	private Integer category_id;
	private String name;
	private String detail;
	private String main_image;
	private String sub_image;
	private BigDecimal price;
	private Integer stock;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date create_time;
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getCategory_id() {
		return category_id;
	}



	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	public String getMain_image() {
		return main_image;
	}



	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}



	public String getSub_image() {
		return sub_image;
	}



	public void setSub_image(String sub_image) {
		this.sub_image = sub_image;
	}



	public BigDecimal getPrice() {
		return price;
	}



	public void setPrice(BigDecimal price) {
		this.price = price;
	}



	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
	}



	public Date getCreate_time() {
		return create_time;
	}



	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}



	@Override
	public String toString() {
		return "Food [id=" + id + ", category_id=" + category_id + ", name=" + name + ", detail=" + detail
				+ ", main_image=" + main_image + ", sub_images=" + sub_image + ", price=" + price + ", stock=" + stock
				+ ", create_time=" + create_time + "]";
	}
	
	
	

}
