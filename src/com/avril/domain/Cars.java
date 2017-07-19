package com.avril.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


/**
 * @author ASUS-PC
 * 汽车信息表
 */
@Entity
public class Cars implements Serializable{
	@Id
	@Column(name="carnumber")
	private String carnumber;//车号
	private String cartype;//型号
	private String color;//颜色
	private Double price;//价值
	private Double rentprice;//租金
	private Double deposit;//押金
	private String isrenting;//租用情况
	private String description;//简介
	private String carpath;//图片路径
	@OneToMany
	@JoinColumn(name="carnumber")
	private Set<Renttable> renttable;//来自Renttable的外键
	
	
	public Set<Renttable> getRenttable() {
		return renttable;
	}
	public void setRenttable(Set<Renttable> renttable) {
		this.renttable = renttable;
	}
	public Cars() {
		
	}
	public Cars(String carnumber, String cartype, String color, Double price,
			Double rentprice, Double deposit, String isrenting,
			String description) {
		
		this.carnumber = carnumber;
		this.cartype = cartype;
		this.color = color;
		this.price = price;
		this.rentprice = rentprice;
		this.deposit = deposit;
		this.isrenting = isrenting;
		this.description = description;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getCartype() {
		return cartype;
	}
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRentprice() {
		return rentprice;
	}
	public void setRentprice(Double rentprice) {
		this.rentprice = rentprice;
	}
	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public String getIsrenting() {
		return isrenting;
	}
	public void setIsrenting(String isrenting) {
		this.isrenting = isrenting;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Cars [carnumber=" + carnumber + ", cartype=" + cartype
				+ ", color=" + color + ", price=" + price + ", rentprice="
				+ rentprice + ", deposit=" + deposit + ", isrenting="
				+ isrenting + ", description=" + description + "]";
	}
	public String getCarpath() {
		return carpath;
	}
	public void setCarpath(String carpath) {
		this.carpath = carpath;
	}
	
}
