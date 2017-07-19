package com.avril.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author ASUS-PC 菜单表
 */
@Entity
public class Menus implements Serializable,Comparable{
	@Id
	private Integer menuid;// 菜单ID
	private String name;// 菜单名称
	private String uri;// 菜单连接路径
	private Integer fatherid;//父节点 （不确定）
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="menus_id")
	private Set<Funs> funs;
	@ManyToMany(mappedBy = "menus",fetch=FetchType.EAGER)
	private Set<Roles> roles;

	
	public Set<Funs> getFuns() {
		return funs;
	}

	public void setFuns(Set<Funs> funs) {
		this.funs = funs;
	}

	public Integer getFatherid() {
		return fatherid;
	}

	public void setFatherid(Integer fatherid) {
		this.fatherid = fatherid;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public Menus() {
		super();
	}

	public Menus(Integer menuid, String name, String uri) {

		this.menuid = menuid;
		this.name = name;
		this.uri = uri;
	}

	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "Menus [menuid=" + menuid + ", name=" + name + ", uri=" + uri + "]";
	}

	@Override
	public int compareTo(Object o) {
		 if (o == null)
             return 1;
		 Menus m = (Menus)o;
         int value = this.menuid - m.getMenuid();
        
         return value;
	}

}
