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
 *  用户表
 */
@Entity
public class Users implements Serializable{
	@Id
	private String username;//登录名
	private String identity; //身份证
	private String fullname;//姓名
	private String sex;//性别
	private String address;//地址
	private Long  phone;//联系电话
	private String  userpwd;//密码
	private String position;//职位
	@ManyToOne
	@JoinColumn(name="roleid")
	private Roles role;//role表的外键
	@OneToMany
	@JoinColumn(name="username")
	private Set<Renttable> renttables;
	@OneToMany
	@JoinColumn(name="username")
	private Set<Checktable> checktables;
	
	
	public Set<Renttable> getRenttables() {
		return renttables;
	}

	public void setRenttables(Set<Renttable> renttables) {
		this.renttables = renttables;
	}

	public Set<Checktable> getChecktables() {
		return checktables;
	}

	public void setChecktables(Set<Checktable> checktables) {
		this.checktables = checktables;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Users() {
		
	}
	
	public Users(String username, String identity, String fullname, String sex, String address, Long phone,
			String userpwd, String position) {
		super();
		this.username = username;
		this.identity = identity;
		this.fullname = fullname;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.userpwd = userpwd;
		this.position = position;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String usersname) {
		this.username = usersname;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", identity=" + identity
				+ ", fullname=" + fullname + ", sex=" + sex + ", address="
				+ address + ", phone=" + phone + ", userpwd=" + userpwd
				+ ", position=" + position + "]";
	}
	
	
	
	

}
