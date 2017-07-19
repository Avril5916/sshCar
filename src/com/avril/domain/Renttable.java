package com.avril.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author ASUS-PC
 *  出租单信息表
 */
@Entity
public class Renttable implements Serializable{
	@Id

   private Long tableid;//出租单编号
   private Double imprest;//预付金
   private Double shouldpayprice;//应付金
   private Double price;//实际交付金额
   private Date begindate;//起租日期
   private Date shouldreturndate;//应归还日期
   private Date returndate;//归还日期
   private String rentflag;//出租单状态(出租中/已入库)
   @ManyToOne
   @JoinColumn(name="custid")
   private Customers customer;//到Customer的外键
   @ManyToOne
   @JoinColumn(name="carid")
   private Cars car;//到cars的外键
   @ManyToOne
   @JoinColumn(name="username")
   private Users user;//到Users的外键
 /* @OneToOne
  // @JoinColumn(name="rentid")
   private Checktable checktable;
   
   
public Checktable getChecktable() {
	return checktable;
}
public void setChecktable(Checktable checktable) {
	this.checktable = checktable;
}*/
public Customers getCustomer() {
	return customer;
}
public void setCustomer(Customers customer) {
	this.customer = customer;
}
public Cars getCar() {
	return car;
}
public void setCar(Cars car) {
	this.car = car;
}
public Users getUser() {
	return user;
}
public void setUser(Users user) {
	this.user = user;
}
public Renttable() {
	
}
public Renttable(Long tableid, Double imprest, Double shouldpayprice,
		Double price, Date begindate, Date shouldreturndate, Date returndate,
		String rentflag) {
	
	this.tableid = tableid;
	this.imprest = imprest;
	this.shouldpayprice = shouldpayprice;
	this.price = price;
	this.begindate = begindate;
	this.shouldreturndate = shouldreturndate;
	this.returndate = returndate;
	this.rentflag = rentflag;
}

public Long getTableid() {
	return tableid;
}
public void setTableid(Long tableid) {
	this.tableid = tableid;
}
public Double getImprest() {
	return imprest;
}
public void setImprest(Double imprest) {
	this.imprest = imprest;
}
public Double getShouldpayprice() {
	return shouldpayprice;
}
public void setShouldpayprice(Double shouldpayprice) {
	this.shouldpayprice = shouldpayprice;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Date getBegindate() {
	return begindate;
}
public void setBegindate(Date begindate) {
	this.begindate = begindate;
}
public Date getShouldreturndate() {
	return shouldreturndate;
}
public void setShouldreturndate(Date shouldreturndate) {
	this.shouldreturndate = shouldreturndate;
}
public Date getReturndate() {
	return returndate;
}
public void setReturndate(Date returndate) {
	this.returndate = returndate;
}
public String getRentflag() {
	return rentflag;
}
public void setRentflag(String rentflag) {
	this.rentflag = rentflag;
}
@Override
public String toString() {
	return "Renttable [tableid=" + tableid + ", imprest=" + imprest
			+ ", shouldpayprice=" + shouldpayprice + ", price=" + price
			+ ", begindate=" + begindate + ", shouldreturndate="
			+ shouldreturndate + ", returndate=" + returndate + ", rentflag="
			+ rentflag + "]";
}
  
}
