package com.avril.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author ASUS-PC
 *   客户表
 */
@Entity
public class Customers implements Serializable{
    	@Id
	private Integer identity;//身份证
    private String custname;//姓名
    private String sex; //性别
    private String address;//地址
    private Long  phone;//电话
    private String career;//职位
    @OneToMany
    @JoinColumn(name="custid")
    private Set<Renttable> renttables;//来自renttable的外键
    
    
	public Set<Renttable> getRenttables() {
		return renttables;
	}
	public void setRenttables(Set<Renttable> renttables) {
		this.renttables = renttables;
	}
	public Customers() {
		
	}
	public Customers(Integer identity, String custname, String sex,
			String address, Long phone, String career) {
		
		this.identity = identity;
		this.custname = custname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.career = career;
	}
	
	public Integer getIdentity() {
		return identity;
	}
	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	@Override
	public String toString() {
		return "Customers [identity=" + identity + ", custname=" + custname
				+ ", sex=" + sex + ", address=" + address + ", phone=" + phone
				+ ", career=" + career + "]";
	}
    
}
