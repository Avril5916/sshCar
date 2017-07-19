package com.avril.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Loginlogs implements Serializable{

	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long loginlogid;//日志id
	private String loginname;//用户名
	private String loginip;//登录ip地址
	private Date logintime;//用户登录时间
	@Id
	@SequenceGenerator(name="aaa", sequenceName="seq_loginlog",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aaa")
	public Long getLoginlogid() {
		return loginlogid;
	}
	public void setLoginlogid(Long loginlogid) {
		this.loginlogid = loginlogid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginip() {
		return loginip;
	}
	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	@Override
	public String toString() {
		return "Loginlogs [loginlogid=" + loginlogid + ", loginname=" + loginname + ", loginip=" + loginip
				+ ", logintime=" + logintime + "]";
	}
	public Loginlogs(Long loginlogid, String loginname, String loginip, Date logintime) {
		super();
		this.loginlogid = loginlogid;
		this.loginname = loginname;
		this.loginip = loginip;
		this.logintime = logintime;
	}
	public Loginlogs() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginlogid == null) ? 0 : loginlogid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loginlogs other = (Loginlogs) obj;
		if (loginlogid == null) {
			if (other.loginlogid != null)
				return false;
		} else if (!loginlogid.equals(other.loginlogid))
			return false;
		return true;
	}
	
	
	
}
