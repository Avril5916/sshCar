package com.avril.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author ASUS-PC
 *   检查单信息表
 */
@Entity
public class Checktable implements Serializable{
	@Id
	private Long checkid;//检查单号
	private Date checkdate;//检查时间
	private String field;//属性
	private String problem;//问题
	private Double  paying;//赔费 老师关联图中缺少这个属性
	@ManyToOne
	@JoinColumn(name="checkuser")
	private Users user;//到Users的外键
	@OneToOne
	@JoinColumn(name="rentid")
	private Renttable renttable;//到出租单的外键
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Renttable getRenttable() {
		return renttable;
	}

	public void setRenttable(Renttable renttable) {
		this.renttable = renttable;
	}

	public Checktable() {
		
	}

	public Checktable(Long checkid, Date checkdate, String field,
			String problem, Double paying) {
		
		this.checkid = checkid;
		this.checkdate = checkdate;
		this.field = field;
		this.problem = problem;
		this.paying = paying;
	}

	

	public Long getCheckid() {
		return checkid;
	}

	public void setCheckid(Long checkid) {
		this.checkid = checkid;
	}

	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Double getPaying() {
		return paying;
	}

	public void setPaying(Double paying) {
		this.paying = paying;
	}

	@Override
	public String toString() {
		return "Checktable [checkid=" + checkid + ", checkdate=" + checkdate
				+ ", field=" + field + ", problem=" + problem + ", paying="
				+ paying + "]";
	}
	
   
}
